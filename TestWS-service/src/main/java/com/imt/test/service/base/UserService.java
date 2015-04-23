/**
 * 
 */
package com.imt.test.service.base;

import java.util.List;

import org.springframework.stereotype.Component;

import com.imt.test.persistence.entity.User;

/**
 * @author imti
 *
 */
@Component
public interface UserService {

	List<User> getUser();
}
