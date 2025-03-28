package 서버증설횟수;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

//players.size() == 시간
//m == 서버당 제한사용자수 (m부터 증설)
//k == 증설서버 유시지간
class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = sol.solution(new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5}, 3,5);
    }
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> serverBuildTimes = new ArrayDeque<>();
        int serverSize = 1;
        for (int i = 0; i < players.length; i++) {//1시 생성 k==5 5시까지
            while (!serverBuildTimes.isEmpty() && serverBuildTimes.peek()+k-1<i){
                serverBuildTimes.poll();
                serverSize--;
            }
            int AvailablePlayer = serverSize*m-1;
            if(players[i] > AvailablePlayer) {
                int overedPlayer = players[i] - AvailablePlayer;

                int haveToBuild = overedPlayer%m==0 ? overedPlayer/m : overedPlayer/m+1;
                for (int j = 0; j < haveToBuild; j++) {
                    serverBuildTimes.add(i);
                    serverSize++;
                    answer++;
                }

            }
        }



        return answer;
    }
}