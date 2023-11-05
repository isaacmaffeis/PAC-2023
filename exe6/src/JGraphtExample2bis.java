import org.jgrapht.graph.*;
import org.jgrapht.*;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm.SingleSourcePaths;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
//https://jgrapht.org/guide/UserOverview#hello-jgrapht

public class JGraphtExample2bis {
	public static void main(String[] args) { 
		//Creo un grafo orientato
        Graph<String, DefaultWeightedEdge> grafo =
            new DefaultDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
        
		// creo i vertici 
		grafo.addVertex("1"); 
		grafo.addVertex("2"); 
		grafo.addVertex("3"); 
		grafo.addVertex("4"); 
		grafo.addVertex("5"); 
		grafo.addVertex("6"); 
		grafo.addVertex("7"); 
		// connetto i vertici con gli archi 
		DefaultWeightedEdge arco = grafo.addEdge("1", "2"); 
		//grafo.setEdgeWeight(arco, -4.0);//java.lang.IllegalArgumentException: Negative edge weight not allowed
		grafo.setEdgeWeight(arco, 4.0);
		arco = grafo.addEdge("2", "5"); 
		grafo.setEdgeWeight(arco, 3.4);
		arco = grafo.addEdge("5", "1"); 
		grafo.setEdgeWeight(arco, 1);
		arco = grafo.addEdge("5", "4");
		grafo.setEdgeWeight(arco, 23.0);
		arco = grafo.addEdge("4", "3"); 
		grafo.setEdgeWeight(arco, 1);
		arco = grafo.addEdge("4", "6"); 
		grafo.setEdgeWeight(arco, 1);
		arco = grafo.addEdge("6", "4"); 
		grafo.setEdgeWeight(arco, 12);
		arco = grafo.addEdge("3", "6"); 
		grafo.setEdgeWeight(arco, 5);
		grafo.setEdgeWeight(grafo.addEdge("7", "3"),1); //In forma compatta! 
		// stampo il grafo 
		System.out.println(grafo.toString()); 
		    
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraAlg =
            new DijkstraShortestPath<>(grafo);
        
        System.out.println("\nShortest path from 1 to 3:");
        //Computa tutti i cammini minimi da un certo nodo sorgente.
        SingleSourcePaths<String, DefaultWeightedEdge> iPaths = dijkstraAlg.getPaths("1");
        //Ottiene un cammino minimo da un nodo sorgente ad un nodo destinatario
        System.out.println(iPaths.getPath("3"));
        //Stampa il peso del cammino minimo (un double)
        System.out.println(iPaths.getWeight("3") + "\n");

        // This path does NOT exist for our particular directed graph. Hence the path is
        // empty and the result must be null.
        System.out.println("Shortest path from 1 to 7:");
        SingleSourcePaths<String, DefaultWeightedEdge> cPaths = dijkstraAlg.getPaths("1");
        System.out.println(cPaths.getPath("7"));
        System.out.println(iPaths.getWeight("7") + "\n"); //Double.POSITIVE_INFINITY

	}

}