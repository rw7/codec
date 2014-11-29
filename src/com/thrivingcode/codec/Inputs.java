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
 
package com.thrivingcode.codec;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

class Inputs {

	private List<Input> inputs = new ArrayList<>();
	private GridPane grid;
	int row = 0;

	public Inputs(GridPane grid) {
		this.grid = grid;
	}

	void add(Input input) {
		inputs.add(input);
	}

	public void add(Node node) {
		int r = row++;
		grid.add(node, 0, r, 2, 1);
	}
	
	public int nextRow() {
		return row++;
	}

	GridPane getGrid() {
		return grid;
	}

	public void update(String plaintext, Input except) {
		for (Input input : inputs) {
			if (input == except)
				continue;
			input.encodeAndSet(plaintext);
		}
	}
}
