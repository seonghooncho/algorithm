package 완주하지_못한선수;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> nameList = new HashMap<>();
        for(String member : participant) {
            nameList.put(member, nameList.getOrDefault(member, 0)+1);
        }
        for(String member : completion) {
            nameList.put(member, nameList.getOrDefault(member,0)-1);
        }
        for(String member : nameList.keySet()) {
            if(nameList.get(member)>0) {
                return member;
            }
        }
        return "";
    }
}