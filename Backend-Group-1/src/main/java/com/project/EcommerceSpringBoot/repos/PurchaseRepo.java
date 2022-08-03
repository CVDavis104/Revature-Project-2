package com.project.EcommerceSpringBoot.repos;

import com.project.EcommerceSpringBoot.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface PurchaseRepo extends JpaRepository<Purchase, Integer> {

    //Used for updating the purchase table
    @Query(value = "UPDATE purchase_t SET purchase_quantity=?1, checkout=?2, total_amount=?3 WHERE purchase_id=?4",nativeQuery = true)
    public boolean updatePurchase(int purchase_quantity, boolean checkout, double total_amount, int purchase_id);

    //Used to delete a product from purchase
    @Query(value = "DELETE * FROM purchase_t WHERE purchase_id=?",nativeQuery = true)
    public Integer deleteFromPurchase(int purchase_id);

    //Used to select from purchase by the purchase_id
    @Query(value = "SELECT * FROM purchase_t WHERE purchase_id=?",nativeQuery = true)
    public Purchase selectFromPurchase(int purchase_id);



}/*PurchaseRepo interface ending*/