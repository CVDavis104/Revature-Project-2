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
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = "Access-Control-Allow-Origin", origins = {"*"})
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public @ResponseBody User getById(@RequestParam int id) {
        return userService.getUserById(id);
    }

    @PostMapping(value = "/userLogin", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody User getByEmail(@RequestBody User user){
        System.out.println(user);
        String email = user.getEmail();
        String password = user.getPassword();
        System.out.println(email);
        System.out.println(password);
        return userService.getByEmail(email, password);
    }

    @PutMapping(value="/userupdate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ClientMessage updateUser(@RequestBody User user){
        System.out.println(user);
        System.out.println("id: " + user.getId());
        System.out.println("email: " +  user.getEmail());
        System.out.println("username: " + user.getUsername() );
        System.out.println("password: " + user.getPassword());
        System.out.println("last: " + user.getLastname() );
        System.out.println("first: " + user.getFirstname());
        return userService.updateUser(user) > 0 ? UPDATE_SUCCESSFUL:UPDATE_FAILED;
    }
//    @PostMapping("/userLogin")
//    public @ResponseBody User getByEmail(@RequestBody String email, String password) {
//        return userService.getByEmail(email, password);
//        //http://localhost:8080/api/userLogin?username=cpearcy&password=cpearcy
//    }

    @GetMapping("/users")
    public @ResponseBody List<User> getAll(){
        return userService.getAllUsers();
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody ClientMessage createUser(@RequestBody User user){
        return userService.createUser(user) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }


    @DeleteMapping("/user")
    public @ResponseBody ClientMessage deleteUser(@RequestBody User user){
        return userService.deleteUser(user) ? DELETION_SUCCESSFUL : DELETION_FAILED;
    }

}

// {
//         "id": 1,
//         "username": "gpearcy",
//         "password": "gpearcy",
//         "firstname": "Gerald",
//         "lastname": "Pearcy",
//         "email": "gpearcy@aol.com",
//         "address": "7 ButterCup Lane, Flower TX 77777",
//         "phonenumber": "281-777-0000"
//         },
//         {
//         "id": 2,
//         "username": "mpearcy",
//         "password": "mpearcy",
//         "firstname": "Gerald",
//         "lastname": "Pearcy",
//         "email": "mpearcy@aol.com",
//         "address": "5 ButterCup Lane, Flower TX 77777",
//         "phonenumber": "281-777-4444"
//         },
//         {
//         "id": 3,
//         "username": "cpearcy",
//         "password": "cpearcy",
//         "firstname": "Gerald",
//         "lastname": "Pearcy",
//         "email": "cpearcy@aol.com",
//         "address": "5 ButterCup Lane, Flower TX 77777",
//         "phonenumber": "281-777-5555"
//         }
//