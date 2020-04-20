package l1;

import java.util.*;

public class Inicio {
	
	public static void main(String[] args) {
		//int menu;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		listarClientes(clientes);

	}
	
	private static void listarClientes(ArrayList<Cliente> clientes) {
		ordenaPorNome(clientes);
		Scanner sc = new Scanner(System.in);
		
		String opcaoMenu = "";
		while(opcaoMenu != "0") {
			
			System.out.println("\nMENU \n" +
					"1 - Cadastrar Clientes \n" +
					"2 - Mostrar Clientes Cadastrados \n" +
					"3 - Editar Cadastro \n" +
					"4 - Remoção de Cadastro \n" +
					"0 - Sair \n");
			opcaoMenu = sc.nextLine();	
			
			switch(opcaoMenu) {
			case "1": Agenda.adicionarNovoCliente(clientes);
			break;
			
			case "2": 
			for(Cliente elemento: clientes) {
				System.out.println("----------------------------------");
				System.out.println(elemento.nome);
				System.out.println(elemento.tel);
				System.out.println(elemento.genero);
			}
			break;
			
			case "3": 
			Agenda.editarCadastro(clientes);
			for(Cliente elemento: clientes) {
				System.out.println("--------------------------------------");
				System.out.println(elemento.nome);
				System.out.println(elemento.tel);
				System.out.println(elemento.genero);
			}
			break;
			
			case "4":
			Agenda.removerCadastro(clientes);
			for(Cliente elemento: clientes) {
				System.out.println("--------------------------------------");
				System.out.println(elemento.nome);
				System.out.println(elemento.tel);
				System.out.println(elemento.genero);
			}
			break;
			
			case "0":
				opcaoMenu = "0";
				break;
			
			default:
				System.out.println("Opção inválida!");
				break;
			}
			
			}
		
		}
	
	private static void ordenaPorNome(ArrayList<Cliente> clientes) {
	    Collections.sort(clientes, new Comparator<Cliente>() {
	        @Override
	        public int compare(Cliente o1, Cliente o2) {
	            return o1.getNome().compareTo(o2.getNome());
	        }
	    });
	}
	
	


}

