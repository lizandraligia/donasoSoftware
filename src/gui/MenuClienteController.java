package gui;

public class MenuClienteController {

	public void perfil(){
		try{
			ScreenManager.getInstance().getVisualizarPerfil();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void sair(){
		try{
			ScreenManager.getInstance().getTelaInicio();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
}
