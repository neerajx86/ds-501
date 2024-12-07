package linkedlists;

import java.util.Stack;

public class Palindrome {

    boolean isPalindrome(LinkedList list) {
        Stack<Integer> stack = new Stack<>();
        Node fast = list.head;
        Node slow = list.head;

        while (fast != null && fast.next != null) {
            stack.push(slow.value);
            slow = slow.next;
            fast.next = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (stack.pop() != slow.value) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }

}
