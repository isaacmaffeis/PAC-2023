package exe6;

import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

class Result{
	
	private int maxAmici;
	private String persona;
	
	Result(int maxAmici, String persona){
		this.maxAmici = maxAmici;
		this.persona = persona;
	}
	
	public String toString() {
		return persona + ": " + maxAmici;
	}
}

public class Es2 {
	
	 /*
	 * Avete a disposizione il grafo delle amicizie di Facebook.
	 * Volete calcolare la persona che ha il maggior numero di
	 * “amici e amici di amici”, ovvero nodi a distanza 1 o 2 da esso.
	 * 
	 * Definire un algoritmo che ritorna questo valore e calcolare
	 * la complessità.
	 * 
	 * Implementare l’algoritmo usando JGraphT.
	 */
	
	static Result facebook(Graph<String, DefaultEdge > grafo) {
		
		int max = 0;
		String vertex = "";
		
		Set<String> vertici = grafo.vertexSet();
		for (String vertice : vertici) {
			int t = count(grafo, vertice);
			if(t > max) {
				max = t;
				vertex = vertice;
			}
		}
		
		Result result = new Result(max, vertex);
		
		return result;
		
	}
	
	static int count(Graph<String, DefaultEdge> grafo, String vertice) {
		
		Hashtable<String, Boolean> visited = new Hashtable<>();
		
		Set<String> vertici = grafo.vertexSet();
		for (String vertex : vertici) {
			visited.put(vertex, false);
		}
			
		List<String> successori = Graphs.successorListOf(grafo, vertice);

		visited.replace(vertice, true);
		
		int f = 0;
		for (String succ : successori) {
			if(!visited.get(succ)) {
				visited.replace(succ, true);
				f+=1;
			}
			List<String> succSuccessori = Graphs.successorListOf(grafo, succ);
			for (String succSucc : succSuccessori) {
				if(!visited.get(succSucc)) {
					visited.replace(succSucc, true);
					f+=1;
				}
			}
		}
		
		return f;
		
	}
	
	public static void main(String[] args) {
		
		DefaultUndirectedGraph<String, DefaultEdge> grafo = 
				new DefaultUndirectedGraph<String, DefaultEdge>(DefaultEdge.class);
		
		grafo.addVertex("amico1");
		grafo.addVertex("amico2");
		grafo.addVertex("amico3");
		grafo.addVertex("amico4");
		grafo.addVertex("amico5");
		grafo.addVertex("amico6");


		grafo.addEdge("amico1", "amico2");
		//grafo.addEdge("amico1", "amico3");
		//grafo.addEdge("amico1", "amico4");
		//grafo.addEdge("amico1", "amico5");


		//grafo.addEdge("amico2", "amico3");
		grafo.addEdge("amico2", "amico6");

		grafo.addEdge("amico3", "amico6");
		
		grafo.addEdge("amico4", "amico5");
		grafo.addEdge("amico4", "amico1");
		grafo.addEdge("amico4", "amico3");
		grafo.addEdge("amico4", "amico2");

		
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
		
		// ES 2 ------------------------------------------
		
		System.out.println("------------------------------------------");

		System.out.println("Es2:");
		
		System.out.println("Max amici e amici di amici --> " + facebook(grafo).toString());
		
	}

}
