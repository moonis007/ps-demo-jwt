package com.moonis.demo.restapi.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.moonis.demo.restapi.model.User;




@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	@Query(value="{\'email\':?0}")
	User findByEmail(String emailid);
	
	User findById(String userid);
	
	
	
	@Query(value="{'email':?0}",count=true)
	int findByEmailIfUserExists(String emailid);
	
}
