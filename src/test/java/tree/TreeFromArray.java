package tree;

public class TreeFromArray {

    public static BinaryTree fromArray(int[] array) {
        return fromArray(array, 0, array.length - 1);
    }

    private static BinaryTree fromArray(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        BinaryTree tree = new BinaryTree(array[mid]);
        tree.left = fromArray(array, start, mid - 1);
        tree.right = fromArray(array, mid + 1, end);
        return tree;
    }

}