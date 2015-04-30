/**
 * 
 */
package com.imt.test.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

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

}
