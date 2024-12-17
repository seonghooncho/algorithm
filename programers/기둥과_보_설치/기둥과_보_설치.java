package 기둥과_보_설치;

import java.util.*;

class Solution {
    public static int[][] pillarMap;//0:비어있음, 1: 있음;
    public static int[][] boMap;//0:비어있음, 1: 있음;
    public static int n;

    public static int checkPillarIdx(int x, int y) {
        if (x < 0 || y < 0 || x >= n + 1 || y >= n) {
            return 0;
        }
        return 1;
    }

    public static int checkBoIdx(int x, int y) {
        if (x < 0 || y <= 0 || x >= n || y >= n + 1) {
            return 0;
        }
        return 1;
    }

    public static int isPillar(int x, int y) {
        if (checkPillarIdx(x, y) == 1 && pillarMap[x][y] == 1) {
            return 1;
        }
        return 0;
    }

    public static int isBo(int x, int y) {
        if (checkBoIdx(x, y) == 1 && boMap[x][y] == 1) {
            return 1;
        }
        return 0;
    }

    public static int canPillar(int x, int y) {
        if (y == 0 || isPillar(x, y - 1) == 1 || isBo(x - 1, y) == 1 || isBo(x, y) == 1) {
            return 1;//조건 1에 해당
        }
        return 0;

    }

    public static int canBo(int x, int y) {
        if (isPillar(x, y - 1) == 1 || isPillar(x + 1, y - 1) == 1 || (isBo(x - 1, y) == 1 && isBo(x + 1, y) == 1)) {
            return 1;//조건 2에 해당
        }
        return 0;
    }

    public static int buildPillar(int x, int y) {
        if (canPillar(x, y) == 1) {
            pillarMap[x][y] = 1;
            return 1;
        }
        return 0;
    }

    public static int breakPillar(int x, int y) {
        pillarMap[x][y] = 0;
        if (isBo(x, y + 1) == 1 && canBo(x, y + 1) == 0) {
            pillarMap[x][y] = 1;
            return 0;
        } else if (isBo(x - 1, y + 1) == 1 && canBo(x - 1, y + 1) == 0) {
            pillarMap[x][y] = 1;
            return 0;
        } else if (isPillar(x, y + 1) == 1 && canPillar(x, y + 1) == 0) {
            pillarMap[x][y] = 1;
            return 0;
        }
        return 1;
    }

    public static int buildBo(int x, int y) {
        if (canBo(x, y) == 1) {
            boMap[x][y] = 1;
            return 1;
        }
        return 0;
    }

    public static int breakBo(int x, int y) {
        boMap[x][y] = 0;
        if (isBo(x + 1, y) == 1 && canBo(x + 1, y) == 0) {
            pillarMap[x][y] = 1;
            return 0;
        } else if (isBo(x - 1, y) == 1 && canBo(x - 1, y) == 0) {
            pillarMap[x][y] = 1;
            return 0;
        } else if (isPillar(x, y) == 1 && canPillar(x, y) == 0) {
            pillarMap[x][y] = 1;
            return 0;
        } else if (isPillar(x + 1, y) == 1 && canPillar(x + 1, y) == 0) {
            pillarMap[x][y] = 1;
            return 0;
        }
        return 1;
    }

    public static int findRemoveIdx(int a, int b, int c, List<int[]> list) {
        for (int i = 0; i < list.size(); i++) {
            int[] entity = list.get(i);
            if (entity[0] == a && entity[1] == b && entity[2] == c) {
                return i;
            }
        }return -1;
    }
    public List<int[]> solution(int n, int[][] build_frame) {
        List<int[]> resultList = new LinkedList<>();
        this.n = n;
        this.pillarMap = new int[n+1][n+1];
        this.boMap = new int[n+1][n+1];
        for(int[] input: build_frame){
            if(input[2]==0&&checkPillarIdx(input[0],input[1])==1){
                if(input[3]==0){
                    if(breakPillar(input[0],input[1])==1){
                        int deleteIdx = findRemoveIdx(input[0],input[1],input[2],resultList);
                        resultList.remove(deleteIdx);
                    }
                }else if(input[3]==1){
                    if(buildPillar(input[0],input[1])==1){
                        resultList.add(new int[]{input[0],input[1],input[2]});
                    }
                }
            }else if(input[2]==1&&checkBoIdx(input[0],input[1])==1){
                if(input[3]==0){
                    if(breakBo(input[0],input[1])==1){
                        int deleteIdx = findRemoveIdx(input[0],input[1],input[2],resultList);
                        resultList.remove(deleteIdx);
                    }
                }else if(input[3]==1){
                    if(buildBo(input[0],input[1])==1){
                        resultList.add(new int[]{input[0],input[1],input[2]});
                    }
                }
            }
        }resultList.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
        return resultList;
    }


}
