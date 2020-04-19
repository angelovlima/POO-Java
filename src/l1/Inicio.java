package l1;

import java.util.ArrayList;//teste2
//import java.util.Scanner;


public class Inicio {
	
	public static void main(String[] args) {
		//int menu;
		//Scanner sc = new Scanner(System.in);
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Agenda.adicionarNovoCliente(clientes);
		
		for(Cliente elemento: clientes) {
			System.out.println(elemento.nome);
			System.out.println(elemento.tel);
			System.out.println(elemento.genero);
		}
		
		
		
		
		 
		
		
		/*while(GetMenu() != 0) {
			switch(x) {
				case 1:
					
			}
		}*/

	}
	


}

