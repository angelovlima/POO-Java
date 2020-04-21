package l3;

import java.util.*;

public class Usuario {
	public String nome;
	public String tel;
	public Endereco endereco;
	public String email;
	public Login login;
	public boolean juridica;
	public ArrayList<Data> datas;
	public Usuario(String nome, String tel, Endereco endereco, String email, Login login, boolean juridica, ArrayList<Data> datas) {
		this.nome = nome;
		this.tel = tel;
		this.endereco = endereco;
		this.email = email;
		this.login = login;
		this.juridica = juridica;
		this.datas = datas;
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
	public boolean isJuridica() {
		return juridica;
	}
	public void setJuridica(boolean juridica) {
		this.juridica = juridica;
	}
	public ArrayList<Data> getDatas() {
		return datas;
	}
	public void setDatas(ArrayList<Data> datas) {
		this.datas = datas;
	}

	
	
	
}

