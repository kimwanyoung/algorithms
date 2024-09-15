package 프로그래머스.야근지수;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(4, new int[]{4, 3, 3}));
    }
    public static long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int work : works) {
            pq.add(work);
        }

        for(int i = 0; i < n; i++) {
            int work = pq.poll();

            if(work == 0) return 0;

            pq.add(work - 1);
        }

        long answer = 0;
        while(!pq.isEmpty()) {
            answer +=  Math.pow(pq.poll(), 2);
        }
        return answer;
    }
}
