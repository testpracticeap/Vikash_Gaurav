package com.API.Message;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.API.Message.SampleResponse;
import com.API.Message.PostRequest;


@RestController
public class MessageController {
	@RequestMapping("/")
	
	public SampleResponse response(@RequestParam(value = "message",defaultValue = "000")String message) {
        int count = 0;
		SampleResponse response = new SampleResponse();
		response.setId(1);
		Random random = new Random(System.nanoTime());
		
		//response.setName("Hi this is" +name);
		for(int i=0;i<=5;i++) {
			count = random.nextInt(20);
		}
		
		response.setMessage("Hi This is Dummy API" + count +message);
		
		return response;
	}
	
	
	
	
	

	
	
	
	
	
	
	

	}
	
	
	
	
		
		
	
	
	


