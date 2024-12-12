package graph.shortestpath;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Reference <a href="https://www.geeksforgeeks.org/snake-ladder-problem-2/">Chutes and Ladder Problem</a>
 */
public class SnakesAndLaddersTest {

    private static int numberOfMoves(int[] moves, int n) {
        final Queue<Integer> q = new ArrayDeque<>();
        final boolean[] visited = new boolean[n];
        final int[] distance = new int[n];

        q.add(0);

        while (!q.isEmpty()) {
            int node = q.remove();

            if (node == n - 1) {
                break;
            }

            // 'i' represent number on the dice which is [1..6]
            for (int i = 1, adjacent = node + i; i <= 6 && adjacent < n; i++) {
                if (visited[adjacent]) {
                    continue;
                }
                visited[adjacent] = true;

                // In classic Dijkstra, this would be the relaxation function
                // If we encountered a chute or a ladder then traverse it
                if (moves[adjacent] != -1) {
                    distance[adjacent] = moves[adjacent];
                } else {
                    // This is a regular cell, update the distance
                    distance[adjacent] = distance[node] + 1;
                }

                q.add(adjacent);
            }
        }


        return distance[n - 1];
    }


    @Test
    public void basicTest1() {
        final int row = 6, columns = 5;
        final int n = row * columns;
        final int[] moves = new int[n];
        final int[][] movements = new int[][]{{2, 21}, {4, 7}, {10, 25}, {19, 28}, {26, 0}, {20, 8}, {16, 3}, {18, 6}};

        Arrays.fill(moves, -1);
        for (int[] movement : movements) {
            moves[movement[0]] = movement[1];
        }

        Assertions.assertEquals(3, numberOfMoves(moves, n));

    }

}
