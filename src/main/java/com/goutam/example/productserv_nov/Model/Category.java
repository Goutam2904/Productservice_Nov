package com.goutam.example.productserv_nov.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

//@Getter
//@Setter
//@Entity
//public class Category extends BaseModel {
//    private String categoryName;
//
//    @OneToMany(mappedBy = "category", cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
//    @JsonIgnore
//    @Fetch(FetchMode.JOIN)
//     private List<Product> products;
//}

@Getter
@Setter
public class Category{
    private long id;
    private String categoryName;
   }
