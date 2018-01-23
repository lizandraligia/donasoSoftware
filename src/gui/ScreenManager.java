package gui;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class ScreenManager {

	BorderPane border, paneLoginCliente, paneMenuCliente, paneTelaInicio;
	FXMLLoader loginCliente, menuCliente, telaInicio;

	
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
			menuCliente = new FXMLLoader(this.getClass().getResource("MenuCliente.fxml"));
			this.paneMenuCliente = menuCliente.load();
			telaInicio = new FXMLLoader(this.getClass().getResource("TelaInicio.fxml"));
			this.paneTelaInicio = telaInicio.load();
			
			this.border = Main.getRoot();
		} catch (IOException e) {
			e.printStackTrace();
		} 
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
	
}
