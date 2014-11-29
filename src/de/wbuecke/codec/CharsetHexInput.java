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

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;

class CharsetHexInput extends HexInput {

	final private CharsetEncoder encoder;
	final private CharsetDecoder decoder;
	final private Charset charset;

	public CharsetHexInput(Inputs inputs, String charsetName) {
		this(inputs, charsetName, charsetName);
	}
	
	public CharsetHexInput(Inputs inputs, String charsetName, String label) {
		super(inputs, label + " (hex)");
		charset = Charset.forName(charsetName);
		encoder = charset.newEncoder().onMalformedInput(CodingErrorAction.REPORT);
		decoder = charset.newDecoder().onMalformedInput(CodingErrorAction.REPORT);
	}

	@Override
	protected byte[] encodeBinary(String plaintext) {
		try {
			System.out.println(encoder.encode(CharBuffer.wrap(plaintext)).limit());
			ByteBuffer bb = encoder.encode(CharBuffer.wrap(plaintext));
			byte[] b = new byte[bb.remaining()];
			bb.get(b);
			return b;
		} catch (CharacterCodingException e) {
			return null;
		}
	}

	@Override
	protected String decodeBinary(final byte[] bytes) {
		try {
			return decoder.decode(ByteBuffer.wrap(bytes)).toString();
		} catch (CharacterCodingException e) {
			return null;
		}
	}
}
