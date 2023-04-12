package edu.iu.c322.invoicingservice.model;

import java.time.LocalDate;
import java.util.Objects;

public record Item (
    int id,
    String name,
    int quantity,
    double price
) {}
