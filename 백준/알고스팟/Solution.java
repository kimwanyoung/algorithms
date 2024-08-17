package 백준.알고스팟;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    static class Point {
        int x, y, count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static int[][] graph;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] read = br.readLine().split(" ");

        M = Integer.parseInt(read[0]);
        N = Integer.parseInt(read[1]);

        graph = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String[] currentLine = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(currentLine[j]);
            }
        }

        int minCount = bfs();
        System.out.println(minCount);
    }

    static int bfs() {
        PriorityQueue<Point> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.count));
        q.add(new Point(0, 0, 0));
        visited[0][0] = true;

        while(!q.isEmpty()) {
            Point current = q.poll();
            if(current.x == N - 1 && current.y == M - 1) return current.count;

            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(validateRange(nx, ny) && !visited[nx][ny]) {
                    if(graph[nx][ny] == 1) {
                        q.add(new Point(nx, ny, current.count + 1));
                        graph[nx][ny] = 0;
                    } else {
                        q.add(new Point(nx, ny, current.count));
                    }
                    visited[nx][ny] = true;
                }
            }
        }

        return -1;
    }

    static boolean validateRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}
