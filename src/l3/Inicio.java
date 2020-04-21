package l3;

import java.util.*;

public class Inicio {

	public static void main(String[] args) {
		boolean logado = false;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		// TODO Auto-generated method stub
		telaLogin(usuarios);

	}
	
	public static void telaLogin(ArrayList<Usuario> usuarios) {
		boolean logado = false;
		
		Scanner sc = new Scanner(System.in);
		
		String opcaoMenu = "";
		while(opcaoMenu != "0") {
			
			System.out.println("\nMENU \n" +
					"1 - Login \n" +
					"2 - Cadastro \n" +
					"0 - Sair \n");
			opcaoMenu = sc.nextLine();	
			
			switch(opcaoMenu) {
			case "1": 
				logar(logado, usuarios);
			break;
			case "2": 
				cadastrar(usuarios);
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
	
	public static void logar(boolean logado, ArrayList<Usuario> usuarios) {
		Scanner sc = new Scanner(System.in);
		String userLogin, senhaLogin;
		
		System.out.println("Entre com seu user");
		userLogin = sc.nextLine();
		System.out.println("Entre com sua senha");
		senhaLogin = sc.nextLine();
		
		
		for(Usuario elemento: usuarios) {
			if(elemento.login.user.equals(userLogin) && elemento.login.password.equals(senhaLogin)) {
				logado = true;
				FluxoCaixa.sistema(elemento);
			}
		}
		if(logado == false) {
			String op;
			System.out.println("Login ou senha incorretos");
			System.out.println("Deseja continuar? (S/N)\n");
			op = sc.nextLine();
			if(op.equals("s")) {
				logar(logado, usuarios);
			}
			else {
				telaLogin(usuarios);
			}
			
		}
		else {
			telaLogin(usuarios);
		}
	}
	
	public static void cadastrar(ArrayList<Usuario> usuarios) {
		Scanner scCad = new Scanner(System.in);
		String nomeCad, senhaCad, nome, tel, email, rua, bairro, cidade, estado, pais, numero, verificaJuridica;
		boolean juridica;
		System.out.println("Entre com seu user");
		nomeCad = scCad.nextLine();
		System.out.println("Entre com sua senha");
		senhaCad = scCad.nextLine();
		
		for(Usuario elemento: usuarios) {
			if(elemento.login.user.equals(nomeCad)) {
				String option;
				System.out.println("Usuario já cadastrado!\n");
				System.out.println("Deseja continuar? (S/N)");
				clearBuffer(scCad);
				option = scCad.nextLine();
				if (option.equals("s")) {
					cadastrar(usuarios);
				}
				else {
					telaLogin(usuarios);
				}
			}
		}
		
		Login login = new Login(nomeCad, senhaCad);
		System.out.println("Entre com seu nome");
		nome = scCad.nextLine();
		System.out.println("Entre com seu email");
		email = scCad.nextLine();
		System.out.println("Entre com seu telefone");
		tel = scCad.nextLine();
		System.out.println("Entre com seu pais");
		pais = scCad.nextLine();
		System.out.println("Entre com seu estado");
		estado = scCad.nextLine();
		System.out.println("Entre com sua cidade");
		cidade = scCad.nextLine();
		System.out.println("Entre com seu bairro");
		bairro = scCad.nextLine();
		System.out.println("Entre com sua rua");
		rua = scCad.nextLine();
		System.out.println("Entre com o numero da sua casa");
		numero = scCad.nextLine();
		System.out.println("Você é uma pessoa jurídica? (S/N)");
		verificaJuridica = scCad.nextLine();
		if(verificaJuridica.equals("s")) {
			juridica = true;
		}
		else {
			juridica = false;
		}
		Endereco endereco = new Endereco(pais, estado, cidade, bairro, rua, numero);
		
		Usuario usuario = new Usuario(nome, tel, endereco, email, login, juridica);
		usuarios.add(usuario);
		System.out.println("Cadastro realizado com sucesso!");
		telaLogin(usuarios);
	}
	
	private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

}
