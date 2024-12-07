package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary search tree (BST) with duplicates, return all the mode(s)
 * (i.e., the most frequently occurred element) in it.
 * <p>
 * If the tree has more than one mode, return them in any order.
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class Mode {

    private static class State {
        int currentStreak = 0, currentNum = 0, maxStreak = 0;
    }

    List<Integer> getMode(BinaryTree root) {
        List<Integer> modes = new ArrayList<>();
        getModes(root, modes, new State());
        return modes;
    }

    private void getModes(BinaryTree root, List<Integer> modes, State state) {
        if (root == null) {
            return;
        }

        getModes(root.left, modes, state);
        if (root.value == state.currentNum) {
            ++state.currentStreak;
        } else {
            state.currentStreak = 1;
            state.currentNum = root.value;
        }

        if (state.currentStreak > state.maxStreak) {
            modes.removeIf((a) -> true);
            state.maxStreak = state.currentStreak;
        }

        if (state.currentStreak == state.maxStreak) {
            modes.add(state.currentNum);
        }

        getModes(root.right, modes, state);
    }

}
