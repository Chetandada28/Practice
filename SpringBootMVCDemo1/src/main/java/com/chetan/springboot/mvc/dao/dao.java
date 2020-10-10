package com.chetan.springboot.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chetan.springboot.mvc.entity.User;

public interface dao extends JpaRepository<User, String>{

}
