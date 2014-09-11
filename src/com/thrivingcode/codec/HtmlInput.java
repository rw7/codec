package com.thrivingcode.codec;

import org.apache.commons.lang3.StringEscapeUtils;

public class HtmlInput extends Input {

	HtmlInput(Inputs inputs) {
		super(inputs, "HTML escaped");
	}

	@Override protected int[] decode(String input) {
		String result = StringEscapeUtils.unescapeHtml4(input);
		if (result.length() != 1)
			return null;
		return stringToCodepoints(result);
	}

	@Override protected String encode(int[] codepoints) {
		return StringEscapeUtils.escapeHtml4(codepointsToString(codepoints));
	}

}
