package graph.bfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

// https://leetcode.com/problems/minimum-genetic-mutation/
public class GeneMutationTest {
    public static int minMutation(String startGene, String endGene, String[] bank) {
        // Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]

        final Queue<String> q = new ArrayDeque<>();
        final Set<String> visited = new HashSet<>();
        final char[] sequence = new char[]{'A', 'T', 'C', 'G'};
        final Set<String> fastBank = new HashSet<>(Arrays.asList(bank));

        int steps = 0;

        q.add(startGene);
        visited.add(startGene);

        while (!q.isEmpty()) {

            for (int surroundings = 0; surroundings < q.size(); surroundings++) {

                String node = q.remove();

                if (endGene.equalsIgnoreCase(node)) {
                    return steps;
                }

                for (char c : sequence) {
                    for (int j = 0; j < node.length(); j++) {
                        String mutation
                                = node.substring(0, j) + c + node.substring(j + 1);

                        //System.out.printf("Mutated gene [%s]\n", mutation);

                        if (!visited.contains(mutation) && fastBank.contains(mutation)) {
                            System.out.printf("Added mutation [%s] to path in step [%d]\n", mutation, steps);
                            q.add(mutation);
                            visited.add(node);
                        }
                    }

                }
            }
            steps++;
        }

        return -1;

    }

    @Test
    public void basicTest() {
        Assertions.assertEquals(2,
                GeneMutationTest.minMutation(
                        "AACCGGTT",
                        "AAACGGTA",
                        new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}
                )
        );
    }

    @Test
    public void failingCase1() {
        Assertions.assertEquals(-1,
                GeneMutationTest.minMutation(
                        "AAAAAAAA",
                        "CCCCCCCC",
                        new String[]{"AAAAAAAA", "AAAAAAAC", "AAAAAACC", "AAAAACCC", "AAAACCCC", "AACACCCC", "ACCACCCC",
                                "ACCCCCCC", "CCCCCCCA"}
                )
        );
    }

    @Test
    public void failingCase2() {
        Assertions.assertEquals(4,
                GeneMutationTest.minMutation(
                        "AAAACCCC",
                        "CCCCCCCC",
                        new String[]{"AAAACCCA", "AAACCCCA", "AACCCCCA", "AACCCCCC", "ACCCCCCC", "CCCCCCCC", "AAACCCCC", "AACCCCCC"}
                )
        );
    }
}
