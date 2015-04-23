/**
 * 
 */
package com.imt.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imt.test.persistence.entity.User;
import com.imt.test.persistence.repo.UserRepo;
import com.imt.test.service.base.UserService;

/**
 * @author imti
 *
 */
@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.imt.test.service.base.UserService#getUser()
	 */
	@Override
	public List<User> getUser() {
		return userRepo.findAll();
	}

}
