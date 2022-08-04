package com.project.EcommerceSpringBoot.repos;

import com.project.EcommerceSpringBoot.models.Product;
import com.project.EcommerceSpringBoot.models.User;
import com.project.EcommerceSpringBoot.models.UserCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public interface UserCartRepo extends JpaRepository<UserCart,Integer> {


    @Modifying
    @Query(value = "UPDATE usercart SET uc_product_qty=?1 WHERE p_id=?2 and uc_id=?3", nativeQuery = true)
    public int update(int productqty, Product productid, int id);

    @Query(value = "SELECT * FROM usercart WHERE user_id=?1", nativeQuery = true)
    public UserCart findById(int id);
//    @Modifying
//    @Query(value = "DELETE FROM usercart WHERE user_id=?1", nativeQuery = true)
//    public boolean delete(int id);
//
//
}
