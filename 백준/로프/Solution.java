package 백준.로프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] weights = new int[N];
        for(int i = 0; i < N; i++) {
            int maxWeight = Integer.parseInt(br.readLine());
            weights[i] = maxWeight;
        }

        Arrays.sort(weights);

        int max = 0;
        for(int i = 0; i < N; i++) {
            int sum = 0;
            for(int j = i; j < N; j++) {
                sum += weights[i];
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
