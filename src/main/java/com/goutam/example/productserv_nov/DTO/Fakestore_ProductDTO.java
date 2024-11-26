package com.goutam.example.productserv_nov.DTO;

import com.goutam.example.productserv_nov.Model.Category;
import com.goutam.example.productserv_nov.Model.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class Fakestore_ProductDTO {


    private long id;
    private String title;
    private String description;
    private String price;
    private String image;
    private String  category;

    public Product toProduct(Fakestore_ProductDTO responseDTO) {
        Product product = new Product();
        product.setId(responseDTO.getId());
        product.setDescription(responseDTO.getDescription());
        product.setName(responseDTO.getTitle());
        product.setPrice(Double.parseDouble(responseDTO.getPrice()));
        product.setImageurl(responseDTO.getImage());

        Category category = new Category();
        category.setCategoryName(responseDTO.getCategory());
        product.setCategory(category);

        return product;
    }


}
