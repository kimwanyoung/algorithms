package 백준.구슬찾기;

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
        int[][] graph = new int[n + 1][n + 1];

        for(int i = 0; i <= n; i++) Arrays.fill(graph[i], Integer.MAX_VALUE);
        for(int i = 1; i <= n; i++) graph[i][i] = 0;
        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = -1;
        }

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    if (graph[b][k] != Integer.MAX_VALUE && graph[a][k] == graph[k][b]) {
                        graph[a][b] = graph[a][k];
                    }
                }
            }
        }

        int answer = 0;
        int half = (n + 1) / 2;
        for(int i = 1; i <= n; i++) {
            int over = 0;
            int less = 0;
            for(int j = 1; j <= n; j++) {
                if(graph[i][j] == 1) over++;
                if(graph[i][j] == -1) less++;
            }

            if(over >= half || less >= half) answer++;
        }

        System.out.println(answer);
    }
}
