package stackqueues;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class SortStack {


    static Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> sortedStack = new Stack<>();

        while (!stack.isEmpty()) {
            int value = stack.pop();
            while (!sortedStack.isEmpty() && sortedStack.peek() > value) {
                stack.push(sortedStack.pop());
            }
            sortedStack.push(value);
        }

        return sortedStack;
    }

    @Test
    void basicTest() {

        Stack<Integer> case1 = new Stack<>();
        int[] items = new int[]{10, 5, 11, 6};
        for (int item : items) {
            case1.push(item);
        }

        Stack<Integer> sorted = sort(case1);
        System.out.println(sorted);
    }

}
