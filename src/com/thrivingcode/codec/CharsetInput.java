package com.thrivingcode.codec;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;

import org.apache.commons.lang3.StringUtils;

public abstract class CharsetInput extends Input {

	final private CharsetEncoder encoder;
	final private CharsetDecoder decoder;
	final private Charset charset;

	public CharsetInput(Inputs inputs, String label, String charsetName) {
		super(inputs, label);
		charset = Charset.forName(charsetName);
		encoder = charset.newEncoder().onMalformedInput(CodingErrorAction.REPORT);
		decoder = charset.newDecoder().onMalformedInput(CodingErrorAction.REPORT);
	}

	@Override protected String encode(int codepoint) {
		try {
			ByteBuffer bytes = encoder.encode(CharBuffer.wrap(Character.toChars(codepoint)));
			StringBuilder hex = new StringBuilder();
			for (int pos=0; pos<bytes.limit(); pos++)
				hex.append(StringUtils.leftPad(Integer.toHexString(0x000000FF & bytes.get(pos)).toUpperCase(), 2, "0"));
			return hex.toString();
		} catch (CharacterCodingException e) {
			return "(unsupported)";
		}
	}

	@Override protected Integer decode(String input) {
		if (input.length() % 2 != 0 || input.length() == 0)
			return null;
		
		byte[] bytes = new byte[input.length()/2];
		for (int pos=0; pos<input.length(); pos+=2) {
			try {
				bytes[pos/2] = ((byte)Integer.parseInt(input.substring(pos, pos+2), 16));
			} catch (NumberFormatException e) {
				return null;
			}
		}
		try {
			char[] chars = decoder.decode(ByteBuffer.wrap(bytes)).array();
			return Character.codePointAt(chars, 0);
		} catch (Exception e) {
			return null;
		}
	}

}