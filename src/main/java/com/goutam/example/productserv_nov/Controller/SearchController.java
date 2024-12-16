package com.goutam.example.productserv_nov.Controller;

import com.goutam.example.productserv_nov.DTO.SearchDTO;
import com.goutam.example.productserv_nov.Model.Product;
import com.goutam.example.productserv_nov.Service.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@RestController
public class SearchController {
    SearchService searchService;
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }
    @PostMapping("/search")
    public Page<Product> search(@RequestBody SearchDTO searchDTO) {
            return searchService.searchProduct(searchDTO.getQuery(),
                                                searchDTO.getPage(),
                                                searchDTO.getSize());

    }
}
