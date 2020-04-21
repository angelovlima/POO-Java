package l3;

import java.util.*;

import l1.Agenda;

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
				sistema(elemento);
			}
		}
		clearBuffer(sc);
		if(logado == false) {
			String op;
			System.out.println("Login ou senha incorretos");
			System.out.println("Deseja continuar? (S/N)");
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
		System.out.println("Aqui estará o cadastro");
	}
	
	private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
	
	private static void sistema(Object elemento) {
		System.out.println("Aqui estara o sistema");
	}

}
