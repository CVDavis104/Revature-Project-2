package com.project.EcommerceSpringBoot.repos;

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
public interface UserRepo extends JpaRepository<User,Integer> {
    @Modifying
    @Query(value = "UPDATE e_users SET u_username=?1, u_password=?2, u_firstname=?3, u_lastname=?4, u_email=?5, u_address=?6, u_phonenumber=?7 WHERE u_id=?8", nativeQuery = true)
    public int update(String username, String password, String firstname, String lastname, String email, String address, String phonenumber, int id);

    @Query(value = "SELECT * FROM e_users WHERE u_id=?1", nativeQuery = true)
    public User findById(int id);

    @Query(value = "SELECT * FROM e_users WHERE u_username=?1 AND u_password=?2", nativeQuery = true)
    public User findByUser(String username, String u_password);

}
