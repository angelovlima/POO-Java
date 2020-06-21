package l4;

import java.util.Scanner;

public class Inicio {
	public static void main(String[] args) throws Exception {
		String ip = EnvioComentario.pegaIpCliente();
		Cliente c = new Cliente(ip, 3000);
		EnvioComentario.comentar(c);

		//EnvioComentario.comentar(c);
	}
}
