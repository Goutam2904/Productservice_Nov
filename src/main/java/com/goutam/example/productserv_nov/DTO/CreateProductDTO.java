package com.goutam.example.productserv_nov.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDTO {
    private String Title;
    private String description;
    private double price;
    private String image;
    private String category;
}
