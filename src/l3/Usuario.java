package l3;

public class Usuario {
	public String nome;
	public String tel;
	public Endereco endereco;
	public String email;
	public Login login;
	public Usuario(String nome, String tel, Endereco endereco, String email, Login login) {
		this.nome = nome;
		this.tel = tel;
		this.endereco = endereco;
		this.email = email;
		this.login = login;
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	
}

