package 백준.보물섬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static class Land {
        int x, y, len;

        public Land(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }

    static char[][] graph;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int answer, N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(graph[i][j] == 'L') {
                    visited = new boolean[N][M];
                    bfs(new Land(i, j, 0));
                }
            }
        }

        System.out.println(answer);
    }

    static void bfs(Land l) {
        Queue<Land> q = new LinkedList<>();
        q.add(l);
        visited[l.x][l.y] = true;

        while(!q.isEmpty()) {
            Land current = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(validationCheck(nx, ny) && !visited[nx][ny] && graph[nx][ny] == 'L') {
                    visited[nx][ny] = true;
                    q.add(new Land(nx, ny, current.len + 1));
                    answer = Math.max(answer, current.len + 1);
                }
            }
        }
    }

    static boolean validationCheck(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
