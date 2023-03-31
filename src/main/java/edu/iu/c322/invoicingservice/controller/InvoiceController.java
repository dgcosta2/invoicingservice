package edu.iu.c322.invoicingservice.controller;

import edu.iu.c322.invoicingservice.model.Invoice;
import edu.iu.c322.invoicingservice.model.UpdateRequest;
import edu.iu.c322.invoicingservice.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private OrderRepository repository;

    public InvoiceController(OrderRepository orderRepository) {
        this.repository = orderRepository;
    }

    @GetMapping("/{id}")
    public Invoice findByOrderId(@PathVariable int id) {
        return repository.getInvoiceByOrderId(id);
    }

    @PutMapping("/{orderId}")
    public void updateShippingStatus(@RequestBody UpdateRequest updateRequest, @PathVariable int orderId) {
        repository.updateShippingStatus(updateRequest, orderId);
    }
}
