package 두큐의합;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<Integer> queue;

    public int solution(int[] queue1, int[] queue2) {
        queue = new ArrayList<>();
        for (int i = 0; i < queue1.length; i++) {
            queue.add(queue1[i]);
        }

        for (int i = 0; i < queue2.length; i++) {
            queue.add(queue2[i]);
        }
        Long queue1Sum = (long) Arrays.stream(queue1).sum();
        Long queue2Sum = (long) Arrays.stream(queue2).sum();
        Long totalSum = queue1Sum + queue2Sum;
        int queueLen = queue1.length;
        int left = 0;
        int right = queueLen;
        if (totalSum % 2 != 0) {
            return -1;
        }
        int result = 0;
        while (left < queueLen * 2 && right < queueLen * 2) {
            if (totalSum / 2 == queue1Sum) {
                return result;
            }
            if (totalSum / 2 > queue1Sum) {
                queue1Sum += queue.get(right % queue.size());
                right++;
            } else {
                queue1Sum -= queue.get(left % queue.size());
                left++;
            }
            result++;
        }
        return -1;

    }
}
