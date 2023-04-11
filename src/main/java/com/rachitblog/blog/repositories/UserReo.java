package com.rachitblog.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rachitblog.blog.entities.User;

public interface UserReo extends JpaRepository<User,Integer>{

}
