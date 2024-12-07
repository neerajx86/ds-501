package tree;

import java.util.*;

public class DepthList {

    class Level {
        int value;
    }

    /**
     * Creates a list of depths via Level Order Traversal
     */
    List<LinkedList<Integer>> createWithLOT(BinaryTree tree) {
        BinaryTree marker = new BinaryTree(100000);
        List<LinkedList<Integer>> lists = new ArrayList<>();
        BinaryTree node;
        Queue<BinaryTree> queue = new ArrayDeque<>();
        queue.add(tree);
        queue.add(marker);

        while (!queue.isEmpty()) {

            LinkedList<Integer> head = new LinkedList<>();
            while ((node = queue.remove()) != marker) {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                head.add(node.value);
            }
            if (head.size() != 0) {
                lists.add(head);
            }
        }

        return lists;
    }

    void createWithRecursion(BinaryTree root, ArrayList<LinkedList<BinaryTree>> lists, int level) {
        if (root == null) {
            return;
        }

        LinkedList<BinaryTree> list;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }

        list.add(root);
        createWithRecursion(root.left, lists, level + 1);
        createWithRecursion(root.right, lists, level + 1);
    }

    List<LinkedList<BinaryTree>> createWithoutRecursion(BinaryTree root) {

        if (root == null) {
            return Collections.emptyList();
        }

        Stack<BinaryTree> stack = new Stack<>();
        List<LinkedList<BinaryTree>> lists = new ArrayList<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            Stack<BinaryTree> parent = stack;
            stack = new Stack<>();
            LinkedList<BinaryTree> list = new LinkedList<>();
            lists.add(list);

            while (!parent.isEmpty()) {
                BinaryTree item = parent.pop();
                list.add(item);

                if (item.left != null) {
                    stack.push(item.left);
                }

                if (item.right != null) {
                    stack.push(item.right);
                }

                // when this loop terminates, all nodes at a given level
                // will be in the "stack"
            }
        }
        return lists;
    }

}