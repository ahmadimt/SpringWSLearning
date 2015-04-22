/**
 * 
 */
package com.imt.test.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author imteyaza
 *
 */
public class TestWsWebXmlJavaConfig extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebMvcConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

		context.register(WebMvcConfig.class);
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
				"dispatcherServlet", new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");

		ServletRegistration.Dynamic jesreyServlet = servletContext.addServlet(
				"jerseyServlet", new ServletContainer());
		jesreyServlet.setLoadOnStartup(1);
		jesreyServlet.setInitParameter(
				"com.sun.jersey.api.json.POJOMappingFeature", "true");
		jesreyServlet.setInitParameter(
				"com.sun.jersey.config.property.packages", "com.imt.test.ws");
		jesreyServlet.addMapping("/api/*");
	}

}
