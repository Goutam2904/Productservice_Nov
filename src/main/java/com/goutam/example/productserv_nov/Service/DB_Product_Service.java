//package com.goutam.example.productserv_nov.Service;
//
//import com.goutam.example.productserv_nov.DTO.Fakestore_ProductDTO;
//import com.goutam.example.productserv_nov.Exception.Productnotfound;
//import com.goutam.example.productserv_nov.Model.Category;
//import com.goutam.example.productserv_nov.Model.Product;
//import com.goutam.example.productserv_nov.Repository.Category_Repo;
//import com.goutam.example.productserv_nov.Repository.Product_Repo;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Component
//public class DB_Product_Service implements Product_Interface{
//
//    private Product_Repo product_Repo;
//    private Category_Repo category_Repo;
//
//    public DB_Product_Service(Product_Repo product_Repo, Category_Repo category_Repo) {
//        this.product_Repo = product_Repo;
//        this.category_Repo = category_Repo;
//    }
//    @Override
//    public Product getproductbyid(long id) throws Productnotfound {
//
//        Product product = product_Repo.findById(id);
//
//        if(product == null){
//            throw new Productnotfound("Product Not Found");
//        }
//
//        return product;
//    }
//
//    @Override
//    public Product createProduct(String title, String price, String description, String image, String category) {
//            Product product = new Product();
//            product.setName(title);
//            product.setPrice(Double.parseDouble(price));
//            product.setDescription(description);
//            product.setImageurl(image);
//
//            Category checkdbcategory = category_Repo.findByCategoryName(category);
//            if(checkdbcategory == null) {
//                Category newcategory = new Category();
//                newcategory.setCategoryName(category);
//
//                checkdbcategory = newcategory;
//
////                checkdbcategory = category_Repo.save(newcategory); - Not needed since cascade is used in Product Model
//            }
//            product.setCategory(checkdbcategory);
//             return product_Repo.save(product);
//    }
//
//    @Override
//    public List<Product> getallproduct() {
//        List<Product> products = product_Repo.findAll();
//        return products;
//    }
//
//    @Override
//    public Product updateproduct(long id, String title, String price, String description, String image, String category) {
//        return null;
//    }
//}
