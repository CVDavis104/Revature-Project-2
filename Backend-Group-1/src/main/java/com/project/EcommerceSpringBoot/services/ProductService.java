package com.project.EcommerceSpringBoot.services;


import com.project.EcommerceSpringBoot.models.Product;


import java.util.List;

public interface ProductService {

    boolean createProduct(Product product);

    Product  getProductById(int id);

    List<Product> getAllProducts();

    int updateProduct(Product product);

    boolean deleteProduct(Product product);
}
