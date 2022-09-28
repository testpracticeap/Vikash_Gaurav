package com.example.demo;




import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
		       

}
