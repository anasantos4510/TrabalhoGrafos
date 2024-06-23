package parte2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import estruturaGrafo.Aresta;
import estruturaGrafo.Grafo;
import estruturaGrafo.Vertice;

public class GeradorGrafoPorArquivo {
	private static int POSICAO_VERTICE = 0;
	
	private static int POSICAO_ARESTA = 1;
	
	private static int POSICAO_ORIGEM = 0;
	
	private static int POSICAO_DESTINO = 1;
	
	private static int POSICAO_PESO = 2;
	
	public static Grafo gerarGrafo (String filePath) {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			
            String linha;
            Grafo grafo = instanciarGrafo(br.readLine());
            
            List<Aresta> arestas = new ArrayList<>(grafo.totalArestas());
            List<Integer> dadosArestas = null;

            Vertice origem, destino;
			
            while ((linha = br.readLine()) != null) {
            	dadosArestas = converterLinhaParaInt(valoresPorLinha(linha));
            	origem = grafo.getVerticePorLegenda(dadosArestas.get(POSICAO_ORIGEM));
            	destino = grafo.getVerticePorLegenda(dadosArestas.get(POSICAO_DESTINO));

				Aresta aresta = new Aresta(dadosArestas.get(POSICAO_PESO), origem, destino);
				
				origem.addAresta(aresta);
				destino.addAresta(aresta);
            	arestas.add(aresta);
            }
            grafo.adicionarArestas(arestas);

            return grafo;
        } catch (IOException e) {
            e.printStackTrace();
        }

		return null;
	}
	
	private static Grafo instanciarGrafo(String linha) {
		List<Integer> dimensoesGrafo = converterLinhaParaInt(valoresPorLinha(linha));
		return new Grafo(dimensoesGrafo.get(POSICAO_ARESTA), dimensoesGrafo.get(POSICAO_VERTICE));
	}
	
	private static List<Integer> converterLinhaParaInt(List<String> linha) {
		List<Integer> listaInt = new ArrayList<>(linha.size());
		try {
			for (String valor : linha) {
				listaInt.add(Integer.parseInt(valor));
			}
		} catch (NumberFormatException e) {
			System.err.println("Erro ao converter string para inteiro: " + e.getMessage());
		}
		return listaInt;
	}
	
	private static List<String> valoresPorLinha(String linha) {
		return Arrays.asList(linha.split("\\s+"));
	}
}
