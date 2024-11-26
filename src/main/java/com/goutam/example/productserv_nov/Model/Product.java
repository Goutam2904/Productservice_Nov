package com.goutam.example.productserv_nov.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

//@Getter
//@Setter
//@Entity
//public class Product extends BaseModel{
//    private String name;
//    private String description;
//    private double price;
//    private String imageurl;
//
//    @ManyToOne(cascade = {CascadeType.PERSIST})
//    private Category category;
//}

@Getter
@Setter
public class Product {
    private long id;
    private String name;
    private String description;
    private double price;
    private String imageurl;
    private Category category;
}