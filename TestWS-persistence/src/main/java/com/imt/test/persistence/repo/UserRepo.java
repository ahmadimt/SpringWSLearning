/**
 * 
 */
package com.imt.test.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imt.test.persistence.entity.User;

/**
 * @author imti
 *
 */
@Repository("userRepo")
public interface UserRepo extends JpaRepository<User, Long> {

}
