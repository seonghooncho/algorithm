package 단어변환;

import java.util.LinkedList;
import java.util.Queue;

//bfs
class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String > queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        queue.add(begin);
        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                String cur = queue.poll();
                if(cur.equals(target)) return depth;
                for(int j=0; j<words.length; j++) {
                    if(!visited[j]&&canTransform(cur,words[j])) {
                        visited[j] = true;
                        queue.add(words[j]);
                    }
                }
            }
            depth++;

        }
        return 0;
    }

    boolean canTransform(String from, String to) {
        int differentCount = 0;
        for(int i=0; i<from.length(); i++) {
            if(from.charAt(i) != to.charAt(i)) {
                differentCount++;
            }if (differentCount>1) return false;
        }
        return differentCount==1;
    }
}





//dfs

//class Solution {
//    int min = Integer.MAX_VALUE;
//
//    public int solution(String begin, String target, String[] words) {
//        boolean[] visited = new boolean[words.length];
//        dfs(begin, target, words, visited, 0);
//        return min == Integer.MAX_VALUE ? 0 : min;
//    }
//
//    void dfs(String curWord, String target, String[] words, boolean[] visited, int count) {
//        if (curWord.equals(target)) {
//            min = Math.min(min, count);
//            return;
//        }
//        for (int i = 0; i < words.length; i++) {
//            if (!visited[i] && canTrans(curWord, words[i])) {
//                visited[i] = true;
//                dfs(words[i], target, words, visited, count + 1);
//                visited[i] = false; // 상태 복원
//            }
//        }
//    }
//
//    boolean canTrans(String from, String to) {
//        int diffCount = 0;
//        for (int i = 0; i < from.length(); i++) {
//            if (from.charAt(i) != to.charAt(i)) {
//                diffCount++;
//                if (diffCount > 1) {
//                    return false;
//                }
//            }
//        }
//        return diffCount == 1;
//    }
//}
