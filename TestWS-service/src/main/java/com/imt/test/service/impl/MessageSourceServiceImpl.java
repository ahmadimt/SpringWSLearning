/**
 * 
 */
package com.imt.test.service.impl;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import com.imt.test.service.base.MessageSourceService;

/**
 * @author imteyaza
 *
 */
@Component
public class MessageSourceServiceImpl implements MessageSourceService {

	@Autowired
	@Resource(name="messageSource")
	private MessageSource messageSource;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.MessageSource#getMessage(java.lang.String,
	 * java.lang.Object[], java.lang.String, java.util.Locale)
	 */
	@Override
	public String getMessage(String code, Object[] args, String defaultMessage,
			Locale locale) {
		return messageSource.getMessage(code, args, defaultMessage, locale);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.MessageSource#getMessage(java.lang.String,
	 * java.lang.Object[], java.util.Locale)
	 */
	@Override
	public String getMessage(String code, Object[] args, Locale locale)
			throws NoSuchMessageException {
		// TODO Auto-generated method stub
		return messageSource.getMessage(code, args, locale);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.MessageSource#getMessage(org.springframework
	 * .context.MessageSourceResolvable, java.util.Locale)
	 */
	@Override
	public String getMessage(MessageSourceResolvable resolvable, Locale locale)
			throws NoSuchMessageException {
		// TODO Auto-generated method stub
		return messageSource.getMessage(resolvable, locale);
	}

}
