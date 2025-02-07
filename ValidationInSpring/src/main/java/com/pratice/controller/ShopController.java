package com.pratice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pratice.dto.ShopDTO;
import com.pratice.model.Shop;
import com.pratice.service.ShopServiceI;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/items")
public class ShopController {

    @Autowired
    private ShopServiceI shopServiceI;

    @GetMapping("/getsingle/{id}")
    public ResponseEntity<Shop> getProduct(@PathVariable("id") Long id) {
        return new ResponseEntity<>(shopServiceI.getProductById(id), HttpStatus.OK);
    }

    @PostMapping("/postsingle")
    public ResponseEntity<ShopDTO> postProduct(@Valid @RequestBody ShopDTO shopDto){
        return new ResponseEntity<>(shopServiceI.postProduct(shopDto), HttpStatus.CREATED);
    }
}
