package com.thrivingcode.codec;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CodecApplication extends Application {
	@Override public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Codec");
		Scene scene = new Scene(createForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private Parent createForm() {
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25));
		
		Inputs inputs = new Inputs(grid);
		new PlaintextInput(inputs);
		new CodepointNameInput(inputs);
		new CodepointHexInput(inputs);
		new Utf8Input(inputs);
		new Latin1Input(inputs);
		new HtmlInput(inputs);
		new XmlInput(inputs);

		inputs.update(0x1F602, null);
		
		return grid;
	}

	public static void main(String[] args) {
		launch();
	}
}
