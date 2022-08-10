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
    @Query(value = "UPDATE product_t SET product_name=?1, product_price=?2, product_inventory=?3 WHERE product_id=?4", nativeQuery = true)
    public boolean updateProduct(String product_name, double product_price, int product_inventory, int product_id);

    @Modifying
    @Query(value = "UPDATE product_t SET product_inventory=?1 WHERE product_id=?2", nativeQuery = true)
    public Product updateProductInventory(int product_inventory, int product_id);

    /*this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_inventory = product_inventory;*/

<<<<<<< HEAD
    /*The Spring Data module takes this simplification one step
further by providing standard implementation for common DAO
methods allowing for the removal of the DAO implementation
and only requiring the definition of the DAO interface methods.

In order to leverage the Spring Data programming model with JPA,
a DAO interface should extend the Spring JpaRepository interface
from the org.springframework.data.jpa.repository package.

Extending the CrudRepository should implement the following CRUD operations for us:
    save()
    saveAll()
    findById()
    existsById()
    findAll()
    findAllById()
    count()
    deleteById()
    delete()
    deleteAll()
*/

    /*When we are using the @Query annotation, we have to add the
     * wildcard (?) with  param numbers that indicate the index of
     * values. Example of update method using @Query*/

}/*ProductRepo interface ending*/
=======
///












>>>>>>> markclone
