package edu.iu.c322.invoicingservice.model;

import java.util.Objects;

public record Item (
    int id,
    String name,
    int quantity,
    double price
) {}
