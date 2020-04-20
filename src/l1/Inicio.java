package l1;

import java.util.ArrayList;//teste2
//import java.util.Scanner;
import java.util.*;


public class Inicio {
	
	public static void main(String[] args) {
		//int menu;
		//Scanner sc = new Scanner(System.in);
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Agenda.adicionarNovoCliente(clientes);
		
		listarClientes(clientes);

	}
	
	private static void listarClientes(ArrayList<Cliente> clientes) {
		ordenaPorNome(clientes);
		
		//AquiEstariaUmSwitch
		
		
		
		
		
		//case 1
		for(Cliente elemento: clientes) {
			System.out.println("----------------------------------");
			System.out.println(elemento.nome);
			System.out.println(elemento.tel);
			System.out.println(elemento.genero);
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
	
	


}

