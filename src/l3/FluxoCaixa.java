package l3;

import java.util.Scanner;

public class FluxoCaixa {
	//ATIVO
	public int salario;
	public int receitaVendas;
	public int contasReceber;
	public int dinheiroSocio;
	public int emprestimos;
	public int saldoAplicacao;
	public int chequesVista;
	public int chequesPreDatados;
	public int investimentos;
	public int outrosAtivos;
	
	//PASSIVO
	
	public int contasPagar;
	public int comprasVista;
	public int pagamentoEmprestimo;
	public int salariosFuncionarios;
	public int energiaEletica;
	public int gas;
	public int alimentacao;
	public int combustivel;
	public int outrosPassivos;
	
	
	public FluxoCaixa(int salario, int receitaVendas, int contasReceber, int dinheiroSocio, int emprestimos,
			int saldoAplicacao, int chequesVista, int chequesPreDatados, int investimentos, int outrosAtivos,
			int contasPagar, int comprasVista, int pagamentoEmprestimo, int salariosFuncionarios, int energiaEletica,
			int gas, int alimentacao, int combustivel, int outrosPassivos) {
		this.salario = salario;
		this.receitaVendas = receitaVendas;
		this.contasReceber = contasReceber;
		this.dinheiroSocio = dinheiroSocio;
		this.emprestimos = emprestimos;
		this.saldoAplicacao = saldoAplicacao;
		this.chequesVista = chequesVista;
		this.chequesPreDatados = chequesPreDatados;
		this.investimentos = investimentos;
		this.outrosAtivos = outrosAtivos;
		this.contasPagar = contasPagar;
		this.comprasVista = comprasVista;
		this.pagamentoEmprestimo = pagamentoEmprestimo;
		this.salariosFuncionarios = salariosFuncionarios;
		this.energiaEletica = energiaEletica;
		this.gas = gas;
		this.alimentacao = alimentacao;
		this.combustivel = combustivel;
		this.outrosPassivos = outrosPassivos;
	}


	
	public static void sistema(Usuario usuario){
		Scanner sc = new Scanner(System.in);
		String opcaoMenu = "";
		while(opcaoMenu != "0") {
			
			System.out.println("\nMENU \n" +
					"1 - Cadastrar Ativos (Lucros) e Passivo (Preju�zos)\n" +
					"2 - Mostrar Relat�rios Semanais \n" +
					"3 - Mostrar Relat�rios Mensais \n" +
					"0 - Sair \n");
			opcaoMenu = sc.nextLine();
			
			switch(opcaoMenu) {
			case "1": 
				cadastrarAtivosAndPassivos(usuario);
			break;
			case "2": 
				mostrarRelatoriosSemana(usuario);
			break;
			case "3": 
				mostrarRelatoriosMes(usuario);
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
	
	public static void cadastrarAtivosAndPassivos(Usuario usuario) {
		Scanner sc = new Scanner(System.in);
		int mes, semana, salario, receitaVendas, contasReceber, dinheiroSocio, emprestimos,
		saldoAplicacao, chequesVista, chequesPreDatados, investimentos, outrosAtivos,
		contasPagar, comprasVista, pagamentoEmprestimo, salariosFuncionarios, energiaEletica,
		gas, alimentacao, combustivel, outrosPassivos;
		boolean encontrada;
		
		System.out.println("Eles ser�o referentes a que m�s (1 a 12)");
		mes = sc.nextInt();
		System.out.println("Eles ser�o referentes a que semana (1 a 5)");
		semana = sc.nextInt();
		encontrada = false;
		for(Data data: usuario.datas) {
			if(data.mes == mes && data.semana == semana) {
				System.out.println("Data j� cadastrada!");
				encontrada = true;
			}
			
		}
		if(encontrada == false) {
			System.out.println("ATIVOS: \n");
			
			if(usuario.juridica == true) {
				System.out.println("Entre com as receitas de vendas");
				receitaVendas = sc.nextInt();
				System.out.println("Entre com as contas a receber");
				contasReceber = sc.nextInt();
				System.out.println("Entre com o dinheiro dos s�cios");
				dinheiroSocio = sc.nextInt();
				salario = 0;	
			}
			else {
				System.out.println("Entre com o seu sal�rio");
				salario = sc.nextInt();
				receitaVendas = 0;
				contasReceber = 0;
				dinheiroSocio = 0;
				
			}
			System.out.println("Entre com os seus emprestimos");
			emprestimos = sc.nextInt();
			System.out.println("Entre com o saldo de aplica��es");
			saldoAplicacao = sc.nextInt();
			System.out.println("Entre com os cheques a vista");
			chequesVista = sc.nextInt();
			System.out.println("Entre com os cheques pre datados");
			chequesPreDatados = sc.nextInt();
			System.out.println("Entre com os investimentos");
			investimentos = sc.nextInt();
			System.out.println("Entre com os outros ativos");
			outrosAtivos = sc.nextInt();
			
			System.out.println("PASSIVOS: \n");
			if(usuario.juridica == true) {
				System.out.println("Entre com o sal�rio dos fuuncionarios");
				salariosFuncionarios = sc.nextInt();
			}
			else {
				salariosFuncionarios = 0;
			}
			System.out.println("Entre com as contas a pagar");
			contasPagar = sc.nextInt();
			System.out.println("Entre com as compras a vista");
			comprasVista = sc.nextInt();
			System.out.println("Entre com o pagamento de emprestimo");
			pagamentoEmprestimo = sc.nextInt();
			System.out.println("Entre com os gastos de energia el�trica");
			energiaEletica = sc.nextInt();
			System.out.println("Entre com os gastos de g�s");
			gas = sc.nextInt();
			System.out.println("Entre com a alimenta��o");
			alimentacao = sc.nextInt();
			System.out.println("Entre com os gastos com combust�vel");
			combustivel = sc.nextInt();
			System.out.println("Entre com os demais gastos");
			outrosPassivos = sc.nextInt();

			
			FluxoCaixa fluxo = new FluxoCaixa(salario, receitaVendas, contasReceber, dinheiroSocio, emprestimos,
					saldoAplicacao, chequesVista, chequesPreDatados, investimentos, outrosAtivos,
					contasPagar, comprasVista, pagamentoEmprestimo, salariosFuncionarios, energiaEletica,
					gas, alimentacao, combustivel, outrosPassivos);
			Data data = new Data(mes, semana, fluxo);
			usuario.datas.add(data);
			
		}
		sistema(usuario);
		
		
		
	}
	
	
	public static void mostrarRelatoriosSemana(Usuario usuario) {
		int mes, semana;
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com o m�s que deseja: \n");
		mes = sc.nextInt();
		System.out.println("Entre com o semana que deseja: \n");
		semana = sc.nextInt();
		for(Data data: usuario.datas) {
			if(data.mes == mes && data.semana == semana) {
				System.out.println("ATIVOS\n");
				if(usuario.juridica == true) {
					System.out.println("Receitas vendas: " + data.fluxo.receitaVendas);
					System.out.println("Contas � receber: " + data.fluxo.contasReceber);
					System.out.println("Dinheiro dos s�cios: " + data.fluxo.dinheiroSocio);
				}else {
					System.out.println("Sal�rio: " + data.fluxo.salario);
				}
				System.out.println("Emprestimos: " + data.fluxo.emprestimos);
				System.out.println("Saldo de aplica��o: " + data.fluxo.saldoAplicacao);
				System.out.println("Cheques � vista: " + data.fluxo.chequesVista);
				System.out.println("Cheques pr�-Datados: " + data.fluxo.chequesPreDatados);
				System.out.println("Investimento: " + data.fluxo.investimentos);
				System.out.println("Outros ativos: " + data.fluxo.outrosAtivos);
				
				System.out.println("\nPASSIVOS\n");
				if(usuario.juridica == true) {
					System.out.println("Sal�rios dos funcion�rios: " + data.fluxo.salariosFuncionarios);
				}
				System.out.println("Contas � pagar: " + data.fluxo.contasPagar);
				System.out.println("Compras � vista: " + data.fluxo.comprasVista);
				System.out.println("Pagamento de empr�stimos: " + data.fluxo.pagamentoEmprestimo);
				System.out.println("Energia el�trica: " + data.fluxo.energiaEletica);
				System.out.println("G�s: " + data.fluxo.gas);
				System.out.println("Alimenta��o: " + data.fluxo.alimentacao);
				System.out.println("Combust�vel: " + data.fluxo.combustivel);
				System.out.println("Outros passivos: " + data.fluxo.outrosPassivos);
				
				int totalAtivo, totalPassivo, saldo;
				totalAtivo = (data.fluxo.salario+ data.fluxo.receitaVendas+ data.fluxo.contasReceber+ data.fluxo.dinheiroSocio + data.fluxo.emprestimos +
						data.fluxo.saldoAplicacao+ data.fluxo.chequesVista+ data.fluxo.chequesPreDatados+ data.fluxo.investimentos+ data.fluxo.outrosAtivos);
				totalPassivo = (data.fluxo.contasPagar+ data.fluxo.comprasVista+ data.fluxo.pagamentoEmprestimo+ data.fluxo.salariosFuncionarios+ data.fluxo.energiaEletica+
						data.fluxo.gas+ data.fluxo.alimentacao+ data.fluxo.combustivel+ data.fluxo.outrosPassivos);
				saldo = (totalAtivo - totalPassivo);
				System.out.println("Total do fluxo Ativo: " + totalAtivo );
				System.out.println("Total do fluxo Passivo: " + totalPassivo );
				System.out.println("SALDO: " + saldo );
			}
			}
		sistema(usuario);
		}
	
	public static void mostrarRelatoriosMes(Usuario usuario) {
		int mes;
		int tsalario =0 , treceitaVendas=0, tcontasReceber=0, tdinheiroSocio=0, temprestimos=0,
		tsaldoAplicacao=0, tchequesVista=0, tchequesPreDatados=0, tinvestimentos=0, toutrosAtivos=0,
		tcontasPagar=0, tcomprasVista=0, tpagamentoEmprestimo=0, tsalariosFuncionarios=0, tenergiaEletica=0,
		tgas=0, talimentacao=0, tcombustivel=0, toutrosPassivos=0, ttotalAtivo=0, ttotalPassivo=0, tsaldo=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com o m�s que deseja: \n");
		mes = sc.nextInt();
		
		for(Data data: usuario.datas) {
			if(data.mes == mes) {
				if(usuario.juridica == true) {
					treceitaVendas += data.fluxo.receitaVendas;
					tcontasReceber += data.fluxo.contasReceber;
					tdinheiroSocio += data.fluxo.dinheiroSocio;
				}else {
					tsalario += data.fluxo.salario;
				}
				temprestimos += data.fluxo.emprestimos;
				tsaldoAplicacao += data.fluxo.saldoAplicacao;
				tchequesVista += data.fluxo.chequesVista;
				tchequesPreDatados += data.fluxo.chequesPreDatados;
				tinvestimentos += data.fluxo.investimentos;
				toutrosAtivos += data.fluxo.outrosAtivos;
				
				if(usuario.juridica == true) {
					tsalariosFuncionarios+= data.fluxo.salariosFuncionarios;
				}
				tcontasPagar += data.fluxo.contasPagar;
				tcomprasVista += data.fluxo.comprasVista;
				tpagamentoEmprestimo += data.fluxo.pagamentoEmprestimo;
				tenergiaEletica += data.fluxo.energiaEletica;
				tgas += data.fluxo.gas;
				talimentacao += data.fluxo.alimentacao;
				tcombustivel += data.fluxo.combustivel;
				toutrosPassivos += data.fluxo.outrosPassivos;
				
				ttotalAtivo += (data.fluxo.salario+ data.fluxo.receitaVendas+ data.fluxo.contasReceber+ data.fluxo.dinheiroSocio + data.fluxo.emprestimos +
						data.fluxo.saldoAplicacao+ data.fluxo.chequesVista+ data.fluxo.chequesPreDatados+ data.fluxo.investimentos+ data.fluxo.outrosAtivos);
				ttotalPassivo += (data.fluxo.contasPagar+ data.fluxo.comprasVista+ data.fluxo.pagamentoEmprestimo+ data.fluxo.salariosFuncionarios+ data.fluxo.energiaEletica+
						data.fluxo.gas+ data.fluxo.alimentacao+ data.fluxo.combustivel+ data.fluxo.outrosPassivos);
				tsaldo += (ttotalAtivo - ttotalPassivo);
			}
			}
		System.out.println("ATIVOS\n");
		if(usuario.juridica == true) {
			System.out.println("Receitas vendas: " + treceitaVendas);
			System.out.println("Contas � receber: " + tcontasReceber);
			System.out.println("Dinheiro dos s�cios: " + tdinheiroSocio);
		}else {
			System.out.println("Sal�rio: " + tsalario);
		}
		System.out.println("Emprestimos: " + temprestimos);
		System.out.println("Saldo de aplica��o: " + tsaldoAplicacao);
		System.out.println("Cheques � vista: " + tchequesVista);
		System.out.println("Cheques pr�-Datados: " + tchequesPreDatados);
		System.out.println("Investimento: " + tinvestimentos);
		System.out.println("Outros ativos: " + toutrosAtivos);
		
		System.out.println("\nPASSIVOS\n");
		if(usuario.juridica == true) {
			System.out.println("Sal�rios dos funcion�rios: " + tsalariosFuncionarios);
		}
		System.out.println("Contas � pagar: " + tcontasPagar);
		System.out.println("Compras � vista: " + tcomprasVista);
		System.out.println("Pagamento de empr�stimos: " + tpagamentoEmprestimo);
		System.out.println("Energia el�trica: " + tenergiaEletica);
		System.out.println("G�s: " + tgas);
		System.out.println("Alimenta��o: " + talimentacao);
		System.out.println("Combust�vel: " + tcombustivel);
		System.out.println("Outros passivos: " + toutrosPassivos);
		
		System.out.println("Total do fluxo Ativo: " + ttotalAtivo );
		System.out.println("Total do fluxo Passivo: " + ttotalPassivo );
		System.out.println("SALDO: " + tsaldo );
		sistema(usuario);
		}
		
	
}
