package com.rachitblog.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rachitblog.blog.payloads.UserDto;
import com.rachitblog.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	@Qualifier("UserServiceImpl")
	private UserService userservice;
	
	UserDto createdUserDto = null ;
	
	@PostMapping("createUser")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		
		//Validation 
		createdUserDto = this.userservice.createUser(userDto);
		return new ResponseEntity<>(createdUserDto,HttpStatus.CREATED);	
	}
	
	//Post Create user
	
	//Put Update User
	
	//Get User
	
	//get All users
	
	//Delete user
}
