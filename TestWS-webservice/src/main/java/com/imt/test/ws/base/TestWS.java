/**
 * 
 */
package com.imt.test.ws.base;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

/**
 * @author imteyaza
 *
 */
@Component
@Path("/home")
public class TestWS {
	
	@Path("/index")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHomePage(@Context HttpServletRequest request){
		
		return Response.status(200).build();
	}

}
