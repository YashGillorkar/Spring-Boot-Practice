package com.pratice.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationPropertiesInfo {

	@Autowired
    private Environment env;

    public void printAppInfo() {
        String appPort = env.getProperty("server.port");
        String appName = env.getProperty("spring.application.name");
        
        System.out.println("App Name: " + appName);
        System.out.println("App Port: " + appPort);
        
    }
    
    
    
}
