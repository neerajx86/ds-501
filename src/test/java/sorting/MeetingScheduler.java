package sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/meeting-rooms/description/?envType=problem-list-v2&envId=sorting&difficulty=EASY
 */
public class MeetingScheduler {
    public static boolean canAttendMeetings(int[][] intervals) {
        // sort the array by start time first, then check if end time of i is < i+1
        // if it's not, then the meeting is overlapping
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][1]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testBasic1() {
        int[][] testCase = new int[][]{{0, 30}, {15, 20}, {5, 10}};
        Assertions.assertFalse(canAttendMeetings(testCase));
    }

    @Test
    public void testBasic2() {
        int[][] testCase = new int[][]{{7,10}, {2,4}};
        Assertions.assertTrue(canAttendMeetings(testCase));
    }
}
