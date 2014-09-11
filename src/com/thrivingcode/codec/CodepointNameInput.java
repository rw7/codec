package com.thrivingcode.codec;


public class CodepointNameInput extends Input {

	CodepointNameInput(Inputs inputs) {
		super(inputs, "Unicode code point name\n(1st code point only)");
	}

	@Override protected String encode(String plaintext) {
		if (plaintext.length() > 0)
			return Character.getName(plaintext.codePointAt(0));
		else
			return "";
	}

	@Override protected String decode(String input) {
		String normalized = input.trim().toUpperCase();
		for (int codepoint=0; codepoint<0x20000; codepoint++) {
			if (normalized.equals(Character.getName(codepoint)))
				return String.copyValueOf(Character.toChars(codepoint));
		}
		return null;
	}
}
