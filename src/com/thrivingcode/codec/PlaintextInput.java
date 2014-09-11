package com.thrivingcode.codec;


class PlaintextInput extends Input {

	public PlaintextInput(Inputs inputs) {
		super(inputs, "Plain");
	}

	@Override protected int[] decode(String input) {
		return stringToCodepoints(input);
	}

	@Override protected String encode(int[] codepoints) {
		return codepointsToString(codepoints);
	}
}
