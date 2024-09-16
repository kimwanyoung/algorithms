package 프로그래머스.숫자게임;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 2, 2, 2}, new int[]{1, 1, 1, 1}));
    }

    public static int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueueA = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> priorityQueueB = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            priorityQueueA.offer(A[i]);
            priorityQueueB.offer(B[i]);
        }

        for (int i = 0; i < A.length; i++) {
            if(priorityQueueA.peek() < priorityQueueB.peek()) {
                priorityQueueA.poll();
                priorityQueueB.poll();
                answer++;
            } else {
                priorityQueueA.poll();
            }
        }

        return answer;
    }
}
