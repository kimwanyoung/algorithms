package 백준.키순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] check = new boolean[n][n];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            check[a][b] = true;
        }

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(check[i][k] && check[k][j]) {
                        check[i][j] = true;
                    }
                }
            }
        }

        int[] count = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(check[i][j] || check[j][i]) count[i]++;
            }
        }

        int result = 0;
        for(int number: count) {
            if(number == n - 1) result++;
        }

        System.out.println(Arrays.toString(count));
        System.out.println(result);
    }
}
