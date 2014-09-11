package com.thrivingcode.codec;


class PlaintextInput extends Input {

	public PlaintextInput(Inputs inputs) {
		super(inputs, "Plain");
	}

	@Override protected String decode(String input) {
		return input;
	}

	@Override protected String encode(String plaintext) {
		return plaintext;
	}
}
