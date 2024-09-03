package lesson20240903.lists;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class GraphTest {
    private Graph graph;

    @Before
    public void setUp() {
        graph = new Graph();
    }

    @Test
    public void testAddVertex() {
        graph.addVertex(1);
        graph.addVertex(2);
        Map<Integer, List<Integer>> expected = new HashMap<>();
        expected.put(1, new ArrayList<>());
        expected.put(2, new ArrayList<>());
        assertEquals(expected, graph.getAdjacencyList());
    }

    @Test
    public void testAddEdge() {
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        Map<Integer, List<Integer>> expected = new HashMap<>();
        expected.put(1, Arrays.asList(2, 3));
        expected.put(2, Collections.singletonList(1));
        expected.put(3, Collections.singletonList(1));
        assertEquals(expected, graph.getAdjacencyList());
    }

    @Test
    public void testAddDirectedEdge() {
        graph.addDirectedEdge(1, 2);
        graph.addDirectedEdge(2, 3);
        Map<Integer, List<Integer>> expected = new HashMap<>();
        expected.put(1, Collections.singletonList(2));
        expected.put(2, Collections.singletonList(3));
        expected.put(3, new ArrayList<>());
        assertEquals(expected, graph.getAdjacencyList());
    }

    @Test
    public void testRemoveVertex() {
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.removeVertex(2);
        Map<Integer, List<Integer>> expected = new HashMap<>();
        expected.put(1, new ArrayList<>());
        expected.put(3, new ArrayList<>());
        assertEquals(expected, graph.getAdjacencyList());
    }

    @Test
    public void testRemoveEdge() {
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.removeEdge(1, 2);
        Map<Integer, List<Integer>> expected = new HashMap<>();
        expected.put(1, new ArrayList<>());
        expected.put(2, Collections.singletonList(3));
        expected.put(3, Collections.singletonList(2));
        assertEquals(expected, graph.getAdjacencyList());
    }

    @Test
    public void testRemoveNonExistentEdge() {
        graph.addEdge(1, 2);
        graph.removeEdge(1, 3); // This edge does not exist
        Map<Integer, List<Integer>> expected = new HashMap<>();
        expected.put(1, Collections.singletonList(2));
        expected.put(2, Collections.singletonList(1));
        assertEquals(expected, graph.getAdjacencyList());
    }

    @Test
    public void testGraphIsEmptyInitially() {
        assertTrue(graph.getAdjacencyList().isEmpty());
    }
}