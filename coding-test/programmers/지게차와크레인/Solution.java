package 지게차와크레인;

import java.util.*;

class Solution {
    static int[][] dires = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    char[][] map;
    int storageH;
    int storageW;

    public int solution(String[] storage, String[] requests) {
        storageH = storage.length;
        storageW = storage[0].length();
        map = new char[storageH + 2][storageW + 2];

        int deleteCnt = 0;

        for (int i = 1; i < storageH + 2; i++) {
            Arrays.fill(map[i], '-');
        }

        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage[i].length(); j++) {
                map[i + 1][j + 1] = storage[i].charAt(j);
            }
        }

        for (String request : requests) {
            deleteCnt += deleteContainer(request);
        }
        return storageH * storageW - deleteCnt;
    }

    int deleteContainer(String request) {
        int deleteCnt = 0;

        if (request.length() == 2) {
            for (int i = 1; i < storageH + 1; i++) {
                for (int j = 1; j < storageW + 1; j++) {
                    if (request.charAt(0) == map[i][j]) {
                        map[i][j] = '-';
                        deleteCnt++;
                    }
                }
            }
        } else {
            deleteCnt = bfs(request.charAt(0));
        }

        return deleteCnt;
    }

    int bfs(char r) {
        int deleteCnt = 0;

        boolean[][] visited = new boolean[storageH + 2][storageW + 2];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nh = cur[0] + dires[i][0];
                int nw = cur[1] + dires[i][1];
                if (canGo(nh, nw) && !visited[nh][nw] && (map[nh][nw] == '-' || map[nh][nw] == r)) {
                    if (map[nh][nw] == '-') {
                        visited[nh][nw] = true;
                        q.add(new int[]{nh, nw});
                    } else if (map[nh][nw] == r) {
                        deleteCnt++;
                        map[nh][nw] = '-';
                        visited[nh][nw] = true;
                    }
                }
            }
        }
        return deleteCnt;
    }

    boolean canGo(int h, int w) {
        return h >= 0 && w >= 0 && h < storageH + 2 && w < storageW + 2;
    }
}
