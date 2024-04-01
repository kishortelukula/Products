package com.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.entity.AllProducts;
import com.product.entity.ProductFiles;
import com.product.entity.ProductsDeatils;

@Repository
public interface ProductRepo extends JpaRepository<ProductsDeatils, Integer> {

    @Query("SELECT new com.product.entity.AllProducts(d.productId,d.productName, d.productPrice, d.productTitle, d.productDescription, f.fileName, f.filePath) " +
           "FROM ProductsDeatils d INNER JOIN ProductFiles f ON d.productId = f.productId ")
    List<AllProducts> getProducts();

    @Query("SELECT new com.product.entity.AllProducts(d.productId,d.productName, d.productPrice, d.productTitle, d.productDescription, f.fileName, f.filePath) " +
            "FROM ProductsDeatils d INNER JOIN ProductFiles f ON d.productId = f.productId where d.productId=:id")
    AllProducts getProductbyId(int id);
    
    
}
