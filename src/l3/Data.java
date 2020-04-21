package l3;

public class Data {
	public int mes;
	public int semana;
	public FluxoCaixa fluxo;
	//as variavel tudo
	public Data(int mes, int semana, FluxoCaixa fluxo) {
		super();
		this.mes = mes;
		this.semana = semana;
		this.fluxo = fluxo;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getSemana() {
		return semana;
	}
	public void setSemana(int semana) {
		this.semana = semana;
	}
	public FluxoCaixa getFluxo() {
		return fluxo;
	}
	public void setFluxo(FluxoCaixa fluxo) {
		this.fluxo = fluxo;
	}
	
	
}
