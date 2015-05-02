/**
 * 
 */
package com.imt.test.persistence.repo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imt.test.persistence.entity.User;

/**
 * @author imti
 *
 */
@Repository("userRepo")
public interface UserRepo extends JpaRepository<User, Long> {
	
	Logger logger = LoggerFactory.getLogger(UserRepo.class);
	
}
