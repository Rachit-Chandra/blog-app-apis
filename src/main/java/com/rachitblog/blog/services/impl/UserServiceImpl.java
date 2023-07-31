package com.rachitblog.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rachitblog.blog.entities.User;
import com.rachitblog.blog.exceptions.ResourceNotFoundException;
import com.rachitblog.blog.payloads.UserDto;
import com.rachitblog.blog.repositories.UserRepo;
import com.rachitblog.blog.services.UserService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	User user, savedUser = null;
	UserDto userDto, updatedUser = null;
	List<UserDto> userDtos = null;
	List<User> users = null;

	@Override
	public UserDto createUser(UserDto userDto) {

		user = this.dtoToUser(userDto);
		savedUser = this.userRepo.save(user);
		log.info("User saved");
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {

		user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());

		savedUser = this.userRepo.save(user);

		updatedUser = this.userToDto(savedUser);

		return updatedUser;
	}

	@Override
	public UserDto getUserById(Integer userId) {

		user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		users = this.userRepo.findAll();
		userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());

		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		
//		this.userRepo.deleteById(userId);
		user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id", userId));
		this.userRepo.delete(user);
	}

	public User dtoToUser(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());

		return user;
	}

	public UserDto userToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setAbout(user.getAbout());

		return userDto;
	}

}