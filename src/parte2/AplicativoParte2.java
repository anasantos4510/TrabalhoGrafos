package parte2;

import java.util.Scanner;

import estruturaGrafo.Grafo;

public class AplicativoParte2 {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		Grafo grafo = GeradorGrafoPorArquivo.gerarGrafo("arquivosdimacs/GrafoExemplo.txt");
		do {
			int opcao = menu();
			
			switch(opcao) {
			case 1:
				
				break;
			case 2:
				grafo.imprimirGrafo();
				break;
			default:
				System.exit(0);
			}
		}while(true);
		
	}
	
	private static int menu() {
		System.out.println("1. Gerar grafo");
		System.out.println("2. Imprimir Grafo");
		System.out.println("Informar operação:");
		return scanner.nextInt();
	}
	

}
