package estruturaGrafo;

import java.util.ArrayList;

public class Vertice {
	//private ArrayList<Aresta> incidentes = new ArrayList<Aresta>();
	String nome;
	
	public Vertice(String nome) {
		this.nome = nome;
	}
	
	public Vertice(char nome) {
		this.nome = Character.toString(nome);
	}
	
	public String getNome() {
		return nome;
	}
}
