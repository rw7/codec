package com.thrivingcode.codec;


class PlaintextInput extends Input {

	public PlaintextInput(Inputs inputs) {
		super(inputs, "Plain");
	}

	@Override protected Character decode(String input) {
		if (input.length() != 1)
			return null;
		return input.charAt(0);
	}

	@Override protected String encode(char character) {
		return character+"";
	}

}
