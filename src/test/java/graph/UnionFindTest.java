package graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnionFindTest {

    static class Parent {
        int parentId;
        int height;
    }


    /**
     * Array is in the form (index = child_id, value=parent_id)
     */
    public static int findParent(int[] edges, int child) {
        //int height = 0;
        while (edges[child] != -1) {
            child = edges[child];
            //height++;
        }
        return child;
    }

    public static void union(int[] edges, int firstEdge, int secondEdge) {
        int parentOfFirst = findParent(edges, firstEdge);
        int parentOfSecond = findParent(edges, secondEdge);
        if (parentOfFirst != parentOfSecond) {
            edges[parentOfSecond] = parentOfFirst;
        }
    }


    @Test
    public void findPositiveTest1() {
        int[] edges = {-1, 2, 3, 0};

        Assertions.assertEquals(0, findParent(edges, 3));
        Assertions.assertEquals(0, findParent(edges, 2));
        Assertions.assertEquals(0, findParent(edges, 1));
    }

    @Test
    public void findPositiveTest2() {
        int[] edges = {-1, 2, 3, 0, -1, 4};

        Assertions.assertEquals(4, findParent(edges, 4));
        Assertions.assertEquals(4, findParent(edges, 5));
    }

    @Test
    public void unionPositiveTest1() {
        int[] edges = {-1, 2, 3, 0, -1, 4};
        union(edges, 3, 5);
        Assertions.assertEquals(0, findParent(edges, 5));
    }


}
