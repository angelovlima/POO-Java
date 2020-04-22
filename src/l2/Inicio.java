package l2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Inicio {
	
	public static void main(String[] args) {
		System.out.println("SISTEMA DE GERENCIAMENTO DE REVISÕES AUTOMOTIVAS \n\n");
		ArrayList<ClienteClass> clientes = new ArrayList<ClienteClass>();
		ArrayList<VeiculoClass> veiculos = new ArrayList<VeiculoClass>();

		Main(clientes, veiculos);
		
	}

	public static void Main(ArrayList<ClienteClass> clientes, ArrayList<VeiculoClass> veiculos) {
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
		case "1": CadastrarClientes(clientes, veiculos);
		break;
		case "2": CadastrarVeiculo(clientes, veiculos);
		break;
		case "3": AgendarRevisao();
		break;
		case "4": ReagendarRevisão();
		break;
		case "5": CancelarRevisao();
		break;
		case "6": RelatorioServicos();
		break;
		default:
			System.out.println("Opção inválida!");
			Main(clientes, veiculos);
		}

	}
	
	public static void CadastrarClientes(ArrayList<ClienteClass> clientes, ArrayList<VeiculoClass> veiculos) {
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
			Main(clientes, veiculos);
		}
	}
	
	public static void CadastrarVeiculo(ArrayList<ClienteClass> clientes, ArrayList<VeiculoClass> veiculos) {
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
			
			if(clientes.size() > 0) {
				System.out.println("Cliente (Insira o CPF): ");
				String buscarCpf = scanner.next();		
				for (ClienteClass cliente: clientes) {
					if(cliente.getCpfCliente().equals(buscarCpf)) {
						veiculo.cliente = cliente;
					}
					else {
						System.out.println("CPF não encontrado! Tente novamente");
						CadastrarVeiculo(clientes, veiculos);
					}
				}	
			}
			else {
				System.out.println("Não existe nenhum cliente cadastrado.");
				Main(clientes, veiculos);
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
			Main(clientes, veiculos);
		}
	}
	
	public static void AgendarRevisao() {
		System.out.println("AGENDAR REVISÃO");
	}
	
	public static void ReagendarRevisão() {
		System.out.println("REAGENDAR REVISÃO");
	}
	
	public static void CancelarRevisao() {
		System.out.println("CANCELAR REVISÃO");
	}
	
	public static void RelatorioServicos() {
		System.out.println("RELATÓRIO DE SERVIÇOS");
	}
	
	private static String textInput(String text) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(text);
		return scanner.nextLine();
	}
}

