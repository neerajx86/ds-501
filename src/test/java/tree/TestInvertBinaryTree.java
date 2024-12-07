package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 * <p/>
 * Example 1
 * <p/>
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * <p/>
 * Example 2
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 */
public class TestInvertBinaryTree {

    public static BinaryTree invert(BinaryTree root) {
        if (root == null) {
            return null;
        }
        BinaryTree left = root.left, right = root.right;
        if (right != null) {
            root.right = left;
        }
        if (left != null) {
            root.left = right;
        }

        invert(root.left);
        invert(root.right);

        return root;
    }

    @Test
    public void testBasic() {
        BinaryTree root = new BinaryTree(2, new BinaryTree(1, null, null), new BinaryTree(3, null, null));
        invert(root);

        assertEquals(root.value, 2);
        assertEquals(root.left.value, 3);
        assertEquals(root.right.value, 1);
    }

}
