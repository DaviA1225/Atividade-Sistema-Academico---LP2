package br.edu.ifms.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import br.edu.ifms.dao.CursoDao;
import br.edu.ifms.dao.ICursoDao;
import br.edu.ifms.model.Cursos;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ListaCursoController implements Initializable {

	@FXML
	private BorderPane listarCursoRoot;

	@FXML
	private TableView<Cursos> tableCursos;

	@FXML
	private TableColumn<Cursos, Integer> columCodigo;

	@FXML
	private TableColumn<Cursos, String> columNivel;

	@FXML
	private TableColumn<Cursos, String> columNome;
	
	@FXML
	private TableColumn<Cursos, Integer> columCargaHoraria;
	
	@FXML
	private TableColumn<Cursos, String> columSituacao;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		

		columCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		columNivel.setCellValueFactory(new PropertyValueFactory<>("nomeNivel"));
		columNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		columCargaHoraria.setCellValueFactory(new PropertyValueFactory<>("cargaHoraria"));
		columSituacao.setCellValueFactory(new PropertyValueFactory<>("situacao"));
		//columSituacao.setCellValueFactory(new PropertyValueFactory<>("situacaoTexto")); Caso queira o nome da SITUACAO
		
		
		ICursoDao cursoDao = new CursoDao();
		try {
			tableCursos.setItems(FXCollections.observableArrayList(cursoDao.buscarTodos()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	/*public void showCadastrarCurso() {

		try {
			BorderPane root = new FXMLLoader(getClass().getResource("/views/CadastraCurso.fxml")).load();
			Scene scene = new Scene(root);

			Stage primaryStage = (Stage) listarCursoRoot.getScene().getWindow();
			primaryStage.setScene(scene);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	
	
	public void showVoltar() {
		
		try {
			BorderPane root = new FXMLLoader(getClass().getResource("/views/TelaInicial.fxml")).load();
			Scene scene = new Scene(root);
			
			Stage primaryStage = (Stage) listarCursoRoot.getScene().getWindow(); 
			primaryStage.setScene(scene);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
