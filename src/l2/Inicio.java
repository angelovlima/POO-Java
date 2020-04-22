package l2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Inicio {
	
	public static void main(String[] args) {
		System.out.println("SISTEMA DE GERENCIAMENTO DE REVISÕES AUTOMOTIVAS \n\n");
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
				"2 - Cadastrar Veículo \n" +
				"3 - Agendar revisão \n" +
				"4 - Trocar data de revisão \n" +
				"5 - Cancelar revisão \n" +
				"6 - Relatório de serviços \n");
		String opcaoMenu = scanner.nextLine();	
		
		switch(opcaoMenu) {
		case "1": CadastrarClientes(clientes, veiculos, revisoes);
		break;
		case "2": CadastrarVeiculo(clientes, veiculos, revisoes);
		break;
		case "3": AgendarRevisao(clientes, veiculos, revisoes);
		break;
		case "4": ReagendarRevisão(clientes, veiculos, revisoes);
		break;
		case "5": CancelarRevisao(clientes, veiculos, revisoes);
		break;
		case "6": RelatorioServicos(clientes, veiculos, revisoes);
		break;
		default:
			System.out.println("Opção inválida!");
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
			cliente.setEnderecoCliente(textInput("Endereço: "));
			cliente.setCpfCliente(textInput("CPF: "));

			clientes.add(cliente);

			System.out.println("Continuar cadastrando (S/N) ?");
			String continua = scanner.nextLine();
			if (continua.equalsIgnoreCase("N")) {
				cadastrando = false;
			} else if (continua.equalsIgnoreCase("S")){
			} else {
				System.out.println("\nOpção inválida! Você será redirecionado ao Menu.\n");
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
			System.out.println("CADASTRO DE VEÍCULO");
			VeiculoClass veiculo = new VeiculoClass();
			veiculo.setPlacaVeiculo(textInput("Placa: "));
			veiculo.setVersaoModeloVeiculo(textInput("Versão/Modelo: "));
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
					System.out.println("CPF não encontrado! Tente novamente");
					CadastrarVeiculo(clientes, veiculos, revisoes);
				}
			}
			else {
				System.out.println("Não existe nenhum cliente cadastrado.");
				Main(clientes, veiculos, revisoes);
			}

			veiculos.add(veiculo);

			System.out.println("Continuar cadastrando (S/N) ?");
			String continua = scanner.next();
			if (continua.equalsIgnoreCase("N")) {
				cadastrando = false;
			} else if (continua.equalsIgnoreCase("S")){
			} else {
				System.out.println("\nOpção inválida! Você será redirecionado ao Menu.\n");
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
			System.out.println("AGENDAR REVISÃO");
			RevisaoClass revisao = new RevisaoClass();
			revisao.setDataRevisao(textInput("Data da Revisão: "));
			revisao.setServico(textInput("Serviço: "));
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
					System.out.println("Veículo não encontrado! Tente novamente");
					AgendarRevisao(clientes, veiculos, revisoes);
				}
			}
			else {
				System.out.println("Não existe nenhum veículo cadastrado.");
				Main(clientes, veiculos, revisoes);
			}

			revisoes.add(revisao);

			System.out.println("Continuar cadastrando (S/N) ?");
			String continua = scanner.next();
			if (continua.equalsIgnoreCase("N")) {
				cadastrando = false;
			} else if (continua.equalsIgnoreCase("S")){
			} else {
				System.out.println("\nOpção inválida! Você será redirecionado ao Menu.\n");
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
	
	public static void ReagendarRevisão(ArrayList<ClienteClass> clientes, ArrayList<VeiculoClass> veiculos, ArrayList<RevisaoClass> revisoes) {
		Scanner sc = new Scanner(System.in);
		boolean editando = true;
		
		while (editando) {
			System.out.println("REAGENDAR REVISÃO");
			System.out.println("Placa do carro a ser revisado: ");
			String placa = sc.nextLine();
			boolean temRevisao = false;
			
			if(revisoes.size() > 0) {
				for (RevisaoClass revisao: revisoes) {
				   if (revisao.veiculo.getPlacaVeiculo().equals(placa)) {
					   System.out.println("Nova data: ");
					   revisao.dataRevisao = sc.next();
					   System.out.println("Novo serviço: ");
					   revisao.servico = sc.next();
					   temRevisao = true;
				   	}				    
				}
				
				if(!temRevisao) {
					System.out.println("Revisão não encontrado! Tente novamente");
					ReagendarRevisão(clientes, veiculos, revisoes);
				}
			}
			else {
				System.out.println("Não existe nenhuma revisão cadastrada.");
				Main(clientes, veiculos, revisoes);
			}
			
					

			System.out.println("Continuar editando (S/N) ?");
			String continua = sc.next();
			if (continua.equalsIgnoreCase("N")) {
				editando = false;
			} else if (continua.equalsIgnoreCase("S")){
			} else {
				System.out.println("\nOpção inválida! Você será redirecionado ao Menu.\n");
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
			System.out.println("Insira a placa do carro que terá sua revisão removida:");
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
				System.out.println("\nOpção inválida! Você será redirecionado ao Menu.\n");
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
		
		System.out.println("RELATÓRIO DE SERVIÇOS");
		if(clientes.size() > 0) {
			for(ClienteClass cliente: clientes) {
				System.out.println("Cliente: " + cliente.getNomeCliente());
				System.out.println("CPF: " + cliente.getCpfCliente());
				System.out.println("Endereço: " + cliente.getEnderecoCliente());
				System.out.println("Telefone: " + cliente.getTelefoneCliente());
				if(veiculos.size() > 0) {
					for(VeiculoClass veiculo: veiculos) {
						if(veiculo.cliente.getCpfCliente().equals(cliente.getCpfCliente())) {
							System.out.println("Placa veículo: " + veiculo.getPlacaVeiculo());
							System.out.println("Ano: " + veiculo.getAnoVeiculo());
							System.out.println("Versão/Modelo: " + veiculo.getVersaoModeloVeiculo());
							System.out.println("Valor: " + veiculo.getValorVeiculo());
							if(revisoes.size() > 0) {
								for(RevisaoClass revisao: revisoes) {
									if(revisao.veiculo.getPlacaVeiculo().equals(veiculo.placaVeiculo)) {
										System.out.println("Data da Revisão: " + revisao.getDataRevisao() );
										System.out.println("Serviço: " + revisao.getServico());
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
			System.out.println("Opção inválida!");
		}
	}
	
	private static String textInput(String text) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(text);
		return scanner.nextLine();
	}
}

