//package com.goutam.example.productserv_nov;
//
//import com.goutam.example.productserv_nov.Model.Category;
//import com.goutam.example.productserv_nov.Model.Product;
//import com.goutam.example.productserv_nov.Repository.Category_Repo;
//import com.goutam.example.productserv_nov.Repository.Product_Repo;
//import com.goutam.example.productserv_nov.Repository.Projection.Product_Projection_title_desc;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//@SpringBootTest
//class ProductservNovApplicationTests {
//
//    @Autowired
//    private Product_Repo product_Repo;
//    @Autowired
//    private Category_Repo category_Repo;
//
//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//        public void test(){
//        Optional<Product> option = product_Repo.findProductByNameAndCategory_CategoryName("Lion","Mobile");
//
//        System.out.println(option.isPresent());
//        System.out.println(option.get().getName());
//        System.out.println(option.get().getCategory().getCategoryName());
//
//    }
//
//    @Test
//    public void test1(){
//        List<Long> products = product_Repo.findProductid("Mobile");
//        for (Long product : products) {
//            System.out.println(product);
//        }
//    }
//    @Test
//    public void test2(){
//        Product_Projection_title_desc product = product_Repo.getProductdescription(52l);
//            System.out.println(product.getname() +" : "+product.getDescription());
//
//    }
//    @Test
//    @Transactional
//    public void lazyselectget(){
//        Optional<Category> category = category_Repo.findById(1l);
//        System.out.println(category.get().getCategoryName());
//        System.out.println(category.get().getProducts());
//        }
//    @Test
//    @Transactional
//    public void lazyselectnotget(){
//        Optional<Category> category = category_Repo.findById(1l);
//        System.out.println(category.get().getCategoryName());
//    }
//    @Test
//    @Transactional
//    public void lazysubselectget(){
//        Optional<Category> category = category_Repo.findById(1l);
//        System.out.println(category.get().getCategoryName());
//        System.out.println(category.get().getProducts());
//    }
//    @Test
//    @Transactional
//    public void lazysubselectnotget(){
//        Optional<Category> category = category_Repo.findById(1l);
//        System.out.println(category.get().getCategoryName());
//    }
//    @Test
//    @Transactional
//    public void lazyjoinget(){
//        Optional<Category> category = category_Repo.findById(1l);
//        System.out.println(category.get().getCategoryName());
//        System.out.println(category.get().getProducts());
//    }
//    @Test
//    @Transactional
//    public void lazyjoinnotget(){
//        Optional<Category> category = category_Repo.findById(1l);
//        System.out.println(category.get().getCategoryName());
//    }
//    @Test
//    @Transactional
//    public void eagerselectget(){
//        Optional<Category> category = category_Repo.findById(1l);
//        System.out.println(category.get().getCategoryName());
//        System.out.println(category.get().getProducts());
//    }
//    @Test
//    @Transactional
//    public void eagerselectnotget(){
//        Optional<Category> category = category_Repo.findById(1l);
//        System.out.println(category.get().getCategoryName());
//    }
//    @Test
//    @Transactional
//    public void eagersubselectget(){
//        Optional<Category> category = category_Repo.findById(1l);
//        System.out.println(category.get().getCategoryName());
//        System.out.println(category.get().getProducts());
//    }
//    @Test
//    @Transactional
//    public void eagersubselectnotget(){
//        Optional<Category> category = category_Repo.findById(1l);
//        System.out.println(category.get().getCategoryName());
//    }
//    @Test
//    @Transactional
//    public void eagerjoinget(){
//        Optional<Category> category = category_Repo.findById(1l);
//        System.out.println(category.get().getCategoryName());
//        System.out.println(category.get().getProducts());
//    }
//    @Test
//    @Transactional
//    public void eagerjoinnotget(){
//        Optional<Category> category = category_Repo.findById(1l);
//        System.out.println(category.get().getCategoryName());
//    }
//    }
//
