package 프로그래머스.최고의집합;

import java.util.Arrays;

public class Solution {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }

        int[] answer = new int[n];

        Arrays.fill(answer, s / n);

        for (int i = 0; i < s % n; i++){
            answer[i]++;
        }

        Arrays.sort(answer);

        return answer;
    }
}
