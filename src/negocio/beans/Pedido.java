package negocio.beans;

public class Pedido {

	private int id;
	private String descricao;
	
	public Pedido(int id, String descricao){
		this.id = id;
		this.descricao = descricao;
	}
	
	public Pedido(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
