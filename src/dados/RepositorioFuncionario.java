package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import negocio.beans.Funcionario;

public class RepositorioFuncionario implements IRepositorioFuncionario, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9129778942778379988L;
	private static IRepositorioFuncionario instanceUser;
	private ArrayList<Funcionario> funcionarios;
	private int next;

	public RepositorioFuncionario(int tamanho) {
		this.funcionarios = new ArrayList<Funcionario>(tamanho);
		this.next = 0;
	}

	public static synchronized IRepositorioFuncionario getInstance() {
		if (instanceUser == null) {
			if (ler() == null) {
				instanceUser = new RepositorioFuncionario(100);
			} else {
				instanceUser = (IRepositorioFuncionario) ler();
			}
		}
		return instanceUser;
	}

	@Override
	public void salvar() {
		try {
			File f = new File("Funcionarios\\RepositorioFuncionario.db");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(instanceUser);
			oos.close();
			System.out.println("Objeto serializado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static IRepositorioFuncionario ler() {
		IRepositorioFuncionario repo = null;
		try {
			File f = new File("Funcionarios\\RepositorioFuncionario.db");

			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			if (o != null) {
				repo = (RepositorioFuncionario) o;
				System.out.println("agora ele foi des-serializado com sucesso");
			}
			ois.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return repo;
	}

	@Override
	public void cadastrar(Funcionario c) {
		if (c != null) {
			funcionarios.add(c);
			this.next = next + 1;

			System.out.println("Funcionario Cadastrado!");
		}
		this.salvar();
	}

	private int procurarIndice(String login) {
		int indice = 0;
		boolean found = false;
		while (found != true && indice < this.next) {
			if (login.equals(this.funcionarios.get(indice).getLogin())) {
				found = true;
			} else {
				indice = indice + 1;
			}
		}
		return indice;
	}

	@Override
	public Funcionario procurar(String login) {
		int i = this.procurarIndice(login);
		Funcionario saida = null;
		if (i != this.next) {
			saida = this.funcionarios.get(i);
		} else {
			System.out.println("O FUNCIONARIO NÃO FOI ENCONTRADO!");
		}

		return saida;
	}

	@Override
	public void remover(String login) {
		if (existe(login)) {
			Funcionario c = procurar(login);
			this.funcionarios.remove(c);
			System.out.println("Funcionario foi removido!");
		} else {
			System.out.println("Houve um problema! Funcionario não pode ser removido.");
		}

	}

	@Override
	public boolean existe(String login) {
		boolean existe = false;
		Funcionario c = this.procurar(login);
		if (c != null) {
			existe = true;
			System.out.println("Funcionario existe!");
		} else {
			System.out.println("Funcionario não existe!");
		}
		return existe;
	}

	/* (non-Javadoc)
	 * @see dados.IRepositorioFuncionario#printar(negocio.beans.Cliente)
	 */
	@Override
	public void printar(Funcionario c) {
		try {
			JOptionPane.showMessageDialog(null, c.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
