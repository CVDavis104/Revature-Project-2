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


<<<<<<< HEAD
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
=======
    @Query(value = "SELECT * FROM products WHERE p_id=?1", nativeQuery = true)
    public Product findById(int id);
}

>>>>>>> 109e9e7719156587c4a5401eaa06c81bde4f82d9
