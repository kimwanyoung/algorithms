package 백준.소문난칠공주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    static class Info {
        int y, x;

        public Info(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static char[][] map = new char[5][5];
    static boolean[] totalVisited = new boolean[25];
    static int result = 0;

    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            char[] line = br.readLine().toCharArray();
            map[i] = line;
        }

        search(0, 0, 0);
        System.out.println(result);
    }

    static void search(int idx, int depth, int yCnt) {

        if (yCnt >= 4) {
            return;
        }

        if (depth == 7) {
            if (bfs((idx - 1) / 5, (idx - 1) % 5)) {
                result++;
            }
            return;
        }

        for (int i = idx; i < 25; i++) {
            totalVisited[i] = true;
            if (map[i / 5][i % 5] == 'Y') {
                search(i + 1, depth + 1, yCnt + 1);
            } else {
                search(i + 1, depth + 1, yCnt);
            }
            totalVisited[i] = false;
        }
    }

    static boolean bfs(int r, int c) {
        Queue<Info> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        visited[r][c] = true;
        queue.offer(new Info(r, c));
        int cnt = 1;
        while (!queue.isEmpty()) {
            Info cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                int nxt = ny * 5 + nx;
                if (validateRange(ny, nx) && !visited[ny][nx] && totalVisited[nxt]) {
                    visited[ny][nx] = true;
                    queue.offer(new Info(ny, nx));
                    cnt++;
                }
            }
        }
        return cnt == 7;
    }

    static boolean validateRange(int y, int x) {
        return 0 <= y && y < 5 && 0 <= x && x < 5;
    }
}
