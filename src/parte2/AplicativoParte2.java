package parte2;

import java.util.Scanner;

import estruturaGrafo.Grafo;
import util.Util;

public class AplicativoParte2 {

	static Scanner scanner = new Scanner(System.in);


	
	public static void main(String[] args) {
		Util.clear();
		Grafo grafo = GeradorGrafoPorArquivo.gerarGrafo("arquivosdimacs/GrafoExemplo.txt");
		do {
			int opcao = menu();
			
			switch(opcao) {
				case 1: // Imprime Grafo 
					grafo.imprimirGrafo();
				break;

				case 2: // Imprime todas arestas adjacentes a uma aresta "a" (informado pelo usuário).
					System.out.print("Informe a aresta desejada: ");
					String arestaDesejada = scanner.next();

					System.out.println("\nArestas adjacentes: ");
					grafo.getAresta(arestaDesejada).getVerticeOrigem().exibeArestas();
					grafo.getAresta(arestaDesejada).getVerticeDestino().exibeArestas();
					
				break;

				case 3: // Imprime todos os vértices adjacentes a um vértice "v", (informado pelo usuário). 

				break;

				case 4: // Imprimir todas as arestas incidentes a um vértice "v",  (informado pelo usuário). 

				break;

				case 5: // Imprimir todos os vértices incidentes a uma aresta "a",  (informado pelo usuário). 

				break;

				case 6: //  Imprimi o grau do vértice "v", (informado pelo usuário). 

				break;

				case 7: // Determinar se dois vértices são adjacentes. 

				break;

				case 8: // Substituir o peso de uma aresta "a".  (informado pelo usuário). 

				break;

				case 9: //  

				break;

				case 10: //    

				break;

				case 11: //    

				break;

				case 12: //   

				break;

				case 13: //    

				break;

				case 14: // 

				break;
				default:
					System.out.println("Encerrando...");
					Util.esperar(3);
					Util.clear();
					
					System.exit(0);
			}
			
			Util.paraFluxo("prosseguir.");
		}while(true);
		
	}
	
	private static int menu() {
        System.out.println("|-------------------------------------|");
        System.out.println("|                 Menu                |");
        System.out.println("|=====================================|");
        System.out.println("|1. Imprimir Grafo                    |");
        System.out.println("|2. Imprimir todas arestas adjacentes |");
        System.out.println("|3. Sair                              |");
        System.out.println("|-------------------------------------|");

		System.out.print("\nInformar operação: ");
		int value = scanner.nextInt();
		
		Util.clear();

		return value;
	}
	

}
