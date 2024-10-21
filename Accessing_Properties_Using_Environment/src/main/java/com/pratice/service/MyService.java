package com.pratice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratice.component.MyApplicationPropertiesInfo;

import jakarta.annotation.PostConstruct;

@Service
public class MyService {

    @Autowired
    private MyApplicationPropertiesInfo myApplicationPropertiesInfo;

    @PostConstruct
    public void init() {
        // Call the method to print the app info to the console
        myApplicationPropertiesInfo.printAppInfo();
    }
}