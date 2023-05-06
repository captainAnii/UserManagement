package com.geekster.UserManagement.service;

import com.geekster.UserManagement.model.Users;
import com.geekster.UserManagement.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class UserService {
    @Autowired
    IUserRepository iUserRepository;

    public Iterable<Users> getAllUsers() {
        Iterable<Users> allUsers = iUserRepository.findAll();
        return allUsers;
    }
    public List<Users> getAllUsersSorted() {
        return iUserRepository.findUserOrderedByAgeASC();
    }
    public List<Users> getAllUsersWhere(String age) {
        Integer userAge = Integer.parseInt(age);
        return iUserRepository.findUserOrderedByAgeASCWithWhere(userAge);
    }

    public String addUser(List<Users> usersList) {
        Iterable<Users> addedUsers = iUserRepository.saveAll(usersList);
        if(addedUsers!=null){
            return "Yes";
        }else {
            return "No";
        }
    }

    public void removeUserById(Integer id) {
        iUserRepository.deleteById(id);
    }


    public List<Users> fetchUserByFirstName(String firstName) {
        return iUserRepository.findByFirstName(firstName);
    }

    public List<Users> fetchUserByAgeFactor(String age) {
        Integer userAge = Integer.parseInt(age);
        return iUserRepository.findByAgeGreaterThan(userAge);
    }

    public List<Users> getUsersByFirstNameOrAgeAbove(String firstName, String age) {
        Integer userAge = Integer.parseInt(age);
        return iUserRepository.findByFirstNameOrAgeGreaterThan(firstName,userAge);
    }
    public List<Users> getUsersByFirstNameAndAgeAbove(String firstName, String age) {
        Integer userAge = Integer.parseInt(age);
        return iUserRepository.findByFirstNameAndAgeGreaterThan(firstName,userAge);
    }
}
