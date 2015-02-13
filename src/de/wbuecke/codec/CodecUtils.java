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

import java.util.Arrays;

class CodecUtils {
	
	static int[] stringToCodepoints(final String string) {
		final int[] result = new int[string.length()*2];
		int resultOffset = 0;
		for (int sourceOffset = 0; sourceOffset < string.length(); ) {
		   final int codepoint = string.codePointAt(sourceOffset);
		   result[resultOffset++] = codepoint;
		   sourceOffset += Character.charCount(codepoint);
		}
		return Arrays.copyOf(result, resultOffset);
	}

}
