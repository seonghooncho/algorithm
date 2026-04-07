package 무인도;

import java.util.*;

class Solution {
    public static boolean[][] visited;
    static int mapx;
    static int mapy;
    public List<Integer> solution(String[] maps) {
        mapx = maps[0].length();
        mapy =maps.length;
        visited = new boolean[mapy][mapx];

        List<Integer> result = new ArrayList<>();

        for(int i=0;i<mapy;i++){
            for(int j=0;j<mapx;j++){
                if(maps[i].charAt(j) != 'X'&& visited[i][j]==false){
                    visited[i][j]=true;
                    result.add(bfs(maps,j, i));
                }
            }
        }
        if(result.isEmpty()) result.add(-1);

        result.sort(null);
        return result;

    }

    int bfs(String[] maps, int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        int result=0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            result += (int)maps[poll[1]].charAt(poll[0]) - '0';

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if(nx>=0&& ny>=0&& nx<mapx&& ny<mapy){
                    if(visited[ny][nx]==false && maps[ny].charAt(nx)!='X'){
                        visited[ny][nx]=true;
                        queue.add(new int[]{nx, ny});
                    }
                }

            }
        }
        return result;

    }
}