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
//    @Query(value = "DELETE * FROM cart_t WHERE cart_product=?1 AND cart_id=?2",nativeQuery = true)
//    public Integer deleteFromCart(List<Product> products,int cart_id);

    //Used to select all products from a cart
//    @Query(value = "SELECT * FROM cart_t WHERE cart_id=?1",nativeQuery = true)
//    public Cart findCartById(int cart_id);

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


}/*CartRepo interface ending*/