package negocio.beans;

import java.util.ArrayList;

public class Cliente extends Conta{

	private String nome;
	private int cpf;
	private String endereco;
	private String email;
	private ArrayList<Pedido> pedidos;
	
	public Cliente(String nome, int cpf, String endereco, String email, String login, String senha){
		
		super(login, senha);
		this.nome = nome; 
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
		this.pedidos = new ArrayList<Pedido>();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void addPedido(Pedido p) {
		pedidos.add(p);
	}
	
	public void deletePedido(Pedido p) {
		if(p!=null) {
			for (int j = 0; j < pedidos.size(); j++) {
				if(p.getId() == pedidos.get(j).getId())
					pedidos.remove(j);
			}
		} else {
			System.out.println("Pedido Invalido!");
		}
		
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
}
