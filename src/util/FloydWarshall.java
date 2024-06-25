package util;

import java.util.Arrays;

import estruturaGrafo.Aresta;
import estruturaGrafo.Grafo;
import estruturaGrafo.Vertice;

public class FloydWarshall {
    private int[][] dist;
    private int[][] next;
    private int numVertices;
    private Grafo grafo;

    public FloydWarshall(Grafo grafo) {
        this.grafo = grafo;
        this.numVertices = grafo.totalVertices();
        this.dist = new int[numVertices][numVertices];
        this.next = new int[numVertices][numVertices];
        inicializar();
    }

    private void inicializar() {
        for (int i = 0; i < numVertices; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            Arrays.fill(next[i], -1);
        }

        for (Vertice v : grafo.getVertices()) {
            dist[v.getLegenda() - 1][v.getLegenda() - 1] = 0;
        }

        for (Aresta aresta : grafo.getArestas()) {
            int origem = aresta.legendaVerticeOrigem() - 1;
            int destino = aresta.legendaVerticeDestino() - 1;
            dist[origem][destino] = aresta.getPeso();
            next[origem][destino] = destino;
        }
    }

    public void executar() {
        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }

    public void imprimirCaminho(int origem, int destino) {
        origem -= 1;
        destino -= 1;
        if (dist[origem][destino] == Integer.MAX_VALUE) {
            System.out.println("Não há caminho do vértice " + (origem + 1) + " ao vértice " + (destino + 1));
            return;
        }
        System.out.println("Caminho mínimo do vértice " + (origem + 1) + " ao vértice " + (destino + 1) + ":");
        System.out.print((origem + 1));
        int atual = origem;
        while (atual != destino) {
            atual = next[atual][destino];
            System.out.print(" -> " + (atual + 1));
        }
        System.out.println("\nDistância total: " + dist[origem][destino]);
    }

    public void imprimirTodasDistancias() {
        System.out.println("Matriz de distâncias mínimas:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (dist[i][j] == Integer.MAX_VALUE) {
                    System.out.print("∞ ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}