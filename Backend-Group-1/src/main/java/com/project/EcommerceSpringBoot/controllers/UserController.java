package com.project.EcommerceSpringBoot.controllers;
import com.project.EcommerceSpringBoot.models.ClientMessage;
import com.project.EcommerceSpringBoot.models.User;
import com.project.EcommerceSpringBoot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.project.EcommerceSpringBoot.utils.ClientMessageUtil.*;

@RestController
@RequestMapping("/map")
@CrossOrigin(allowedHeaders = "Access-Control-Allow-Origin", origins = {"*"})
public class UserController {

     /* Fields for testing the User in Postman

         {
         "user_id": int,
         "user_name": String,
         "pass_word": String,
         "first_name": String,
         "last_name": String,
         "email": String,
         "address": String,
         "phone_number": String
         }

//Example HTTP link for testing
//http://localhost:8080/[RequestMapping]/[MethodMapping]?user_name=[exampleName]&pass_word=[examplePassword]

*///Field testing explanation ending

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody User getUserById(@RequestParam int user_id) {return userService.getUserById(user_id);
    }//getUserById method ending

    @PostMapping(value = "/user")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody ClientMessage createUser(@RequestBody User user){
        return userService.createUser(user) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }//createUser method ending

    @PutMapping("/user")
    public @ResponseBody ClientMessage updateUser(@RequestBody User user){
        return userService.updateUser(user) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }//updateUser method ending

    @DeleteMapping("/user")
    public @ResponseBody ClientMessage deleteUser(@RequestBody User user){
        return userService.deleteUser(user) ? DELETION_SUCCESSFUL : DELETION_FAILED;
    }//deleteUser method ending

    @GetMapping("/users")
    public @ResponseBody List<User> getAll(){
        return userService.getAllUsers();
    }//getAllUsers method ending

}/*UserController Class ending*/