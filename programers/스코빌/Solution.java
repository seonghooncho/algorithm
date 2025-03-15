package 스코빌;

import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }
        int prevSco = 0;
//        while((prevSco = pq.poll())<K) {
//            if(pq.size()>0) pq.add(prevSco+pq.poll()*2);
//            answer++;
//        }
        while (pq.peek() < K) {
            if (pq.size() < 2) {
                return -1;
            }
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first + second * 2);
            answer++;
        }
        return answer;
    }
}