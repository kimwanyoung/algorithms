package 프로그래머스.기지국설치;

public class Solution {

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int stationIdx = 0;
        int position = 1;

        while (position <= n) {
            if (stationIdx < stations.length && position >= stations[stationIdx] - w) {
                position = stations[stationIdx] + w + 1;
                stationIdx++;
            } else {
                answer += 1;
                position += (w * 2) + 1;
            }
        }
        return answer;
    }
}
