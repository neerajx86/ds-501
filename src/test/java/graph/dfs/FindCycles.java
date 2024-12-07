package graph.dfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class FindCycles {

    enum State {
        NOT_VISITED,
        VISITING,
        VISITED
    }

    /**
     * A recursion less implementation of cycle detection in directed graph.
     * <br/>
     * Basic idea is - the node being visited shouldn't be in the current path which is being
     * traversed
     */
    public static boolean containsCycle(Map<Integer, List<Integer>> graph, int numVertices) {
        Deque<Integer> stack = new ArrayDeque<>();
        State[] states = new State[numVertices];

        Arrays.fill(states, State.NOT_VISITED);

        for (int vertex : graph.keySet()) {
            if (states[vertex] != State.VISITED) {
                stack.push(vertex);
            }

            List<Integer> neighbours = graph.getOrDefault(vertex, Collections.emptyList());
            do {
                for (int neighbour : neighbours) {
                    if (stack.contains(neighbour)) {
                        return true;
                    }
                    stack.push(neighbour);
                }
                neighbours = graph.getOrDefault(stack.pop(), Collections.emptyList());
            } while (!stack.isEmpty());
        }

        return false;
    }


    @Test
    public void basicTrueTest1() {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(2));
        graph.put(2, Arrays.asList(0, 3));
        graph.put(3, Arrays.asList(3));

        Assertions.assertTrue(FindCycles.containsCycle(graph, 4));

    }

    @Test
    public void basicTrueTest2() {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(5));
        graph.put(2, Arrays.asList(3));
        graph.put(3, Arrays.asList(5));
        graph.put(5, Arrays.asList(0));

        Assertions.assertTrue(FindCycles.containsCycle(graph, 6));

    }

    @Test
    public void basicFalseTest1() {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1));
        graph.put(1, Arrays.asList(2));
        graph.put(2, Arrays.asList(3));
        graph.put(3, Arrays.asList(4));

        Assertions.assertFalse(FindCycles.containsCycle(graph, 5));

    }

    @Test
    public void basicFalseTest2() {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1));
        graph.put(1, Arrays.asList(2));
        graph.put(2, Arrays.asList(3));
        graph.put(3, Arrays.asList(4));
        graph.put(5, Arrays.asList(6));
        graph.put(6, Arrays.asList(7));
        graph.put(7, Arrays.asList(8));
        graph.put(8, Arrays.asList(4));

        Assertions.assertFalse(FindCycles.containsCycle(graph, 9));

    }

    @Test
    public void basicFalseTest3() {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1));
        graph.put(0, Arrays.asList(5));
        graph.put(1, Arrays.asList(2));
        graph.put(2, Arrays.asList(3));
        graph.put(3, Arrays.asList(4));
        graph.put(5, Arrays.asList(6));
        graph.put(6, Arrays.asList(7));
        graph.put(7, Arrays.asList(8));
        graph.put(8, Arrays.asList(4));

        Assertions.assertFalse(FindCycles.containsCycle(graph, 9));

    }

}
