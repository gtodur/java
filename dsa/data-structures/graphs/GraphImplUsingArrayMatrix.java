package practice.graphs;

public class GraphImplUsingArrayMatrix {

	private int noOfVertices;
	private int noOfEdges;
	private int[][] adjmatrix;
	
	public GraphImplUsingArrayMatrix(int nodes) {
		this.noOfVertices = nodes;
		this.noOfEdges = 0;
		this.adjmatrix = new int[nodes][nodes];
	}
	
	/*
	 * adds an edge between the supplied vertices
	 */
	public void addEdge(int u, int v) {
		adjmatrix[u][v] = 1;
		adjmatrix[v][u] = 1;
		noOfEdges++;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(noOfVertices + " vertices, " + noOfEdges + " edges" + "\n");
		
		for(int v=0; v<noOfVertices; v++) {
			sb.append(v + ": ");
			for(int w : adjmatrix[v]) {
				sb.append(w + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
