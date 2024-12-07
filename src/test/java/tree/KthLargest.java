package tree;


// https://leetcode.com/problems/kth-largest-element-in-a-stream/description/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * There are two ways two solve this:
 * <p>
 * 1. Sort the array at the beginning and whenever a new value is added perform the binary search and insert the new
 * element in the array. This works because
 * 2. Use Min Heap (Priority queue), this works because value of k is fixed hence we can maintain only k elements
 * and the kth element would essentially be the smallest element if the elements are sorted in natural order (ascending)
 */
public class KthLargest {

    private final int[] nums;

    private final int k;

    private final List<Integer> stream;

    public KthLargest(int k, int[] nums) {
        this.nums = nums;
        this.stream = new ArrayList<>();
        this.k = k;
    }

    private void KthLargestMinHeap() {
        PriorityQueue<Integer> stream = new PriorityQueue<>();
        for (int num : nums) {
            if (stream.size() < k || (stream.size() > 0 && stream.peek() < num)) {
                stream.add(num);
                if (stream.size() > k) {
                    stream.remove();
                }
            }
        }
    }

    private void KthLargestArray() {
        for (int num : nums) {
            stream.add(num);
        }
        Collections.sort(stream);
    }

    private int addArray(int val) {
        int position = midPoint(val);
        stream.add(position, val);
        return stream.get(stream.size() - k);
    }

    private int midPoint(int val) {
        int left = 0, right = stream.size() - 1, mid = (left) + (right / 2), valAtPoint = 0;

        while (left <= right) {
            valAtPoint = stream.get(mid);
            if (valAtPoint == val)
                return mid;

            if (valAtPoint > val) {
                right = mid - 1;
            } else {
                left = mid - 1;
            }
            mid = left + (right / 2);
        }

        return left;
    }

    public int add(int val) {
        return 0;
    }

}
