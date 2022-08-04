package com.project.EcommerceSpringBoot.repos;

import com.project.EcommerceSpringBoot.models.Product;
import com.project.EcommerceSpringBoot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface ProductRepo extends JpaRepository<Product,Integer> {
    @Modifying
    @Query(value = "UPDATE products SET p_name=?1, p_price=?2, p_invcount=?3 WHERE p_id=?4", nativeQuery = true)
    public int update(String name, Double price, int invcount, int id);


    @Query(value = "SELECT * FROM products WHERE p_id=?1", nativeQuery = true)
    public Product findById(int id);
}

