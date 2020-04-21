package l1;

import java.util.*;

public class Inicio {
	
	public static void main(String[] args) {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		listarClientes(clientes);

	}
	
	private static void listarClientes(ArrayList<Cliente> clientes) {
		Scanner sc = new Scanner(System.in);
		
		String opcaoMenu = "";
		while(opcaoMenu != "0") {
			
			System.out.println("\nMENU \n" +
					"1 - Cadastrar Clientes(em ordem alfabética) \n" +
					"2 - Mostrar Clientes Cadastrados \n" +
					"3 - Editar Cadastro \n" +
					"4 - Remoção de Cadastro \n" +
					"5 - Lista por Gênero \n" +
					"6 - Serviços do Cliente\n" +
					"7 - Idade Media dos Clientes\n" +
					"8 - Idade Media dos Clientes por sexo\n" +
					"9 - Verificar serviço mais procurado\n" +
					"0 - Sair \n");
			opcaoMenu = sc.nextLine();	
			
			switch(opcaoMenu) {
			case "1": Agenda.adicionarNovoCliente(clientes);
			ordenaPorNome(clientes);
			break;
			
			case "2": 
			for(Cliente elemento: clientes) {
				System.out.println("----------------------------------");
				System.out.println(elemento.nome);
				System.out.println(elemento.tel);
				System.out.println(elemento.nasci.dia + "/" + elemento.nasci.mes + "/" + elemento.nasci.ano);
				System.out.println(elemento.genero);
				
			}
			break;
			
			case "3": 
			Agenda.editarCadastro(clientes);
			break;
			
			case "4":
			Agenda.removerCadastro(clientes);
			break;
			
			case "5":
			ordenaPorGenero(clientes);
			break;
			
			case "6":
			Agenda.servicosCliente(clientes);
			break;
			
			case "7":
			Agenda.idadeMediaDosClientes(clientes);	
			
			case "9":
			Agenda.verificarServicoMaisProcurado(clientes);
			
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
	
	private static void ordenaPorGenero(ArrayList<Cliente> clientes) {
		ordenaPorNome(clientes);
		ArrayList<Cliente> clientesMasculinos = new ArrayList<Cliente>();
		ArrayList<Cliente> clientesFemininos = new ArrayList<Cliente>();
		ArrayList<Cliente> clientesOutrosGeneros = new ArrayList<Cliente>();
		
		for(int i=0; i<clientes.size(); i++)
		if(clientes.get(i).getGenero().equals("m")) {
			clientesMasculinos.add(clientes.get(i));
		}else if(clientes.get(i).getGenero().equals("f")) {
			clientesFemininos.add(clientes.get(i));
		}else {
			clientesOutrosGeneros.add(clientes.get(i));
		}
		
		System.out.println("\nMASCULINO ##########################################\n");
		for(Cliente elemento: clientesMasculinos) {
			System.out.println("--------------------------------------");
			System.out.println(elemento.nome);
			System.out.println(elemento.tel);
			System.out.println(elemento.nasci.dia + "/" + elemento.nasci.mes + "/" + elemento.nasci.ano);
			System.out.println(elemento.genero);
		} 
		
		System.out.println("\nFEMININO ##########################################\n");
		for(Cliente elemento: clientesFemininos) {
			System.out.println("--------------------------------------");
			System.out.println(elemento.nome);
			System.out.println(elemento.tel);
			System.out.println(elemento.nasci.dia + "/" + elemento.nasci.mes + "/" + elemento.nasci.ano);
			System.out.println(elemento.genero);
			
		}
		
		
	}
	
	


}

