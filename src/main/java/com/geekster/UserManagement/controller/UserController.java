package com.geekster.UserManagement.controller;

import com.geekster.UserManagement.model.Users;
import com.geekster.UserManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping(value = "/allUsers")
    public Iterable<Users> getUsers(){
       return userService.getAllUsers();
    }

    @PostMapping(value = "/users")
    public String insertUsers(@RequestBody List<Users> usersList){
        return userService.addUser(usersList);
    }
    @DeleteMapping(value = "user/{id}")
    public void deleteUserById(@PathVariable Integer id){
         userService.removeUserById(id);
    }
    @GetMapping(value = "/users/{firstName}")
    public List<Users> getUsersByName(@PathVariable String firstName){
        return userService.fetchUserByFirstName(firstName);
    }
    @GetMapping(value = "/users/age/{age}")
    public List<Users> getUsersByAgeFactor(@PathVariable String age){
        return userService.fetchUserByAgeFactor(age);
    }
    @GetMapping(value = "/users/{firstName}/greaterThan/{age}")
    public List<Users> getUsersByNameOrAgeAbove(@PathVariable String firstName,@PathVariable String age){
        return userService.getUsersByFirstNameOrAgeAbove(firstName,age);
    }
    @GetMapping(value = "/users/ageGreater/combined")
    public List<Users> getUsersByNameAndAgeAbove(@RequestParam String firstName, @RequestParam String age){
        return userService.getUsersByFirstNameAndAgeAbove(firstName,age);
    }
    @GetMapping(value = "/userSort")
    public List<Users> getSortedUsers(){
        return userService.getAllUsersSorted();
    }
    @GetMapping(value = "/userWhere/{age}")
    public List<Users> getUsersWhereAge(@PathVariable String age){
        return userService.getAllUsersWhere(age);
    }
}
