package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import negocio.beans.Empresa;
import negocio.beans.Funcionario;
import negocio.beans.Produto;

public class RepositorioProduto implements IRepositorioProduto, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2010454631604883198L;
	private static IRepositorioProduto instanceUser;
	private ArrayList<Produto> produtos;
	private int next;

	public RepositorioProduto() {
		this.produtos = new ArrayList<Produto>();
		this.next = 0;
	}

	public static synchronized IRepositorioProduto getInstance() {
		if(instanceUser == null) {
			instanceUser = new RepositorioProduto();
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


	public boolean cadastrar(Produto p){
		if (p != null) {
			produtos.add(p);
			this.next = next + 1;
			return true;
			//System.out.println("Produto Cadastrada!");
		}
		this.salvar();
		return false; 
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

	@Override
	public Produto procurar(String nome) {
		int i = this.procurarIndice(nome);
		Produto saida = null;
		if (i != this.next) {
			saida = this.produtos.get(i);
		} else {
			System.out.println("O PRODUTO N�O FOI ENCONTRADO!");
		}

		return saida;
	}

	@Override
	public boolean remover(String nome) {
		if (existe(nome)) {
			Produto p = procurar(nome);
			this.produtos.remove(p);
			return true;
			//System.out.println("Produto foi removido!");
		} else {
			return false;
			//System.out.println("Houve um problema! Produto n�o pode ser removido.");
		}

	}

	@Override
	public boolean existe(String nome) {
		boolean existe = false;
		Produto u = this.procurar(nome);
		if (u != null) {
			existe = true;
			System.out.println("Produto existe!");
		} else {
			System.out.println("Produto n�o existe!");
		}
		return existe;
	}

	/* (non-Javadoc)
	 * @see dados.IRepositorioProduto#printar(negocio.beans.Empresa)
	 */
	@Override
	public void printar(Produto p) {
		try {
			JOptionPane.showMessageDialog(null, p.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}