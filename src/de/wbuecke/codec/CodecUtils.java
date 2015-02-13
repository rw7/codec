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
