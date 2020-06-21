package l4;

import java.util.*;
import java.lang.*;
import java.net.*;

public class EnvioComentario {

	static void comentar (Cliente cliente) throws Exception {
		String comentario;
		Scanner sc = new Scanner(System.in);
		pegaNomeComputador();
		System.out.println("Entre com um comentário");
		comentario = sc.nextLine();
		cliente.enviar(comentario);
	}
	
	public static void pegaNomeComputador() {
	    try{
	      String nomeComputador=System.getProperty("user.name");;
	      System.out.println(nomeComputador);
	    }catch (Exception e){
	      System.out.println("Exception caught ="+e.getMessage());
	    }
	  }
	
	public static String pegaIpCliente() throws UnknownHostException {
		String ipComputador= InetAddress.getLocalHost().getHostAddress();
		System.out.println(ipComputador);
		return ipComputador;
	}
	
}
