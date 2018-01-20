package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import negocio.beans.Cliente;
import negocio.beans.Empresa;

public class RepositorioEmpresa implements IRepositorioEmpresa, Serializable {

	private static final long serialVersionUID = -1626060227666620516L;
	private static IRepositorioEmpresa instanceUser;
	private ArrayList<Empresa> empresas;
	private int next;

	public RepositorioEmpresa(int tamanho) {
		this.empresas = new ArrayList<Empresa>(tamanho);
		this.next = 0;
	}

	public static synchronized IRepositorioEmpresa getInstance() {
		if (instanceUser == null) {
			if (ler() == null) {
				instanceUser = new RepositorioEmpresa(100);
			} else {
				instanceUser = (IRepositorioEmpresa) ler();
			}
		}
		return instanceUser;
	}

	@Override
	public void salvar() {
		try {
			File f = new File("Empresas\\RepositorioEmpresa.db");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(instanceUser);
			oos.close();
			System.out.println("Objeto serializado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static IRepositorioEmpresa ler() {
		IRepositorioEmpresa repo = null;
		try {
			File f = new File("Empresas\\RepositorioEmpresa.db");

			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			if (o != null) {
				repo = (RepositorioEmpresa) o;
				System.out.println("agora ele foi des-serializado com sucesso");
			}
			ois.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return repo;
	}

	@Override
	public boolean cadastrar(Empresa e){
		if (e != null) {
			empresas.add(e);
			this.next = next + 1;
			this.salvar();
			return true;
			//System.out.println("Empresa Cadastrada!");
		}
		return false; 
	}

	private int procurarIndice(String login) {
		int indice = 0;
		boolean found = false;
		while (found != true && indice < this.next) {
			if (login.equals(this.empresas.get(indice).getLogin())) {
				found = true;
			} else {
				indice = indice + 1;
			}
		}
		return indice;
	}

	@Override
	public Empresa procurar(String login) {
		int i = this.procurarIndice(login);
		Empresa saida = null;
		if (i != this.next) {
			saida = this.empresas.get(i);
		} else {
			System.out.println("A EMPRESA NÃO FOI ENCONTRADA!");
		}

		return saida;
	}

	@Override
	public boolean remover(String login) {
		if (existe(login)) {
			Empresa c = procurar(login);
			this.empresas.remove(c);
			return true;
			//System.out.println("Empresa foi removida!");
		} else {
			return false;
			//System.out.println("Houve um problema! Empresa não pode ser removida.");
		}

	}

	
	@Override
	public boolean existe(String login) {
		boolean existe = false;
		Empresa u = this.procurar(login);
		if (u != null) {
			existe = true;
			System.out.println("Empresa existe!");
		} else {
			System.out.println("Empresa não existe!");
		}
		return existe;
	}

	@Override
	public void printar(Empresa emp) {
		try {
			JOptionPane.showMessageDialog(null, emp.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}