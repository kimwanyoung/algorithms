package 백준.역사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(check[i][k] && check[k][j]) {
                        check[i][j] = true;
                    }
                }
            }
        }

        int s = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s; i++) {
            String[] element = br.readLine().split(" ");
            int a = Integer.parseInt(element[0]) - 1;
            int b = Integer.parseInt(element[1]) - 1;

            if(check[a][b]) sb.append(-1 + " ");
            else if(check[b][a]) sb.append(1 + " ");
            else sb.append(0 + " ");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
