package l6;

import java.util.ArrayList;
import java.util.Scanner;


public class Inicio {

	public static void main(String[] args) {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		Scanner sc = new Scanner(System.in);
		
		String opcaoMenu = "";
		while(opcaoMenu != "0") {
			
			System.out.println("\nMENU \n" +
					"1 - Cadastrar Profissionais \n" +
					"2 - Cadastrar Clientes \n" +
					"3 - Relat�rios \n" +
					"4 - Hist�rico \n" +
					"0 - Sair \n");
			opcaoMenu = sc.nextLine();	
			
			switch(opcaoMenu) {
			case "1":
				System.out.println("�eeeee");
				break;
				
			case "2":
				Cliente.adicionarNovoCliente(clientes);
				break;
				
			case "0":
				opcaoMenu = "0";
				break;
				
			default:
				System.out.println("Op��o inv�lida!");
				break;
				
			}
		}
	}
		

}
