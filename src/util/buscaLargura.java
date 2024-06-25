package util;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import estruturaGrafo.Aresta;
import estruturaGrafo.Grafo;
import estruturaGrafo.Vertice;

public class BuscaLargura {
    
    private int[] L; // Índices de visitação
    private int[] nivel; // Nível de cada vértice
    private Integer[] pai; // Predecessores de cada vértice
    private Queue<Vertice> fila; // Fila para BFS
    private int t; // Contador de tempo

    // Construtor
    public BuscaLargura() {
        fila = new LinkedList<>();
        t = 0;
    }

    // Inicialização e chamada inicial do algoritmo
    public void inicializacao(Grafo grafo, int verticeInicial) {
        int numVertices = grafo.totalVertices();
        L = new int[numVertices];
        nivel = new int[numVertices];
        pai = new Integer[numVertices];
        t = 0;
        fila.clear();

        for (int v = 0; v < numVertices; v++) {
            L[v] = 0;       // Inicializar índice
            nivel[v] = 0;   // Inicializar nível
            pai[v] = null;  // Inicializar predecessor ou pai
        }

        Vertice vertice = grafo.getVertice(verticeInicial);
        t++;
        L[vertice.getLegenda() - 1] = t;
        fila.add(vertice); // Inserir a raiz na fila
        buscaLargura(grafo); // Executar busca para raiz v

        // Exibir os níveis e predecessores dos vértices
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vértice: " + (i + 1) + ", Nível: " + nivel[i] + ", Predecessor: " + pai[i]);
        }
    }

    // Algoritmo de Busca em Largura
    private void buscaLargura(Grafo grafo) {
        while (!fila.isEmpty()) {
            Vertice v = fila.poll(); // Remover 1º elemento da fila
            List<Vertice> adjacentes = grafo.getAdjacentes(v);
            adjacentes.sort((v1, v2) -> Integer.compare(v1.getLegenda(), v2.getLegenda())); // Ordenar adjacentes

            for (Vertice w : adjacentes) { // Para toda a vizinhança de v
                if (L[w.getLegenda() - 1] == 0) { // Se w é visitado pela 1ª vez
                    // Visitar aresta de árvore ou pai {v, w}
                    pai[w.getLegenda() - 1] = v.getLegenda();
                    nivel[w.getLegenda() - 1] = nivel[v.getLegenda() - 1] + 1;
                    t++;
                    L[w.getLegenda() - 1] = t;
                    fila.add(w);
                } else if (nivel[w.getLegenda() - 1] == nivel[v.getLegenda() - 1] + 1) {
                    // Visitar aresta tio {v, w}
                    System.out.println("Aresta tio {" + v.getLegenda() + ", " + w.getLegenda() + "}");
                } else if (nivel[w.getLegenda() - 1] == nivel[v.getLegenda() - 1] &&
                        pai[v.getLegenda() - 1] == pai[w.getLegenda() - 1] &&
                        L[w.getLegenda() - 1] > L[v.getLegenda() - 1]) {
                    // Visitar aresta irmão {v, w}
                    System.out.println("Aresta irmão {" + v.getLegenda() + ", " + w.getLegenda() + "}");
                } else if (nivel[w.getLegenda() - 1] == nivel[v.getLegenda() - 1] &&
                        pai[v.getLegenda() - 1] != pai[w.getLegenda() - 1] &&
                        L[w.getLegenda() - 1] > L[v.getLegenda() - 1]) {
                    // Visitar aresta primo {v, w}
                    System.out.println("Aresta primo {" + v.getLegenda() + ", " + w.getLegenda() + "}");
                }
            }
        }
    }
}
