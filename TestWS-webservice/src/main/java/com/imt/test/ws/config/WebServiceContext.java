/**
 * 
 */
package com.imt.test.ws.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.imt.test.service.config.ServiceContextConfig;

/**
 * @author imteyaza
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.imt.test" })
@Import(ServiceContextConfig.class)
public class WebServiceContext {

}
