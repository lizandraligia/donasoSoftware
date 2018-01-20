package dados;

import negocio.beans.Funcionario;

public interface IRepositorioFuncionario {

	void salvar();

	boolean cadastrar(Funcionario c);

	Funcionario procurar(String login);
	
	boolean remover(String login);

	boolean existe(String login);

	void printar(Funcionario c);

}