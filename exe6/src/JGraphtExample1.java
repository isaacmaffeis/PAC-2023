//Consultare le API alla pagina web:
//https://jgrapht.org/guide/UserOverview
//https://github.com/jgrapht/jgrapht/wiki/Users:-How-to-use-JGraphT-as-a-dependency-in-your-projects
//In Eclipse importare (come "external jar file") il file .jar da "lib" in classpath!

import org.jgrapht.graph.*;
import org.jgrapht.*;
import java.util.List; 
import java.util.Set;

public class JGraphtExample1 {
	public static void main(String[] args) { 
		//Creo un grafo orientato
        Graph<String, DefaultEdge> grafo =
            new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
        
		// creo i vertici 
		grafo.addVertex("1"); 
		grafo.addVertex("2"); 
		grafo.addVertex("3"); 
		grafo.addVertex("4"); 
		grafo.addVertex("5"); 
		grafo.addVertex("6"); 
		grafo.addVertex("7"); 
		// connetto i vertici con gli archi 
		grafo.addEdge("1", "2"); 
		grafo.addEdge("2", "5"); 
		grafo.addEdge("5", "1"); 
		grafo.addEdge("5", "4"); 
		grafo.addEdge("4", "3"); 
		grafo.addEdge("4", "6"); 
		grafo.addEdge("6", "4"); 
		grafo.addEdge("3", "6"); 
		grafo.addEdge("7", "3"); 
		//Stampo il grafo 
		System.out.println(grafo.toString()); 
		
		//Visita sistematica delle liste di adiacenza.
		//Per ogni nodo scorro tutti i suoi archi uscenti e li stampo 
		//Restituisce l'insieme di vertici presenti nel grafo 
		Set<String> vertici = grafo.vertexSet(); 
		for (String s : vertici) { 
			System.out.print(s + ":"); 
			List<String> succ = Graphs.successorListOf(grafo, s); 
			for (String l : succ) { 
				System.out.print(" " + l); } 
			System.out.println(""); } } 
	}

