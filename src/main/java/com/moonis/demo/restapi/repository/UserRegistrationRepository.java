package com.moonis.demo.restapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.DuplicateKeyException;
import com.moonis.demo.restapi.model.AppUser;
import com.moonis.demo.restapi.model.User;

@Repository
public class UserRegistrationRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public AppUser getUser(String fname ) {
		return mongoTemplate.findOne(new Query(Criteria.where("fname").is(fname)), AppUser.class);
	}
	
	public List<User> getAllUser() {
		return mongoTemplate.findAll(User.class);
	}
	
	
}
