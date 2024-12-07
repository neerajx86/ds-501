package graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestConnectIslands {

    private final static int[][] directions = new int[][]{
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1},
            {1, 1},
            {-1, -1}
    };

    public static int numConnected(int[][] island) {
        boolean[][] visited = new boolean[island.length][island[0].length];
        int islandSize = 0, numIslands = 0;

        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[0].length; j++) {
                if (visited[i][j]) {
                    continue;
                }
                if (island[i][j] == 1) {
                    islandSize = Math.max(dfs(island, visited, i, j), islandSize);
                    ++numIslands;
                }
                // This will give island count
            }
        }
        System.out.printf("Number of islands [%d]\n", numIslands);
        return islandSize;
    }

    public static int dfs(int[][] island, boolean[][] visited, int i, int j) {
        int x, y, islandSize = 0;
        for (int[] direction : directions) {
            x = i + direction[0];
            y = j + direction[1];

            if (x < island.length && y < island[0].length && x >= 0 && y >= 0 && !visited[x][y]) {
                visited[x][y] = true;
                if (island[x][y] == 1) {
                    System.out.printf("Visiting x=[%d], y=[%d]\n", x, y);
                    islandSize += dfs(island, visited, x, y) + 1;

                }
            }

        }
        return islandSize;
    }

    @Test
    public void basicTest1() {
        int[][] island = new int[][]{
                {1, 1},
                {1, 1},
        };

        Assertions.assertEquals(4, numConnected(island));
    }

    @Test
    public void basicDiagonalTest1() {
        int[][] island = new int[][]{
                {1, 0},
                {0, 1},
        };

        Assertions.assertEquals(2, numConnected(island));

        int[][] island2 = new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        Assertions.assertEquals(3, numConnected(island2));
    }

    @Test
    public void basicFalseTest1() {
        int[][] island = new int[][]{
                {0, 0},
                {0, 0},
        };

        Assertions.assertEquals(0, numConnected(island));
    }

    @Test
    public void basicTest2() {
        int[][] island = new int[][]{
                {1, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0, 1, 1}
        };

        Assertions.assertEquals(6, numConnected(island));
    }

}
