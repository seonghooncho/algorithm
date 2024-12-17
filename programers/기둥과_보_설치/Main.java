package 기둥과_보_설치;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] build_frame = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};
        List<int[]> result = s.solution(5, build_frame);
        for (int[] re : result) {
            Arrays.toString(re);
            System.out.print(Arrays.toString(re));
        }
    }
}
