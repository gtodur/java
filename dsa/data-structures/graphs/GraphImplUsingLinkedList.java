package practice.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphImplUsingLinkedList {

	private LinkedList<Integer>[] adj;
	private int noOfVertices;
	private int noOfEdges;
	private int ccCount;
	private int[] componentId;
	
	public GraphImplUsingLinkedList(int nodes) {
		this.noOfVertices = nodes;
		this.noOfEdges = 0;
		this.adj = new LinkedList[nodes];
		for(int v = 0; v < noOfVertices; v++) {
			adj[v] = new LinkedList<>();
		}
	}
	
	/*
	 * add an edge between supplied two vertices
	 */
	public void addEdge(int u, int v) {
		this.adj[u].add(v);
		this.adj[v].add(u);
		noOfEdges++;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(noOfVertices + " vertices, " + noOfEdges + " edges" + "\n");
		
		for(int v=0; v<noOfVertices; v++) {
			sb.append(v + ": ");
			for(int w : adj[v]) {
				sb.append(w + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public void breadthFirstSearch(int s) {
		boolean[] visited = new boolean[noOfVertices];
		
		Queue<Integer> q = new LinkedList<>();
		visited[s] = true;
		q.offer(s);
		
		while(!q.isEmpty()) {
			int u = q.poll();
			System.out.print(u + " ");
			for(int v : adj[u]) {
				if(!visited[v]) {
					visited[v] = true;
					q.offer(v);
				}
			}
		}
	} 
	
	public void iterativeDepthFirstSearch(int s) {
		boolean[] visited = new boolean[noOfVertices];
		
		Stack<Integer> stack = new Stack<>();
		stack.push(s);
		
		while(!stack.isEmpty()) {
			int u = stack.pop();
				if(!visited[u]) {
					visited[u] = true;
					System.out.print(u + " ");
				}
				for(int v : adj[u]) {
					if(!visited[v]) {
						stack.push(v);
					}
				}
		}
	}
	
	public void recursiveDepthFirstSearch() {
		boolean[] visited = new boolean[noOfVertices];
		for(int v = 0; v < noOfVertices; v++) {
			if(!visited[v]) {
				recursiveDepthFirstSearch(v, visited);
			}
		}
	}
	
	public void recursiveDepthFirstSearch(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		for(int w : adj[v]) {
			if(!visited[w]) {
				recursiveDepthFirstSearch(w, visited);
			}
		}
	}
	
	public void connectedComponentsUsingRecursiveDFS() {
		boolean[] visited = new boolean[noOfVertices];
		this.componentId = new int[noOfVertices];
		this.ccCount = 0;
		
		for(int v = 0; v < noOfVertices; v++) {
			if(!visited[v]) {
				connectedComponentsUsingRecursiveDFS(v, visited, componentId, ccCount);
				this.ccCount++;
			}
		}
	}
	
	public void connectedComponentsUsingRecursiveDFS(int v, boolean[] visited, int[] componentId, int ccCount) {
		visited[v] = true;
		this.componentId[v] = ccCount;
		
		for(int w : adj[v]) {
			if(!visited[w]) {
				connectedComponentsUsingRecursiveDFS(w, visited, componentId, ccCount);
			}
		}
	}
	
	public int getConnectedComponentsInGraph() { return this.ccCount;}
	
	public boolean isConnected(int x, int y) { return this.componentId[x] == this.componentId[y]; }
}
