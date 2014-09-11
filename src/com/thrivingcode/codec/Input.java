package com.thrivingcode.codec;

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
		textField.setMinWidth(100);
		textField.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override public void handle(KeyEvent event) {
				String text = textField.getText();
				inputs.update(decode(text), Input.this);
			}
		});
		inputs.getGrid().add(textField, 1, row);
		inputs.add(this);
	}

	void encodeAndSet(Character newPlainText) {
		if (newPlainText == null)
			textField.setText("(invalid)");
		else
			textField.setText(encode(newPlainText.charValue()));
	}
	
	abstract protected Character decode(String input);
	abstract protected String encode(char newPlaintext);
}
