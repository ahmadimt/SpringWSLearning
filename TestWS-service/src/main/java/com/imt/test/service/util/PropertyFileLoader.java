/**
 * 
 */
package com.imt.test.service.util;

import java.io.IOException;
import java.util.Properties;

/**
 * @author imteyaza
 *
 */
public class PropertyFileLoader {

	public static Properties applicationProperties= null;
	public void init() throws IOException {
		String userCatHome = System.getenv("CATALINA_HOME");
		String userDirPath = System.getProperty("user.dir");
	}

}
