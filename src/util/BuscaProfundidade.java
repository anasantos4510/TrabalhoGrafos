package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import estruturaGrafo.Aresta;
import estruturaGrafo.Grafo;
import estruturaGrafo.Vertice;

public class BuscaProfundidade {
    private int tempo;
    private int[] tempoDescoberta;
    private int[] tempoTermino;
    private Integer[] pai;
    private Grafo grafo;

    public BuscaProfundidade(Grafo grafo) {
        this.grafo = grafo;
        int numVertices = grafo.totalVertices();
        this.tempoDescoberta = new int[numVertices];
        this.tempoTermino = new int[numVertices];
        this.pai = new Integer[numVertices];
        Arrays.fill(tempoDescoberta, 0);
        Arrays.fill(tempoTermino, 0);
        Arrays.fill(pai, null);
    }

    public void inicializacao(int verticeInicial) {
        tempo = 0;
        Vertice vertice = grafo.getVertice(verticeInicial);
        if (vertice != null) {
            buscaProfundidade(vertice);
        }
        imprimirResultados();
    }

    private void buscaProfundidade(Vertice v) {
        tempo++;
        tempoDescoberta[v.getLegenda() - 1] = tempo;
        List<Vertice> vizinhos = new ArrayList<>();
        for (Aresta aresta : v.getArestas()) {
            vizinhos.add(aresta.getVerticeDestino());
        }
        vizinhos.sort(Comparator.comparingInt(Vertice::getLegenda)); // Ordena os vizinhos em ordem crescente

        for (Vertice w : vizinhos) {
            if (tempoDescoberta[w.getLegenda() - 1] == 0) {
                pai[w.getLegenda() - 1] = v.getLegenda();
                buscaProfundidade(w);
            } else if (tempoTermino[w.getLegenda() - 1] == 0 && !Objects.equals(pai[v.getLegenda() - 1], w.getLegenda())) {
                // Visitando aresta de retorno
            }
        }
        tempo++;
        tempoTermino[v.getLegenda() - 1] = tempo;
    }

    private void imprimirResultados() {
        System.out.println("Resultados da Busca em Profundidade:");
        for (int i = 0; i < grafo.totalVertices(); i++) {
            System.out.println("Vértice: " + (i + 1) + ", Descoberta: " + tempoDescoberta[i] + ", Término: " + tempoTermino[i] + ", Pai: " + (pai[i] != null ? pai[i] : "N/A"));
        }
    }
}
