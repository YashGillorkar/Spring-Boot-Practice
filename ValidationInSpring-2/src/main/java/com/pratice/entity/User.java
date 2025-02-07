package com.pratice.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
@Entity
public class User {

    public User(String name, String email, Integer age, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id;

    private String name;

    private String email;

    private Integer age;

    private String phoneNumber;
}
