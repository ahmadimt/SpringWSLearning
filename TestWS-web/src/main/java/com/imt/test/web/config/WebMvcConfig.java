/**
 * 
 */
package com.imt.test.web.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author imteyaza
 *
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.imt.test" })
// @PropertySource(value = { "classpath:application.properties" })
public class WebMvcConfig extends WebMvcConfigurationSupport {

	@Autowired
	private Environment environment;

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setExposeContextBeansAsAttributes(true);
		return viewResolver;
	}

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public ControllerClassNameHandlerMapping controllerClassNameHandlerMapping() {
		ControllerClassNameHandlerMapping classNameHandlerMapping = new ControllerClassNameHandlerMapping();
		return classNameHandlerMapping;

	}

	@Bean
	public SessionLocaleResolver sessionLocaleResolver() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("en"));
		return resolver;
	}

	@Bean
	public HandlerInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}

	@Bean
	RequestMappingHandlerMapping handlerMapping() {
		RequestMappingHandlerMapping mapping = new RequestMappingHandlerMapping();
		mapping = super.requestMappingHandlerMapping();
		mapping.setInterceptors(getInterceptors());
		return mapping;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(localeChangeInterceptor());
	}

}
