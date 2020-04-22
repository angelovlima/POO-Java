package L2Pack;

public class VeiculoClass{
	String placaVeiculo;
	String versaoModeloVeiculo;
	int anoVeiculo;
	float valorVeiculo;
	ClienteClass cliente = new ClienteClass();
	
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
	public String getVersaoModeloVeiculo() {
		return versaoModeloVeiculo;
	}
	public void setVersaoModeloVeiculo(String versaoModeloVeiculo) {
		this.versaoModeloVeiculo = versaoModeloVeiculo;
	}
	public int getAnoVeiculo() {
		return anoVeiculo;
	}
	public void setAnoVeiculo(int anoVeiculo) {
		this.anoVeiculo = anoVeiculo;
	}
	public float getValorVeiculo() {
		return valorVeiculo;
	}
	public void setValorVeiculo(float valorVeiculo) {
		this.valorVeiculo = valorVeiculo;
	}
	public ClienteClass getCliente() {
		return cliente;
	}
	public void setCliente(ClienteClass cliente) {
		this.cliente = cliente;
	}
	
	
	
}
