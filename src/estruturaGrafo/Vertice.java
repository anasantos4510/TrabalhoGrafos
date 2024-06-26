package estruturaGrafo;

import java.util.ArrayList;

public class Vertice {
	private ArrayList<Aresta> arestas = new ArrayList<Aresta>();
	int legenda;
	
	public Vertice(int nome) {
		this.legenda = nome;
	}

	public void addAresta(Aresta arestas) {
		this.arestas.add(arestas);
	}

	public ArrayList<Aresta> getArestas()
	{
		return this.arestas;
	}
	
	public void exibeArestas() {
		arestas.forEach(aresta -> System.out.println(aresta.toString()));
	}

	public int getLegenda() {
		return legenda;
	}

	public int getGrau()
	{
		return this.arestas.size();
	}

	public String toString() {
		return this.legenda + "";
	}
}
