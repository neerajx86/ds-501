package stackqueues;

public class ArrayBackedStack {

    private static final int numStacks = 3;

    private int stackSize;

    private int[] array;

    private int[] sizes;

    ArrayBackedStack(int stackSize) {
        this.stackSize = stackSize;
        array = new int[numStacks * this.stackSize];
        sizes = new int[stackSize];
    }

    void push(int stackNumber, int value) {
        if (isFull(stackNumber)) {
            return;
        }

        array[getOffset(stackNumber)] = value;
        incrementStack(stackNumber);
    }

    int pop(int stackNumber) {
        if (isEmpty(stackNumber)) {
            return Integer.MIN_VALUE;
        }

        return array[decrementStack(stackNumber) - 1];
    }


    boolean isFull(int stackNumber) {
        return sizes[stackNumber] > stackNumber;
    }

    boolean isEmpty(int stackNumber) {
        return sizes[stackNumber] == 0;
    }

    int getOffset(int stackNumber) {
        return this.stackSize * stackNumber + sizes[stackNumber];
    }

    void incrementStack(int stackNumber) {
        if (isFull(stackNumber)) {
            return;
        }
        sizes[stackNumber]++;
    }

    int decrementStack(int stackNumber) {
        if (isEmpty(stackNumber)) {
            return Integer.MIN_VALUE;
        }
        return --sizes[stackNumber];
    }


}
