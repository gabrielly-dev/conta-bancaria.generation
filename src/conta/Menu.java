package conta;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import conta.util.Cores;

public class Menu {

	static Scanner leitura = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContaController contas = new ContaController();
		
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 126, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);
		
		contas.listarTodas();
		
		while (true) {
			System.out.println(Cores.TEXT_YELLOW_BOLD + "******************************************************");
			System.out.println(Cores.TEXT_YELLOW_BOLD + "*                                                    *");
			System.out.println(Cores.TEXT_YELLOW_BOLD + "*                BANCO DO BRAZIL COM Z               *");
			System.out.println(Cores.TEXT_YELLOW_BOLD + "*                                                    *");
			System.out.println(Cores.TEXT_YELLOW_BOLD + "******************************************************");
			System.out.println(Cores.TEXT_WHITE + "*                                                    *");
			System.out.println(Cores.TEXT_WHITE + "*            1 - Criar Conta                         *");
			System.out.println(Cores.TEXT_WHITE + "*            2 - Listar todas as Contas              *");
			System.out.println(Cores.TEXT_WHITE + "*            3 - Buscar Conta por Numero             *");
			System.out.println(Cores.TEXT_WHITE + "*            4 - Atualizar Dados da Conta            *");
			System.out.println(Cores.TEXT_WHITE + "*            5 - Apagar Conta                        *");
			System.out.println(Cores.TEXT_WHITE + "*            6 - Sacar                               *");
			System.out.println(Cores.TEXT_WHITE + "*            7 - Depositar                           *");
			System.out.println(Cores.TEXT_WHITE + "*            8 - Transferir valores entre Contas     *");
			System.out.println(Cores.TEXT_WHITE + "*            9 - Sair                                *");
			System.out.println(Cores.TEXT_WHITE + "*                                                    *");
			System.out.println(Cores.TEXT_WHITE + "******************************************************");
			System.out.println(Cores.TEXT_WHITE + "Entre com a opção desejada:                          ");
			System.out.println(Cores.TEXT_WHITE + "                                                     "
					+ Cores.TEXT_RESET);
			
			
			try {
				opcao = leitura.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leitura.nextLine();
				opcao = 0;
			}
			
			
			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				leitura.close();
				System.exit(0);//o 0 significa que a finalização foi executada com sucesso
			}
			
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_GREEN_BOLD + "Criar Conta \n\n" + Cores.TEXT_RESET);
				
				System.out.println("Digite o " + Cores.TEXT_WHITE_BOLD_BRIGHT + "Número" + Cores.TEXT_RESET + " da Agência: ");
				agencia = leitura.nextInt();
				System.out.println("Digite o " + Cores.TEXT_WHITE_BOLD_BRIGHT + "Nome" + Cores.TEXT_RESET + " do Titular: ");
				leitura.skip("\\R?");
				titular = leitura.nextLine();
				
				do {
					System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
						tipo = leitura.nextInt();
				} while (tipo < 1 && tipo > 2);
				
				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = leitura.nextFloat();
				
				switch(tipo) {
					case 1 -> {
						System.out.println("Digite o Limite de Crédito (R$): ");
						limite = leitura.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do Aniversario da Conta: ");
						aniversario = leitura.nextInt();
						contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
				}
 				
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_GREEN_BOLD + "Listar todas as Contas\n\n" + Cores.TEXT_RESET);
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_GREEN_BOLD + "Consultar dados da Conta - por número\n\n" + Cores.TEXT_RESET);
				
				System.out.println("Digite o número da conta: ");
				numero = leitura.nextInt();
				
				contas.procurarPorNumero(numero);
				
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_GREEN_BOLD + "Atualizar dados da Conta\n\n" + Cores.TEXT_RESET);
				
				System.out.println("Digite o número da conta: ");
				numero = leitura.nextInt();
				
				var buscaConta = contas.buscarNaCollection(numero);
				
				if (buscaConta != null) {
					tipo = buscaConta.getTipo();
					
					System.out.println("Digite o " + Cores.TEXT_WHITE_BOLD_BRIGHT + "Número" + Cores.TEXT_RESET + " da Agência: ");
					agencia = leitura.nextInt();
					System.out.println("Digite o " + Cores.TEXT_WHITE_BOLD_BRIGHT + "Nome" + Cores.TEXT_RESET + " do Titular: ");
					leitura.skip("\\R?");
					titular = leitura.nextLine();
					
					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = leitura.nextFloat();
					
					switch(tipo) {
						case 1 -> {
							System.out.println("Digite o Limite de Crédito (R$): ");
							limite = leitura.nextFloat();
							contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
						}
						case 2 -> {
							System.out.println("Digite o dia do Aniversario da Conta: ");
							aniversario = leitura.nextInt();
							contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
						}
						default -> {
							System.out.println("Tipo de conta inválido!");
						}
					}
				} else {
					System.out.println("A Conta não foi encontrada!");
				}
					
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_RED_BOLD + "Apagar a Conta\n\n" + Cores.TEXT_RESET);
				
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_GREEN_BOLD + "Saque\n\n" + Cores.TEXT_RESET);
				
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_GREEN_BOLD + "Depósito\n\n" + Cores.TEXT_RESET);
				
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_GREEN_BOLD + "Transferência entre Contas\n\n" + Cores.TEXT_RESET);
				
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		}
		
		
	}
	
	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressiona Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}

	private static void sobre() {
		System.out.println(Cores.TEXT_CYAN + "\n*********************************************************");
		System.out.println(Cores.TEXT_CYAN + "Projeto Desenvolvido por: Gabrielly Barbosa Silva");
		System.out.println(Cores.TEXT_CYAN + "Caso queira entrar em contato, segue abaixo os meios:");
		System.out.println(Cores.TEXT_CYAN + "E-mail: gabriellybarbosa.dev@gmail.com");
		System.out.println(Cores.TEXT_CYAN + "GitHub: github.com/gabrielly-dev");
		System.out.println(Cores.TEXT_CYAN + "*********************************************************" + 
		Cores.TEXT_RESET);
	}

}
