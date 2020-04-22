package l2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Inicio {
	
	public static void main(String[] args) {
		System.out.println("SISTEMA DE GERENCIAMENTO DE REVIS�ES AUTOMOTIVAS \n\n");
		ArrayList<ClienteClass> clientes = new ArrayList<ClienteClass>();
		ArrayList<VeiculoClass> veiculos = new ArrayList<VeiculoClass>();
		ArrayList<RevisaoClass> revisoes = new ArrayList<RevisaoClass>();

		Main(clientes, veiculos, revisoes);
		
	}

	public static void Main(ArrayList<ClienteClass> clientes, ArrayList<VeiculoClass> veiculos, ArrayList<RevisaoClass> revisoes) {
		Scanner scanner = new Scanner(System.in);
		//menu
		System.out.println("\nMenu \n" +
				"1 - Cadastrar Clientes \n" +
				"2 - Cadastrar Ve�culo \n" +
				"3 - Agendar revis�o \n" +
				"4 - Trocar data de revis�o \n" +
				"5 - Cancelar revis�o \n" +
				"6 - Relat�rio de servi�os \n");
		String opcaoMenu = scanner.nextLine();	
		
		switch(opcaoMenu) {
		case "1": CadastrarClientes(clientes, veiculos, revisoes);
		break;
		case "2": CadastrarVeiculo(clientes, veiculos, revisoes);
		break;
		case "3": AgendarRevisao(clientes, veiculos, revisoes);
		break;
		case "4": ReagendarRevis�o(clientes, veiculos, revisoes);
		break;
		case "5": CancelarRevisao(clientes, veiculos, revisoes);
		break;
		case "6": RelatorioServicos(clientes, veiculos, revisoes);
		break;
		default:
			System.out.println("Op��o inv�lida!");
			Main(clientes, veiculos, revisoes);
		}

	}
	
	public static void CadastrarClientes(ArrayList<ClienteClass> clientes, ArrayList<VeiculoClass> veiculos, ArrayList<RevisaoClass> revisoes) {
		Scanner scanner = new Scanner(System.in);
		
		boolean cadastrando = true;

		while (cadastrando) {
			System.out.println("CADASTRO DE CLIENTE");
			ClienteClass cliente = new ClienteClass();
			cliente.setNomeCliente(textInput("Nome: "));
			cliente.setTelefoneCliente(textInput("Telefone: "));
			cliente.setEnderecoCliente(textInput("Endere�o: "));
			cliente.setCpfCliente(textInput("CPF: "));

			clientes.add(cliente);

			System.out.println("Continuar cadastrando (S/N) ?");
			String continua = scanner.nextLine();
			if (continua.equalsIgnoreCase("N")) {
				cadastrando = false;
			} else if (continua.equalsIgnoreCase("S")){
			} else {
				System.out.println("\nOp��o inv�lida! Voc� ser� redirecionado ao Menu.\n");
				cadastrando = false;
			}
		}
		
		if(cadastrando == false) {
			//for (ClienteClass cliente: clientes) {
			//	System.out.println(cliente.nomeCliente);
			//}
			Main(clientes, veiculos, revisoes);
		}
	}
	
	public static void CadastrarVeiculo(ArrayList<ClienteClass> clientes, ArrayList<VeiculoClass> veiculos, ArrayList<RevisaoClass> revisoes) {
		Scanner scanner = new Scanner(System.in);
		
		boolean cadastrando = true;

		while (cadastrando) {
			System.out.println("CADASTRO DE VE�CULO");
			VeiculoClass veiculo = new VeiculoClass();
			veiculo.setPlacaVeiculo(textInput("Placa: "));
			veiculo.setVersaoModeloVeiculo(textInput("Vers�o/Modelo: "));
			System.out.println("Ano: ");
			veiculo.setAnoVeiculo(scanner.nextInt());
			System.out.println("Valor: ");
			veiculo.setValorVeiculo(scanner.nextFloat());
			boolean temCliente = false;
			
			if(clientes.size() > 0) {
				System.out.println("Cliente (Insira o CPF): ");
				String buscarCpf = scanner.next();		
				for (ClienteClass cliente: clientes) {
					if(cliente.getCpfCliente().equals(buscarCpf)) {
						veiculo.cliente = cliente;
						temCliente = true;
					}
				}
				if (!temCliente) {
					System.out.println("CPF n�o encontrado! Tente novamente");
					CadastrarVeiculo(clientes, veiculos, revisoes);
				}
			}
			else {
				System.out.println("N�o existe nenhum cliente cadastrado.");
				Main(clientes, veiculos, revisoes);
			}

			veiculos.add(veiculo);

			System.out.println("Continuar cadastrando (S/N) ?");
			String continua = scanner.next();
			if (continua.equalsIgnoreCase("N")) {
				cadastrando = false;
			} else if (continua.equalsIgnoreCase("S")){
			} else {
				System.out.println("\nOp��o inv�lida! Voc� ser� redirecionado ao Menu.\n");
				cadastrando = false;
			}
		}
		
		if(cadastrando == false) {
			//for (VeiculoClass veiculo: veiculos) {
			//	System.out.println(veiculo.placaVeiculo);
			//	System.out.println(veiculo.cliente.nomeCliente);
			//}
			Main(clientes, veiculos, revisoes);
		}
	}
	
	public static void AgendarRevisao(ArrayList<ClienteClass> clientes, ArrayList<VeiculoClass> veiculos, ArrayList<RevisaoClass> revisoes) {		
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> placasExistentes = new ArrayList<String>();
		boolean cadastrando = true;

		while (cadastrando) {
			System.out.println("AGENDAR REVIS�O");
			RevisaoClass revisao = new RevisaoClass();
			revisao.setDataRevisao(textInput("Data da Revis�o: "));
			revisao.setServico(textInput("Servi�o: "));
			boolean temVeiculo = false;
			
			if(veiculos.size() > 0) {
				System.out.println("Placa do Carro a Revisar: ");
				String buscarPlaca = scanner.next();		
				for (VeiculoClass veiculo: veiculos) {
					if(veiculo.getPlacaVeiculo().equals(buscarPlaca)) {
						revisao.veiculo = veiculo;
						temVeiculo = true;
						placasExistentes.add(veiculo.getPlacaVeiculo());
					}
				}
				if(!temVeiculo) {
					System.out.println("Ve�culo n�o encontrado! Tente novamente");
					AgendarRevisao(clientes, veiculos, revisoes);
				}
			}
			else {
				System.out.println("N�o existe nenhum ve�culo cadastrado.");
				Main(clientes, veiculos, revisoes);
			}

			revisoes.add(revisao);

			System.out.println("Continuar cadastrando (S/N) ?");
			String continua = scanner.next();
			if (continua.equalsIgnoreCase("N")) {
				cadastrando = false;
			} else if (continua.equalsIgnoreCase("S")){
			} else {
				System.out.println("\nOp��o inv�lida! Voc� ser� redirecionado ao Menu.\n");
				cadastrando = false;
			}
		}
		
		if(cadastrando == false) {
			//for (RevisaoClass revisao: revisoes) {
			//	System.out.println(revisao.dataRevisao);
			//	System.out.println(revisao.veiculo.placaVeiculo);
			//}
			Main(clientes, veiculos, revisoes);
		}
		
	}
	
	public static void ReagendarRevis�o(ArrayList<ClienteClass> clientes, ArrayList<VeiculoClass> veiculos, ArrayList<RevisaoClass> revisoes) {
		Scanner sc = new Scanner(System.in);
		boolean editando = true;
		
		while (editando) {
			System.out.println("REAGENDAR REVIS�O");
			System.out.println("Placa do carro a ser revisado: ");
			String placa = sc.nextLine();
			boolean temRevisao = false;
			
			if(revisoes.size() > 0) {
				for (RevisaoClass revisao: revisoes) {
				   if (revisao.veiculo.getPlacaVeiculo().equals(placa)) {
					   System.out.println("Nova data: ");
					   revisao.dataRevisao = sc.next();
					   System.out.println("Novo servi�o: ");
					   revisao.servico = sc.next();
					   temRevisao = true;
				   	}				    
				}
				
				if(!temRevisao) {
					System.out.println("Revis�o n�o encontrado! Tente novamente");
					ReagendarRevis�o(clientes, veiculos, revisoes);
				}
			}
			else {
				System.out.println("N�o existe nenhuma revis�o cadastrada.");
				Main(clientes, veiculos, revisoes);
			}
			
					

			System.out.println("Continuar editando (S/N) ?");
			String continua = sc.next();
			if (continua.equalsIgnoreCase("N")) {
				editando = false;
			} else if (continua.equalsIgnoreCase("S")){
			} else {
				System.out.println("\nOp��o inv�lida! Voc� ser� redirecionado ao Menu.\n");
				editando = false;
			}
		}
		if(editando == false) {
			for (RevisaoClass revisao: revisoes) {
				System.out.println(revisao.dataRevisao);
				System.out.println(revisao.veiculo.placaVeiculo);
			}
			Main(clientes, veiculos, revisoes);
		}
	}
	
	public static void CancelarRevisao(ArrayList<ClienteClass> clientes, ArrayList<VeiculoClass> veiculos, ArrayList<RevisaoClass> revisoes) {
		boolean removendo = true;
		Scanner sc = new Scanner(System.in);
		
		while (removendo) {
			System.out.println("REMOVER CADASTRO");
			System.out.println("Insira a placa do carro que ter� sua revis�o removida:");
			String placa = sc.next();
			for (int i = 0; i < revisoes.size(); i++) {
			    if (revisoes.get(i).veiculo.getPlacaVeiculo().equals(placa)) {
			    	revisoes.remove(i);
			    }
			}
			System.out.println("Continuar removendo (S/N) ?");
			String continua = sc.next();
			if (continua.equalsIgnoreCase("N")) {
				removendo = false;
			} else if (continua.equalsIgnoreCase("S")){
			} else {
				System.out.println("\nOp��o inv�lida! Voc� ser� redirecionado ao Menu.\n");
				removendo = false;
			}
		}
		if(removendo == false) {
			for (RevisaoClass revisao: revisoes) {
				System.out.println(revisao.dataRevisao);
				System.out.println(revisao.veiculo.placaVeiculo);
			}
			Main(clientes, veiculos, revisoes);
		}
	}
	
	public static void RelatorioServicos(ArrayList<ClienteClass> clientes, ArrayList<VeiculoClass> veiculos, ArrayList<RevisaoClass> revisoes) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("RELAT�RIO DE SERVI�OS");
		if(clientes.size() > 0) {
			for(ClienteClass cliente: clientes) {
				System.out.println("Cliente: " + cliente.getNomeCliente());
				System.out.println("CPF: " + cliente.getCpfCliente());
				System.out.println("Endere�o: " + cliente.getEnderecoCliente());
				System.out.println("Telefone: " + cliente.getTelefoneCliente());
				if(veiculos.size() > 0) {
					for(VeiculoClass veiculo: veiculos) {
						if(veiculo.cliente.getCpfCliente().equals(cliente.getCpfCliente())) {
							System.out.println("Placa ve�culo: " + veiculo.getPlacaVeiculo());
							System.out.println("Ano: " + veiculo.getAnoVeiculo());
							System.out.println("Vers�o/Modelo: " + veiculo.getVersaoModeloVeiculo());
							System.out.println("Valor: " + veiculo.getValorVeiculo());
							if(revisoes.size() > 0) {
								for(RevisaoClass revisao: revisoes) {
									if(revisao.veiculo.getPlacaVeiculo().equals(veiculo.placaVeiculo)) {
										System.out.println("Data da Revis�o: " + revisao.getDataRevisao() );
										System.out.println("Servi�o: " + revisao.getServico());
									}
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println("Tecle 1 para voltar ao menu");
		String op = scanner.next();
		if(op.equals("1"))
			Main(clientes, veiculos, revisoes);
		else {
			System.out.println("Op��o inv�lida!");
		}
	}
	
	private static String textInput(String text) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(text);
		return scanner.nextLine();
	}
}

