package practice.graphs;

public class TestGraphs {

	public static void main(String[] args) {
		GraphImplUsingArrayMatrix graphUsingArrayMatrix = new GraphImplUsingArrayMatrix(4);
		graphUsingArrayMatrix.addEdge(0, 1);
		graphUsingArrayMatrix.addEdge(1, 2);
		graphUsingArrayMatrix.addEdge(2, 3);
		graphUsingArrayMatrix.addEdge(3, 0);
		System.out.println(graphUsingArrayMatrix);
		
		GraphImplUsingLinkedList graphUsingLinkedList = new GraphImplUsingLinkedList(4);
		graphUsingLinkedList.addEdge(0, 1);
		graphUsingLinkedList.addEdge(1, 2);
		graphUsingLinkedList.addEdge(2, 3);
		graphUsingLinkedList.addEdge(3, 0);
		System.out.println(graphUsingLinkedList);
		
		System.out.println("Breadth First Search");
		
		GraphImplUsingLinkedList breadthFirstSearchGraph = new GraphImplUsingLinkedList(5);
		breadthFirstSearchGraph.addEdge(0, 1);
		breadthFirstSearchGraph.addEdge(1, 2);
		breadthFirstSearchGraph.addEdge(2, 3);
		breadthFirstSearchGraph.addEdge(3, 0);
		breadthFirstSearchGraph.addEdge(2, 4);
		breadthFirstSearchGraph.breadthFirstSearch(0);
		
		System.out.println();
		System.out.println("Iterative Depth First Search");
		
		GraphImplUsingLinkedList iterativeDepthFirstSearchGraph = new GraphImplUsingLinkedList(5);
		iterativeDepthFirstSearchGraph.addEdge(0, 1);
		iterativeDepthFirstSearchGraph.addEdge(1, 2);
		iterativeDepthFirstSearchGraph.addEdge(2, 3);
		iterativeDepthFirstSearchGraph.addEdge(3, 0);
		iterativeDepthFirstSearchGraph.addEdge(2, 4);
		iterativeDepthFirstSearchGraph.iterativeDepthFirstSearch(0);
		
		System.out.println();
		System.out.println("Recursive Depth First Search");
		
		GraphImplUsingLinkedList recursiveDepthFirstSearchGraph = new GraphImplUsingLinkedList(5);
		recursiveDepthFirstSearchGraph.addEdge(0, 1);
		recursiveDepthFirstSearchGraph.addEdge(1, 2);
		recursiveDepthFirstSearchGraph.addEdge(2, 3);
		recursiveDepthFirstSearchGraph.addEdge(3, 0);
		recursiveDepthFirstSearchGraph.addEdge(2, 4);
		recursiveDepthFirstSearchGraph.recursiveDepthFirstSearch();
		
		System.out.println();
		System.out.println("Connected Components using Recursive Depth First Search");
		
		GraphImplUsingLinkedList connectedComponentsUndirectedGraph = new GraphImplUsingLinkedList(5);
		connectedComponentsUndirectedGraph.addEdge(0, 1);
		connectedComponentsUndirectedGraph.addEdge(1, 2);
		connectedComponentsUndirectedGraph.addEdge(2, 3);
		connectedComponentsUndirectedGraph.addEdge(3, 0);
		connectedComponentsUndirectedGraph.addEdge(2, 4);
		System.out.println(connectedComponentsUndirectedGraph.getConnectedComponentsInGraph());
		System.out.println(connectedComponentsUndirectedGraph.isConnected(0, 4));
	}

}
