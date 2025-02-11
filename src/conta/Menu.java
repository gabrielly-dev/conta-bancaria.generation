package conta;

import java.util.Scanner;

import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leitura = new Scanner(System.in);
		
		int opcao;
		
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
			
			opcao = leitura.nextInt();
			
			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				leitura.close();
				System.exit(0);//o 0 significa que a finalização foi executada com sucesso
			}
			
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_GREEN_BOLD + "Criar Conta \n\n" + Cores.TEXT_RESET);
				
				break;
			case 2:
				System.out.println(Cores.TEXT_GREEN_BOLD + "Listar todas as Contas\n\n" + Cores.TEXT_RESET);
				
				break;
			case 3:
				System.out.println(Cores.TEXT_GREEN_BOLD + "Consultar dados da Conta - por número\n\n" + Cores.TEXT_RESET);
				
				break;
			case 4:
				System.out.println(Cores.TEXT_GREEN_BOLD + "Atualizar dados da Conta\n\n" + Cores.TEXT_RESET);
				
				break;
			case 5:
				System.out.println(Cores.TEXT_RED_BOLD + "Apagar a Conta\n\n" + Cores.TEXT_RESET);
				
				break;
			case 6:
				System.out.println(Cores.TEXT_GREEN_BOLD + "Saque\n\n" + Cores.TEXT_RESET);
				
				break;
			case 7:
				System.out.println(Cores.TEXT_GREEN_BOLD + "Depósito\n\n" + Cores.TEXT_RESET);
				
				break;
			case 8:
				System.out.println(Cores.TEXT_GREEN_BOLD + "Transferência entre Contas\n\n" + Cores.TEXT_RESET);
				
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				break;
			}
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
