package com.project.EcommerceSpringBoot.services;

import com.project.EcommerceSpringBoot.models.Product;
import com.project.EcommerceSpringBoot.repos.ProductRepo;
import com.project.EcommerceSpringBoot.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepo pRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo pRepo) {
        this.pRepo = pRepo;
    }

    @Override
    public boolean createProduct(Product product) {
        int pk = pRepo.save(product).getId();
        return (pk > 0) ? true : false ;
    }

    @Override
    public Product getProductById(int id) {
        return pRepo.findById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return pRepo.findAll();
    }

    @Override
    public int updateProduct(Product product) {
        return pRepo.update(product.getName(), product.getPrice(), product.getInvcount(), product.getId());
    }

    @Override
    public boolean deleteProduct(Product product) {
        return false;
    }
}
////