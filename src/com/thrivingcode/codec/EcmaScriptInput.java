package com.thrivingcode.codec;

import org.apache.commons.lang3.StringEscapeUtils;

public class EcmaScriptInput extends Input {

	EcmaScriptInput(Inputs inputs) {
		super(inputs, "ECMAScript escaped\n(= Javascript = JSON)");
	}

	@Override protected String decode(String input) {
		return StringEscapeUtils.unescapeEcmaScript(input);
	}

	@Override protected String encode(String plaintext) {
		return StringEscapeUtils.escapeEcmaScript(plaintext);
	}

}
