package tree;

public class BinaryTree {
    public int value;
    public BinaryTree left, right;
    public BinaryTree(int value, BinaryTree left, BinaryTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    public BinaryTree(int value) {
        this(value, null, null);

    }
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
