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

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
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
		new CodepointHexInput(inputs);
		new CodepointNameInput(inputs);
		inputs.add(new Separator());
		new HtmlInput(inputs);
		new XmlInput(inputs);
		new EcmaScriptInput(inputs);
		new UrlInput(inputs, "UTF-8");
		new UrlInput(inputs, "ISO-8859-1");
		inputs.add(new Separator());
		new Base64Input(inputs);
		inputs.add(new Separator());
		new CharsetHexInput(inputs, "US-ASCII");
		new CharsetHexInput(inputs, "UTF-8");
		new CharsetHexInput(inputs, "ISO-8859-1");
		new CharsetHexInput(inputs, "ISO-8859-15");
		new CharsetHexInput(inputs, "UTF-16BE");
		new CharsetHexInput(inputs, "Windows-1251");
		new CharsetHexInput(inputs, "GB2312");
		new CharsetHexInput(inputs, "Cp1047", "EBCDIC");

		inputs.update(String.copyValueOf(Character.toChars(0x1F602)), null);
		
		return grid;
	}

	public static void main(String[] args) {
		launch();
	}
}
