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

public class RepositorioClientes implements IRepositorioCliente, Serializable {

	private static final long serialVersionUID = 2483691135743332876L;
	private static IRepositorioCliente instanceUser;
	private ArrayList<Cliente> clientes;
	private int next;

	public RepositorioClientes() {
		this.clientes = new ArrayList<Cliente>();
		this.next = 0;
	}

	public static synchronized IRepositorioCliente getInstance() {
		if(instanceUser == null) {
			instanceUser = new RepositorioClientes();
		}
		return instanceUser;
	}

	@Override
	public void salvar() {
		try {
			File f = new File("Clientes\\Repositorio.db");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(instanceUser);
			oos.close();
			System.out.println("Objeto serializado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public boolean cadastrar(Cliente c){	 //mudei pra boolean
		if (c != null) {
			clientes.add(c);
			this.next = next + 1;
			return true;
			//System.out.println("Cliente Cadastrado!");
		}
		this.salvar();
		return false; 
	}

	private int procurarIndice(String login) {
		int indice = 0;
		boolean found = false;
		while (found != true && indice < this.next) {
			if (login.equals(this.clientes.get(indice).getLogin())) {
				found = true;
			} else {
				indice = indice + 1;
			}
		}
		return indice;
	}


	@Override
	public Cliente procurar(String login) {
		int i = this.procurarIndice(login);
		Cliente saida = null;
		if (i != this.next) {
			saida = this.clientes.get(i);
		} else {
			System.out.println("O CLIENTE NÃO FOI ENCONTRADO!");
		}

		return saida;
	}


	@Override
	public boolean remover(String login) { // mudei pra boolean 
		if (existe(login)) {
			Cliente c = procurar(login);
			this.clientes.remove(c);
			return true;
			//System.out.println("Cliente foi removido!");
		} else {
			return false;
			//System.out.println("Houve um problema! Cliente não pode ser removido.");
		}

	}

	@Override
	public boolean existe(String login) {
		boolean existe = false;
		Cliente c = this.procurar(login);
		if (c != null) {
			existe = true;
			System.out.println("Cliente " + login + " existe!");
		} else {
			System.out.println("Cliente não existe!");
		}
		return existe;
	}

	@Override
	public void printar(Cliente c) {
		try {
			JOptionPane.showMessageDialog(null, c.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
