package com.thrivingcode.codec;

import org.apache.commons.lang3.StringEscapeUtils;

public class XmlInput extends Input {

	XmlInput(Inputs inputs) {
		super(inputs, "XML escaped");
	}

	@Override protected Integer decode(String input) {
		String result = StringEscapeUtils.unescapeXml(input);
		return result.codePointAt(0);
	}

	@Override protected String encode(int codepoint) {
		return StringEscapeUtils.escapeXml(codePointToString(codepoint));
	}

}
