package l4;

import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
	// socket para comunicação com o servidor.
	private Socket encaixeCliente;
	private String nome;
	public Cliente(String ip, int porta, String nome) throws Exception {
		// ip do servidor e a porta onde o servidor está escutando
		encaixeCliente = new Socket(ip, porta);
		this.nome = nome;
	}
	
	public void enviar(String texto, String nome) throws Exception {
		// canal de saida (binário) para escrever para o servidor
		PrintWriter escritor = new PrintWriter(encaixeCliente.getOutputStream());
		escritor.write(nome + ":" + Criptografar.criptografar(texto));
		escritor.close();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
