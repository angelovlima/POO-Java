package l6;

public class Animal {
	private String raca;
	private String genero;
	public String idade;
	
	public Animal(String raca, String genero, String idade) {
		super();
		this.raca = raca;
		this.genero = genero;
		this.idade = idade;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	
}
