package edu.iu.c322.invoicingservice.model;

import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public record Order (
        int id,
        int customerId,
        double total,
        Address shippingAddress,
        List<Item> items,
        Payment payment,
        String status,
        LocalDate orderPlaced
) {}
