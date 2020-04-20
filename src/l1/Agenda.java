package l1;

import java.util.*;


public class Agenda extends Cliente{
	
	Scanner sc = new Scanner(System.in);
	
	public Agenda(String nome, String tel, Nascimento nasci, String genero, ArrayList<String> servicos) {
		super(nome, tel, nasci, genero, servicos);
	}



	ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	
	
	public static void adicionarNovoCliente(ArrayList<Cliente> listaClientes){
		boolean cadastrando = true;
		Scanner sc = new Scanner(System.in);
		Scanner scInt = new Scanner(System.in);

		while (cadastrando) {
			System.out.println("\nCADASTRO DE CLIENTE\n");

			System.out.println("Insira seu nome: ");
			String nomeCliente = sc.nextLine();
			System.out.println("Insira seu telefone: ");
			String telCliente = sc.nextLine();
			System.out.println("Insira o dia em que nasceu: ");
			int diaNiverCliente = scInt.nextInt();
			System.out.println("Insira o mês em que nasceu: ");
			int mesNiverCliente = scInt.nextInt();
			System.out.println("Insira o ano em que nasceu: ");
			int anoNiverCliente = scInt.nextInt();
			Nascimento nasciCliente = new Nascimento(diaNiverCliente,mesNiverCliente,anoNiverCliente);
			
			System.out.println("Insira seu genero (m/f): ");
			String generoCliente = sc.nextLine();
			
			ArrayList<String> listaServicos = new ArrayList <String>();
			System.out.println("Insira quantos serviços e produtos foram consumidos");
			int quantidadeServico = scInt.nextInt();
			for(int i = 0; i<quantidadeServico; i++ ) {
				System.out.println("Insira o serviço ou produto consumido: "); //(erro: o primeiro serviço/produto não está sendo "scaneado")
				String servicoOuProduto = sc.nextLine();
				listaServicos.add(servicoOuProduto);
			}
			
			
			
			Cliente cliente = new Cliente(nomeCliente, telCliente,nasciCliente, generoCliente, listaServicos);

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
	
	public static void editarCadastro(ArrayList<Cliente> listaClientes){
		boolean editando = true;
			
		while (editando) {
			System.out.println("EDITAR CADASTRO");
			System.out.println("Busque pelo nome: ");
			Scanner sc = new Scanner(System.in);
			String nome = sc.nextLine();
			for (int i = 0; i < listaClientes.size(); i++) {
				   if (listaClientes.get(i).getNome().equals(nome)) {
					   System.out.println("Digite o novo nome: ");
					   listaClientes.get(i).setNome(nome = sc.nextLine());
					   System.out.println("Digite o novo telefone: ");
					   listaClientes.get(i).setTel(nome = sc.nextLine());
					   System.out.println("Digite o novo gênero: ");
					   listaClientes.get(i).setGenero(nome = sc.nextLine());
				   }
			}
					

			System.out.println("Continuar editando (S/N) ?");
			String continua = sc.nextLine();
			if (continua.equalsIgnoreCase("N")) {
				editando = false;
			} else if (continua.equalsIgnoreCase("S")){
			} else {
				System.out.println("\nOpção inválida! Você será redirecionado ao Menu.\n");
				editando = false;
			}
		}
	}
	
	public static void removerCadastro(ArrayList<Cliente> listaClientes){
		boolean removendo = true;
		
		while (removendo) {
			System.out.println("REMOVER CADASTRO");
			System.out.println("Digite o nome para REMOVER:");
			Scanner sc = new Scanner(System.in);
			String nome = sc.nextLine();
			for (int i = 0; i < listaClientes.size(); i++) {
			    if (listaClientes.get(i).getNome().equals(nome)) {
			      listaClientes.remove(i);
			    }
			  }
			System.out.println("Continuar removendo (S/N) ?");
			String continua = sc.nextLine();
			if (continua.equalsIgnoreCase("N")) {
				removendo = false;
			} else if (continua.equalsIgnoreCase("S")){
			} else {
				System.out.println("\nOpção inválida! Você será redirecionado ao Menu.\n");
				removendo = false;
			}
		}
		
	}
	
	public static void servicosCliente(ArrayList<Cliente> clientes) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Busque pelo nome: ");
		String nome = sc.nextLine();
		for (int i = 0; i < clientes.size(); i++) {
		    if (clientes.get(i).getNome().equals(nome)) {
		    	for(Cliente elemento: clientes) {
					System.out.println(elemento.servicos);
		    	}
		    }
		}
	}
	public static void idadeMediaDosClientes(ArrayList<Cliente> clientes) {
		int anos = 0, mediaAnos, i;
		for(Cliente elemento: clientes) {
			anos += elemento.nasci.ano;
	    }
		
		mediaAnos = 2020-(anos/clientes.size());
		System.out.println("A idade média dos clientes é de " + mediaAnos);
	}

}




