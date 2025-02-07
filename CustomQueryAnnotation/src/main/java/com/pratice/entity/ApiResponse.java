package com.pratice.entity;

import java.util.Date;

public class ApiResponse {
	
	private String response;
	private Date timestamp;
	
	ApiResponse(String response, Date timestamp){
		this.response = response;
		this.timestamp = timestamp;
	}

}
