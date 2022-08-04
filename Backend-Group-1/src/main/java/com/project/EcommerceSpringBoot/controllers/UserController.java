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
@CrossOrigin(allowedHeaders = "Access-Control-Allow-Origin", origins = {"*"})
@RequestMapping("/map")
public class UserController {

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
    public @ResponseBody List<User> getAllUsers(){return userService.getAllUsers();
    }//getAllUsers method ending

}/*UserController class ending*/
