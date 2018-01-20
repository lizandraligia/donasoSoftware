package dados;

import negocio.beans.Produto;

public interface IRepositorioProduto {

	void salvar();

	boolean cadastrar(Produto u);

	Produto procurar(String nome);

	boolean remover(String nome);

	boolean existe(String nome);

	void printar(Produto u);

}