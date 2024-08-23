package 백준.파이프옮기기1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] map;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        DFS(1, 2, 0);

        System.out.println(ans);
    }

    public static void DFS(int x, int y, int direction) {
        if (x == N && y == N) {
            ans++;
            return;
        }

        // 가로
        if(direction == 0) {
            if (y + 1 <= N && map[x][y + 1] == 0) {
                DFS(x, y + 1, 0);
            }
        }

        // 세로
        if(direction == 1) {
            if (x + 1 <= N && map[x + 1][y] == 0) {
                DFS(x + 1, y, 1);
            }
        }

        // 대각
        if(direction == 2) {
            if (y + 1 <= N && map[x][y + 1] == 0) {
                DFS(x, y + 1, 0);
            }

            if (x + 1 <= N && map[x + 1][y] == 0) {
                DFS(x + 1, y, 1);
            }
        }

        if (y + 1 <= N && x + 1 <= N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
            DFS(x + 1, y + 1, 2);
        }
    }
}
