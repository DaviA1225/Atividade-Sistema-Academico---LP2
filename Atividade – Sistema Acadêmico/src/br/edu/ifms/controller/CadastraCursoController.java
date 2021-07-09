package br.edu.ifms.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ifms.dao.CursoDao;
import br.edu.ifms.dao.ICursoDao;
import br.edu.ifms.model.Cursos;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CadastraCursoController implements Initializable {
	
	@FXML
	private BorderPane cadastraCursoRoot;
	
	@FXML
	private ComboBox<String> comboboxNivel;
	
	@FXML
	private ComboBox<String> comboboxSituacao;
	
	@FXML
	private TextArea textAreaCadastro;
	
	@FXML
	private Text alertTextCadastro;
	
	@FXML
	private TextArea textFieldCargaHr;
	
	
	String[] nivelCurso = {"1 - Ensino Fundamental", "2 - Ensino Medio", "3 - Ensino Superior"};
	String[] situacaoCurso = {"1 - Em curso", "2 - Inativo"};
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		comboboxNivel.setItems(FXCollections.observableArrayList(nivelCurso));
		comboboxNivel.setValue(nivelCurso[0]);
		
		comboboxSituacao.setItems(FXCollections.observableArrayList(situacaoCurso));
		comboboxSituacao.setValue(situacaoCurso[0]);
		
	}
	
	public void cadastrarCurso() {
		String nomeCurso= textAreaCadastro.getText();
		String cargaHoraria=textFieldCargaHr.getText(); 
		
		int chInt=Integer.parseInt(cargaHoraria);
		
		if(nomeCurso.isEmpty()) {
			textAreaCadastro.setText("Obrigatório escrever o nome do Curso");
		}else if(chInt <= 0) {
			textFieldCargaHr.setText("Informe uma carga Horaria Valida");
			
		}else {
			int nivel = comboboxNivel.getSelectionModel().getSelectedIndex() + 1;
			int situacaoInt = comboboxSituacao.getSelectionModel().getSelectedIndex();
			boolean situacao = situacaoInt == 1 ? false:true;
			
			Cursos cursos = new Cursos();
			
			try {
				cursos.setNivel(nivel);
				cursos.setNome(nomeCurso);
				cursos.setCargaHoraria(chInt);
				cursos.setSituacao(situacao);
				
				ICursoDao cursoDao = new CursoDao();
				cursoDao.cadastrar(cursos);
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("CadastroRealizado");
				alert.setHeaderText(null);
				alert.setContentText("Curso Cadastrado");
				alert.showAndWait();
				
				
				lauchTelaInicial();
				
			} catch (Exception e) {
				
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erroooouu");
				alert.setHeaderText(null);
				alert.setContentText("Erro: " + e.getMessage());
				alert.showAndWait();
			}
			
			
			
			
			
			
		}
		
		
	}
	
	public void lauchTelaInicial() {
		try {
			BorderPane root = new FXMLLoader(getClass().getResource("/views/TelaInicial.fxml")).load();
			Scene scene = new Scene(root);
			
			Stage primaryStage = (Stage) cadastraCursoRoot.getScene().getWindow(); 
			primaryStage.setScene(scene);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void cancelar() {
		lauchTelaInicial();
	}
	}
		
		
