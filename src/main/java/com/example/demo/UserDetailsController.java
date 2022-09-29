package com.example.demo;




import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class UserDetailsController {
	
	@RequestMapping("/sample")
	public UserResponse Sample(@RequestParam(value = "name" , defaultValue = "Vikash")String name,
			@RequestParam(value = "email" , defaultValue = "assd@sggc.com")String email) {
		UserResponse response = new UserResponse();
		response.setID(1);
		response.setName("Your name is" +name);
		response.setEmail("Email is" +email);
		//response.setPhoneno("Phoneno is" +phoneno);
		return response;
		
	}
	 @GetMapping( path = "/",produces = MediaType.APPLICATION_JSON_VALUE)
		  
		  
	  public UserList getUserList()
	   {
	       UserDAO userdao=new UserDAO();
	       return userdao.getAllUserList();
	           
	   }
	 @PostMapping(
	            path = "/",
	            consumes = MediaType.APPLICATION_JSON_VALUE,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	      
	        public ResponseEntity<Object> addMessage(
	            @RequestBody UserResponse response)
	        {
	              UserDAO userdao=new UserDAO();
	            
	            Integer id= userdao.getAllUserList().getUserList().size()+ 1;
	      
	            response.setID(id);
	      
	            userdao.addUser(response);
	      
	            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getID()) .toUri();
	      
	                   return ResponseEntity.created(location).build();
	        }

		       

}
