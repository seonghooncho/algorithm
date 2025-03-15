package 네트워크;

import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;


        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                queue.add(i);
                while(!queue.isEmpty()){
                    int cur = queue.poll();
                    for(int j =0; j<n; j++){
                        if(computers[cur][j]==1&&cur!=j&&!visited[j]){
                            visited[j] = true;
                            queue.add(j);
                        }
                    }
                }
                answer++;

            }
        }
        return answer;
    }
}
