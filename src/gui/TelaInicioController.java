package gui;


public class TelaInicioController {

	
	public void loginCliente(){
		try{
			ScreenManager.getInstance().getLoginCliente();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
}
