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

import org.apache.commons.lang3.StringUtils;

abstract class HexInput extends Input {

	HexInput(Inputs inputs, String label) {
		super(inputs, label);
	}

	protected abstract byte[] encodeBinary(String plaintext);
	protected abstract String decodeBinary(byte[] bytes);
	
	@Override protected String encode(String plaintext) {
		byte[] bytes = encodeBinary(plaintext);
		if (bytes == null)
			return null;
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
