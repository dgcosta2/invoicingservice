package edu.iu.c322.invoicingservice.controller;

import edu.iu.c322.invoicingservice.model.Invoice;
import edu.iu.c322.invoicingservice.model.InvoiceItem;
import edu.iu.c322.invoicingservice.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final WebClient orderService;

    public InvoiceController(WebClient.Builder webClientBuilder) {
        this.orderService = webClientBuilder.baseUrl("http://localhost:8082").build();
    }

    private Invoice createInvoiceFromOrder(Order order) {
        Invoice invoice = new Invoice();
        List<InvoiceItem> invoiceItems = new ArrayList<>();
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setStatus("Shipping now");
        invoiceItem.setOn(LocalDate.now());
        invoiceItem.setItems(order.items());
        invoiceItem.setAddress(order.shippingAddress());
        invoiceItems.add(invoiceItem);
        invoice.setInvoiceItem(invoiceItems);
        invoice.setPayment(order.payment());
        invoice.setTotal(order.total());
        invoice.setOrderPlaced(order.orderPlaced());
        return invoice;
    }


    @GetMapping("/{id}")
    @ResponseBody
    public Invoice findByOrderId(@PathVariable int id) {
        try {
            return createInvoiceFromOrder(orderService.get()
                    .uri("/orders/order/{id}", id)
                    .retrieve()
                    .bodyToMono(Order.class)
                    .block());
        }
        catch (Exception e) {
            throw new IllegalStateException("Invalid Order id");
        }
    }

}
