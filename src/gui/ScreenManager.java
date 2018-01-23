package gui;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class ScreenManager {

	BorderPane border, paneLoginCliente, paneMenuCliente, paneMenuEmpresa;
	BorderPane paneMenuFuncionario, paneTelaInicio, paneCriarConta;
	FXMLLoader loginCliente, menuCliente, menuEmpresa, menuFuncionario, telaInicio, criarConta;

	
	public static ScreenManager instancia;
	
	public static synchronized ScreenManager getInstance(){
		if(instancia == null){
			instancia = new ScreenManager();
		}
		return instancia;
	}
	
	private ScreenManager(){
		try {
			loginCliente = new FXMLLoader(this.getClass().getResource("LoginCliente.fxml"));
			this.paneLoginCliente = loginCliente.load();
			criarConta = new FXMLLoader(this.getClass().getResource("CriarConta.fxml"));
			this.paneCriarConta = criarConta.load();
			menuCliente = new FXMLLoader(this.getClass().getResource("MenuCliente.fxml"));
			this.paneMenuCliente = menuCliente.load();
			menuEmpresa = new FXMLLoader(this.getClass().getResource("MenuEmpresa.fxml"));
			this.paneMenuEmpresa = menuEmpresa.load();
			menuFuncionario = new FXMLLoader(this.getClass().getResource("MenuFuncionario.fxml"));
			this.paneMenuFuncionario = menuFuncionario.load();
			telaInicio = new FXMLLoader(this.getClass().getResource("TelaInicio.fxml"));
			this.paneTelaInicio = telaInicio.load();
			
			
			this.border = Main.getRoot();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void getCriarConta(){	
		border.setCenter(this.paneCriarConta);
	}
	
	public void getLoginCliente(){	
		border.setCenter(this.paneLoginCliente);	
	}
	
	public void getMenuCliente(){	
		border.setCenter(this.paneMenuCliente);
	}
	
	public void getTelaInicio(){	
		border.setCenter(this.paneTelaInicio);
	}

	public void getMenuEmpresa(){	
		border.setCenter(this.paneMenuEmpresa);
	}
	
	public void getMenuFuncionario(){	
		border.setCenter(this.paneMenuFuncionario);
	}
	
	
	
}
