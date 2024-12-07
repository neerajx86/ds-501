package graph.mst;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalMST {

    static class Edge {
        public final int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        static Edge fromArray(int[] values) {
            return new Edge(values[0], values[1], values[2]);
        }
    }

    static class Subset {
        public int parent;

        public int rank;

        public List<Edge> edges;

        Subset(int parent) {
            this.parent = parent;
        }
    }

    public static List<Edge> createMst(List<Edge> edges, int numVertices) {
        edges.sort(Comparator.comparingInt(e -> e.weight));

        final List<Edge> mstGraph = new ArrayList<>();

        int verticesCovered = 0;

        while (verticesCovered < numVertices - 1) {
            for (Edge nextEdge : edges) {

            }
        }

        return Collections.emptyList();
    }

    static int parentOf(List<Edge> edges, int node) {
        int iter = node;
        while (edges.get(iter) != null) {
            iter = edges.get(iter).src;
        }
        return iter;
    }

    @Test
    public void basicTest1() {
        /*
         Created from this graph
         https://media.geeksforgeeks.org/wp-content/uploads/20210727035309/UntitledDiagram92.png
        */
        final int[][] edgeValues = new int[][]{
                {7, 6, 1},
                {8, 2, 2},
                {6, 5, 2},
                {0, 1, 4},
                {2, 5, 4},
                {8, 6, 6},
                {2, 3, 7},
                {7, 8, 7},
                {0, 7, 8},
                {1, 2, 8},
                {3, 4, 9},
                {5, 4, 10},
                {1, 7, 11},
                {3, 5, 14}
        };

        final List<Edge> edges = new ArrayList<>();

        for (int[] edgeValue : edgeValues) {
            edges.add(Edge.fromArray(edgeValue));
        }

        List<Edge> mstGraph = createMst(edges, 9);
    }
}
