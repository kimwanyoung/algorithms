package 백준.숫자판점프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static String[][] map = new String[5][5];
    static Set<String> result = new HashSet<>();

    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = st.nextToken();
            }
        }

        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(0, i, j, map[i][j]);
            }
        }

        System.out.println(result.size());
    }

    private static void dfs(int depth, int y, int x, String current) {
        if(depth == 5) {
            result.add(current);
            return;
        }

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(0 <= ny && ny < 5 && 0 <= nx && nx < 5) {
                dfs(depth + 1, ny, nx, current + map[ny][nx]);
            }
        }
    }
}
