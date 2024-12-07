package graph.shortestpath;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FloydWarshall {

    private static final int NO_PATH = 0;

    public int[][] shortestPath(int[][] graph, int src, int destination) {
        int[][] allPaths = new int[graph.length][graph[0].length];
        for (int[] ints : graph) {
            Arrays.fill(ints, NO_PATH);
        }
        int V = graph.length;

        // Source vertex
        for (int i = 0; i < V; i++) {

            // Destination vertex
            for (int j = 0; j < V; j++) {

                // Intermediate vertex
                for (int k = src; k < V; k++) {

                    allPaths[i][j] = Math.min(allPaths[i][j], graph[i][k] + graph[j][k]);
                }

            }

        }
        return allPaths;
    }

    @Test
    public void basicTest1() {

    }
}
