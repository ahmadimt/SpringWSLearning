/**
 * 
 */
package com.imt.test.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author imteyaza
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.imt.test", "com.imt.test.persistence" })
public class ServiceContextConfig {

}
