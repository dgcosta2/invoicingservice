package edu.iu.c322.invoicingservice.model;

import java.util.Objects;

public record Address(
    int id,
    String state,
    String city,
    int postalCode
)
{}
