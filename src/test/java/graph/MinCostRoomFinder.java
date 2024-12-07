package graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

// Problem statement: https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/
class MinCostRoomFinder {

    private static class Pair {
        final int x, y, cost;

        Pair(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    //TODO: we should have excellent comfort level with this
    private static final int[][] DIRECTIONS = new int[][]{
            {1, 0}, {-1, 0},
            {0, 1}, {0, -1}
    };

    public static int minTimeToReach(int[][] moveTime) {
        final int n = moveTime.length, m = moveTime[0].length;
        final PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        final int[][] distances = new int[n][m];

        for (int[] row : distances) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        pq.add(new Pair(0, 0, 0));
        distances[0][0] = 0;

        while (!pq.isEmpty()) {
            Pair step = pq.poll();

            // This is required by Dijkstra's algorithm
            if (step.cost > distances[step.x][step.y]) {
                continue;
            }

            for (int[] direction : DIRECTIONS) {
                int nx = step.x + direction[0], ny = step.y + direction[1];

                // Guard
                if (!((nx >= 0 && nx < n) && (ny >= 0 && ny < m))) {
                    continue;
                }

                int newCost = 1 + Math.max(step.cost, moveTime[nx][ny]);
                if (newCost < distances[nx][ny]) {
                    // Relax the node
                    distances[nx][ny] = newCost;
                    pq.offer(new Pair(nx, ny, newCost));
                }
            }

        }

        return distances[n - 1][m - 1];
    }


    @Test
    public void basicTest() {
//        final int[][] moveTime = new int[][]{
//                {0, 4, 1},
//                {1, 3, 9},
//                {75, 6, 1},
//                {8, 1, 4},
//                {11, 10, 19},
//                {67, 9, 343}};
        final int[][] moveTime = new int[][]{
                {56, 93},
                {3, 38}
        };
        Assertions.assertEquals(39, MinCostRoomFinder.minTimeToReach(moveTime));
    }
}
