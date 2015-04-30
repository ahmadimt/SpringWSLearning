/**
 * 
 */
package com.imt.test.ws.base;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imt.test.persistence.entity.User;
import com.imt.test.service.base.UserService;
import com.imt.test.service.impl.MessageSourceServiceImpl;
import com.imt.test.service.util.ErrorMessageKey;

/**
 * @author imteyaza
 *
 */
@Component
@Path("/home")
public class TestWS {

	@Autowired
	private UserService userService;

	@Autowired
	private MessageSourceServiceImpl messageSourceServiceImpl;

	// private final String firstName = "label.firstName";

	@Path("/index")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public @ResponseBody Response getHomePage(
			@Context HttpServletRequest request) {

		List<User> users = userService.getUser();
		String label = messageSourceServiceImpl.getMessage(ErrorMessageKey.FIRST_NAME, new Object[] {},request.getLocale());
		if (users.isEmpty()) {
			return Response.ok(label).build();
		}

		return Response.ok(users).build();
	}

}
