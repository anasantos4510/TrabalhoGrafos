package util;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

import estruturaGrafo.Aresta;
import estruturaGrafo.Grafo;
import estruturaGrafo.Vertice;

public class Dijkstra {
    private int[] dist; // Distâncias mínimas
    private int[] pred; // Predecessores
    private Set<Vertice> explorados; // Conjunto de vértices explorados
    private PriorityQueue<Vertice> queue; // Fila de prioridade para seleção do próximo vértice
    private Grafo grafo;

    public Dijkstra(Grafo grafo) {
        this.grafo = grafo;
    }

    public void inicializacao(int origem, int destino) {
        int numVertices = grafo.totalVertices();
        dist = new int[numVertices];
        pred = new int[numVertices];
        explorados = new HashSet<>();
        queue = new PriorityQueue<>(numVertices, Comparator.comparingInt(v -> dist[v.getLegenda() - 1]));

        for (int i = 0; i < numVertices; i++) {
            dist[i] = Integer.MAX_VALUE; // Inicializa as distâncias com infinito
            pred[i] = 0;             // Inicializa os predecessores com null
        }

        dist[origem - 1] = 0; // Distância do vértice de origem para ele mesmo é zero
        queue.add(grafo.getVertice(origem));

        while (!queue.isEmpty()) {
            Vertice u = queue.poll();
            explorados.add(u);

            for (Aresta aresta : u.getArestas()) {
                Vertice v = aresta.getVerticeDestino();
                if (!explorados.contains(v)) {
                    int novaDistancia = dist[u.getLegenda() - 1] + aresta.getPeso();
                    if (novaDistancia < dist[v.getLegenda() - 1]) {
                        dist[v.getLegenda() - 1] = novaDistancia;
                        pred[v.getLegenda() - 1] = u.getLegenda();
                        queue.add(v);
                    }
                }
            }
        }

        imprimirCaminho(origem, destino);
    }

    private void imprimirCaminho(int origem, int destino) {
        LinkedList<Integer> caminho = new LinkedList<>();
        int atual = destino;

        while (atual != 0) {
            caminho.addFirst(atual);
            atual = pred[atual - 1];
        }

        System.out.println("Caminho mínimo do vértice " + origem + " ao vértice " + destino + ":");
        for (int i = 0; i < caminho.size() - 1; i++) {
            int de = caminho.get(i);
            int para = caminho.get(i + 1);
            Aresta aresta = grafo.buscaArestaAdjacente(grafo.getVertice(de), grafo.getVertice(para)).orElse(null);
            if (aresta != null) {
                System.out.println("Vértice " + de + " -> Vértice " + para + " com peso " + aresta.getPeso());
            }
        }
    }
}