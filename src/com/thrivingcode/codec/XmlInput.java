package com.thrivingcode.codec;

import org.apache.commons.lang3.StringEscapeUtils;

public class XmlInput extends Input {

	XmlInput(Inputs inputs) {
		super(inputs, "XML escaped");
	}

	@Override protected String decode(String input) {
		return StringEscapeUtils.unescapeXml(input);
	}

	@Override protected String encode(String plaintext) {
		return StringEscapeUtils.escapeXml(plaintext);
	}

}
