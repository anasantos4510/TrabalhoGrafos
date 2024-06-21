package estruturaGrafo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Grafo {
	private ArrayList<Aresta> arestas;
	private ArrayList<Vertice> vertices;
	private int[][] matrizAdjacencia;
	private List<Vertice>[] listaAdjacencia;
	
	
	public Grafo(int quantAresta, int quantVertice) {
		arestas = new ArrayList<Aresta>(quantAresta);
		vertices = new ArrayList<Vertice>(quantVertice);
	}
	
	private Optional<Aresta> buscaArestaAdjacente(Vertice verticeOrigem, Vertice verticeDestino) {
		return arestas.stream().filter(aresta -> aresta.nomeVerticeOrigem().equals(verticeOrigem.getNome()) 
				&& aresta.nomeVerticeDestino().equals(verticeDestino.getNome())).findAny();
	}
	
	private List<Vertice> ordenaVerticesPorNome() {
		return vertices.stream().sorted((v1, v2) -> v1.getNome().compareTo(v2.getNome())).collect(Collectors.toList());
	}
	
	private void preencheMatrizAdjacencia () {
		Vertice verticeOrigem;
		Vertice verticeDestino;
		List<Vertice> verticesOrdenados = ordenaVerticesPorNome();
		int quantVertices = verticesOrdenados.size();
		matrizAdjacencia = new int[quantVertices][quantVertices];
		for (int i = 0; i < quantVertices; i++) {
			verticeOrigem = verticesOrdenados.get(i);
			for (int j = 0; j < quantVertices; j++) {
				verticeDestino = verticesOrdenados.get(j);
				Optional<Aresta> arestaAdjacencia = buscaArestaAdjacente(verticeOrigem, verticeDestino);
				matrizAdjacencia[i][j] = arestaAdjacencia.isPresent() ? arestaAdjacencia.get().getPeso() : 0;
			}
		}
	}
	
	public void adicionarVertices(List<Vertice> verticesLista) {
		this.vertices.addAll(verticesLista);
	}
	
	public void adicionarArestas(List<Aresta> arestasLista) {
		this.arestas.addAll(arestasLista);
		if (arestas.size() > 0) {
			if(isDenso()) {
				preencheMatrizAdjacencia();
			}
			else{
				preencherListaAdjacencia();
			}
		}
	}
	
	private void preencherListaAdjacencia() {
		List<Vertice> verticesOrdenados = ordenaVerticesPorNome();
		listaAdjacencia = new List[verticesOrdenados.size()]; 
		int index = 0;
		for (Vertice vertice : verticesOrdenados) {
			List<Aresta> arestasIncidentes = arestas.stream().filter(aresta -> aresta.nomeVerticeOrigem().equals(vertice.getNome())).collect(Collectors.toList());
			
				listaAdjacencia[index] = arestasIncidentes.stream().map(Aresta::getVerticeDestino).toList();
			
			index++;
		}
	}
	
	public Vertice getVerticePorLegenda(String legenda) {
		return vertices.stream().filter(vertice -> vertice.getNome().equals(legenda)).findFirst().orElse(null);
	}
	
	private double getDensidade() {
		BigDecimal quantAresta = BigDecimal.valueOf(arestas.size());
		BigDecimal quantVertice = BigDecimal.valueOf(vertices.size());
		
		BigDecimal denominador = quantVertice.multiply(quantVertice.subtract(BigDecimal.ONE));
		return quantAresta.divide(denominador, 3, RoundingMode.HALF_UP).doubleValue();
	}
	
	public boolean isDenso() {
		double densidade = getDensidade();
		return Math.abs(1 - densidade) < Math.abs(densidade) ? true : false;
	}
	
	private void imprimirMatriz() {
		List<Vertice> verticesOrdenados = ordenaVerticesPorNome();
		System.out.printf("  ");
		verticesOrdenados.forEach(vertice -> System.out.printf("%s\t", vertice.getNome()));
		System.out.printf("\n");
		for (int i = 0; i < matrizAdjacencia.length; i++) {
			System.out.printf("%s ", verticesOrdenados.get(i).getNome());
			for (int j = 0; j < matrizAdjacencia.length; j++) {
				System.out.printf("%d\t", matrizAdjacencia[i][j]);
			}
			System.out.printf("\n");
		}
	}
	
	private void imprimirListaAdjacencia() {
		
		List<Vertice> verticesOrdenados = ordenaVerticesPorNome();
		for(int i = 0; i < listaAdjacencia.length; i++)
		{
			System.out.printf("%s\t", verticesOrdenados.get(i).getNome());
			listaAdjacencia[i].forEach(vertice -> System.out.printf("%s\t", vertice.getNome()));
			System.out.printf("\n");
		}
	}
	
	public void imprimirGrafo() {
		if(isDenso()) {
			imprimirMatriz();
		}
		else {
			imprimirListaAdjacencia();
		}
	}
}
