package com.thrivingcode.codec;

import org.apache.commons.lang3.CharEncoding;

public class Utf8Input extends CharsetHexInput {

	Utf8Input(Inputs inputs) {
		super(inputs, "UTF-8 (hex)", CharEncoding.UTF_8);
	}
}
