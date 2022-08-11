<<<<<<< HEAD
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

    @Query(value = "SELECT * FROM purchase_t WHERE purchase_price=?1 AND user_purchase_rel=?2",nativeQuery = true)
    public Purchase getTotalPriceByUser(double purchase_price,User user_purchase_rel);

}/*PurchaseRepo interface ending*/
=======
//package com.project.EcommerceSpringBoot.repos;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import javax.transaction.Transactional;
//
//@Transactional
//@Repository
//public interface PurchaseRepo extends JpaRepository<Purchase, Integer> {
//
//    //Used for updating the purchase table
//    @Query(value = "UPDATE purchase_t SET purchase_quantity=?1, checkout=?2, total_amount=?3 WHERE purchase_id=?4",nativeQuery = true)
//    public boolean updatePurchase(int purchase_quantity, boolean checkout, double total_amount, int purchase_id);
//
//    //Used to delete a product from purchase
////    @Query(value = "DELETE * FROM purchase_t WHERE purchase_id=?",nativeQuery = true)
////    public Integer deleteFromPurchase(int purchase_id);
//
//    //Used to select from purchase by the purchase_id
////    @Query(value = "SELECT * FROM purchase_t WHERE purchase_id=?",nativeQuery = true)
////    public Purchase selectFromPurchase(int purchase_id);
//
//    /*The Spring Data module takes this simplification one step
//further by providing standard implementation for common DAO
//methods allowing for the removal of the DAO implementation
//and only requiring the definition of the DAO interface methods.
//
//In order to leverage the Spring Data programming model with JPA,
//a DAO interface should extend the Spring JpaRepository interface
//from the org.springframework.data.jpa.repository package.
//
//Extending the CrudRepository should implement the following CRUD operations for us:
//    save()
//    saveAll()
//    findById()
//    existsById()
//    findAll()
//    findAllById()
//    count()
//    deleteById()
//    delete()
//    deleteAll()
//*/
//
//    /*When we are using the @Query annotation, we have to add the
//     * wildcard (?) with  param numbers that indicate the index of
//     * values. Example of update method using @Query*/
//
//}/*PurchaseRepo interface ending*/
>>>>>>> CVDavis104
