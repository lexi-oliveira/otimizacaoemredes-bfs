import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Grafo{
	int numVertices;
	int numArestas;
	ArrayList <Integer> listaAdjacencias[];
	
	/*Grafo(int numVertices, int numArestas){ //construtor para iniciar a lista de adjacencia
		this.numVertices = numVertices;
		this.numArestas = numArestas;
		
		listaAdjacencias[numVertices] = new ArrayList<>(numVertices);
		for(int i = 0; i <= numVertices; i++) {
			listaAdjacencias[i] = new ArrayList<>();
		}
	}*/
	
	int soma() {
		return numArestas+numVertices;
	}
}


public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Grafo a = new Grafo();
		
		System.out.print("Digite o numero de arestas: ");
		a.numArestas = sc.nextInt();
		System.out.println("Digite o numero de vertices: ");
		a.numVertices = sc.nextInt();
				
		System.out.print("Numero de vertices: " + a.numVertices + "\nNumero de arestas: " + a.numArestas + "\n");
		System.out.println("Soma: " + a.soma());
		
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
	
	static void addVerticeAdjacente(ArrayList <List<Integer>> listaAdjacencias, int vertice , int novoVerticeAdjacente) {
		
		if (listaAdjacencias.get(vertice).isEmpty())
			listaAdjacencias.get(vertice).add(novoVerticeAdjacente);
		
		else {
			for(int i = 0; i < listaAdjacencias.get(vertice).size(); i++) {
				if(novoVerticeAdjacente < listaAdjacencias.get(vertice).get(i)) { //verifica se eh menor que um elemento presente na posicao i da lista
					listaAdjacencias.get(vertice).add(i, novoVerticeAdjacente);
					i = listaAdjacencias.get(vertice).size();
				}
				else if (i+1 == listaAdjacencias.get(vertice).size()){ //verifica se eh o ultimo elemento da lista, se for adiciona o elemento na ultima posicao
					listaAdjacencias.get(vertice).add(novoVerticeAdjacente);
					return;
				}
			}
		}
	}

}


