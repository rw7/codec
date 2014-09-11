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
