package com.project.EcommerceSpringBoot.services;

import com.project.EcommerceSpringBoot.models.Product;
import com.project.EcommerceSpringBoot.repos.ProductRepo;
import com.project.EcommerceSpringBoot.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public boolean createProduct(Product product) {
        int pk = productRepo.save(product).getProduct_id();
        return (pk > 0) ? true : false;
    }//Create a Product method ending

    @Override
    public boolean updateProduct(Product product) {
        return productRepo.updateProduct(product.getProduct_name(), product.getProduct_price(), product.getProduct_inventory(), product.getProduct_id());
    }//Update a Product method ending

    @Override
    public Product updateProductInventory(Product product) {
        return productRepo.updateProductInventory(product.getProduct_inventory(),product.getProduct_id());
    }//updateProductInventory method ending

    @Override
    public Product getProductById(int product_id) {
        Optional<Product> productSearch = productRepo.findById(product_id);
        Product product = productSearch.get();
        return product;
    }//Get a Product by its id method ending

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }//Get all Product method ending

    @Override
    public boolean deleteProduct(Product product) {
        productRepo.delete(product);
        return true;
    }//Delete Product method ending


}/*ProductServiceImpl class ending*/


