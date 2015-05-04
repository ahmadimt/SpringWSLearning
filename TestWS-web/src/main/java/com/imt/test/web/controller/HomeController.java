/**
 * 
 */
package com.imt.test.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author imteyaza
 *
 */
@Controller
public class HomeController {
	
	final static Logger logger = LoggerFactory.getLogger(HomeController.class) ;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("logging in logback");
		return "home";
	}
}
