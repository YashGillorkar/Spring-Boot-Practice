package com.pratice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pratice.entity.User;
import com.pratice.service.UserServiceI;


@RestController
public class UserController {

    @Autowired
    UserServiceI userServiceI;

    @GetMapping("/{id}")
    public ResponseEntity<User> getMethodName(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(userServiceI.getUserById(id), HttpStatus.OK);  
    }
    
//    @GetMapping("/{name}")
//    public ResponseEntity<ApiResponse> getUserByName(@PathVariable String name) {
//    	
//        return new ResponseEntity<ApiResponse>();
//    }
    
    @GetMapping("/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name) {
    	
        return new ResponseEntity<User>( userServiceI.getUserByName(name), HttpStatus.OK);
    }
    

    @PostMapping("/adduser")
    public ResponseEntity<User> addUser(@RequestBody User entity) {
        return new ResponseEntity<>(userServiceI.addUser(entity), HttpStatus.CREATED);  
    }

    @PutMapping("updateuser/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable("id") Integer id, @RequestBody User entity) {
        userServiceI.updateUser(id, entity);
        return new ResponseEntity<>(HttpStatus.OK);  
    }

    @PatchMapping("/{id}/name")
    public ResponseEntity<User> updateName(@PathVariable("id") Integer id, @RequestBody String name) {
        return new ResponseEntity<>(userServiceI.updateName(id, name), HttpStatus.OK); 
    }

    @PatchMapping("/{id}/{name}")
    public ResponseEntity<User> updateName2(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        return new ResponseEntity<>(userServiceI.updateName(id, name), HttpStatus.OK);  
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
        userServiceI.deleteId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }
}
