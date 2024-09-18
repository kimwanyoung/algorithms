package 프로그래머스.단속카메라;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}));
    }
    public static int solution(int[][] routes) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();

        Arrays.sort(routes, (a, b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        for(int[] route: routes) q.offer(route);

        while (!q.isEmpty()) {
            int[] current = q.poll();

            while(q.peek() != null && current[1] >= q.peek()[0]) {
                q.poll();
            }
            answer++;
        }

        return answer;
    }
}
