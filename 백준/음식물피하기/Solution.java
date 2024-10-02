package 백준.음식물피하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;

    static int totalCount = 0;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = 1;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(totalCount);
    }

    public static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{r, c});
        visited[r][c] = true;

        int count = 1;
        while (!q.isEmpty()) {
            int[] current = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = current[0] + dy[i];
                int nextC = current[1] + dx[i];

                if(isValid(nextR, nextC) && !visited[nextR][nextC]) {
                    if(map[nextR][nextC] == 1) {
                        visited[nextR][nextC] = true;
                        q.offer(new int[]{nextR, nextC});
                        count++;
                    }
                }
            }
        }

        totalCount = Math.max(totalCount, count);
    }

    private static boolean isValid(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}
