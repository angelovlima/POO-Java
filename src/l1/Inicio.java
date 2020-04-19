package l1;

import java.util.Scanner;


public class Inicio {
	
	public static void main(String[] args) {
		//int menu;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com seu nome");
		
		Cliente a = new Cliente("Coringa", "3221-7235", "222.23233.42");
		
		System.out.println(a.getNome());
		System.out.println(a.getTel());
		 
		
		
		/*while(GetMenu() != 0) {
			switch(x) {
				case 1:
					
			}
		}*/

	}
	


}

