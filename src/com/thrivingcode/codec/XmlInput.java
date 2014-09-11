package com.thrivingcode.codec;

import org.apache.commons.lang3.StringEscapeUtils;

public class XmlInput extends Input {

	XmlInput(Inputs inputs) {
		super(inputs, "XML escaped");
	}

	@Override protected Character decode(String input) {
		String result = StringEscapeUtils.unescapeXml(input);
		if (result.length() != 1)
			return null;
		return result.charAt(0);
	}

	@Override protected String encode(char newPlaintext) {
		return StringEscapeUtils.escapeXml(newPlaintext+"");
	}

}
