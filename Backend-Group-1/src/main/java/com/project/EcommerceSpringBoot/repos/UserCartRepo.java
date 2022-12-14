package com.project.EcommerceSpringBoot.repos;

import com.project.EcommerceSpringBoot.models.Product;
import com.project.EcommerceSpringBoot.models.User;
import com.project.EcommerceSpringBoot.models.UserCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface UserCartRepo extends JpaRepository<UserCart,Integer> {


    @Modifying
    @Query(value = "UPDATE usercart SET user_id=?1, uc_product_id=?2, uc_product_qty=?3 WHERE uc_id=?4", nativeQuery = true)
    public int update(User userid, Product productid,  int productqty, int id);

    @Modifying
    @Query(value = "UPDATE usercart SET uc_product_qty=?1 WHERE uc_id=?2", nativeQuery = true)
    public int updateById(int productqty, int id);

    @Query(value = "SELECT * FROM usercart WHERE uc_id=?1", nativeQuery = true)
    public UserCart findById(int id);

    @Query(value = "SELECT * FROM usercart WHERE user_id=?1", nativeQuery = true)
    public List<UserCart> findByUser(User userid);

    @Modifying
    @Query(value = "INSERT INTO userpurchases (user_id,up_product_id,up_product_qty) VALUES (?1, ?2, ?3)", nativeQuery = true)
    public int insertPurchase(User userid, Product productid,  int productqty);


//    @Modifying
//    @Query(value = "DELETE FROM usercart WHERE user_id=?1", nativeQuery = true)
//    public boolean delete(int id);
//
//
}
////