package com.project.EcommerceSpringBoot.repos;

import com.project.EcommerceSpringBoot.models.Cart;
import com.project.EcommerceSpringBoot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    //Used to create a User
    @Query(value = "UPDATE user_t SET user_name=?1, pass_word=?2, first_name=?3, last_name=?4, phone_number=?5, email=?6, address=?7, address=?8, user_cart=? WHERE user_id=?9",nativeQuery = true)
    public boolean updateUser(String user_name, String pass_word, String first_name, String last_name, String phone_number, String email, String address, Cart cart, int user_id);

    //Used to delete a User
    @Query(value = "DELETE * FROM user_t WHERE user_id=?1",nativeQuery = true)
    public Integer deleteUser(int user_id);

    //Used to find a User by id
    @Query(value = "SELECT * FROM user_t WHERE user_id=?1",nativeQuery = true)
    public User findUserById(int user_id);

}/*UserRepo interface ending*/