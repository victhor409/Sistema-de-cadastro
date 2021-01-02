package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.utils.Alerts;
import model.utils.Utils;

public class LoginController implements Initializable{
	
	@FXML
	private TextField txUsuario;
	
	@FXML
	private PasswordField psSenha;
	
	@FXML
	private Button btLogin;
	
	@FXML
	private Button btCancelar;
	
	@FXML
	public void OnBtActionLogin(){
		if(txUsuario.getText().equals("Root")&& psSenha.getText().equals("1234")) {
			loadView("/gui/Main.fxml",x->{});
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			
			alert.setTitle("Error");
			alert.setHeaderText("Login Invalido");
			alert.setContentText("Erro Aconteceu devido Usuario ou senha invalidos");
			alert.show();
		}
	}
	
	
	@FXML
	public void OnBtActionCancelar(ActionEvent event) {
		Utils.currentStage(event).close();
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
	private synchronized<T> void loadView(String absoluteName,Consumer<T>initializingAction) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();

			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			T controller = loader.getController();
			initializingAction.accept(controller);
		}
		
		catch(IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
	
	
	
	
}
