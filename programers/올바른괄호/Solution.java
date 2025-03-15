package 올바른괄호;

import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i =0; i<s.length(); i++){
            stack.push(s.charAt(i));
        }
        int open=0;
        int close=0;
        while(!stack.isEmpty()&&(close>=open)){//)로 끝나는지는 제어가능
            char c = stack.peek();
            if(c=='(') open++;
            else if(c==')') close++;

            stack.pop();
        }

        return close==open&&stack.isEmpty();
    }
}

class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();

        boolean queue = solution.solution("()()");
        System.out.println(queue);
    }
}