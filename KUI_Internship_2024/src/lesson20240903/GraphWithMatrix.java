package lesson20240903;

import java.util.Arrays;

class GraphWithMatrix {
    private int[][] adjMatrix;
    private int numVertices;

    // Constructor
    public GraphWithMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    // Add an edge (undirected)
    public void addEdge(int source, int destination) {
        if (source >= 0 && source < numVertices && destination >= 0 && destination < numVertices) {
            adjMatrix[source][destination] = 1;
            adjMatrix[destination][source] = 1; // For undirected graph
        }
    }

    // Add a directed edge
    public void addDirectedEdge(int source, int destination) {
        if (source >= 0 && source < numVertices && destination >= 0 && destination < numVertices) {
            adjMatrix[source][destination] = 1;
        }
    }

    // Remove an edge (undirected)
    public void removeEdge(int source, int destination) {
        if (source >= 0 && source < numVertices && destination >= 0 && destination < numVertices) {
            adjMatrix[source][destination] = 0;
            adjMatrix[destination][source] = 0; // For undirected graph
        }
    }

    // Remove a directed edge
    public void removeDirectedEdge(int source, int destination) {
        if (source >= 0 && source < numVertices && destination >= 0 && destination < numVertices) {
            adjMatrix[source][destination] = 0;
        }
    }

    // Print the adjacency matrix
    public void printGraph() {
        for (int[] row : adjMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        GraphWithMatrix graph = new GraphWithMatrix(4); // Create a graph with 4 vertices
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        System.out.println("Adjacency Matrix:");
        graph.printGraph();

        // Output:
        // Adjacency Matrix:
        // [0, 1, 1, 0]
        // [1, 0, 1, 0]
        // [1, 1, 0, 1]
        // [0, 0, 1, 0]
    }

	public int[][] getAdjMatrix() {
		return adjMatrix;
	}
}