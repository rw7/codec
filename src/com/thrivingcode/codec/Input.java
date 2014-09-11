package com.thrivingcode.codec;

import java.util.Arrays;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

abstract class Input {
	private final TextField textField;

	Input(final Inputs inputs, final String label) {
		int row = inputs.nextRow();
		
		Label labelNode = new Label(label);
		inputs.getGrid().add(labelNode, 0, row);

		textField = new TextField();
		textField.setMinWidth(300);
		textField.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override public void handle(KeyEvent event) {
				String text = textField.getText();
				inputs.update(decode(text), Input.this);
			}
		});
		inputs.getGrid().add(textField, 1, row);
		inputs.add(this);
	}

	void encodeAndSet(int[] newCodepoints) {
		if (newCodepoints == null)
			textField.setText("(invalid input)");
		else
			textField.setText(encode(newCodepoints));
	}
	
	abstract protected int[] decode(String input);
	abstract protected String encode(int[] codepoints);

	protected String codepointsToString(int[] codepoints) {
		StringBuilder builder = new StringBuilder();
		for (int codepoint : codepoints)
			builder.append(Character.toChars(codepoint));
		return builder.toString();
	}

	protected int[] stringToCodepoints(final String string) {
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
