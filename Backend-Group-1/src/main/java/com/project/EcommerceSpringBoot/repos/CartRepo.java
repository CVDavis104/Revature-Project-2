package com.project.EcommerceSpringBoot.repos;

import com.project.EcommerceSpringBoot.models.Product;
<<<<<<< HEAD
import com.project.EcommerceSpringBoot.models.User;
=======
import com.project.EcommerceSpringBoot.models.UserCart;
>>>>>>> CVDavis104
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
<<<<<<< HEAD
@Transactional
public interface CartRepo extends JpaRepository<Cart,Integer> {
=======
public interface CartRepo extends JpaRepository<UserCart,Integer> {
>>>>>>> CVDavis104

    //Used to update our Cart with Products
    @Modifying
    @Query(value = "UPDATE cart_t SET cart_user_rel=?1, cart_product_id=?2, product_quantity=?3 WHERE cart_id=?4", nativeQuery = true)
    public boolean updateCart(User cart_user_rel, Product cart_product_id,  int product_quantity, int cart_id);

    //Used to update the Product Quantity in our Cart
    @Modifying//Might have to add cart_product_id into SQL statement and parameters
    @Query(value = "UPDATE cart_t SET product_quantity=?1 WHERE cart_id=?2", nativeQuery = true)
    public int updateCartProductsQuantity(int product_quantity, int cart_id);

    //Used to find a Cart by its id
    @Query(value = "SELECT * FROM cart_t WHERE cart_id=?1", nativeQuery = true)
    public Cart findCartById(int cart_id);

    //Used to find a Cart by its User
    @Query(value = "SELECT * FROM cart_t WHERE cart_user_rel=?1", nativeQuery = true)
    public List<Cart> findCartByUser(User cart_user_rel);

    //Used to insert purchases into our purchase table
//    @Modifying
//    @Query(value = "INSERT INTO purchase_t (user_purchase_rel,purchase_product_rel,product_quantity) VALUES (?1, ?2, ?3)", nativeQuery = true)
//    public int insertPurchase(User user_purchase_rel, Product purchase_product_rel, int product_quantity);

}/*CartRepo interface ending*/
