package l1;

import java.util.ArrayList;
import java.util.Scanner;
//import java.util.Arrays;


public class Agenda extends Cliente{
	public Agenda(String nome, String tel, String genero) {
		super(nome, tel, genero);
		// TODO Auto-generated constructor stub
	}



	ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	
	


	//teste
	
	public static void adicionarNovoCliente(ArrayList<Cliente> listaClientes){
		boolean cadastrando = true;
		Scanner sc = new Scanner(System.in);

		while (cadastrando) {
			System.out.println("CADASTRO DE CLIENTE");

			System.out.println("Insira seu nome: ");
			String nomeCliente = sc.nextLine();
			System.out.println("Insira seu telefone: ");
			String telCliente = sc.nextLine();
			System.out.println("Insira seu genero: ");
			String generoCliente = sc.nextLine();
			
			Cliente cliente = new Cliente(nomeCliente, telCliente, generoCliente);

			listaClientes.add(cliente);

			System.out.println("Continuar cadastrando (S/N) ?");
			String continua = sc.nextLine();
			if (continua.equalsIgnoreCase("N")) {
				cadastrando = false;
			} else if (continua.equalsIgnoreCase("S")){
			} else {
				System.out.println("\nOpção inválida! Você será redirecionado ao Menu.\n");
				cadastrando = false;
			}
		}
		
		
	}

	private static String textInput(String text) {
		Scanner sc = new Scanner(System.in);
		System.out.println(text);
		return sc.nextLine();
	}
}




