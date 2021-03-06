/**
 * 
 */
package com.imt.test.service.config;

import java.io.IOException;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import com.imt.test.service.util.PropertyFileLoader;

/**
 * @author imteyaza
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.imt.test", "com.imt.test.persistence" })
public class ServiceContextConfig {

	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource resourceBundleMessageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	
	@Bean
	PropertyFileLoader fileLoader(){
		return new PropertyFileLoader();
	}
	@Bean
	public PropertyPlaceholderConfigurer configurer() throws IOException{
		PropertyPlaceholderConfigurer configurer =  new PropertyPlaceholderConfigurer();
		configurer.setSearchSystemEnvironment(true);
		configurer.setLocation(fileLoader().loadProperties());
		return configurer;
	}

}
