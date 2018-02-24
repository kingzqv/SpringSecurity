package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.entity.Role;
import com.spring.entity.User;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserService userService;

	/*
	 * @Autowired private PasswordEncoder passwordEncoder;
	 */

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userService.findByName(username);
		if (user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
		/*
		 * System.out.println("Username:"+user.getUsername());
		 * System.out.println("Password:"+user.getPassword());
		 * System.out.println("CryptPassword:"+passwordEncoder.encode(user.getPassword()
		 * )); System.out.println("bcrypt√‹¬Î∂‘±»:" + passwordEncoder.matches("1",
		 * user.getPassword()));
		 */
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), 
				user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));
	}

	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role r : user.getRoles()) {
			System.out.println("Role : " + r.getRole());
			authorities.add(new SimpleGrantedAuthority("ROLE_" + r.getRole()));
		}
		System.out.println("authorities :"+authorities);
		return authorities;
	}
}
