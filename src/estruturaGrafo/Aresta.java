package estruturaGrafo;

public class Aresta {
	private int peso;
	private Vertice origem;
	private Vertice destino;
	
	public Aresta (int peso, Vertice origem, Vertice destino)
	{
		this.peso = peso;
		this.origem = origem;
		this.destino = destino;
	}
	
	public int legendaVerticeOrigem() {
		return origem.getLegenda();
	}
	
	public int legendaVerticeDestino() {
		return destino.getLegenda();
	}
	
	public int getPeso() {
		return peso;
	}
	
	public Vertice getVerticeDestino () {
		return destino;
	}
}
