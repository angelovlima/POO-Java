package l6;

import java.util.ArrayList;
import java.util.Scanner;

public class Profissional extends Pessoa {

	public Profissional(String nome, String cpf, String endereco, String telefone) {
		super(nome, cpf, endereco, telefone);
	}
	
	ArrayList<Profissional> listaProfissionais = new ArrayList<Profissional>();

	public static void adicionarNovoProfissional(ArrayList<Profissional> listaProfissionais){
		boolean cadastrando = true;
		Scanner sc = new Scanner(System.in);
		Scanner scInt = new Scanner(System.in);

		while (cadastrando) {
			System.out.println("\nCADASTRO DE PROFISSIONAIS\n");

			System.out.println("Insira seu nome: ");
			String nomeProfissional = sc.nextLine();
			System.out.println("Insira seu cpf: ");
			String cpfProfissional = sc.nextLine();
			System.out.println("Insira seu endereço: ");
			String endProfissional = sc.nextLine();
			System.out.println("Insira seu telefone: ");
			String telProfissional = sc.nextLine();			

			Profissional profissional = new Profissional(nomeProfissional,cpfProfissional, endProfissional, telProfissional);
			listaProfissionais.add(profissional);	
			
			System.out.println("Continuar cadastrando Profissionais (S/N) ?");
			String continua = sc.nextLine();
			if (continua.equalsIgnoreCase("N")) {
				cadastrando = false;
			} else if (continua.equalsIgnoreCase("S")){
			} else {
				System.out.println("\nOpção inválida! Você será redirecionado ao Menu.\n");
				cadastrando = false;
			}
	
		}
			

			
			
			
			
			
	}
	

}
