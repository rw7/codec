package com.thrivingcode.codec;


public class CodepointHexInput extends Input {

	CodepointHexInput(Inputs inputs) {
		super(inputs, "Unicode code point (hex)");
	}

	@Override protected String encode(String plaintext) {
		StringBuilder result = new StringBuilder();
		boolean first = true;
		for (int codepoint : stringToCodepoints(plaintext)) {
			if (!first)
				result.append(" ");
			first = false;
			result.append(Integer.toHexString(codepoint).toUpperCase());
		}
		return result.toString();
	}

	@Override protected String decode(String input) {
		try {
			String[] groups = input.split(" ");
			StringBuilder result = new StringBuilder();
			for (int i=0; i<groups.length; i++)
				result.append(Character.toChars(Integer.parseInt(groups[i], 16)));
			return result.toString();
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
