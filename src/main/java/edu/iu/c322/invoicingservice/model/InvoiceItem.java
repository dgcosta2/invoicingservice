package edu.iu.c322.invoicingservice.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class InvoiceItem {

    private String status;
    private List<Item> items;
    private LocalDate on;
    private Address address;

    public LocalDate getOn() {
        return on;
    }

    public void setOn(LocalDate on) {
        this.on = on;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceItem that = (InvoiceItem) o;
        return status.equals(that.status) && items.equals(that.items) && on.equals(that.on) && address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, items, on, address);
    }
}
