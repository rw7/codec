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

	@Override protected String encode(char character) {
		try {
			String hex = "";
			CharBuffer buffer = CharBuffer.allocate(1);
			buffer.append(character);
			buffer.rewind();
			ByteBuffer bytes = encoder.encode(buffer);
			for (int pos=0; pos<bytes.limit(); pos++)
				hex += StringUtils.leftPad(Integer.toHexString(0x000000FF & bytes.get(pos)), 2, "0");
			return hex.toUpperCase();
		} catch (CharacterCodingException e) {
			return "(unsupported)";
		}
	}

	@Override protected Character decode(String input) {
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
			return decoder.decode(ByteBuffer.wrap(bytes)).get();
		} catch (Exception e) {
			return null;
		}
	}

}