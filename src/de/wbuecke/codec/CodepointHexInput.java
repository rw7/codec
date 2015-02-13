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


class CodepointHexInput extends Input {

	CodepointHexInput(Inputs inputs) {
		super(inputs, "Unicode code point (hex)");
	}

	@Override protected String encode(String plaintext) {
		StringBuilder result = new StringBuilder();
		boolean first = true;
		for (int codepoint : stringToCodepoints(plaintext)) {
			if (!first)
				result.append(" ");
			first = false;
			result.append(Integer.toHexString(codepoint).toUpperCase());
		}
		return result.toString();
	}

	@Override protected String decode(String input) {
		try {
			String[] groups = input.split(" ");
			StringBuilder result = new StringBuilder();
			for (int i=0; i<groups.length; i++)
				result.append(Character.toChars(Integer.parseInt(groups[i], 16)));
			return result.toString();
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
