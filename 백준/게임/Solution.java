package 백준.게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DFS + DP
// 게임 문제
public class Solution {
    static int n, m, max; // n : 세로, m : 가로
    static boolean isCycle = false;
    static int[][] dp;
    static char[][] map;
    static boolean[][] visited;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n][m];
        map = new char[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }

        visited[0][0] = true;
        dfs(0, 0, 1);

        if(isCycle) {
            System.out.println(-1);
        } else {
            System.out.println(max);
        }
    }

    static void dfs(int x, int y, int moveCount) {
        int moveSquareCount = Character.getNumericValue(map[y][x]);
        dp[y][x] = moveCount;

        if(moveCount > max) max = moveCount;

        for(int i = 0; i < moveX.length; i++) {
            int nextX = x + (moveSquareCount * moveX[i]);
            int nextY = y + (moveSquareCount * moveY[i]);

            if(nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) continue;

            if(map[nextY][nextX] == 'H') continue;

            if(moveCount < dp[nextY][nextX]) continue;

            if(visited[nextY][nextX]) {
                isCycle = true;
                return;
            }

            visited[nextY][nextX] = true;
            dfs(nextX, nextY, moveCount + 1);
            visited[nextY][nextX] = false;

        }
    }
}