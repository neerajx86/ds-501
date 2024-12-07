package graph.dfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FindCycleUndirectedTests {

    private static boolean dfs(List<List<Integer>> graph, int startVertex, int parent, boolean[] visited) {
        visited[startVertex] = true;

        for (int neighbour : graph.get(startVertex)) {
            if (!visited[neighbour]) {
                if (dfs(graph, /*startVertex*/ neighbour, /*parent*/ startVertex, visited)) {
                    return true;
                }
            }

            // If a vertex has been visited, and we didn't start from it then there exists a path
            // to reach parent. L&G we have a cycle.
            else if (neighbour != parent) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasCycle(List<List<Integer>> graph, int numEdges) {
        boolean[] visited = new boolean[numEdges];
        for (int i = 0; i < numEdges; i++) {
            if (!visited[i] && dfs(graph, i, -1, visited)) {
                return true;
            }
        }
        return false;
    }


    @Test
    public void basicTrueTest1() {
        int[][] adjList = new int[][]{
                {1, 2},
                {2, 0},
                {1, 0}
        };

        Assertions.assertTrue(
                hasCycle(
                        createGraph(adjList), 3
                )
        );
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

        Assertions.assertFalse(hasCycle(adj, V));
    }

    private List<List<Integer>> createGraph(int[][] adjMatrix) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < adjMatrix.length; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                graph.get(i).add(adjMatrix[i][j]);
            }
        }

        return graph;
    }

}
