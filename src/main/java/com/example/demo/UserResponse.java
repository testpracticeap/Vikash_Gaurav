package com.example.demo;

public class UserResponse {
	
	private int id;
	private String name;
	private String email;
	private String phoneno;
	public UserResponse() {
		
	}
	public UserResponse(int id,String name,String email,String phoneno) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
	}
	
	  public int getID() {
	        return id;
	    }



	   public void setID(int id) {
	        this.id = id;
	    }



	   public String getName() {
	        return name;
	    }



	   public void setName(String name) {
	        this.name = name;
	    }
	   
	   public String getEmail() {
		   return email;
	   }
	   
	   public void setEmail(String email) {
		   this.email = email;
	   }
	   
	   public String getPhoneno() {
		  return phoneno;
	   }
	   
	   public void setPhoneno(String phoneno) {
		   this.phoneno = phoneno;
	   }
}


