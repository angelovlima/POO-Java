package l4;

import java.util.Scanner;

public class Inicio {
	public static void main(String[] args) throws Exception {
		// ip = 192.168...
		Cliente c = new Cliente("127.0.0.1", 3000);
		String comentario;
		Scanner sc = new Scanner(System.in);
		comentario = sc.nextLine();
		c.enviar(comentario);
	}
}
