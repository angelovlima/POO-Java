package l1;//teste3

import java.util.ArrayList;

public class Cliente {
	protected String nome;
	public String tel;
	public Nascimento nasci;
	protected String genero;
	public ArrayList<String> servicos = new ArrayList<String>();
	
	public Cliente(String nome, String tel, Nascimento nasci, String genero, ArrayList<String> servicos) {
		this.nome = nome;
		this.tel = tel;
		this.nasci = nasci;
		this.genero = genero;
		this.servicos = servicos;
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

	public ArrayList<String> getServicos() {
		return servicos;
	}

	public void setServicos(ArrayList<String> servicos) {
		this.servicos = servicos;
	}
	
	
	
}
