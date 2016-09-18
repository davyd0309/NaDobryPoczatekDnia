package pl.dawydiuk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dawydiuk.model.User;
import pl.dawydiuk.service.UserService;

import java.util.List;

/**
 * Created by Konrad on 13.09.2016.
 */
@RequestMapping(value = "users")
@RestController
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "getAllUsers",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = userService.getAllUsers();
        HttpStatus httpStatus = !users.isEmpty() ? HttpStatus.OK : HttpStatus.NO_CONTENT;
        return new ResponseEntity<List<User>>(users,httpStatus);
    }


    @PostMapping(value = "addUser",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addAndSaveUser(@RequestBody User user){
        userService.saveOrUpdateUser(user);
        HttpStatus httpStatus = user !=null ? HttpStatus.CREATED : HttpStatus.CONFLICT;
        return new ResponseEntity<User>(httpStatus);
    }

    @DeleteMapping(value = "deleteUser/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id){
        User user = userService.findUserById(id);
        HttpStatus httpStatus;
        if(user!=null){
            userService.deleteUser(id);
            httpStatus = HttpStatus.OK;
            return new ResponseEntity<User>(httpStatus);
        }else {
            httpStatus = HttpStatus.NOT_FOUND;
            return new ResponseEntity<User>(httpStatus);
        }
    }


    @GetMapping(value = "findUserById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> findUserById(@PathVariable Integer id){
        User user = userService.findUserById(id);
        HttpStatus httpStatus;
        if(user!=null){
            httpStatus = HttpStatus.OK;
            return new ResponseEntity<User>(user,httpStatus);
        }else {
            httpStatus = HttpStatus.NOT_FOUND;
            return new ResponseEntity<User>(httpStatus);
        }
    }


}
