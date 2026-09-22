package com.goutam.example.productserv_nov.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class OrderItem extends BaseModel {
    private long productId;
    private String productName;
    private double unitPrice;
    private int quantity;

    @ManyToOne
    private Order order;
}
