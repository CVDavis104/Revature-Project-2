package com.project.EcommerceSpringBoot.controllers;

import com.project.EcommerceSpringBoot.models.ClientMessage;
import com.project.EcommerceSpringBoot.models.User;
import com.project.EcommerceSpringBoot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
<<<<<<< HEAD
import org.springframework.http.MediaType;
=======
>>>>>>> 109e9e7719156587c4a5401eaa06c81bde4f82d9
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.project.EcommerceSpringBoot.utils.ClientMessageUtil.*;

@RestController
<<<<<<< HEAD
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
=======
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = "Access-Control-Allow-Origin", origins = {"*"})

public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public @ResponseBody User getById(@RequestParam int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/userLogin")
    public @ResponseBody User getByUser(@RequestParam String username, String password) {
        return userService.getUserByUser(username, password);
       //http://localhost:8080/api/userLogin?username=cpearcy&password=cpearcy
    }

    @GetMapping("/users")
    public @ResponseBody List<User> getAll(){
        return userService.getAllUsers();
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody ClientMessage createUser(@RequestBody User user){
        return userService.createUser(user) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    @PutMapping("/user")
    public @ResponseBody ClientMessage updateUser(@RequestBody User user){
        return userService.updateUser(user) > 0 ? UPDATE_SUCCESSFUL:UPDATE_FAILED;
    }
>>>>>>> 109e9e7719156587c4a5401eaa06c81bde4f82d9

    @DeleteMapping("/user")
    public @ResponseBody ClientMessage deleteUser(@RequestBody User user){
        return userService.deleteUser(user) ? DELETION_SUCCESSFUL : DELETION_FAILED;
<<<<<<< HEAD
    }//deleteUser method ending

    @GetMapping("/users")
    public @ResponseBody List<User> getAllUsers(){return userService.getAllUsers();
    }//getAllUsers method ending

}/*UserController class ending*/
=======
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
>>>>>>> 109e9e7719156587c4a5401eaa06c81bde4f82d9
