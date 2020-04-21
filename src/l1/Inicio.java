package l1;

import java.util.*;

public class Inicio {
	
	public static void main(String[] args) {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		listarClientes(clientes);

	}
	
	private static void listarClientes(ArrayList<Cliente> clientes) {
		ArrayList<Cliente> clientesMasculinos = new ArrayList<Cliente>();
		ArrayList<Cliente> clientesFemininos = new ArrayList<Cliente>();
		ArrayList<Cliente> clientesOutrosGeneros = new ArrayList<Cliente>();
		
		Scanner sc = new Scanner(System.in);
		
		String opcaoMenu = "", menuDois = "";
		while(opcaoMenu != "0") {
			
			System.out.println("\nMENU \n" +
					"1 - Cadastrar Clientes(em ordem alfabética) \n" +
					"2 - Mostrar Clientes Cadastrados \n" +
					"3 - Editar Cadastro \n" +
					"4 - Remoção de Cadastro \n" +
					"5 - Lista por Gênero \n" +
					"6 - Serviços do Cliente\n" +
					"7 - Idade Media dos Clientes\n" +
					"8 - Idade Media dos Clientes por Gênero \n" +
					"9 - Verificar Serviço mais Procurado\n" +
					"10 - Verificar Serviço mais Procurado por Gênero \n" +
					"0 - Sair \n");
			opcaoMenu = sc.nextLine();	
			
			switch(opcaoMenu) {
			case "1": Agenda.adicionarNovoCliente(clientes);
			ordenaPorNome(clientes);
			break;
			
			case "2": 
			Agenda.printarClientes(clientes);
			break;
			
			case "3": 
			Agenda.editarCadastro(clientes);
			break;
			
			case "4":
			Agenda.removerCadastro(clientes);
			break;
			
			case "5":
			ordenaPorGenero(clientes,clientesMasculinos, clientesFemininos, clientesOutrosGeneros);
			System.out.println("\nEscolha um Gênero\n"+
					"1 - Masculino \n" +
					"2 - Feminino \n" +
					"3 - Outros \n");
			menuDois = sc.nextLine();
			switch(menuDois) {
			case "1":
				System.out.println("\nMasculino ##########################################\n");
				Agenda.printarClientes(clientesMasculinos);
				break;
			
			case "2":
				System.out.println("\nFeminino ##########################################\n");
				Agenda.printarClientes(clientesFemininos);
				break;
			
			case "3":
				System.out.println("\nOutrosGêneros ##########################################\n");
				Agenda.printarClientes(clientesOutrosGeneros);
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
			
			break;
			
			case "6":
			Agenda.servicosCliente(clientes);
			break;
			
			case "7":
			Agenda.idadeMediaDosClientes(clientes);
			break;
			
			case "8":
				ordenaPorGenero(clientes,clientesMasculinos, clientesFemininos, clientesOutrosGeneros);
				System.out.println("\nEscolha um Gênero\n"+
						"1 - Masculino \n" +
						"2 - Feminino \n" +
						"3 - Outros \n");
				menuDois = sc.nextLine();
				switch(menuDois) {
				case "1": 
					Agenda.idadeMediaDosClientes(clientesMasculinos);
					break;
				case "2": 
					Agenda.idadeMediaDosClientes(clientesFemininos);
					break;
				case "3":
					Agenda.idadeMediaDosClientes(clientesOutrosGeneros);
					break;
				default:
					System.out.println("Opção inválida!");
					break;
				}
			
			case "9":
			Agenda.verificarServicoMaisProcurado(clientes);
			break;
			
			case "10":
				ordenaPorGenero(clientes,clientesMasculinos, clientesFemininos, clientesOutrosGeneros);
				System.out.println("\nEscolha um Gênero\n"+
						"1 - Masculino \n" +
						"2 - Feminino \n" +
						"3 - Outros \n");
				menuDois = sc.nextLine();
				switch(menuDois) {
				case "1": 
					Agenda.verificarServicoMaisProcurado(clientesMasculinos);
					break;
				case "2": 
					Agenda.verificarServicoMaisProcurado(clientesFemininos);
					break;
				case "3":
					Agenda.verificarServicoMaisProcurado(clientesOutrosGeneros);
					break;
				default:
					System.out.println("Opção inválida!");
					break;
				}
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
	
	private static void ordenaPorGenero(ArrayList<Cliente> clientes,ArrayList<Cliente> clientesMasculinos,ArrayList<Cliente> clientesFemininos,ArrayList<Cliente> clientesOutrosGeneros) {
		ordenaPorNome(clientes);
		clientesMasculinos.clear();
		clientesFemininos.clear();
		clientesOutrosGeneros.clear();
		
		for(int i=0; i<clientes.size(); i++)
		if(clientes.get(i).getGenero().equals("m")) {
			clientesMasculinos.add(clientes.get(i));
		}else if(clientes.get(i).getGenero().equals("f")) {
			clientesFemininos.add(clientes.get(i));
		}else {
			clientesOutrosGeneros.add(clientes.get(i));
		}
		
		
		
		
	}
	
	


}

