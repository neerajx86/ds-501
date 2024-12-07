import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class TestDeque {

    @Test
    public void testDequeAsQueue() {
        final int[] nums = new int[]{10, 12, 343, 12, 53, 12, 35, 314, 1, 13, 53, 70, -1};
        final Deque<Integer> q = new ArrayDeque<>();

        //Push all elements to the Queue
        for (int num : nums) {
            // add - internally calls addLast
            q.add(num);

        }

        // Get the head element without removing it
        Assertions.assertEquals(q.peek(), nums[0]);

        // Remove the head element
        Assertions.assertEquals(q.poll(), nums[0]);
        // Get the head element without removing it
        Assertions.assertEquals(q.peek(), nums[1]);
    }

    @Test
    public void testDequeAsStack() {
        final int[] nums = new int[]{10, 12, 343, 12, 53, 12, 35, 314, 1, 13, 53, 70, -1};
        final Deque<Integer> q = new ArrayDeque<>();

        //Push all elements to the Queue
        for (int num : nums) {
            // push - internally calls addFirst
            q.push(num);

        }

        // Get the top of the stack (TOS) without removing it
        Assertions.assertEquals(nums[nums.length - 1], q.peek());

        // Remove TOS
        Assertions.assertEquals(nums[nums.length - 1], q.pop());
        // Get the TOS removing it
        Assertions.assertEquals(nums[nums.length - 2], q.peek());
    }
}
