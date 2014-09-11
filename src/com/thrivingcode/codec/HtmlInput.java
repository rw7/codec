package com.thrivingcode.codec;

import org.apache.commons.lang3.StringEscapeUtils;

public class HtmlInput extends Input {

	HtmlInput(Inputs inputs) {
		super(inputs, "HTML escaped");
	}

	@Override protected Integer decode(String input) {
		String result = StringEscapeUtils.unescapeHtml4(input);
		if (result.length() != 1)
			return null;
		return result.codePointAt(0);
	}

	@Override protected String encode(int codepoint) {
		return StringEscapeUtils.escapeHtml4(codePointToString(codepoint));
	}

}
