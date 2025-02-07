package com.pratice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pratice.dto.UserDTO;
import com.pratice.service.UserServiceI;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceI userServiceI;
    @GetMapping("/singleuser/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") Long id){
        return new ResponseEntity<>(userServiceI.getUserById(id), HttpStatus.OK);
    }

    @PostMapping("/adduser")
    public ResponseEntity<UserDTO> postUser(@Valid @RequestBody UserDTO entity) {
        return new ResponseEntity<>(userServiceI.postUser(entity), HttpStatus.CREATED);
    }
}
