package com.thrivingcode.codec;

import javax.xml.bind.DatatypeConverter;

public class Base64Input extends HexInput {

	Base64Input(Inputs inputs) {
		super(inputs, "Base64 (inverse, hex)");
	}

	@Override protected byte[] encodeBinary(String plaintext) {
		try {
			return DatatypeConverter.parseBase64Binary(plaintext);
		}
		catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override protected String decodeBinary(byte[] bytes) {
		return DatatypeConverter.printBase64Binary(bytes);
	}

}
