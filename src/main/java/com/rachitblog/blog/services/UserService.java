package com.rachitblog.blog.services;

import java.util.List;

import com.rachitblog.blog.payloads.UserDto;

public interface UserService {
//DEMO TEST PUSH VIA ECLIPSE
	//Once again
	
//	createUser(User user);
	
	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(UserDto user,Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId);
	
}
