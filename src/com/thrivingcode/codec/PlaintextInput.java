package com.thrivingcode.codec;


class PlaintextInput extends Input {

	public PlaintextInput(Inputs inputs) {
		super(inputs, "Plain");
	}

	@Override protected Integer decode(String input) {
		return input.codePointAt(0);
	}

	@Override protected String encode(int codepoint) {
		return codePointToString(codepoint);
	}
}
