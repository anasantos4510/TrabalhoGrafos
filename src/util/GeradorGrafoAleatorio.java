package util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeradorGrafoAleatorio {

    public static void gerarGrafoDIMACS(int numVertices, int numArestas, String nomeArquivo) throws IOException {
        Random random = new Random();
        FileWriter writer = new FileWriter(nomeArquivo);

        writer.write(numVertices + " " + numArestas + "\n");

        for (int i = 0; i < numArestas; i++) {
            int origem = random.nextInt(numVertices) + 1;
            int destino = random.nextInt(numVertices) + 1;
            int peso = random.nextInt(100) + 1; // Peso entre 1 e 100
            writer.write(origem + " " + destino + " " + peso + "\n");
        }

        writer.close();
    }
}