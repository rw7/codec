package com.thrivingcode.codec;

import org.apache.commons.lang3.StringEscapeUtils;

public class HtmlInput extends Input {

	HtmlInput(Inputs inputs) {
		super(inputs, "HTML escaped");
	}

	@Override protected Character decode(String input) {
		String result = StringEscapeUtils.unescapeHtml4(input);
		if (result.length() != 1)
			return null;
		return result.charAt(0);
	}

	@Override protected String encode(char newPlaintext) {
		return StringEscapeUtils.escapeHtml4(newPlaintext+"");
	}

}
