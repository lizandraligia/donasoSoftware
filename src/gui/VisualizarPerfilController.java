package gui;

public class VisualizarPerfilController {

	public void voltar(){
		try{
			ScreenManager.getInstance().getMenuCliente();
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
