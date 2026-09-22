package com.goutam.example.productserv_nov.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckoutRequest {
    @NotBlank
    private String deliveryAddress;

    @NotBlank
    private String paymentMethod;
}
