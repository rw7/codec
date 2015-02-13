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

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;

class UrlInput implements Input {

	private final String encoding;
	private final CharsetEncoder encoder;

	UrlInput(String encoding) {
		this.encoding = encoding;
		encoder = Charset.forName(encoding).newEncoder().onMalformedInput(CodingErrorAction.REPORT);
	}
	
	@Override public String getLabel() {
		return "URL encoding with " + encoding + "\n(application/x-www-form-urlencoded)";
	}

	@Override public String decode(String input) {
		try {
			return URLDecoder.decode(input, encoding);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	@Override public String encode(String plaintext) {
		// URLEncoder replaces un-encodable characters instead of throwing an exception, hence we check beforehand
		if (!encoder.canEncode(plaintext))
			return null;
		try {
			return URLEncoder.encode(plaintext, encoding);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

}
