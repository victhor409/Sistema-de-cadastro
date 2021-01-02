package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CadastrarPessoaController {

	@FXML
	private TextField txNome;
	
	@FXML
	private TextField txUsuario;
	
	@FXML
	private PasswordField txSenha;
	
	@FXML
	private Button ok;
	
	@FXML
	private Button cancelar;
	
	
	@FXML
	public void OnBtActionOk() {
		System.out.println("OK");
	}
	
	@FXML
	public void OnBtActionCancelar() {
		System.out.println("Cancelar");
	}
	
}
