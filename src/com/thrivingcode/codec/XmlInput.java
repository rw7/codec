package com.thrivingcode.codec;

import org.apache.commons.lang3.StringEscapeUtils;

public class XmlInput extends Input {

	XmlInput(Inputs inputs) {
		super(inputs, "XML escaped");
	}

	@Override protected int[] decode(String input) {
		String result = StringEscapeUtils.unescapeXml(input);
		return stringToCodepoints(result);
	}

	@Override protected String encode(int[] codepoints) {
		return StringEscapeUtils.escapeXml(codepointsToString(codepoints));
	}

}
