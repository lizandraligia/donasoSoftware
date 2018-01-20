package dados;

import negocio.beans.Cliente;

public interface IRepositorioCliente {

	void salvar();
	
	boolean cadastrar(Cliente c);
	
	Cliente procurar(String login);

	boolean remover(String login);

	boolean existe(String login);

	void printar(Cliente c);

	

}