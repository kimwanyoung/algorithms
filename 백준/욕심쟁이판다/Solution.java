package 백준.욕심쟁이판다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static int[][] graph;
    static int[][] dp;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = 1;
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                result = Math.max(result, dfs(i, j));
            }
        }

        System.out.println(result);
    }

    static int dfs(int y, int x) {
        if(dp[y][x] != 1) {
            return dp[y][x];
        }

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

            if(graph[ny][nx] > graph[y][x]) {
                dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
            }
        }

        return dp[y][x];
    }
}
