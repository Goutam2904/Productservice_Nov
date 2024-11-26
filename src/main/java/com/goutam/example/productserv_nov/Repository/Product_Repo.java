//package com.goutam.example.productserv_nov.Repository;
//
//import com.goutam.example.productserv_nov.Model.Product;
//import com.goutam.example.productserv_nov.Repository.Projection.Product_Projection_title_desc;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//public interface Product_Repo extends JpaRepository<Product, Long>{
//
//    Product save(Product product);
//
//    Product findById(long id);
//
//    List<Product> findAll();
//
//    Optional<Product> findProductByNameAndCategory_CategoryName(String title, String categoryname);
//
//    @Query("select p.id from Product p where p.category.categoryName = :categoryName")
//    List<Long> findProductid(@Param("categoryName") String categoryName);
//
//    @Query(value= "select name,description from product where id = :id", nativeQuery = true)
//    Product_Projection_title_desc getProductdescription(@Param("id") Long id);
//}
