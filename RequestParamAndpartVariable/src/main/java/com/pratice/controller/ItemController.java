package com.pratice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    // Using @RequestParam to extract query parameter
    @GetMapping
    public String getItemByName(@RequestParam(name = "name") String name) {
        return "Item requested: " + name;
    }

    // Using @PathVariable to extract from URI path
    @GetMapping("/{name}")
    public String getItemByPath(@PathVariable("name") String name) {
        return "Item requested: " + name;
    }
    
    //http://localhost:8080/api/items?name=FuckYou
    //http://localhost:8080/api/items/Yash
    //http://localhost:8080/api/items?name it will take default value
}