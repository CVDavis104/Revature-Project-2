package com.project.EcommerceSpringBoot.repos;

import com.project.EcommerceSpringBoot.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

    //Used to update our products table
    @Query(value = "UPDATE product_t SET product_name=?1, product_price=?2, product_description=?3, product_inventory=?4 WHERE product_id=?5",nativeQuery = true)
    public boolean updateProducts(String product_name, double product_price, String product_description, int product_inventory,int product_id);

    //Used to delete from our products table based on product_id
//    @Query(value = "DELETE * FROM product_t WHERE product_id=?1")
//    public Integer deleteFromProducts(int product_id);

    //Used to select all products from by product_id
//    @Query(value = "SELECT * FROM product_t WHERE product_id=?1",nativeQuery = true)
//    public Product getAllProducts(int product_id);

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
