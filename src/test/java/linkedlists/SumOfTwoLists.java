package linkedlists;


import org.junit.jupiter.api.Test;

/**
 * 2.5
 * <p>
 * You have two numbers represented by a LinkedList, where each node contains a single digit. The digits are
 * stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds
 * the two numbers and returns the sum as a linked list.
 * <p>
 * EXAMPLE
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295
 * Output: 2 -> 1 -> 9. That's 912.
 * <p>
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295.
 * Output: (9 -> 1 -> 2). That is, 912.
 */
public class SumOfTwoLists {

    @Test
    void testMain() {
        LinkedList first = LinkedList.fromArray(7, 1, 6);
        LinkedList second = LinkedList.fromArray(5, 9, 2);
        LinkedList total = sum(first, second);
    }


    LinkedList sum(LinkedList a, LinkedList b) {
        Node first = a.head,
                second = b.head;

        LinkedList sum = new LinkedList();

        int op = 0, carry = 0;
        boolean overflow = false;

        while (first != null || second != null) {

            op = carry + (first != null ? first.value : 0) + (second != null ? second.value : 0);

            if (overflow = (op > 9)) {
                carry = 1;
                op %= 10;
            } else {
                carry = 0;
            }

            sum.append(op);
            first = first != null ? first.next : null;
            second = second != null ? second.next : null;
        }

        if (overflow) {
            sum.append(carry);
        }

        return sum;
    }
}