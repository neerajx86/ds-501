package tree;

import java.util.*;

/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * <p>
 * A leaf is a node with no children.
 * <p>
 * Example 1:
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 * <p>
 * Example 2:
 * Input: root = [1]
 * Output: ["1"]
 * <p>
 * <a href="https://leetcode.com/problems/binary-tree-paths/description/">source</a>
 */
public class TestTreePaths {

    public List<String> paths(BinaryTree root) {
        List<String> stringPaths = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        Queue<BinaryTree> queue = new ArrayDeque<>();

        queue.add(root);
        builder.append(String.format("%d", root.value));

        while (!queue.isEmpty()) {
            BinaryTree node = queue.remove();
            if (node.left == null && node.right == null) {

            }
        }

        return Collections.emptyList();
    }


}
