package br.edu.ifms.controller;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TelaInicialController {
	
	@FXML
	private BorderPane telaInicial;
	
	
	
	public void showCadastrarCurso() throws IOException{
		
		try {
			BorderPane root = new FXMLLoader(getClass().getResource("/views/CadastraCurso.fxml")).load();
			Scene scene = new Scene(root);
			
			Stage primaryStage = (Stage) telaInicial.getScene().getWindow(); 
			primaryStage.setScene(scene);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void showListarCursos() {
		try {
			BorderPane root = new FXMLLoader(getClass().getResource("/views/ListarCurso.fxml")).load();
			Scene scene = new Scene(root);
			
			Stage primaryStage = (Stage) telaInicial.getScene().getWindow(); 
			primaryStage.setScene(scene);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
