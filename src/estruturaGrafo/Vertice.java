package estruturaGrafo;

import java.util.ArrayList;

public class Vertice {
	//private ArrayList<Aresta> incidentes = new ArrayList<Aresta>();
	int legenda;
	
	public Vertice(int nome) {
		this.legenda = nome;
	}
	
	public int getLegenda() {
		return legenda;
	}
}
