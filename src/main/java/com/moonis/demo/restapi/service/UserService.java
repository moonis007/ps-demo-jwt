package com.moonis.demo.restapi.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moonis.demo.restapi.model.AppUser;
import com.moonis.demo.restapi.model.Role;
import com.moonis.demo.restapi.model.User;
import com.moonis.demo.restapi.repository.AppUserRepository;
import com.moonis.demo.restapi.repository.UserRepository;

import lombok.NonNull;



@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	AppUserRepository appUserRepository;

	
	
	
	
	
		
	
	/**
	 * @param email
	 * @return
	 */
	public String updateLastLogin(@NonNull String email) {
		User user=userRepository.findByEmail(email);
		user.setLastlogin(new Date());
		userRepository.save(user);
		return "done";
		
	}
	
	
	
		
	
	
	/**
	 * @param emailId
	 * @return
	 */
	public AppUser getUserByUserName(String emailId) {		
		return appUserRepository.findByUsername(emailId);
	}
	
	
	/**
	 * @param token
	 * @return
	 */
	public AppUser getAppUserByToken(String token) {		
		return appUserRepository.findByResetoken(token);
	}
	
	/**
	 * @param aUser
	 * @return
	 */
	public AppUser saveAppUser(AppUser aUser) {		
		return appUserRepository.save(aUser);
	}
	
	


}
