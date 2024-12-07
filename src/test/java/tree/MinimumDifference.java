package tree;

/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */
public class MinimumDifference {

    BinaryTree prevNode;

    int minValue = Integer.MIN_VALUE;

    public int getMinimumDifference(BinaryTree root) {
        return Integer.MIN_VALUE;
    }


    private void difference(BinaryTree root) {
        if (root == null) {
            return;
        }
        prevNode = root;
        difference(root.left);
        if (prevNode != null) {
            minValue = Math.min(Math.abs(prevNode.value - root.value), minValue);
        }
        difference(root.right);
    }

}
