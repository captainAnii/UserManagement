package com.geekster.UserManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer studentId;
    @Column(name = "user_name", unique = true)
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "user_age")
    private Integer age;
    @Column(name = "user_dob")
    private LocalDate dob;
    @Column(name = "user_department")
    private String department;

}
