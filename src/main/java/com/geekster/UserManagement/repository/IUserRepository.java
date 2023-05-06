package com.geekster.UserManagement.repository;

import com.geekster.UserManagement.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepository extends CrudRepository<Users,Integer> {

    public List<Users> findByFirstName(String firstName);
    public List<Users> findByAgeGreaterThan(Integer age);
    public List<Users> findByFirstNameOrAgeGreaterThan(String firstName, Integer age);
    public List<Users> findByFirstNameAndAgeGreaterThan(String firstName, Integer age);
    @Query(value = "Select * from Users order by user_age asc", nativeQuery = true)
    public List<Users> findUserOrderedByAgeASC();
    @Query(value = "Select * from Users where user_age = :age order by user_age asc", nativeQuery = true)
    public List<Users> findUserOrderedByAgeASCWithWhere(Integer age);
//    @Query(value = "Select * from Users where user_age = ?1 order by user_age asc", nativeQuery = true)
//    public List<Users> findUserOrderedByAgeASCWithWhere(Integer age);
}
