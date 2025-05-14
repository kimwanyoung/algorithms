package 백준.스타트와링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[] visited;
    static int n;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 0);
        System.out.println(min);
    }

    static void dfs(int idx, int depth) {
        if(depth == n / 2) {
            calculate();
            return;
        }

        for(int i = idx; i <= n; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    static void calculate() {
        int start = 0;
        int link = 0;

        for(int i = 1; i < n; i++) {
            for(int j = i + 1; j <= n; j++) {
                if(visited[i] && visited[j]) {
                    start += map[i][j];
                    start += map[j][i];
                } else if(!visited[i] && !visited[j]) {
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }

        min = Math.min(min, Math.abs(start - link));
    }
}
