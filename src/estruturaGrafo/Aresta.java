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
		return this.origem.getLegenda();
	}
	
	public int legendaVerticeDestino() {
		return this.destino.getLegenda();
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public int getPeso() {
		return this.peso;
	}
	
	public Vertice getVerticeDestino() {
		return this.destino;
	}

	public Vertice getVerticeOrigem() {
		return this.origem;
	}

	public void setOrigem(Vertice v) {
		this.origem = v;
	}

	public void setDestino(Vertice v) {
		this.destino = v;
	}

	public String toString() {
		return this.origem.getLegenda() + "," + this.destino.getLegenda();
	}
}
