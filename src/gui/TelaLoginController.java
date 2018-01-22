package gui;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import negocio.Fachada;
import negocio.IFachada;
import negocio.beans.Cliente;
import negocio.beans.Empresa;
import negocio.beans.Funcionario;

public class TelaLoginController {
	Object whoIsLogged = null;
	IFachada fachada = new Fachada();
	@FXML JFXTextField loginField;
	@FXML JFXPasswordField senhaField;
	


	public Object getWhoIsLogged() {
		return whoIsLogged;
	}



	public void setWhoIsLogged(Object whoIsLogged) {
		this.whoIsLogged = whoIsLogged;
	}



	public boolean LoginButton(String login) {
		login = loginField.getText();
		String senha = senhaField.getText();
		if(fachada.checarTipo(login) instanceof Cliente) {
			//JOptionPane.showMessageDialog(null, "VC É UM CLIENTE!");
			setWhoIsLogged(fachada.procurarCliente(login));
			return fachada.loginCliente(login, senha);
		} else if(fachada.checarTipo(login) instanceof Empresa) {
			//JOptionPane.showMessageDialog(null, "VC É UMA EMPRESA!");
			setWhoIsLogged(fachada.procurarEmpresa(login));
			return fachada.loginEmpresa(login, senha);
		} else if(fachada.checarTipo(login) instanceof Funcionario) {
			//JOptionPane.showMessageDialog(null, "VC É UM FUNCIONARIO!");
			setWhoIsLogged(fachada.procurarFuncionario(login));
			return fachada.loginFuncionario(login, senha);
		} else {
			return false;
		}
	}
	
	

}
