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

import java.util.LinkedHashMap;
import java.util.Map;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

class Inputs {

	private Map<Input, TextField> inputs = new LinkedHashMap<>();
	private GridPane grid;
	int row = 0;

	Inputs(GridPane grid) {
		this.grid = grid;
	}

	void add(Input input) {
		Label labelNode = new Label(input.getLabel());
		grid.add(labelNode, 0, row);

		TextField textField = new TextField();
		textField.setMinWidth(300);
		textField.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override public void handle(KeyEvent event) {
				String text = textField.getText();
				update(input.decode(text), input);
			}
		});
		grid.add(textField, 1, row);
		inputs.put(input, textField);
		row++;
	}

	void add(Node node) {
		grid.add(node, 0, row++, 2, 1);
	}
	
	void update(String plaintext, Input except) {
		for (Map.Entry<Input, TextField> entry : inputs.entrySet()) {
			if (entry.getKey() == except)
				continue;
			entry.getValue().setText(entry.getKey().encodeAndSet(plaintext));
		}
	}
}
