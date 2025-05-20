package 프로그래머스.입국심사;

public class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = (long) n * times[times.length - 1];
        long answer = Long.MAX_VALUE;

        while (left <= right) {
            long mid = (left + right) / 2;
            long total = 0;

            for (int time : times) {
                total += mid / time;
            }

            if (total >= n) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
    
}
