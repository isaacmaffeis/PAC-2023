import org.jgrapht.graph.*;
import org.jgrapht.*;
import  org.jgrapht.traverse.*;  //JGraphT provides traversal via package org.jgrapht.traverse. 
//The common interface is GraphIterator, which specializes the generic Java Iterator interface.
//https://jgrapht.org/guide/UserOverview#hello-jgrapht

import java.util.Iterator;


public class JGraphtExample1_bis {
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
		// stampo il grafo 
		System.out.println(grafo.toString()); 
		
		//Visita in profondita' con un iteratore
		Iterator<String> iterator = new DepthFirstIterator<>(grafo, "1");
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }
	}

}