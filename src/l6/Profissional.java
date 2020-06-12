package l6;

import java.util.ArrayList;
import java.util.Scanner;

public class Profissional extends Pessoa {

	private boolean ocupado;
	public Profissional(String nome, String cpf, String endereco, String telefone) {
		super(nome, cpf, endereco, telefone);
		this.ocupado = false;
	}
	
	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

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



	public static void designar(ArrayList<Profissional> profissionais, ArrayList<Cliente> clientes, ArrayList<String> historico) {
		String profissionalEscolhido = null;
		String clienteEscolhido = null;
		String animalEscolhido = null;
		Cliente escolhido = null;
		boolean escolhendoProfissional = true;
		boolean escolhendoCliente = true;
		boolean escolhendoAnimal = true;
		Scanner sc = new Scanner(System.in);
		int disponivelProf = 0;
		for(Profissional elemento : profissionais) {;
			if(!elemento.isOcupado()) {
				disponivelProf = disponivelProf + 1;
				break;
			}
			
		}
		
		//CLIENTE
		
		if(disponivelProf == 0 || clientes.isEmpty()) {
			System.out.println("Não há profissionais disponíveis no momento");
		}
		else {
			while(escolhendoCliente) {
				System.out.println("Escolha de qual cliente será o animal atendido: ");
				for(Cliente elemento : clientes) {
					System.out.println("- " + elemento.getNome());
					
				}
				clienteEscolhido =  sc.nextLine();
				
				for(Cliente elemento : clientes) {
					if(clienteEscolhido.equals(elemento.getNome())) {
						escolhido = elemento;
						escolhendoCliente = false;
						break;
					}
					
				}
				if(escolhendoCliente) {
					System.out.println("Este cliente não existe, tente outro.");
				}
			}
			//ANIMAL
			while(escolhendoAnimal) {
				System.out.println("Escolha qual animal será atendido: ");
				for(Animal elemento : escolhido.listAnimais) {
					System.out.println("- " + elemento.getRaca());
					
				}
				animalEscolhido =  sc.nextLine();
				
				for(Animal elemento : escolhido.listAnimais) {
					if(animalEscolhido.equals(elemento.getRaca())) {
						escolhendoAnimal = false;
						break;
					}
					
				}
				if(escolhendoAnimal) {
					System.out.println("Este animal não existe, tente outro.");
				}
			}
			
			//PROFISSIONAL
			while(escolhendoProfissional) {
				System.out.println("Escolha qual profissional irá cuidar do animal: ");
				for(Profissional elemento : profissionais) {
					if(!elemento.isOcupado()) {
						System.out.println("- " + elemento.getNome());
					}
					
				}
				profissionalEscolhido =  sc.nextLine();
				
				for(Profissional elemento : profissionais) {
					if(profissionalEscolhido.equals(elemento.getNome()) && !elemento.isOcupado()) {
						escolhendoProfissional = false;
						elemento.setOcupado(true);  
						break;
					}
					
				}
				if(escolhendoProfissional) {
					System.out.println("Este profissional não existe, tente outro.");
				}
			}
			historico.add(profissionalEscolhido + " atendeu o animal " + animalEscolhido + " do cliente " + clienteEscolhido);
		}

		

	}
	
	public static void desocupar(ArrayList<Profissional> profissionais) {
		Scanner sc = new Scanner(System.in);
		boolean escolhendoProfissional = true;
		String profissionalEscolhido;
		
		int ocupados = 0;
		for(Profissional elemento : profissionais) {;
			if(elemento.isOcupado()) {
				ocupados = ocupados + 1;
				break;
			}
			
		}
		
		//CLIENTE
		
		if(ocupados == 0) {
			System.out.println("Não há profissionais ocupados no momento");
		}
		else {
			while(escolhendoProfissional) {
				System.out.println("Qual profissional deseja desocupadar?\n");
				for(Profissional elemento : profissionais) {
					if(elemento.isOcupado()) {
						System.out.println("- " + elemento.getNome());
					}
					
				}
				profissionalEscolhido =  sc.nextLine();
				
				for(Profissional elemento : profissionais) {
					if(profissionalEscolhido.equals(elemento.getNome()) && elemento.isOcupado()) {
						escolhendoProfissional = false;
						elemento.setOcupado(false);  
						break;
					}
					
				}
				if(escolhendoProfissional) {
					System.out.println("Este profissional não existe, tente outro.");
				}
			}
		}
		

		
	}

	public static void gerarHistorico(ArrayList<String> historico) {		
		if(historico.isEmpty()) {
			System.out.println("Não há históricos no momento");
		}
		else {
			System.out.println("Histórico\n");
			for(String elemento : historico) {
				System.out.println(elemento);
			}
		}

	}

}
