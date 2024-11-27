package com.goutam.example.productserv_nov.Controller;

import com.goutam.example.productserv_nov.Model.Category;
import com.goutam.example.productserv_nov.Model.Product;
import com.goutam.example.productserv_nov.Service.Category_Interface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Category_Controller {
    private Category_Interface categoryInterface;

    public Category_Controller(Category_Interface categoryInterface) {
        this.categoryInterface = categoryInterface;
    }

    @GetMapping("/product/category/{categoryname}")
    public List<Product> getproductbycategory(@PathVariable("categoryname") String categoryname) {
        return categoryInterface.getproducts(categoryname);

    }
    @GetMapping("/product/categories")
    public List<String> getcategories() {
        return categoryInterface.getallcategories();
    }
}
