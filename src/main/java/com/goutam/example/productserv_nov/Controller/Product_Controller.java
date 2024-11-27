package com.goutam.example.productserv_nov.Controller;

import com.goutam.example.productserv_nov.DTO.CreateProductDTO;
import com.goutam.example.productserv_nov.DTO.ErrorDTO;
import com.goutam.example.productserv_nov.Exception.Productnotfound;
import com.goutam.example.productserv_nov.Model.Product;
import com.goutam.example.productserv_nov.Service.FakestoreProduct;
import com.goutam.example.productserv_nov.Service.Product_Interface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.color.ProfileDataException;
import java.util.List;

@RestController
public class Product_Controller {

    private Product_Interface product_interface;

    public Product_Controller(@Qualifier("Fakestoreproduct") Product_Interface product_interface) {
        this.product_interface = product_interface;
    }

    @GetMapping("/products")
    public List<Product> getproducts(){

        return product_interface.getallproduct();
    }

    @GetMapping("/products/{id}")
    public Product getproductbyid(@PathVariable("id") Long id) throws Productnotfound {
        return product_interface.getproductbyid(id);
    }


    @PostMapping("/products")
    public ResponseEntity<Product> createproduct(@RequestBody CreateProductDTO createProductDTO){


        Product product =  product_interface.createProduct(createProductDTO.getTitle(),
                String.valueOf(createProductDTO.getPrice()),
                createProductDTO.getDescription(),
                createProductDTO.getImage(),
                createProductDTO.getCategory());

        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, HttpStatusCode.valueOf(201));
        return responseEntity;
    }

    @PatchMapping("/products/{id}")
    public Product updateproduct(@RequestBody CreateProductDTO updateProductDTO, @PathVariable("id") Long id){
        Product product = product_interface.updateproduct(id,updateProductDTO.getTitle(),
                String.valueOf(updateProductDTO.getPrice()),
                updateProductDTO.getDescription(),
                updateProductDTO.getImage(),
                updateProductDTO.getCategory());
        return product;
    }

    @DeleteMapping("/products/{id}")
    public Product deleteproduct(@PathVariable("id") Long id){
        return product_interface.deleteproduct(id);
    }

    @GetMapping("/products/limit={count}")
    public List<Product> limitproduct(@PathVariable("count") long count){
        return product_interface.limitproduct(count);
    }
    @GetMapping("/products/sort={order}")
    public List<Product> sortproduct(@PathVariable("order") String order){
        return product_interface.sortproduct(order);
    }

}
