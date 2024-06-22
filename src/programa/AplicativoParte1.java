package programa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import estruturaGrafo.Aresta;
import estruturaGrafo.Grafo;
import estruturaGrafo.Vertice;

public class AplicativoParte1 {

	private static Scanner scanner = new Scanner(System.in);
	
	private static final String ORIGEM = "origem";
	
	private static final String DESTINO = "destino";
	
	private static Grafo grafo;
	
	public static void main(String[] args) {
	
	do {
		int opcao = menu();
		
		switch(opcao) {
		case 1:
			cadastrarGrafo();
			break;
		case 2:
			grafo.imprimirGrafo();
			break;
		default:
			System.exit(0);
		}
	}while(true);
		
		
		
	}
	
	private static int validaQauntidadeVertices(int quantVertice) {
		while (quantVertice == 0) {
			System.out.println("Quantidade de vértices inválida!");
			System.out.println("Informe a quantidade de vértices:");
			quantVertice = scanner.nextInt();
		}
		return quantVertice;
	}
	
	private static int validaPesoAresta(int peso) {
		while (peso == 0) {
			System.out.println("Peso inválido!");
			System.out.println("Informe um peso diferente de zero:");
			peso = scanner.nextInt();
			limpaBuffer();
		}
		return peso;
	}
	
	private static void cadastrarGrafo() {
		System.out.println("Informe a quantidade de arestas:");
		int quantAresta = scanner.nextInt();
		System.out.println("Informe a quantidade de vértices:");
		int quantVertice = scanner.nextInt();
		quantVertice = validaQauntidadeVertices(quantVertice);
		
		criarGrafo(quantVertice, quantAresta);
	}
	
	private static int menu() {
		System.out.println("1. Cadastrar Grafo");
		System.out.println("2. Imprimir Grafo");
		System.out.println("Informar operação:");
		return scanner.nextInt();
	}
	
	
	
	private static void limpaBuffer() {
		scanner.nextLine();
	}
	
	private static Vertice obterExtremidadeAresta(String extremidade) {
		Vertice vertice = null;
		do {
			System.out.printf("Informe o vértice de %s da aresta: \n", extremidade);
			int legenda = scanner.nextInt();
			vertice = grafo.getVerticePorLegenda(legenda);
			limpaBuffer();
			if(vertice == null) {
				System.out.println("Vértice não encontrado!");
			}
				
		}while(vertice == null);
		return vertice;
	}
	
	
	private static List<Aresta> preencherArestas(int quantAresta) {
		int peso;
		Vertice origem;
		Vertice destino;
		List<Aresta> arestas = new ArrayList<Aresta>(quantAresta);
		for (int i = 1; i <= quantAresta; i++) {
			System.out.printf("Informe o peso da aresta %d:", i);
			peso = validaPesoAresta(scanner.nextInt());
			limpaBuffer();
			origem = obterExtremidadeAresta(ORIGEM);
			destino = obterExtremidadeAresta(DESTINO);
			arestas.add(new Aresta(peso, origem, destino));
		}
		return arestas;
	}
	
	private static void criarGrafo(int quantVertice, int quantAresta) {
		grafo = new Grafo(quantAresta, quantVertice);
		grafo.adicionarArestas(preencherArestas(quantAresta));
		
	}
	
	

}
