package linkedlists;

import org.junit.jupiter.api.Test;

public class KthElementTest {


    public static int recursiveKthElement(Node head, int k) {
        if (head == null) {
            return 0;
        }

        int counter = recursiveKthElement(head.next, k) + 1;
        if (counter == k) {
            System.out.println(head.value);
        }
        return counter;
    }

    public static int iterateToKthElement(Node head, int k) {
        if (head == null) {
            return -1;
        }

        Node fast = head, slow = head;

        while (fast != null) {
            fast = fast.next;
            if (k > 0) {
                --k;
            } else {
                slow = slow.next;
            }
        }
        return slow.value;
    }


    @Test
    public void testIterateToKthElement() {

        LinkedList list = new LinkedList();
        int[] values = {5, 65, 342, 43, 34, 3423, 1, 34, 32};

        for (int value : values) {
            list.append(value);
        }

        //Assertions.assertEquals(34, iterateToKthElement(list.head, 5));
        recursiveKthElement(list.head, 5);
        recursiveKthElement(list.head, 3);

    }

}
