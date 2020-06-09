package l6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Cliente extends Pessoa{
	
	public List<Animal> listAnimais;
	
	public Cliente(String nome, String cpf, String endereco, String telefone,
			List<Animal> listAnimais) {
		super(nome, cpf, endereco, telefone);
		this.listAnimais = listAnimais;
	}
	
	ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

	public static void adicionarNovoCliente(ArrayList<Cliente> listaClientes, ArrayList<Profissional> listaProfissionais){
		boolean cadastrando = true;
		int qntddAnimais = 0;
		Scanner sc = new Scanner(System.in);
		Scanner scInt = new Scanner(System.in);

		while (cadastrando) {
			System.out.println("\nCADASTRO DE CLIENTE\n");

			System.out.println("Insira seu nome: ");
			String nomeCliente = sc.nextLine();
			System.out.println("Insira seu cpf: ");
			String cpfCliente = sc.nextLine();
			System.out.println("Insira seu endere�o: ");
			String endCliente = sc.nextLine();
			System.out.println("Insira seu telefone: ");
			String telCliente = sc.nextLine();
			
			
			
			ArrayList<Animal> listaAnimais = new ArrayList <Animal>();
			int quantidadeAnimais = 0;
			boolean escolhendoProfissional = true;
			boolean terminado = false;
			System.out.println("Insira quantos animais possui:");
			quantidadeAnimais = scInt.nextInt();
			
			while(terminado == false) {
				if (quantidadeAnimais <= 5) {
					
					for(int i = 0; i<quantidadeAnimais; i++ ) {
						System.out.println("Insira a ra�a do animal: ");
						String raca = sc.nextLine();
						System.out.println("Insira o g�nero (F/M): ");
						String genero = sc.nextLine();
						System.out.println("Insira a idade: ");
						String idade = sc.nextLine();
						String profissionalEscolhido;
						Profissional prof = null;
						
						
						while(escolhendoProfissional) {
							System.out.println("Escolha qual profissional ir� cuidar do seu animal: ");
							for(Profissional elemento : listaProfissionais) {
								System.out.println("- " + elemento.getNome());
							}
							profissionalEscolhido =  sc.nextLine();
							
							for(Profissional elemento : listaProfissionais) {
								if(profissionalEscolhido.equals(elemento.getNome())) {
									prof = elemento;
									escolhendoProfissional = false;
									break;
								}
								
							}
							if(escolhendoProfissional) {
								System.out.println("Este profissional n�o existe, tente outro.");
							}
						}
						
						Animal animal = new Animal(raca,genero,idade,prof);
						listaAnimais.add(animal);
						
					}
					terminado = true;
				}else {
					System.out.println("Erro. Insira at� 5 animais:");
					quantidadeAnimais = scInt.nextInt();
				}
			}
			Cliente cliente = new Cliente(nomeCliente,cpfCliente, endCliente, telCliente, listaAnimais);
			listaClientes.add(cliente);	
			
			System.out.println("Continuar cadastrando Cliente (S/N) ?");
			String continua = sc.nextLine();
			if (continua.equalsIgnoreCase("N")) {
				cadastrando = false;
			} else if (continua.equalsIgnoreCase("S")){
			} else {
				System.out.println("\nOp��o inv�lida! Voc� ser� redirecionado ao Menu.\n");
				cadastrando = false;
			}
	
		}
			

			
			
			
			
			
	}
		
		
}

