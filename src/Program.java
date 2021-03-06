import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ArestaOuArco{
	int verticeOrigem;
	int verticeDestino;
	int peso;
	
	ArestaOuArco(int verticeOrigem, int verticeDestino, int peso){
		this.verticeOrigem = verticeOrigem;
		this.verticeDestino = verticeDestino;
		this.peso = peso;
	}
	
	void imprimeArestaOuArco(){
		System.out.println("Origem: " + verticeOrigem + ", Destino: " + verticeDestino + ", Peso: " + peso);
	}
}

class Grafo{
	int numVertices;
	int numArestas;
	ArrayList <List<Integer>> listaAdjacencias;
	List<ArestaOuArco> arestasOuArcos;
	
	Grafo(int numVertices, int numArestas){ //construtor para iniciar a lista de adjacencia
		this.numVertices = numVertices;
		this.numArestas = numArestas;
		arestasOuArcos = new ArrayList<>();
		
		listaAdjacencias = new ArrayList<>();
		for(int i = 0; i < numVertices; i++) {
			listaAdjacencias.add(new ArrayList<>());
		}
	}
	
	void addArestaOuArco(int origem, int destino, int peso) {
		arestasOuArcos.add(new ArestaOuArco(origem, destino, peso));
	}
	
	void imprimeArestasOuArcos() {
		for(ArestaOuArco a : arestasOuArcos) {
			a.imprimeArestaOuArco();
		}
	}
}


public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n; // representa a quantidade de vertices do grafo
		int m; // representa a quantidade de arestas ou arcos do grafo
		int b; // indica se o grafo eh direcionado 1 - sim, 0 - nao
		int i; // indice do vertice a partir do qual sera realizada a busca
		
		n = sc.nextInt();
		m = sc.nextInt();
		b = sc.nextInt();
		i = sc.nextInt();
		
		Grafo g = new Grafo(n, m);
		
		for(int j=0; j<m; j++) {
			int origem = sc.nextInt();
			int destino = sc.nextInt();
			int peso = sc.nextInt();
			
			g.addArestaOuArco(origem, destino, peso);
			
		}
		
		g.imprimeArestasOuArcos();
		
		
		sc.close();
	}
	
	static void addVerticeAdjacente(ArrayList <List<Integer>> listaAdjacencias, int vertice , int novoVerticeAdjacente) { //adiciona um novo vertice adjacente de forma que a lista ja fique ordenada
		
		if (listaAdjacencias.get(vertice).isEmpty())
			listaAdjacencias.get(vertice).add(novoVerticeAdjacente);
		
		else {
			for(int i = 0; i < listaAdjacencias.get(vertice).size(); i++) {
				if(novoVerticeAdjacente < listaAdjacencias.get(vertice).get(i)) { //verifica se eh menor que um elemento presente na posicao i da lista
					listaAdjacencias.get(vertice).add(i, novoVerticeAdjacente);
					return;
				}
				else if (i+1 == listaAdjacencias.get(vertice).size()){ //verifica se eh o ultimo elemento da lista, se for adiciona o elemento na ultima posicao
					listaAdjacencias.get(vertice).add(novoVerticeAdjacente);
					return;
				}
			}
		}
	}
	
	static void imprimeAdjacencias(ArrayList <List<Integer>> listaAdjacencias) {
		int v = 1;
		for(List<Integer> l: listaAdjacencias) {
			System.out.print("Vertice " + v + ": ");
			for(int i=0; i<l.size(); i++) {
				System.out.print("->" + l.get(i) + " ");
			}
			v++;
			System.out.println();
		}
	}

}



/*
public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Grafo a = new Grafo();
		
		System.out.print("Digite o numero de arestas: ");
		a.numArestas = sc.nextInt();
		System.out.println("Digite o numero de vertices: ");
		a.numVertices = sc.nextInt();
		
		ArrayList <List<Integer>> listaAdjacencias = new ArrayList<>();
		listaAdjacencias.add(new ArrayList<>());
		
		addVerticeAdjacente(listaAdjacencias, 0, 3);
		addVerticeAdjacente(listaAdjacencias, 0, 1);
		addVerticeAdjacente(listaAdjacencias, 0, 2);
		addVerticeAdjacente(listaAdjacencias, 0, 7);
		addVerticeAdjacente(listaAdjacencias, 0, 9);
		
		//listaAdjacencias.get(0).add(3);
		//listaAdjacencias.get(0).add(1);
		//listaAdjacencias.get(0).add(2);
		//listaAdjacencias.get(0).add(7);
		//listaAdjacencias.get(0).add(0, 4); //adiciona um novo elemento na posicao estabelecida
		
		
		listaAdjacencias.add(new ArrayList<>());
		//listaAdjacencias.get(1).add(9);
		//listaAdjacencias.get(1).add(2);
		//listaAdjacencias.get(1).add(6);
		//listaAdjacencias.get(1).add(5);
		addVerticeAdjacente(listaAdjacencias, 1, 9);
		addVerticeAdjacente(listaAdjacencias, 1, 2);
		addVerticeAdjacente(listaAdjacencias, 1, 6);
		addVerticeAdjacente(listaAdjacencias, 1, 5);
		addVerticeAdjacente(listaAdjacencias, 1, 10);
		
		
		listaAdjacencias.add(new ArrayList<>());
		int r = 1;
		for(List<Integer> l: listaAdjacencias) {
			for(int i=0; i<l.size(); i++) {
				System.out.println("Lista " + r + ": " + l.get(i));
			}
			r++;
		}
		
		
		sc.close();
	}
*/


