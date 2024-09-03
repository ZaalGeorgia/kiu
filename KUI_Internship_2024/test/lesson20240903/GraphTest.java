package lesson20240903;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {
    private GraphWithMatrix graph;

    @Before
    public void setUp() {
        graph = new GraphWithMatrix(4); // Initialize a graph with 4 vertices
    }

    @Test
    public void testAddEdge() {
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        int[][] expected = {
            {0, 1, 1, 0},
            {1, 0, 0, 0},
            {1, 0, 0, 0},
            {0, 0, 0, 0}
        };
        assertArrayEquals(expected, graph.getAdjMatrix());
    }

    @Test
    public void testAddDirectedEdge() {
        graph.addDirectedEdge(0, 1);
        graph.addDirectedEdge(1, 2);
        int[][] expected = {
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        assertArrayEquals(expected, graph.getAdjMatrix());
    }

    @Test
    public void testRemoveEdge() {
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.removeEdge(0, 1);
        int[][] expected = {
            {0, 0, 0, 0},
            {0, 0, 1, 0},
            {0, 1, 0, 0},
            {0, 0, 0, 0}
        };
        assertArrayEquals(expected, graph.getAdjMatrix());
    }

    @Test
    public void testRemoveDirectedEdge() {
        graph.addDirectedEdge(0, 1);
        graph.addDirectedEdge(1, 2);
        graph.removeDirectedEdge(0, 1);
        int[][] expected = {
            {0, 0, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        assertArrayEquals(expected, graph.getAdjMatrix());
    }

    @Test
    public void testNoEdgeBetweenVertices() {
        int[][] expected = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        assertArrayEquals(expected, graph.getAdjMatrix());
    }

    @Test
    public void testAddEdgeOutOfBounds() {
        graph.addEdge(0, 5); // This should not add any edge since the index is out of bounds
        graph.addEdge(-1, 2); // This should also not add any edge since the index is out of bounds
        int[][] expected = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        assertArrayEquals(expected, graph.getAdjMatrix());
    }
}