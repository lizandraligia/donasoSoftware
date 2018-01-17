package negocio.beans;

public class Empresa extends Conta{

	private String nome;
	private int cnpj;
	private String endereco;
	private String email;
	
	public Empresa(String nome, int cnpj, String endereco, String email, String login, String senha){
		
		super(login, senha);
		this.nome = nome; 
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.email = email;
	}
	
	public Empresa(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
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
}
