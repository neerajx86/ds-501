package graph;

import java.util.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @see <a href="https://www.geeksforgeeks.org/count-number-trees-forest/">Ref</a>
 */
public class TreesInForestTests {

    static class Edge {
        public final int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }

        @Override
        public boolean equals(Object another) {
            if (!(another instanceof Edge)) {
                return false;
            }
            Edge anotherEdge = (Edge) another;
            return this.src == anotherEdge.src &&
                    this.dest == anotherEdge.dest;
        }
    }

    /**
     * Forest is an array of edges in the form [[src, destination]...], the assumption is all nodes are unique
     * in the entire forest.
     * <br/>
     * This implementation uses a map to build adjacency list
     *
     * @return Number of trees found in forest
     */
    public static int countTrees(int[][] forest) {
        final Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        final Set<Integer> visited = new HashSet<>();
        final Deque<Integer> stack = new ArrayDeque<>();

        int treeCount = 0;

        // Populate the adjacency list
        for (int[] edge : forest) {
            adjacencyList.computeIfAbsent(edge[0], (k) -> new ArrayList<>()).add(edge[1]);
        }

        for (int root : adjacencyList.keySet()) {
            // Pickup a source and push it onto the stack
            if (visited.contains(root)) {
                continue;
            }
            stack.push(root);

            // Start the tree traversal
            while (!stack.isEmpty()) {
                // Add all adjacent edges onto the stack
                int node = stack.pop();
                if (!visited.add(node)) {
                    continue;
                }
                for (int child : adjacencyList.getOrDefault(node, Collections.emptyList())) {
                    if (!visited.contains(child)) {
                        stack.push(child);
                    }
                }
            }

            // We have finished traversing the tree, increment the count
            ++treeCount;
        }

        return treeCount;
    }

    public static int countTreesUnionFind(int[][] forest) {
        return -1;
    }

    @Test
    public void basicTest1() {
        final int[][] edges = new int[][]{{0, 1}, {1, 2}, {3, 4}};
        assertEquals(2, countTrees(edges));

    }

    @Test
    public void basicTest2() {
        final int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}};
        assertEquals(1, countTrees(edges));
    }

    @Test
    public void basicTest3() {
        final int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {5, 6}, {4, 8}};
        assertEquals(3, countTrees(edges));
    }

    @Test
    public void basicTest4() {
        final int[][] edges = new int[][]{{0, 1}, {0, 2}, {3, 4}, {2, 5}};
        assertEquals(2, countTrees(edges));
    }

}
