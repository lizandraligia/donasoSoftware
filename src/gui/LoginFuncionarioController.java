package gui;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import negocio.Fachada;
import negocio.IFachada;

public class LoginFuncionarioController {

	@FXML TextField tfLogin;
	@FXML PasswordField tfSenha;
	
	IFachada fachada = Fachada.getInstance();
	
	public void Login(){
		String login = this.tfLogin.getText();
		String senha = this.tfSenha.getText();
		try{
			this.fachada.loginFuncionario(login, senha);
			//ScreenManager.getInstance().getMenuCliente();

		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
}
