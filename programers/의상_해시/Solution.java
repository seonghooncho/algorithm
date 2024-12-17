package 의상_해시;

import java.util.HashMap;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] c : clothes){
            map.put(c[1],map.containsKey(c[1])?map.get(c[1])+1:1);
        }
        int combination=1;
        for(String s : map.keySet()){
            //각 항목의 개수를 가져옴
            combination *= (map.get(s)+1);
        }
        return combination-1;
    }
}