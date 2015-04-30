/**
 * 
 */
package com.imt.test.service.base;

import java.util.Locale;

import org.springframework.context.MessageSource;

/**
 * @author imteyaza
 *
 */
public interface MessageSourceService extends MessageSource {
	Locale defaultLocale = Locale.US;
}
