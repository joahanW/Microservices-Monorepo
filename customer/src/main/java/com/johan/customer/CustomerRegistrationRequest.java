package com.johan.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
