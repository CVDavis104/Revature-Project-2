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