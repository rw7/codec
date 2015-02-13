/*
 * Copyright (C) 2014 Wolfgang Buecke
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package de.wbuecke.codec;


class CodepointNameInput extends Input {

	CodepointNameInput(Inputs inputs) {
		super(inputs, "Unicode code point name\n(1st code point only)");
	}

	@Override protected String encode(String plaintext) {
		if (plaintext.length() > 0)
			return Character.getName(plaintext.codePointAt(0));
		else
			return "";
	}

	@Override protected String decode(String input) {
		String normalized = input.trim().toUpperCase();
		for (int codepoint=0; codepoint<0x20000; codepoint++) {
			if (normalized.equals(Character.getName(codepoint)))
				return String.copyValueOf(Character.toChars(codepoint));
		}
		return null;
	}
}
