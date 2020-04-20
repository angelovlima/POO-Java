package l1;

import java.util.*;


public class Agenda extends Cliente{
	
	Scanner sc = new Scanner(System.in);
	
	public Agenda(String nome, String tel, String genero) {
		super(nome, tel, genero);
		// TODO Auto-generated constructor stub
	}



	ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	
	
	public static void adicionarNovoCliente(ArrayList<Cliente> listaClientes){
		boolean cadastrando = true;
		Scanner sc = new Scanner(System.in);

		while (cadastrando) {
			System.out.println("CADASTRO DE CLIENTE");

			System.out.println("Insira seu nome: ");
			String nomeCliente = sc.nextLine();
			System.out.println("Insira seu telefone: ");
			String telCliente = sc.nextLine();
			System.out.println("Insira seu genero (M/F): ");
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

}




