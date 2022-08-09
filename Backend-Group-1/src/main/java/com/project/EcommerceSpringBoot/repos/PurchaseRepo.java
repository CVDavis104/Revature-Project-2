package com.project.EcommerceSpringBoot.repos;

import com.project.EcommerceSpringBoot.models.Product;
import com.project.EcommerceSpringBoot.models.Purchase;
import com.project.EcommerceSpringBoot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PurchaseRepo extends JpaRepository<Purchase,Integer> {

    @Modifying
    @Query(value = "UPDATE purchase_t SET user_purchase_rel=?1, purchase_product_rel=?2, purchase_quantity=?3, purchase_price=?4, WHERE purchase_id=?5",nativeQuery = true)
    public boolean createPurchase(User user_purchase_rel, Product purchase_product_rel, int purchase_quantity, double purchase_price, int purchase_id);

    @Modifying
    @Query(value = "UPDATE purchase_t SET purchase_quantity=?1, purchase_price=?2, purchase_product_rel=?3, WHERE user_purchase_rel=?3, AND purchase_id=?4",nativeQuery = true)
    public boolean updatePurchaseByUser(int purchase_quantity, double purchase_price, Product purchase_product_rel, User user_purchase_rel, int purchase_id);

    @Query(value = "UPDATE purchase_t SET purchase_quantity=?1 WHERE user_purchase_rel=?2",nativeQuery = true)
    public boolean updatePurchaseQuantityByUser(int purchase_quantity, User user_purchase_rel);

    @Query(value = "SELECT * FROM purchase_t WHERE purchase_price=?1",nativeQuery = true)
    public double gotTotalPrice(double purchase_price);

    /*       this.purchase_id = purchase_id;
        this.user_purchase_rel = user_purchase_rel;
        this.purchase_product_rel = purchase_product_rel;
        this.purchase_quantity = purchase_quantity;
        this.purchase_price = purchase_price;*/

}/*PurchaseRepo interface ending*/
