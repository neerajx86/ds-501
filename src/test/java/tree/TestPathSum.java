package tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Queue;
import java.util.Stack;

/**
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals targetSum. A leaf is a node with no children.
 */
public class TestPathSum {

    public boolean hasPathSumRecursive(BinaryTree root, int sum) {
        // This is pre-order traversal
        // Can the same be accomplished via in-order traversal?

        if (root == null) {
            return false;
        }

        sum -= root.value;

        // Remember!!, we are looking for a root to LEAF path which matches a sum
        // hence only verifying that sum==0 wouldn't cut.
        // Also, n4j, please READ the question very carefully
        if ((root.left == null) && (root.right == null) && sum == 0) return true;

        return hasPathSumRecursive(root.left, sum) || hasPathSumRecursive(root.right, sum);
    }

    public boolean hasPathSumIterative(BinaryTree root, int sum) {
        Stack<Integer> ansStack = new Stack<>();
        Stack<BinaryTree> dfs = new Stack<>();

        dfs.push(root);
        ansStack.push(sum);

        while (!dfs.isEmpty()) {
            BinaryTree node = dfs.pop();
            int value = ansStack.pop();

            value -= node.value;
            if (value == 0 && node.left == null && node.right == null) {
                return true;
            }

            if (node.left != null) {
                dfs.push(node.left);
                ansStack.push(value);
            }

            if (node.right != null) {
                dfs.push(node.right);
                ansStack.push(value);
            }
        }

        // The key learning here is, how to do iterative DFS and how to store state in a stack to mimic
        // recursion
        return false;
    }

    @Test
    void testBasicPathSumRecursive() {
        BinaryTree root = new BinaryTree(1, new BinaryTree(2), new BinaryTree(4));
        Assertions.assertTrue(hasPathSumRecursive(root, 3));
    }

    @Test
    void testBasicPathSumIterative() {
        BinaryTree root = new BinaryTree(1, new BinaryTree(2), new BinaryTree(4));
        Assertions.assertTrue(hasPathSumIterative(root, 3));
    }

}
