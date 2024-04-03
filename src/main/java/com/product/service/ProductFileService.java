package com.product.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.product.entity.ProductFiles;
import com.product.entity.ProductsDeatils;

@Service
public class ProductFileService {


    private final ProductDetailsService detailsService;

    @Autowired
    public ProductFileService(ProductDetailsService detailsService) {
        this.detailsService = detailsService;
    }

    public String saveFilesAndDetails(ProductsDeatils deatils, ProductFiles files) {
        detailsService.saveFilesAndDetails(deatils, files);
        return "final success";
    }
    
  
}
