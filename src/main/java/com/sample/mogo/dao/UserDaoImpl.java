package com.sample.mogo.dao;

/*
* @   Developed by LahiruA 10/05/2016
* @   Spring REST API with Mongo DB
* @   User Management
* 
* */

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.sample.mogo.domain.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public static final String COLLECTION_NAME = "user";

	public List<User> getUser() {
		return mongoTemplate.findAll(User.class, COLLECTION_NAME);
	}
	
	public User getUserById(String lastname){
		Query query = new Query();
		query.addCriteria(Criteria.where("lastname").is(lastname));
		User user =  mongoTemplate.findOne(query, User.class);
		System.out.println(user.getFirstName());
		return user;
	}
	
	public String addUser(User user) {
		try{
			if (!mongoTemplate.collectionExists(User.class)) {
				mongoTemplate.createCollection(User.class);
			}		
			user.setId(UUID.randomUUID().toString());
			mongoTemplate.insert(user, COLLECTION_NAME);
			return "Succseefully Saved..!";
		}catch(Exception e){
			return "Can not insert the record..";
		}
	}
	
	public void deleteUser(User user) {
		mongoTemplate.remove(user, COLLECTION_NAME);
	}
	
	public void updateUser(User user) {
		mongoTemplate.insert(user, COLLECTION_NAME);		
	}


}
