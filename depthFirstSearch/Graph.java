package depthFirstSearch;

import java.io.*;
import java.util.*;

//Depth First Traversal (or Search) for a graph is similar to Depth First Traversal of a tree. 
//The only catch here is, unlike trees, graphs may contain cycles, so we may come to the same node again.
//To avoid processing a node more than once, we use a boolean visited array.
//For example, in the following graph, we start traversal from vertex 2. 
//When we come to vertex 0, we look for all adjacent vertices of it. 
//2 is also an adjacent vertex of 0. 
//If we don�t mark visited vertices, then 2 will be processed again and it will become a non-terminating process. 
//A Depth First Traversal of the following graph is 2, 0, 1, 3.

//This class represents a directed graph using adjacency list 
//representation 
public class Graph {

	private int V; // No. of vertices

	// Array of lists for Adjacency List Representation
	private LinkedList<Integer> adj[];

	public Graph(int v) {

		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	public void addEdge(int v, int w) {

		adj[v].add(w); // Add w to v's list.

	}

	// A function used by DFS
	public void DFSUtil(int v, boolean visited[]) {

		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				DFSUtil(n, visited);
		}
	}

	// The function to do DFS traversal. It uses recursive DFSUtil()
	public void DFS(int v) {

		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean visited[] = new boolean[V];

		// Call the recursive helper function to print DFS traversal
		DFSUtil(v, visited);
	}
}
