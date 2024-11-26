package com.goutam.example.productserv_nov.Service;

import com.goutam.example.productserv_nov.DTO.Fakestore_ProductDTO;
import com.goutam.example.productserv_nov.Exception.Productnotfound;
import com.goutam.example.productserv_nov.Model.Product;
import org.springframework.context.annotation.Configuration;

import java.util.List;


public interface Product_Interface {

    public Product getproductbyid(long id) throws Productnotfound;
    public Product createProduct(String title, String price, String description, String image, String category);
    public List<Product> getallproduct();
    public Product updateproduct(long id, String title, String price, String description, String image, String category);
    public Product deleteproduct(long id);
}
