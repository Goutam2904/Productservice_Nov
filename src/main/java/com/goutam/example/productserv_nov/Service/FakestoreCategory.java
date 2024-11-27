package com.goutam.example.productserv_nov.Service;

import com.goutam.example.productserv_nov.DTO.Fakestore_ProductDTO;
import com.goutam.example.productserv_nov.Model.Category;
import com.goutam.example.productserv_nov.Model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakestoreCategory implements Category_Interface{
    private RestTemplate restTemplate;

    public FakestoreCategory(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getproducts(String categoryname) {
            Fakestore_ProductDTO[] fakestoreProductDTOS =restTemplate.getForObject("https://fakestoreapi.com/products/category/"+categoryname,
                    Fakestore_ProductDTO[].class);
            List<Product> products = new ArrayList<>();
            for (Fakestore_ProductDTO fakestoreProductDTO : fakestoreProductDTOS){
                products.add(fakestoreProductDTO.toProduct(fakestoreProductDTO));
            }
        return products;
    }

    @Override
    public List<String> getallcategories() {
        List<String> categories = new ArrayList<>();
        String[] categorylist = restTemplate.getForObject("http://fakestoreapi.com/products/categories", String[].class);
        for (String category : categorylist){
            categories.add(category);
        }
        return categories;
    }
}
