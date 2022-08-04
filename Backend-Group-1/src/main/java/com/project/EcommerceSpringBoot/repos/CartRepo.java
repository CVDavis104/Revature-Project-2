package com.project.EcommerceSpringBoot.repos;

import com.project.EcommerceSpringBoot.models.Cart;
import com.project.EcommerceSpringBoot.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CartRepo extends JpaRepository<Cart,Integer> {

    //Used to update our cart
    @Query(value = "UPDATE cart_t SET cart_product=?1 WHERE cart_id=?2",nativeQuery = true)
    public boolean updateCart(List<Product> products, int cart_id);

    //Used to delete specific products from a cart
    @Query(value = "DELETE * FROM cart_t WHERE cart_product=?1 AND cart_id=?2",nativeQuery = true)
    public Integer deleteFromCart(List<Product> products,int cart_id);

    //Used to select all products from a cart
    @Query(value = "SELECT * FROM cart_t WHERE cart_id=?1",nativeQuery = true)
    public Cart findCartById(int cart_id);

}/*CartRepo interface ending*/