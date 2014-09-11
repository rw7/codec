package com.thrivingcode.codec;

import org.apache.commons.lang3.CharEncoding;

public class Utf8Input extends CharsetInput {

	Utf8Input(Inputs inputs) {
		super(inputs, "UTF-8 (hex)", CharEncoding.UTF_8);
	}
}
