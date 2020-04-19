package l1;//teste2

public class Cliente {
	protected String nome;
	public String tel;
	//private Nascimento nasci;
	protected String genero;
	
	public Cliente(String nome, String tel, String genero) {
		this.nome = nome;
		this.tel = tel;
		//this.nasci = nasci;
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	
}
