package com.moonis.demo.restapi.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.moonis.demo.restapi.model.AppUser;

@Repository
public interface AppUserRepository extends MongoRepository<AppUser, String>{
	AppUser findByUsername(String username);
	
	AppUser findByResetoken(String resetoken);
}