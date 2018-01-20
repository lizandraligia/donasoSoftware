package negocio.beans;

import java.util.Random;

public class Pedido {
	
	private Cliente cliente;
	private int id;
	private String descricao;
	
	public Pedido(Cliente cliente, String descricao){
		Random r = new Random();
		this.cliente = cliente;
		this.id = r.nextInt(999999999);
		for (int i = 0; i < cliente.getPedidos().size(); i++) {
			if(this.getId() == cliente.getPedidos().get(i).getId()) {
				this.setId(r.nextInt(999999999));
			}
		}
		
		this.descricao = descricao;
	}
<<<<<<< HEAD
	

	public Cliente getCliente() {
		return cliente;
	}
=======
>>>>>>> branch 'master' of https://github.com/DavidPierre21/donasoSoftware


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId() {
		return id;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
