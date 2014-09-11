package com.thrivingcode.codec;

import org.apache.commons.lang3.StringUtils;


public abstract class HexInput extends Input {

	HexInput(Inputs inputs, String label) {
		super(inputs, label);
	}

	protected abstract byte[] encodeBinary(String plaintext);
	protected abstract String decodeBinary(byte[] bytes);
	
	@Override protected String encode(String plaintext) {
		byte[] bytes = encodeBinary(plaintext);
		if (bytes == null)
			return "(unsupported)";
		StringBuilder hex = new StringBuilder();
		for (int pos=0; pos<bytes.length; pos++)
			hex.append(StringUtils.leftPad(Integer.toHexString(0x000000FF & bytes[pos]).toUpperCase(), 2, "0"));
		return hex.toString();
	}

	@Override protected String decode(String input) {
		if (input.length() % 2 != 0 || input.length() == 0)
			return null;
		
		final byte[] bytes = new byte[input.length()/2];
		for (int pos=0; pos<input.length(); pos+=2) {
			try {
				bytes[pos/2] = ((byte)Integer.parseInt(input.substring(pos, pos+2), 16));
			} catch (NumberFormatException e) {
				return null;
			}
		}
		return decodeBinary(bytes);
	}
}
