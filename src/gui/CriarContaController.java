package gui;

public class CriarContaController {

	
	public void cadastroCliente(){
		try{
			ScreenManager.getInstance().getMenuCliente();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void cadastroEmpresa(){
		try{
			ScreenManager.getInstance().getMenuEmpresa();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void cadastroFuncionario(){
		try{
			ScreenManager.getInstance().getMenuFuncionario();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
}
