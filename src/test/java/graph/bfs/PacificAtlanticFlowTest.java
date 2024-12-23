package graph.bfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/pacific-atlantic-water-flow/editorial/">Reference</a>
 */
public class PacificAtlanticFlowTest {

    private static final int[][] DIRECTIONS = new int[][]{
            // Top
            {0, 1},
            // Down
            {0, -1},
            // Left
            {-1, 0},
            // Right
            {1, 0}
    };

    public List<int[]> flow(int[][] graph) {

        final Queue<int[]> pacificQueue = new ArrayDeque<>();
        final Queue<int[]> atlanticQueue = new ArrayDeque<>();

        // Populate the queue for Pacific and the Atlantic ocean
        // with the parts of the island adjacent to both of them
        // Refer below image
        // https://assets.leetcode.com/uploads/2021/06/08/waterflow-grid.jpg


        int numRows = graph.length;
        int numCols = graph[0].length;

        for (int i = 0; i < numRows; i++) {
            pacificQueue.offer(new int[]{i, 0});
            atlanticQueue.offer(new int[]{i, numCols - 1});
        }
        for (int i = 0; i < numCols; i++) {
            pacificQueue.offer(new int[]{0, i});
            atlanticQueue.offer(new int[]{numRows - 1, i});
        }

        boolean[][] pacificPaths = reachable(graph, pacificQueue, numRows, numCols);
        boolean[][] atlanticPaths = reachable(graph, atlanticQueue, numRows, numCols);
        List<int[]> flowPath = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (pacificPaths[i][j] && atlanticPaths[i][j]) {
                    flowPath.add(new int[]{i, j});
                }
            }

        }

        return flowPath;
    }

    public boolean[][] reachable(int[][] graph, Queue<int[]> paths, int numRows, int numColumns) {
        boolean[][] reachable = new boolean[numRows][numColumns];

        while (!paths.isEmpty()) {

            int[] path = paths.remove();

            // This path is reachable, so mark it as true
            reachable[path[0]][path[1]] = true;

            for (int[] direction : DIRECTIONS) {

                int row = path[0] + direction[0];
                int col = path[1] + direction[1];

                if (row < 0 || row >= numRows || col < 0 || col >= numColumns) {
                    continue;
                }

                if (reachable[row][col]) {
                    continue;
                }

                if (graph[row][col] < graph[path[0]][path[1]]) {
                    continue;
                }
                paths.offer(new int[]{row, col});
            }

        }
        return reachable;
    }

    @Test
    public void basic() {
        final int[][] graph = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        PacificAtlanticFlowTest test = new PacificAtlanticFlowTest();
        List<int[]> flowPath = test.flow(graph);
        System.out.println(flowPath);
    }

    @Test
    public void basic2() {
        final int[][] graph = new int[][]{
                {1, 2, 2, 3, 5, 1, 1, 1, 3},
                {3, 2, 3, 4, 4, 2, 2, 2, 3},
                {2, 4, 5, 3, 2, 1, 5, 1, 4},
                {6, 7, 1, 4, 5, 1, 6, 4, 2},
                {5, 1, 1, 2, 4, 4, 1, 1, 4}
        };
        PacificAtlanticFlowTest test = new PacificAtlanticFlowTest();
        List<int[]> flowPath = test.flow(graph);
        System.out.println(flowPath);
    }

}
