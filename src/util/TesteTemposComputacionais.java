package util;

import estruturaGrafo.Grafo;
import parte2.GeradorGrafoPorArquivo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TesteTemposComputacionais {

    public static void main(String[] args) throws IOException {
        int[] tamanhos = {100, 1000, 10000, 100000};
        String[] arquivos = {"arquivos/output/grafos/grafo_100.txt", "arquivos/output/grafos/grafo_1000.txt", "arquivos/output/grafos/grafo_10000.txt", "arquivos/output/grafos/grafo_100000.txt"};
        int[] arestas = {200, 2000, 20000, 200000}; // Assume densidade média

        FileWriter writer = new FileWriter("arquivos/output/tempos_computacionais.txt");

        for (int i = 0; i < tamanhos.length; i++) {
            GeradorGrafoAleatorio.gerarGrafoDIMACS(tamanhos[i], arestas[i], arquivos[i]);
            Grafo grafo = GeradorGrafoPorArquivo.gerarGrafo(arquivos[i]);

            long inicio = System.nanoTime();
            grafo.isEuleriano();
            long fim = System.nanoTime();
            long duracao = TimeUnit.NANOSECONDS.toMillis(fim - inicio);
            writer.write("Verificação Euleriana para " + tamanhos[i] + " vértices: " + duracao + " ms\n");

            inicio = System.nanoTime();
            grafo.encontrarPontes();
            fim = System.nanoTime();
            duracao = TimeUnit.NANOSECONDS.toMillis(fim - inicio);
            writer.write("Busca por Pontes para " + tamanhos[i] + " vértices: " + duracao + " ms\n");
        }

        writer.close();
    }
}
