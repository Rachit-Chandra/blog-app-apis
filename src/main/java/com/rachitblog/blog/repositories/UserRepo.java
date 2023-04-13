package com.rachitblog.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rachitblog.blog.entities.User;


public interface UserRepo extends JpaRepository<User,Integer>{

}
