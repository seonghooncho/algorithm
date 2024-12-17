package 기능개발;

import java.util.*;

class Solution {
    public Stack<Integer> solution(int[] progresses, int[] speeds) {

        Stack<Integer> stack = new Stack<>();

        int maxDate = 0;
        for(int i =0; i<speeds.length; i++){
            int now = (int)Math.ceil((double)(100-progresses[i])/speeds[i]);

            if(maxDate<now){
                stack.add(1);
                maxDate = now;
            }else{
                stack.add(stack.pop()+1);
                System.out.println(stack.peek());
            }

        }


        return stack;
    }


}
class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[]pro = {95, 90, 99, 99, 80, 99};
        int[] speeds ={1, 1, 1, 1, 1, 1};
        Stack<Integer> queue = solution.solution(pro,speeds);
        System.out.println(queue);
    }
}
