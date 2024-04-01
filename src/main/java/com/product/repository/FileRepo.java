package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.ProductFiles;

public interface FileRepo extends JpaRepository<ProductFiles, Integer>{

}
