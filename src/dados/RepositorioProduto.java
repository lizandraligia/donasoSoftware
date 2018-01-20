package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import negocio.beans.Produto;

public class RepositorioProduto implements IRepositorioProduto, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2010454631604883198L;
	private static IRepositorioProduto instanceUser;
	private ArrayList<Produto> produtos;
	private int next;

	public RepositorioProduto(int tamanho) {
		this.produtos = new ArrayList<Produto>(tamanho);
		this.next = 0;
	}

	public static synchronized IRepositorioProduto getInstance() {
		if (instanceUser == null) {
			if (ler() == null) {
				instanceUser = new RepositorioProduto(100);
			} else {
				instanceUser = (IRepositorioProduto) ler();
			}
		}
		return instanceUser;
	}

	/* (non-Javadoc)
	 * @see dados.IRepositorioProduto#salvar()
	 */
	@Override
	public void salvar() {
		try {
			File f = new File("Produtos\\RepositorioProduto.db");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(instanceUser);
			oos.close();
			System.out.println("Objeto serializado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static IRepositorioProduto ler() {
		IRepositorioProduto repo = null;
		try {
			File f = new File("Produtos\\RepositorioProduto.db");

			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			if (o != null) {
				repo = (RepositorioProduto) o;
				System.out.println("agora ele foi des-serializado com sucesso");
			}
			ois.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return repo;
	}

	@Override
	public void cadastrar(Produto u) {
		if (u != null) {
			produtos.add(u);
			this.next = next + 1;

			System.out.println("Produto Cadastrado!");
		}
		this.salvar();
	}

	private int procurarIndice(String nome) {
		int indice = 0;
		boolean found = false;
		while (found != true && indice < this.next) {
			if (nome.equals(this.produtos.get(indice).getNome())) {
				found = true;
			} else {
				indice = indice + 1;
			}
		}
		return indice;
	}

	/* (non-Javadoc)
	 * @see dados.IRepositorioProduto#procurar(java.lang.String)
	 */
	@Override
	public Produto procurar(String nome) {
		int i = this.procurarIndice(nome);
		Produto saida = null;
		if (i != this.next) {
			saida = this.produtos.get(i);
		} else {
			System.out.println("O PRODUTO NÃO FOI ENCONTRADA!");
		}

		return saida;
	}

	/* (non-Javadoc)
	 * @see dados.IRepositorioProduto#remover(java.lang.String)
	 */
	@Override
	public void remover(String nome) {
		if (existe(nome)) {
			Produto u = procurar(nome);
			this.produtos.remove(u);
			System.out.println("Produto foi removido!");
		} else {
			System.out.println("Houve um problema! Produto não pôde ser removido.");
		}

	}

	/* (non-Javadoc)
	 * @see dados.IRepositorioProduto#existe(java.lang.String)
	 */
	@Override
	public boolean existe(String nome) {
		boolean existe = false;
		Produto u = this.procurar(nome);
		if (u != null) {
			existe = true;
			System.out.println("Produto existe!");
		} else {
			System.out.println("Produto não existe!");
		}
		return existe;
	}

	/* (non-Javadoc)
	 * @see dados.IRepositorioProduto#printar(negocio.beans.Empresa)
	 */
	@Override
	public void printar(Produto u) {
		try {
			JOptionPane.showMessageDialog(null, u.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}