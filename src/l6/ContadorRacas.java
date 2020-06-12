package l6;

public class ContadorRacas implements Comparable<ContadorRacas>{
	private String raca;
	private int quantidade;
	
	public ContadorRacas(String raca) {
		super();
		this.raca = raca;
		this.quantidade = 1;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade() {
		this.quantidade = this.quantidade + 1;
	}
	
	@Override
	public int compareTo(ContadorRacas raca) { 
		if (this.quantidade > raca.getQuantidade()) { 
		  return -1; 
		  } if (this.quantidade < raca.getQuantidade()) { 
		  return 1; 
		  } 
		  return 0; 
		 }
	
	
}
