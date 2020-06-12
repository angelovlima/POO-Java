package l6;

import java.util.ArrayList;
import java.util.Scanner;


public class Inicio {

	public static void main(String[] args) {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ArrayList<Profissional> profissionais = new ArrayList<Profissional>();
		ArrayList<String> historico = new ArrayList<String>();
		ArrayList<Animal> animais = new ArrayList<Animal>();

		Scanner sc = new Scanner(System.in);
		
		String opcaoMenu = "";
		while(opcaoMenu != "0") {
			
			System.out.println("\nMENU \n" +
					"1 - Cadastrar Profissionais \n" +
					"2 - Cadastrar Clientes \n" +
					"3 - Designar Profissional\n" +
					"4 - Concluir Serviço\n" +
					"5 - Relatórios \n" +
					"6 - Histórico \n" +
					"0 - Sair \n");
			opcaoMenu = sc.nextLine();	
			
			switch(opcaoMenu) {
			case "1":
				Profissional.adicionarNovoProfissional(profissionais);
				break;
				
			case "2":
				Cliente.adicionarNovoCliente(clientes,profissionais,animais);
				break;
				
			case "3":
				Profissional.designar(profissionais, clientes, historico);
				break;
			
			case "4":
				Profissional.desocupar(profissionais);
				break;
			
			case "5":
				
				System.out.println("\nMENU\n"+
						"1 - Ranking de Raças mais Populares\n"+
						"2 - Gênero Preferido dos Clientes");
				
				String escolha = sc.nextLine();
				Animal.ranks(animais, escolha);
				break;
				
			case "6":
				Profissional.gerarHistorico(historico);
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
		

}
