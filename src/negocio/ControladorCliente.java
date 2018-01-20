package negocio;

import dados.IRepositorioCliente;
import dados.RepositorioClientes;
import exceptions.NaoExisteException;
import exceptions.UsuarioExistenteException;
import exceptions.ValorInvalidoException;
import negocio.beans.Cliente;

public class ControladorCliente {

	private IRepositorioCliente repositorioC;
	
	public ControladorCliente(){
		this.repositorioC = RepositorioClientes.getInstance(); 
	}
	
	public IRepositorioCliente getRepositorioC() {
		return repositorioC;
	}

	public void setRepositorioC(IRepositorioCliente repositorioC) {
		this.repositorioC = repositorioC;
	}
	
	public boolean cadastrar(Cliente c) throws ValorInvalidoException, UsuarioExistenteException{
		
		Cliente clienteExiste = this.repositorioC.procurar(c.getLogin());
		if(clienteExiste != null){
			throw new UsuarioExistenteException();
		}		
	
		if(this.repositorioC.cadastrar(c)==true){
			if(c!=null){
				return true;
			}
		}
		throw new ValorInvalidoException();
	}
	
	public Cliente procurar(String login){
		return this.repositorioC.procurar(login);
	}
	
	public boolean remover(String login) throws NaoExisteException{
		if(login!=null){
			return this.repositorioC.remover(login);
		}
		throw new NaoExisteException();
	}
	
}
