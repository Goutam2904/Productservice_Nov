package com.goutam.example.productserv_nov.Service;

import com.goutam.example.productserv_nov.DTO.CreateProductDTO;
import com.goutam.example.productserv_nov.DTO.Fakestore_ProductDTO;
import com.goutam.example.productserv_nov.Exception.Productnotfound;
import com.goutam.example.productserv_nov.Model.Product;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;


@Service("Fakestoreproduct")
public class FakestoreProduct implements Product_Interface{

    private RestTemplate restTemplate;

    public FakestoreProduct(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getproductbyid(long id) throws Productnotfound {
//        Fakestore_ProductDTO responseDTO = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, Fakestore_ProductDTO.class);
        ResponseEntity<Fakestore_ProductDTO> responseEntity =
                                        restTemplate.getForEntity("https://fakestoreapi.com/products/"+id, Fakestore_ProductDTO.class);
        if(responseEntity.getStatusCode() == HttpStatusCode.valueOf(500)){
            throw new Productnotfound("Product id is not valid");
        }
//        if(responseEntity.getBody()==null){
//            throw new Productnotfound("Product id is not valid");
//        }
        return responseEntity.getBody().toProduct(responseEntity.getBody());

    }

    @Override
    public Product createProduct(String title, String price, String description, String image, String category) {
        CreateProductDTO createProductDTO = new CreateProductDTO();
        createProductDTO.setTitle(title);
        createProductDTO.setPrice(Double.parseDouble(price));
        createProductDTO.setDescription(description);
        createProductDTO.setImage(image);
        createProductDTO.setCategory(category);
        Fakestore_ProductDTO responseDTO = restTemplate.postForObject("https://fakestoreapi.com/products", createProductDTO, Fakestore_ProductDTO.class);
        return responseDTO.toProduct(responseDTO);
    }

    @Override
    public List<Product> getallproduct() {
            Fakestore_ProductDTO[] responseDTO =restTemplate.getForObject("https://fakestoreapi.com/products", Fakestore_ProductDTO[].class);
            List<Product> products = new ArrayList<>();
            for(Fakestore_ProductDTO productDTO : responseDTO){
                products.add(productDTO.toProduct(productDTO));
            }
        return products;
    }

    @Override
    public Product updateproduct(long id, String title, String price, String description, String image, String category) {
        CreateProductDTO updateproduct = new CreateProductDTO();
        updateproduct.setTitle(title);
        updateproduct.setPrice(Double.parseDouble(price));
        updateproduct.setDescription(description);
        updateproduct.setImage(image);
        updateproduct.setCategory(category);
        Fakestore_ProductDTO fakestoreProductDTO = restTemplate.patchForObject("https://fakestoreapi.com/products/"+id ,
                                                                                    updateproduct,
                                                                                    Fakestore_ProductDTO.class);
        return fakestoreProductDTO.toProduct(fakestoreProductDTO);
    }

    @Override
    public Product deleteproduct(long id) {
                ResponseEntity<Fakestore_ProductDTO> responseEntity = restTemplate.exchange("https://fakestoreapi.com/products/"+id, HttpMethod.DELETE,
                                        null,
                                        Fakestore_ProductDTO.class);

        return responseEntity.getBody().toProduct(responseEntity.getBody());
    }

    @Override
    public List<Product> limitproduct(long count) {

        Fakestore_ProductDTO[] fakestoreProductDTOS =restTemplate.
                getForObject("https://fakestoreapi.com/products?limit="+count, Fakestore_ProductDTO[].class);
        List<Product> products = new ArrayList<>();
        for(Fakestore_ProductDTO productDTO : fakestoreProductDTOS){
            products.add(productDTO.toProduct(productDTO));
        }
        return products;
    }
    @Override
    public List<Product> sortproduct(String order){
        Fakestore_ProductDTO[] fakestoreProductDTOS = restTemplate.
                getForObject("https://fakestoreapi.com/products?sort="+order, Fakestore_ProductDTO[].class);
        List<Product> products = new ArrayList<>();
        for(Fakestore_ProductDTO productDTO : fakestoreProductDTOS){
            products.add(productDTO.toProduct(productDTO));
        }
        return products;
    }
}
