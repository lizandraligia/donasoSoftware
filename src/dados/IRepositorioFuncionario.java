package dados;

import negocio.beans.Funcionario;

public interface IRepositorioFuncionario {

	void salvar();

	void cadastrar(Funcionario c);

	Funcionario procurar(String login);
	
	void remover(String login);

	boolean existe(String login);

	void printar(Funcionario c);

}