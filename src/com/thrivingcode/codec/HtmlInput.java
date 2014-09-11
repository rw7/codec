package com.thrivingcode.codec;

import org.apache.commons.lang3.StringEscapeUtils;

public class HtmlInput extends Input {

	HtmlInput(Inputs inputs) {
		super(inputs, "HTML escaped");
	}

	@Override protected String decode(String input) {
		return StringEscapeUtils.unescapeHtml4(input);
	}

	@Override protected String encode(String plaintext) {
		return StringEscapeUtils.escapeHtml4(plaintext);
	}

}
