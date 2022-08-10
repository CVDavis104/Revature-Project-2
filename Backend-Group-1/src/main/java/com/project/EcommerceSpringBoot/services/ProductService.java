package com.project.EcommerceSpringBoot.services;


import com.project.EcommerceSpringBoot.models.Product;


import java.util.List;

public interface ProductService {

    boolean createProduct(Product product);

    int updateProduct(Product product);

    Product updateProductInventory(Product product);

    Product getProductById(int product_id);

    List<Product> getAllProducts();

    boolean deleteProduct(Product product);

}/*ProductService interface ending*/
