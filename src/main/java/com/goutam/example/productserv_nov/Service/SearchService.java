package com.goutam.example.productserv_nov.Service;

import com.goutam.example.productserv_nov.Model.Product;
import com.goutam.example.productserv_nov.Repository.Product_Repo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
    Product_Repo productRepo;

    public SearchService(Product_Repo productRepo) {
        this.productRepo = productRepo;
    }

    public Page<Product> searchProduct(String query, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return productRepo.findByNameContaining(query, pageable);
    }
}
