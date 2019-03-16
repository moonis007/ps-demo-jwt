package com.moonis.demo.restapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.moonis.demo.restapi.model.AppUser;
import com.moonis.demo.restapi.model.Role;
import com.moonis.demo.restapi.model.User;
import com.moonis.demo.restapi.repository.AppUserRepository;


@Component
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private UserService UserService;
    
    AppUser user;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         user = appUserRepository.findByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", username));
        }else
        {
        	if(user.getStatus()!=1) {
        		//TODO- Need to update with custom exception.
        		throw new UsernameNotFoundException(String.format("The username %s account is not enabled", username));
        	}
        }

        System.out.println(user.getUsername()+" | "+user.getPassword());
         // added on 10-dec-2018 to update last login details
         UserService.updateLastLogin(user.getUsername());        
        //end 10-dec-2018
        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        
        
        
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        return userDetails;
        
    }
    
    @Override
    public boolean equals(Object otherUser) {
        if(otherUser == null) { 
        	System.out.println("false");
        	return false;
        	}
        else if (!(otherUser instanceof UserDetails)) { 
        	System.out.println("diff false");
        	return false;
        	}
        else {
        	System.out.println("result "+ (otherUser.hashCode() == hashCode()));
        	return (otherUser.hashCode() == hashCode());
        }
    }

    @Override
    public int hashCode() {
    	System.out.println(user.getUsername().hashCode());
        return user.getUsername().hashCode() ;
    }
    
}
