/**
 * 
 */
package com.imt.test.service.util;

import java.io.IOException;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * @author imteyaza
 *
 */
@Component
public class PropertyFileLoader implements ResourceLoaderAware {

	private ResourceLoader resourceLoader;
	final String CONFIG_DIR = System.getProperty("config.dir");

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;

	}

	public Resource loadProperties() throws IOException {
		Resource resource = resourceLoader.getResource("file:" + CONFIG_DIR
				+ "/application.properties");
		return resource;
	}
}
