package l4;

import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
	// socket para comunica��o com o servidor.
	private Socket encaixeCliente;
	public Cliente(String ip, int porta) throws Exception {
		// ip do servidor e a porta onde o servidor est� escutando
		encaixeCliente = new Socket(ip, porta);
	}
	
	public void enviar(String texto) throws Exception {
		// canal de saida (bin�rio) para escrever para o servidor
		PrintWriter escritor = new PrintWriter(encaixeCliente.getOutputStream());
		escritor.write(texto);
		escritor.close();
	}
}
