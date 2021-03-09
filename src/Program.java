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

class Fila{
	List <Integer> fila;
	
	Fila(){
		fila = new ArrayList<>();
	}
	
	void addFila(int vertice) {
		fila.add(vertice);
	}
	
	int removeFila() {
		int aux = fila.get(0);		
		fila.remove(0);
		return aux;
	}
	
	void imprimeFila() {
		System.out.println("Fila: ");
		for(int i : fila) {
			System.out.println(i);
		}
	}
	
	boolean filaVazia() {
		return fila.isEmpty();
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
		Fila fila = new Fila();
		
		
		for(int j=0; j<m; j++) {
			int origem = sc.nextInt();
			int destino = sc.nextInt();
			int peso = sc.nextInt();
			
			g.addArestaOuArco(origem, destino, peso);
			addVerticeAdjacente(g.listaAdjacencias, origem-1, destino);
			if(b == 0) {
				g.addArestaOuArco(origem, destino, peso);
				addVerticeAdjacente(g.listaAdjacencias, destino-1, origem);
			}
			
		}
		
		//g.imprimeArestasOuArcos();
		System.out.println();
		
		imprimeAdjacencias(g.listaAdjacencias);
		
		buscaEmLargura(g, i, b);
		
		
		
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
	
	static void buscaEmLargura(Grafo grafo, int vertice, int b) {
		boolean[] verticesExplorados = new boolean[grafo.numVertices];
		boolean[][] arestasOuArcosExplorados = new boolean[grafo.numVertices][grafo.numVertices];
		List <Integer> ordemExploracao = new ArrayList<>();
		
		
		Fila fila = new Fila();
		
		verticesExplorados[vertice-1] = true; // marca o vertice inicial como explorado
		
		fila.addFila(vertice);
		ordemExploracao.add(vertice);
		
		//System.out.println("TAMANHO DA LISTA 1: " + grafo.listaAdjacencias.get(vertice-1).size());
		
		while (!fila.filaVazia()) {
			//System.out.println("VERTICE VISITADO: " + );
			vertice = fila.removeFila();
			for(int i=0; i < grafo.listaAdjacencias.get(vertice-1).size(); i++) {
				if(!verticesExplorados[grafo.listaAdjacencias.get(vertice-1).get(i)-1]) {
					arestasOuArcosExplorados[vertice-1][grafo.listaAdjacencias.get(vertice-1).get(i)-1] = true;
					if(b == 0)
						arestasOuArcosExplorados[grafo.listaAdjacencias.get(vertice-1).get(i)-1][vertice-1] = true;
					fila.addFila(grafo.listaAdjacencias.get(vertice-1).get(i));
					verticesExplorados[grafo.listaAdjacencias.get(vertice-1).get(i)-1] = true;
					
					ordemExploracao.add(grafo.listaAdjacencias.get(vertice-1).get(i));
				}
				else {
					if(!arestasOuArcosExplorados[vertice-1][grafo.listaAdjacencias.get(vertice-1).get(i)-1]) {
						arestasOuArcosExplorados[vertice-1][grafo.listaAdjacencias.get(vertice-1).get(i)-1] = true;
						if(b == 0)
							arestasOuArcosExplorados[grafo.listaAdjacencias.get(vertice-1).get(i)-1][vertice-1] = true;
					}
				}
			}
		}
		
		for(int i : ordemExploracao)
			System.out.print(i + " ");
		
	}

}