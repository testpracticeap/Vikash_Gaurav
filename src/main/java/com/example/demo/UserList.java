package com.example.demo;

import java.util.ArrayList;
import java.util.List;


public class UserList {
	
	  public List<UserResponse> userList;
	  
	  public List<UserResponse> getUserList()
	    {
	  
	        if (userList == null) {
	  
	            userList= new ArrayList<>();
	  
	                   
	        }
	  
	        return userList;
	  
	           
	    }
	

}


