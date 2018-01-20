package dados;

import negocio.beans.Produto;

public interface IRepositorioProduto {

	void salvar();

	void cadastrar(Produto u);

	Produto procurar(String nome);

	void remover(String nome);

	boolean existe(String nome);

	void printar(Produto u);

}