package graph.shortestpath;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BellmanFordTest {

    private static final int INF = Integer.MAX_VALUE;

    private static final int[] INVALID_GRAPH = new int[]{};

    /**
     * returns - An array of weights for each vertex, e.g.
     * +-------------------+
     * | 0 | 1 | 2 | 3 | 4 | <- Array index
     * ---------------------
     * | 0 | 3 | 8 | 5 | 7 | <- Relaxed weight
     * +-------------------+
     */
    public static int[] shortestPath(int[][] edges, int numVertices) {
        int[] distances = new int[numVertices];
        Arrays.fill(distances, INF);

        // Need to initialize this
        distances[0] = 0;

        int u, v, w;

        for (int i = 0; i < numVertices; i++) {
            for (int[] edge : edges) {
                u = edge[0];
                v = edge[1];
                w = edge[2];

                if (distances[u] != INF && (distances[u] + w < distances[v])) {
                    distances[v] = distances[u] + w;
                }

                if (i > numVertices - 1) {
                    return INVALID_GRAPH;
                }

            }

        }

        return distances;
    }

    @Test
    public void BasicTest1() {
        int numVertices = 6;
        int[] result = shortestPath(new int[][]{
                /*{source, destination, weight}*/
                {0, 1, 5},
                {1, 3, 2},
                {1, 2, 1},
                {2, 4, 1},
                {4, 3, -1}
        }, numVertices);

        Assertions.assertEquals(7, result[numVertices - 2]);
    }

}
