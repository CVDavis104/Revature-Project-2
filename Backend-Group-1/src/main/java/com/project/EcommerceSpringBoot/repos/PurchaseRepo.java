package com.project.EcommerceSpringBoot.repos;

import com.project.EcommerceSpringBoot.models.Product;
import com.project.EcommerceSpringBoot.models.User;
import com.project.EcommerceSpringBoot.models.UserPurchases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PurchaseRepo extends JpaRepository<UserPurchases,Integer> {

    /*this.id = id;
        this.userid = userid;
        this.productid = productid;
        this.productqty = productqty;
        this.checkout = checkout;*/

//    @Modifying
//    @Query(value = "UPDATE userpurchases SET up_product_qty=?1 WHERE up_id=?2", nativeQuery = true)
//    public int updateById(int productqty, int id);

    @Modifying
    @Query(value = "UPDATE userpurchases SET up_checkout=?1 WHERE up_id=?2", nativeQuery = true)
    public boolean updateByCheckout(boolean checkout, int id);

//    @Modifying
//    @Query(value = "UPDATE purchase_t SET purchase_quantity=?1, purchase_price=?2, purchase_product_rel=?3, WHERE user_purchase_rel=?3, AND purchase_id=?4",nativeQuery = true)
//    public boolean updatePurchaseByUser(int purchase_quantity, double purchase_price, Product purchase_product_rel, User user_purchase_rel, int purchase_id);
//
//    @Query(value = "UPDATE purchase_t SET purchase_quantity=?1 WHERE user_purchase_rel=?2",nativeQuery = true)
//    public boolean updatePurchaseQuantityByUser(int purchase_quantity, User user_purchase_rel);
//
//    @Query(value = "SELECT * FROM purchase_t WHERE purchase_price=?1 AND user_purchase_rel=?2",nativeQuery = true)
//    public Purchase getTotalPriceByUser(double purchase_price,User user_purchase_rel);

}/*PurchaseRepo interface ending*/
