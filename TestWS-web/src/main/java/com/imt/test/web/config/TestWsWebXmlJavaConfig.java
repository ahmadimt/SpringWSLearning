/**
 * 
 */
package com.imt.test.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * @author imteyaza
 *
 */
public class TestWsWebXmlJavaConfig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {

		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(ApplicationContextConfig.class);
		applicationContext.setServletContext(servletContext);
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
				"SpringDispatcher", new ServletContainer());
		dispatcher.setInitParameter("jersey.config.server.provider.packages",
				"com.imt.test");
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

}
