package exe6;

import java.util.List;
import java.util.Set;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

public class Es1 {
	
	/*
	 * Creare un grafo non orientato con JGraphT per rappresentare 
	 * le amicizie come in fb. I nodi sono i nickname (di tipo String) 
	 * delle persone.
	 * 
	 * Esplorare l’interfaccia Graph o anche la classe statica Graphs 
	 * per stampare a video gli “amici diretti” di nodi dati 
	 * (la lista di adiacenza)
	 */
	
	public static void main(String[] args) {
		
		DefaultUndirectedGraph<String, DefaultEdge> grafo = 
				new DefaultUndirectedGraph<String, DefaultEdge>(DefaultEdge.class);
		
		grafo.addVertex("amico1");
		grafo.addVertex("amico2");
		grafo.addVertex("amico3");
		grafo.addVertex("amico4");
		grafo.addVertex("amico5");

		grafo.addEdge("amico1", "amico2");
		grafo.addEdge("amico1", "amico3");
		grafo.addEdge("amico1", "amico4");

		grafo.addEdge("amico2", "amico3");
		grafo.addEdge("amico2", "amico5");

		grafo.addEdge("amico3", "amico4");
		
		grafo.addEdge("amico4", "amico5");
		
		System.out.println(grafo.toString()); 

		Set<String> vertici = grafo.vertexSet();
		for (String vertice : vertici) {
			System.out.print( vertice +": ");
			List<String> successori = Graphs.successorListOf(grafo, vertice);
			for (String nodo : successori) {
				System.out.print( nodo +", ");
			}
			System.out.println();
		}
		
	}

}
