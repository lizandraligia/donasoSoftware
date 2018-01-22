package gui;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class ScreenManager {

	BorderPane border, paneLogin, paneMenuCliente, paneTelaInicio;
	FXMLLoader login, menuCliente, telaInicio;

	
	public static ScreenManager instancia;
	
	public static synchronized ScreenManager getInstance(){
		if(instancia == null){
			instancia = new ScreenManager();
		}
		return instancia;
	}
	
	private ScreenManager(){
		try {
			login = new FXMLLoader(this.getClass().getResource("LoginCliente.fxml"));
			this.paneLogin = login.load();
			menuCliente = new FXMLLoader(this.getClass().getResource("MenuCliente.fxml"));
			this.paneMenuCliente = menuCliente.load();
			telaInicio = new FXMLLoader(this.getClass().getResource("TelaInicio.fxml"));
			this.paneTelaInicio = telaInicio.load();
			
			this.border = Main.getRoot();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void getLogin(){	
		border.setCenter(this.paneLogin);	
	}
	
	public void getMenuCliente(){	
		border.setCenter(this.paneMenuCliente);
	}
	
	public void getTelaInicio(){	
		border.setCenter(this.paneTelaInicio);
	}
	
}
