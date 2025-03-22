package 게임_맵_최단거리;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//class Solution {
//    public int solution(int[][] maps) {
//
//        Queue<int[]> queue = new LinkedList<>();
//        //인덱스 0,1은 현재인덱스, 2,3은 과거 인덱스
//        queue.add(new int[]{0,0,0,0,0});
//
//        int n= maps[0].length;
//        int m= maps.length;
//
//        int min=Integer.MAX_VALUE;
//
//        while (!queue.isEmpty()) {
//            int[] last = queue.poll();
//            if(last[0]==n&&last[1]==m) min=last[4];
//
//            if((last[0]-1>=0)
//                    && maps[last[0]-1][last[1]] == 1
//                    && !(last[0]-1==last[2]&&last[1]==last[3])){
//                queue.add(new int[]{last[0]-1, last[1], last[0], last[1], last[4]+1});
//            }
//            if((last[1]-1>=0)
//                    && maps[last[0]][last[1]-1] == 1
//                    && !(last[0]==last[2]&&last[1]-1==last[3])){
//                queue.add(new int[]{last[0], last[1]-1, last[0], last[1], last[4]+1});
//            }
//            if((last[0]+1<n)
//                    && maps[last[0]+1][last[1]] == 1
//                    && !(last[0]+1==last[2]&&last[1]==last[3])){
//                queue.add(new int[]{last[0]+1, last[1], last[0], last[1], last[4]+1});
//            }
//            if((last[1]+1<m)
//                    && maps[last[0]][last[1]+1] == 1
//                    && !(last[0]==last[2]&&last[1]+1==last[3])){
//                queue.add(new int[]{last[0], last[1]+1, last[0], last[1], last[4]+1});
//            }
//        }
//
//        return min;
//
//    }
//
//}
//


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int n = maps[0].length; // 열 (x 좌표)
        int m = maps.length; // 행 (y 좌표)

        int[] dx = {1, -1, 0, 0}; // 우, 좌, 하, 상
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        queue.add(new int[]{0, 0, 1}); // 시작점 (0,0)에서 이동 거리 1
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            // 목표 지점 도착 시 최단 거리 반환
            if (x == m - 1 && y == n - 1) {
                return distance;
            }

            // 네 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵을 벗어나지 않고, 벽이 아니며, 방문하지 않은 곳이라면 이동
                if (nx >= 0 && ny >= 0 && nx < m && ny < n
                        && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny, distance + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1; // 상대팀 진영에 도달할 수 없는 경우
    }
}
