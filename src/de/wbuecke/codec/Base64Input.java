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

import javax.xml.bind.DatatypeConverter;

class Base64Input extends HexInput {

	Base64Input(Inputs inputs) {
		super(inputs, "Base64 (inverse, hex)");
	}

	@Override protected byte[] encodeBinary(String plaintext) {
		try {
			return DatatypeConverter.parseBase64Binary(plaintext);
		}
		catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override protected String decodeBinary(byte[] bytes) {
		return DatatypeConverter.printBase64Binary(bytes);
	}

}
