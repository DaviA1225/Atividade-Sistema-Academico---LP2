package br.edu.ifms.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ProgramaFX extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		BorderPane root = new FXMLLoader(getClass().getResource("/views/TelaInicial.fxml")).load();
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	
	
}
