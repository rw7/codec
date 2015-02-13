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
		inputs.add(new PlaintextInput(inputs));
		inputs.add(new CodepointHexInput(inputs));
		inputs.add(new CodepointNameInput(inputs));
		inputs.add(new Separator());
		inputs.add(new HtmlInput(inputs));
		inputs.add(new XmlInput(inputs));
		inputs.add(new EcmaScriptInput(inputs));
		inputs.add(new UrlInput(inputs, "UTF-8"));
		inputs.add(new UrlInput(inputs, "ISO-8859-1"));
		inputs.add(new Separator());
		inputs.add(new Base64Input(inputs));
		inputs.add(new Separator());
		inputs.add(new CharsetHexInput(inputs, "UTF-8"));
		inputs.add(new CharsetHexInput(inputs, "UTF-16BE"));
		inputs.add(new CharsetHexInput(inputs, "US-ASCII"));
		inputs.add(new CharsetHexInput(inputs, "ISO-8859-1", "ISO-8859-1 (Latin-1, \"Western ISO\")"));
		inputs.add(new CharsetHexInput(inputs, "ISO-8859-2", "ISO-8859-2 (\"Central Europe ISO\")"));
		inputs.add(new CharsetHexInput(inputs, "ISO-8859-15"));
		inputs.add(new CharsetHexInput(inputs, "Windows-1250", "Windows/CP-1250 (\"Central Europe\")"));
		inputs.add(new CharsetHexInput(inputs, "Windows-1251", "Windows/CP-1251 (\"Cyrillic\")"));
		inputs.add(	new CharsetHexInput(inputs, "Windows-1252", "Windows/CP-1252 (\"Western\")"));
		inputs.add(new CharsetHexInput(inputs, "GB2312", "GB2312 (official in China)"));
		inputs.add(new CharsetHexInput(inputs, "Cp1047", "EBCDIC (CP1047)"));
	
		inputs.update(String.copyValueOf(Character.toChars(0x1F602)), null);

		return grid;
	}

	public static void main(String[] args) {
		launch();
	}
}
