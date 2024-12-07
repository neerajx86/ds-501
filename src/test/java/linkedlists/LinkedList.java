package linkedlists;

public class LinkedList {

    Node head;

    /*
     * Tail reference to facilitate O(1) insertions
     * */
    Node tail;

    int count;

    public LinkedList() {
        count = 0;
    }

    static LinkedList fromArray(int... values) {
        LinkedList newList = new LinkedList();
        for (int value : values) {
            newList.append(value);
        }
        return newList;
    }

    public int append(int value) {
        if (head == null) {
            tail = head = new Node(value);
        } else {
            tail = tail.next = new Node(value);
        }
        return count++;
    }

    public int getCount() {
        return count;
    }

    void deleteNode(int value) {
        Node iterator = head;
        if (iterator.value == value) {
            head = null;
            --count;
            return;
        }

        while (iterator.next != null) {
            if (iterator.next.value == value) {
                iterator.next = iterator.next.next;
                --count;
                break;
            }
            iterator = iterator.next;
        }
    }
}
