package tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class TreeTraversal {

    public static void inOrderTraversal(BinaryTree tree, Consumer<BinaryTree> visitor) {
        if (tree.left != null) {
            inOrderTraversal(tree.left, visitor);
        }
        visitor.accept(tree);
        if (tree.right != null) {
            inOrderTraversal(tree.right, visitor);
        }
    }

    public static int numLevels(BinaryTree tree) {
        if (tree == null) {
            return 0;
        }
        return Math.max(numLevels(tree.left), numLevels(tree.right)) + 1;
    }

    @Test
    public void basicInOrderTraversalTest() {
        BinaryTree tree = new BinaryTree(3, new BinaryTree(1), new BinaryTree(2));
        inOrderTraversal(tree, System.out::println);
    }

    @Test
    public void basicLevelTest() {
        BinaryTree tree = new BinaryTree(3, new BinaryTree(1), new BinaryTree(2));
        Assertions.assertEquals(2, numLevels(tree));

        //BinaryTree tree = new BinaryTree(3, new BinaryTree(1, new BinaryTree(5, new BinaryTree(6), null), new BinaryTree(2));
    }

}
