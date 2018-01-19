package dados;

import negocio.beans.Cliente;

public interface IRepositorioCliente {

	void salvar();

	Cliente procurar(String login);

	void remover(String login);

	boolean existe(String login);

	void printar(Cliente c);

	void cadastrar(Cliente c);

}