package estruturaGrafo;

public class Aresta {
	private int peso;
	private Vertice origem;
	private Vertice destino;
	private String nome;
	
	public Aresta (int peso, Vertice origem, Vertice destino)
	{
		this.peso = peso;
		this.origem = origem;
		this.destino = destino;
		this.nome = origem + "," + destino;
	}
	
	public int legendaVerticeOrigem() {
		return origem.getLegenda();
	}
	
	public int legendaVerticeDestino() {
		return destino.getLegenda();
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public int getPeso() {
		return peso;
	}
	
	public Vertice getVerticeDestino() {
		return this.destino;
	}

	public Vertice getVerticeOrigem() {
		return this.origem;
	}

	public String toString() {
		return this.nome;
	}
}
