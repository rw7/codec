package com.thrivingcode.codec;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlInput extends Input {

	private final String encoding;

	UrlInput(Inputs inputs, String encoding) {
		super(inputs, "URL encoding with " + encoding + "\n(application/x-www-form-urlencoded)");
		this.encoding = encoding;
	}

	@Override protected String decode(String input) {
		try {
			return URLDecoder.decode(input, encoding);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	@Override protected String encode(String plaintext) {
		try {
			return URLEncoder.encode(plaintext, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

}
