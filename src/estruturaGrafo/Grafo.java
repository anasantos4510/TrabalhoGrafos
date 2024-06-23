package estruturaGrafo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import util.Util;

public class Grafo {
	private ArrayList<Aresta> arestas;
	private ArrayList<Vertice> vertices;
	private int[][] matrizAdjacencia;
	private List<Vertice>[] listaAdjacencia;
	private int totalArestas, totalVertices;
	
	
	public Grafo(int quantAresta, int quantVertice) {
		totalArestas = quantAresta;
		totalVertices = quantVertice;
		arestas = new ArrayList<Aresta>(quantAresta);
		vertices = new ArrayList<Vertice>(quantVertice);
		preencherVertices(quantVertice);
	}
	
	public int totalArestas() {
		return totalArestas;
	}
	
	public int totalVertices() {
		return totalVertices;
	}
	
	private Optional<Aresta> buscaArestaAdjacente(Vertice verticeOrigem, Vertice verticeDestino) {
		return arestas.stream().filter(aresta -> aresta.legendaVerticeOrigem() == verticeOrigem.getLegenda() 
				&& aresta.legendaVerticeDestino() == verticeDestino.getLegenda()).findAny();
	}
	
	private List<Vertice> ordenaVerticesPorLegenda() {
		return vertices.stream().sorted(Comparator.comparingInt(Vertice::getLegenda)).collect(Collectors.toList());
	}
	
	private void preencheMatrizAdjacencia () {
		Vertice verticeOrigem;
		Vertice verticeDestino;
		List<Vertice> verticesOrdenados = ordenaVerticesPorLegenda();
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
		List<Vertice> verticesOrdenados = ordenaVerticesPorLegenda();
		listaAdjacencia = new List[verticesOrdenados.size()]; 
		int index = 0;
		for (Vertice vertice : verticesOrdenados) {
			List<Aresta> arestasIncidentes = arestas.stream().filter(aresta -> aresta.legendaVerticeOrigem() == vertice.getLegenda()).collect(Collectors.toList());
			
				listaAdjacencia[index] = arestasIncidentes.stream().map(Aresta::getVerticeDestino).toList();
			
			index++;
		}
	}
	
	public Vertice getVerticePorLegenda(int legenda) {
		return vertices.stream().filter(vertice -> vertice.getLegenda() == legenda).findFirst().orElse(null);
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
		List<Vertice> verticesOrdenados = ordenaVerticesPorLegenda();
		System.out.printf("  ");
		verticesOrdenados.forEach(vertice -> System.out.printf("%s\t", vertice.getLegenda()));
		System.out.printf("\n");
		for (int i = 0; i < matrizAdjacencia.length; i++) {
			System.out.printf("%s ", verticesOrdenados.get(i).getLegenda());
			for (int j = 0; j < matrizAdjacencia.length; j++) {
				System.out.printf("%d\t", matrizAdjacencia[i][j]);
			}
			System.out.printf("\n");
		}
		
		Util.paraFluxo("voltar...");
	}
	
	private void imprimirListaAdjacencia() {
		System.out.println("**** Lista Adjacencia ****");
		List<Vertice> verticesOrdenados = ordenaVerticesPorLegenda();
		for(int i = 0; i < listaAdjacencia.length; i++)
		{
			System.out.printf("V%s\t", verticesOrdenados.get(i).getLegenda());
			listaAdjacencia[i].forEach(vertice -> System.out.printf("%s\t", vertice.getLegenda()));
			System.out.printf("\n");
		}

		Util.paraFluxo("voltar...");
	}
	
	public void imprimirGrafo() {
		if(isDenso()) {
			imprimirMatriz();
		}
		else {
			imprimirListaAdjacencia();
		}
	}
	
	private void preencherVertices(int quantVertice) {
		for (int i = 1; i <= quantVertice; i++) {
			vertices.add(new Vertice(i));
		}
	}
	
	public static char gerarLegendaVertice(int posicao) {
        return (char) ('A' + posicao - 1);
    }

	public Aresta getAresta(String a) {
		return arestas.stream()
						.filter(a1 -> a1.toString().equals(a))
						.findFirst()
						.get();
	}
	

	public Vertice getVerticeOrigem(int a) {
	    Aresta aresta = arestas.stream()
						.filter(a1 -> a1.legendaVerticeOrigem() == a)
						.findFirst()
						.get();

		return aresta.getVerticeOrigem();
	}

	public Vertice getVerticeDestino(int a) {
		Aresta aresta = arestas.stream()
						.filter(a1 -> a1.legendaVerticeDestino() == a)
						.findFirst()
						.get();

		return aresta.getVerticeDestino();
	}
}
