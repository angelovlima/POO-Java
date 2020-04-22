package L2Pack;

public class RevisaoClass extends VeiculoClass {
	String dataRevisao;
	String servico;
	VeiculoClass veiculo = new VeiculoClass();
	
	public String getDataRevisao() {
		return dataRevisao;
	}
	public void setDataRevisao(String dataRevisao) {
		this.dataRevisao = dataRevisao;
	}
	public String getServico() {
		return servico;
	}
	public void setServico(String servico) {
		this.servico = servico;
	}
	public VeiculoClass getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(VeiculoClass veiculo) {
		this.veiculo = veiculo;
	}
	
	
}
