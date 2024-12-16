package com.goutam.example.productserv_nov.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDTO {
    private String query;
    private int page;
    private int size;
}
