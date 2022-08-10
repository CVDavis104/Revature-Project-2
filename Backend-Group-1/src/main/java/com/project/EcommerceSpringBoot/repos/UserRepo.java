package com.project.EcommerceSpringBoot.repos;

import com.project.EcommerceSpringBoot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<User,Integer> {

    //Used to create a new User
    @Modifying
    @Query(value = "UPDATE user_t SET user_name=?1, pass_word=?2, first_name=?3, last_name=?4, phone_number=?5, email=?6, address=?7 WHERE user_id=?8", nativeQuery = true)
    public int updateUser(String user_name, String pass_word, String first_name, String last_name, String phone_number, String email, String address, int user_id);

    // Logging in query
    @Query(value = "SELECT * FROM user_t WHERE email=?1 AND pass_word=?2", nativeQuery = true)
    User findByEmail(String email, String pass_word);

//    @Query(value = "SELECT * FROM user_t WHERE user_id=?1", nativeQuery = true)
//    public User getUserById(int user_id);

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

}/*UserRepo interface ending*/


<<<<<<< HEAD
}
///
=======
>>>>>>> main
