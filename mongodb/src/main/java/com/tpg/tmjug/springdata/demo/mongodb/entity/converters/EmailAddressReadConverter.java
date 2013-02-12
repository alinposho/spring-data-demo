package com.tpg.tmjug.springdata.demo.mongodb.entity.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.tpg.tmjug.springdata.demo.mongodb.entity.EmailAddress;

@Component
class EmailAddressReadConverter implements Converter<String, EmailAddress> {
	
	public EmailAddress convert(String source) {
		return StringUtils.hasText(source) ? new EmailAddress(source) : null;
	}
	
}