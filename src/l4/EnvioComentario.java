package l4;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EnvioComentario {

	static void comentar (Cliente cliente) throws Exception {
		String comentario;
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com um comentário");
		comentario = sc.nextLine();
		cliente.enviar(comentario, cliente.getNome());
	}
	
	public static String pegaNomeComputador() {
	    try{
	      String nomeComputador=System.getProperty("user.name");;
	      return nomeComputador;
	    }catch (Exception e){
	      System.out.println("Exception caught ="+e.getMessage());
	    }
		return null;
	  }
	
	public static String pegaIpCliente() throws UnknownHostException {
		String ipComputador= InetAddress.getLocalHost().getHostAddress();
		return ipComputador;
	}
	
}
