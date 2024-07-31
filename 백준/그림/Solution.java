package 백준.그림;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static int m;
    static int count = 0;
    static int max = 0;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] graph;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = false;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(graph[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(max, bfs(i, j));
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    private static int bfs(int y, int x) {
        int area = 1;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int next_y = current[0] + dy[i];
                int next_x = current[1] + dx[i];

                if(validateRange(next_y, next_x) && !visited[next_y][next_x] && graph[next_y][next_x] == 1){
                    area++;
                    queue.add(new int[]{next_y, next_x});
                    visited[next_y][next_x] = true;
                }
            }
        }

        return area;
    }

    private static boolean validateRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
