package l3;

import java.util.Scanner;

public class FluxoCaixa {
	public int a;
	
	//construtor
	
	public static void sistema(Usuario usuario){
		Scanner sc = new Scanner(System.in);
		String opcaoMenu = "";
		while(opcaoMenu != "0") {
			
			System.out.println("\nMENU \n" +
					"1 - Cadastrar Ativo (Lucros) \n" +
					"2 - Cadstrar Passivo (Prejuízos) \n" +
					"3 - Mostrar Relatórios Semanais \n" +
					"4 - Mostrar Relatórios Mensais \n" +
					"0 - Sair \n");
			opcaoMenu = sc.nextLine();
			
			switch(opcaoMenu) {
			case "1": 
				System.out.println("Ativos");
			break;
			case "2": 
				System.out.println("Passivos");
			break;
			case "3": 
				System.out.println("Semanais");
			break;
			case "4": 
				System.out.println("Mensais");
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
