package l1;

import java.util.Scanner;

public class Agenda extends Cliente{
	Cliente[] listaClientes;
	Scanner sc = new Scanner(System.in);
	
	public Agenda(String nome, String tel, String genero) {
		super(nome, tel, genero);
		// TODO Auto-generated constructor stub
	}

	
	
	public void adicionarNovoCliente(){
		System.out.println("Entre com seu nome");
		nome = sc.nextLine();
		System.out.println("Entre com seu telefone");
		tel = sc.nextLine();
		System.out.println("Entre com seu genero");
		genero = sc.nextLine();
		
		
	}

}




