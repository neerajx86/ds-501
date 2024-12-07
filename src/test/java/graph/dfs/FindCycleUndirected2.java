package graph.dfs;

// A Java Program to detect
// cycle in an undirected graph

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class FindCycleUndirected2 {

    // A recursive function that
    // uses visited[] and parent to detect
    // cycle in subgraph reachable
    // from vertex v.
    static boolean isCyclicUtil(int startingEdge, List<List<Integer>> adj, boolean[] visited, int parent) {

        System.out.printf("Starting Edge [%d], Parent [%d]\n", startingEdge, parent);

        // Mark the current node as visited
        visited[startingEdge] = true;

        // Recur for all the vertices
        // adjacent to this vertex
        for (int neighbour : adj.get(startingEdge)) {
            System.out.printf("\tNeighbour [%d]\n", neighbour);

            // If an adjacent vertex is not visited,
            // then recur for that adjacent
            if (!visited[neighbour]) {
                if (isCyclicUtil(neighbour, adj, visited, startingEdge))
                    return true;
            }

            // If an adjacent vertex is visited and
            // is not parent of current vertex,
            // then there exists a cycle in the graph.
            else if (neighbour != parent)
                return true;
        }
        return false;
    }

    // Returns true if the graph contains
    // a cycle, else false.
    static boolean isCyclic(int V, List<List<Integer>> adj) {

        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];

        // Call the recursive helper function
        // to detect cycle in different DFS trees
        for (int u = 0; u < V; u++) {

            // Don't recur for u if it is already visited
            if (!visited[u]) {
                if (isCyclicUtil(u, adj, visited, -1))
                    return true;
            }
        }
        return false;
    }

    @Test
    public void basicTrueTest1() {
        int V = 3;
        List<List<Integer>> adj = new ArrayList<>(V);

        for (int neighbour = 0; neighbour < V; neighbour++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(0);
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);

        Assertions.assertTrue(isCyclic(V, adj));
    }

    @Test
    public void basicFalseTest1() {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>(V);

        for (int neighbour = 0; neighbour < V; neighbour++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        Assertions.assertFalse(isCyclic(V, adj));
    }
}