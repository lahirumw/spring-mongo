package com.sample.mogo.controller;

/*
 * @   Developed by LahiruA 10/05/2016
 * @   Spring REST API with Mongo DB
 * @   User Management
 * 
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.mogo.dao.UserDao;
import com.sample.mogo.domain.User;


//https://github.com/lahirumw/spring-mongo.git

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/user/{lastname}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User getUser(@PathVariable String lastname){
		
		return userDao.getUserById(lastname);
	}
	
	@RequestMapping(value="/user/saveUser" , method=RequestMethod.POST)
	public @ResponseBody String addUserInfo(@RequestBody User user){
		
		return userDao.addUser(user);
	}

}
