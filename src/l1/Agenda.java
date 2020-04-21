package l1;

import java.util.*;


public class Agenda extends Cliente{
	
	Scanner sc = new Scanner(System.in);
	
	public Agenda(String nome, String tel, Nascimento nasci, String genero, ArrayList<String> servicos) {
		super(nome, tel, nasci, genero, servicos);
	}



	ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	
	
	public static void adicionarNovoCliente(ArrayList<Cliente> listaClientes){
		boolean cadastrando = true;
		Scanner sc = new Scanner(System.in);
		Scanner scInt = new Scanner(System.in);

		while (cadastrando) {
			System.out.println("\nCADASTRO DE CLIENTE\n");

			System.out.println("Insira seu nome: ");
			String nomeCliente = sc.nextLine();
			System.out.println("Insira seu telefone: ");
			String telCliente = sc.nextLine();
			System.out.println("Insira o dia em que nasceu: ");
			int diaNiverCliente = scInt.nextInt();
			System.out.println("Insira o mês em que nasceu: ");
			int mesNiverCliente = scInt.nextInt();
			System.out.println("Insira o ano em que nasceu: ");
			int anoNiverCliente = scInt.nextInt();
			Nascimento nasciCliente = new Nascimento(diaNiverCliente,mesNiverCliente,anoNiverCliente);
			
			System.out.println("Insira seu genero (m/f): ");
			String generoCliente = sc.nextLine();
			
			ArrayList<String> listaServicos = new ArrayList <String>();
			
			System.out.println("Insira quantos serviços e produtos foram consumidos");
			int quantidadeServico = scInt.nextInt();
			for(int i = 0; i<quantidadeServico; i++ ) {
				System.out.println("Insira o serviço ou produto consumido: ");
				String servicoOuProduto = sc.nextLine();
				listaServicos.add(servicoOuProduto);
			}
			
			
			
			Cliente cliente = new Cliente(nomeCliente, telCliente,nasciCliente, generoCliente, listaServicos);

			listaClientes.add(cliente);

			System.out.println("Continuar cadastrando (S/N) ?");
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
	
	public static void editarCadastro(ArrayList<Cliente> listaClientes){
		boolean editando = true;
			
		while (editando) {
			System.out.println("EDITAR CADASTRO");
			System.out.println("Busque pelo nome: ");
			Scanner sc = new Scanner(System.in);
			Scanner scInt = new Scanner(System.in);
			String nome = sc.nextLine();
			int numero;
			for (Cliente elemento: listaClientes) {
				   if (elemento.nome.equals(nome)) {
					   System.out.println("Digite o novo nome: ");
					   elemento.setNome(nome = sc.nextLine());
					   System.out.println("Digite o novo telefone: ");
					   elemento.setTel(nome = sc.nextLine());
					   System.out.println("Digite o novo gênero: ");
					   elemento.setGenero(nome = sc.nextLine());
					   
					   System.out.println("Digite o dia de nascimento: ");
					   elemento.setNasciDia(numero = sc.nextInt());
					   System.out.println("Digite o mes de nascimento: ");
					   elemento.setNasciMes(numero = sc.nextInt());
					   System.out.println("Digite o ano de nascimento: ");
					   elemento.setNasciAno(numero = sc.nextInt());
				   }
			}
					

			System.out.println("Continuar editando (S/N) ?");
			String continua = sc.nextLine();
			if (continua.equalsIgnoreCase("N")) {
				editando = false;
			} else if (continua.equalsIgnoreCase("S")){
			} else {
				System.out.println("\nOpção inválida! Você será redirecionado ao Menu.\n");
				editando = false;
			}
		}
	}
	
	public static void removerCadastro(ArrayList<Cliente> listaClientes){
		boolean removendo = true;
		
		while (removendo) {
			System.out.println("REMOVER CADASTRO");
			System.out.println("Digite o nome para REMOVER:");
			Scanner sc = new Scanner(System.in);
			String nome = sc.nextLine();
			for (int i = 0; i < listaClientes.size(); i++) {
			    if (listaClientes.get(i).getNome().equals(nome)) {
			      listaClientes.remove(i);
			    }
			  }
			System.out.println("Continuar removendo (S/N) ?");
			String continua = sc.nextLine();
			if (continua.equalsIgnoreCase("N")) {
				removendo = false;
			} else if (continua.equalsIgnoreCase("S")){
			} else {
				System.out.println("\nOpção inválida! Você será redirecionado ao Menu.\n");
				removendo = false;
			}
		}
		
	}
	
	public static void servicosCliente(ArrayList<Cliente> clientes) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Busque pelo nome: ");
		String nome = sc.nextLine();
		for(Cliente elemento: clientes) {
		    if (elemento.nome.equals(nome)) {
					System.out.println(elemento.servicos);
		    }
		}
	}
	public static void idadeMediaDosClientes(ArrayList<Cliente> clientes) {
        Calendar cal = GregorianCalendar.getInstance();
        int diaAtual = cal.get(Calendar.DAY_OF_MONTH);
        int mesAtual = cal.get(Calendar.MONTH) + 1;
        int anoAtual = cal.get(Calendar.YEAR);
        int idadeTotal = 0;

		for(Cliente elemento: clientes) {
		        int diaNasc = elemento.nasci.dia;
		        if ((diaNasc<=0) && (diaNasc>31))
		        {
		            System.out.println("Dia Invalido");
		        }else{
		        	int mesNasc = elemento.nasci.mes;
		        	if ((mesNasc<=0) && (mesNasc>12)){
		            System.out.println("Mes invalido");
		        	}else{
		        		int anoNasc = elemento.nasci.ano;
		        		if ((anoNasc<=0) && (anoNasc>anoAtual)){
		        			System.out.println("Ano Invalido");
		        		}else{
		        			int nasc = anoNasc*365;
		        			nasc = nasc+(mesNasc*31);
		        			nasc = nasc+diaNasc;
		        			int atual = anoAtual*365;
		        			atual = atual+(mesAtual*31);
		        			atual = atual+diaAtual;
		        			idadeTotal += (atual-nasc)/365;
		        			
		           
		        		}
		        	}
		        }
		    }
			idadeTotal = idadeTotal/clientes.size();
			System.out.println("A idade media é de " + idadeTotal);
		
        

          
            
	}
	
	public static void verificarServicoMaisProcurado(ArrayList<Cliente> clientes) {
		ArrayList<String> todosOsServicos = new ArrayList<String>();
		String servicoMaisConsumido="", servicoAnterior="";
		int vezesConsumidas=0, cont=1;
		for(Cliente elemento: clientes) {
			for(String servico: elemento.servicos) {
				todosOsServicos.add(servico);
		    }
		}
		Collections.sort(todosOsServicos);
		for(String servico: todosOsServicos) {
			if(servico.equals(servicoAnterior)) {
				cont++;
				
				if(vezesConsumidas<cont) {
					vezesConsumidas = cont;
					servicoMaisConsumido = servico;
					
				}
			}
			else {
				servicoAnterior = servico;
				cont=1;
				
			}
		}
		
		System.out.println("O servico " + servicoMaisConsumido + " foi utilizado " + vezesConsumidas+ " vezes, sendo assim o mais consumido");
		
		
	}
	
	public static void printarClientes(ArrayList<Cliente> clientes) {
		for(Cliente elemento: clientes) {
			
			System.out.println(elemento.nome);
			System.out.println(elemento.tel);
			System.out.println(elemento.nasci.dia + "/" + elemento.nasci.mes + "/" + elemento.nasci.ano);
			System.out.println(elemento.genero);
			System.out.println("--------------------------------------");
		}
	}
	

}




