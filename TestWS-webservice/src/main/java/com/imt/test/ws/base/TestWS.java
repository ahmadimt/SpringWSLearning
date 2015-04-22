/**
 * 
 */
package com.imt.test.ws.base;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author imteyaza
 *
 */
@Component
@Path("/home")
public class TestWS {

	@Path("/index")
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody Response getHomePage(@Context HttpServletRequest request) {

		return Response.status(200).build();
	}

}
