package com.thrivingcode.codec;


public class UnicodeInput extends Input {

	UnicodeInput(Inputs inputs) {
		super(inputs, "Unicode code point (hex)");
	}

	@Override protected String encode(char character) {
		return Integer.toHexString(character).toUpperCase();
	}

	@Override protected Character decode(String input) {
		try {
			return (char)Integer.parseInt(input, 16);
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
