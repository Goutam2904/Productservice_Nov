package com.goutam.example.productserv_nov.Service;

import com.goutam.example.productserv_nov.Model.Category;
import com.goutam.example.productserv_nov.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface Category_Interface {

    public List<Product> getproducts(String categoryname);
    public List<String> getallcategories();

}
