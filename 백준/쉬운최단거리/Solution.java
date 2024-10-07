package 백준.쉬운최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int n, m;
    static int[][] map;
    static int[][] result;
    static boolean[][] visited;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];

        int startY = 0;
        int startX = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    startY = i;
                    startX = j;
                }
            }
        }

        bfs(startY, startX);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    sb.append(-1).append(" ");
                } else {
                    sb.append(result[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int i, int j) {
        Queue<Pos> q = new LinkedList<>();

        q.offer(new Pos(i, j));
        result[i][j] = 0;
        visited[i][j] = true;

        while(!q.isEmpty()) {
            Pos current = q.poll();

            for(int k = 0; k < 4; k++) {
                int ny = current.y + dy[k];
                int nx = current.x + dx[k];

                if(validate(ny, nx) && map[ny][nx] != 0) {
                    q.offer(new Pos(ny, nx));
                    result[ny][nx] = result[current.y][current.x] + 1;
                    visited[ny][nx] = true;
                }
            }
        }
    }

    static boolean validate(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m && !visited[y][x];
    }

    static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
