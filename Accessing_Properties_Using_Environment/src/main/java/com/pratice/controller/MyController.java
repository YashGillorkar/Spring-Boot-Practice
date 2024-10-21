package com.pratice.controller;

import com.pratice.component.MyApplicationPropertiesInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private MyApplicationPropertiesInfo myApplicationPropertiesInfo;

    @GetMapping("/app-info")
    public String getAppInfo() {
        myApplicationPropertiesInfo.printAppInfo();
        return "App Info Printed to Console";
    }
}
