package parte2;

import java.util.Scanner;

import estruturaGrafo.Aresta;
import estruturaGrafo.Grafo;
import estruturaGrafo.Vertice;
import util.Util;

public class AplicativoParte2 {

	static Scanner scanner = new Scanner(System.in);


	
	public static void main(String[] args) {
		Util.clear();
		Grafo grafo = GeradorGrafoPorArquivo.gerarGrafo("arquivosdimacs/GrafoExemplo.txt");
		int verticeDesejado, verticeDesejado2;
		String arestaDesejada = "";
		do {
			int opcao = menu();
			
			switch(opcao) {
				case 1: // Imprime Grafo 
					grafo.imprimirGrafo();
				break;

				case 2: // Imprime todas arestas adjacentes a uma aresta "a" (informado pelo usuário).
					System.out.print("Informe a aresta desejada: ");
					arestaDesejada = scanner.next();

					System.out.println("\nArestas adjacentes: ");
					grafo.getAresta(arestaDesejada).getVerticeOrigem().exibeArestas();
					grafo.getAresta(arestaDesejada).getVerticeDestino().exibeArestas();
					
				break;

				case 3: // Imprime todos os vértices adjacentes a um vértice "v", (informado pelo usuário). 
					
					System.out.print("Informe o vértice desejado: ");
					verticeDesejado = Integer.parseInt(scanner.next());

					System.out.println("\nVérices adjacentes: ");
					grafo.exibeVerticesAdjacentes(verticeDesejado);
				break;

				case 4: // Imprimir todas as arestas incidentes a um vértice "v",  (informado pelo usuário). 
					System.out.print("Informe o vértice desejado: ");
					verticeDesejado = Integer.parseInt(scanner.next());

					System.out.println("\nVérices incidentes: ");
					grafo.exibeArestasIncidentes(verticeDesejado);
				break;

				case 5: // Imprimir todos os vértices incidentes a uma aresta "a",  (informado pelo usuário). 
					System.out.print("Informe a aresta desejada: ");
					arestaDesejada = scanner.next();

					System.out.println("Vértices incidentes à aresta: " + arestaDesejada);
					System.out.println("\n" + grafo.getAresta(arestaDesejada).getVerticeOrigem().toString());
					System.out.println(grafo.getAresta(arestaDesejada).getVerticeDestino().toString());
				break;

				case 6: //  Imprimi o grau do vértice "v", (informado pelo usuário). 
					System.out.print("Informe o vértice desejado: ");
					verticeDesejado = Integer.parseInt(scanner.next());
					int grau = grafo.getVertice(verticeDesejado).getGrau();
					System.out.println("O vértice v" + verticeDesejado + " tem o grau: " + grau);
				break;

				case 7: // Determinar se dois vértices são adjacentes. 
					System.out.print("Informe os vértices desejado: ");
					System.out.print("\n\n1º: ");
					verticeDesejado = Integer.parseInt(scanner.next());
					System.out.print("2º: ");
					verticeDesejado2 = Integer.parseInt(scanner.next());
					Vertice v = grafo.getVertice(verticeDesejado);

					for (Aresta aresta : v.getArestas()) {
						
						if(aresta.getVerticeOrigem().getLegenda() == verticeDesejado2 || aresta.getVerticeDestino().getLegenda() == verticeDesejado2) {
							System.out.println("\nO vértice v" + verticeDesejado + " é adjacente ao vértice v" + verticeDesejado2); break;
						}
						
					}
					System.out.println("\nO vértice v" + verticeDesejado + " não é adjacente ao vértice v" + verticeDesejado2);

				break;

				case 8: // Substituir o peso de uma aresta "a".  (informado pelo usuário). 
					System.out.print("Informe a aresta que desejada substituir o peso: ");
					arestaDesejada = scanner.next();
					Aresta aresta = grafo.getAresta(arestaDesejada);

					System.out.println("A aresta {"+ arestaDesejada + "} tem o peso = " + aresta.getPeso());
					System.out.print("\nInforme o novo peso da aresta: ");
					String novoPeso = scanner.next();
					aresta.setPeso(Integer.parseInt(novoPeso));

					System.out.println("Novo peso cadastrado para a aresta " + arestaDesejada);
				break;

				case 9: //  Trocar dois vértices

				break;

				case 10: //    

				break;

				case 11: //    

				break;

				case 12: //   

				break;

				case 13: //    

				break;

				case 14: // Criação de um menu de interação com usuário

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
        System.out.println("|--------------------------------------------------------------|");
        System.out.println("|                          Menu                                |");
        System.out.println("|==============================================================|");
        System.out.println("|1. Imprimir Grafo                                             |");
        System.out.println("|2. Imprimir todas arestas adjacentes a partir de uma aresta.  |");
        System.out.println("|3. Imprimir todos vértices adjcentes a partir de um vértice.  |");
        System.out.println("|4. Imprimir todas arestas incidentes a partir de um vértice.  |");
        System.out.println("|5. Imprimir todas vértices incidentes a partir de uma aresta. |");
        System.out.println("|6. Imprimir o grau de um vértice.                             |");
        System.out.println("|7. Verificar se dois vértices são adjacentes.                 |");
        System.out.println("|8. Substituir o peso de uma aresta.                           |");
        System.out.println("|15. Sair                                                      |");
        System.out.println("|--------------------------------------------------------------|");

		System.out.print("\nInformar operação: ");
		int value = scanner.nextInt();
		
		Util.clear();

		return value;
	}
	

}
