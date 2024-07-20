package 백준.토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class solution {
    public static int N;
    public static int M;
    public static int[][] box;

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }

        bfs();
    }

    static void bfs() {
        int day = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            day = current[2];

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        queue.add(new int[]{nx, ny, day + 1});
                    }
                }
            }
        }

        if (check()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

    static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) return false;
            }
        }
        return true;
    }
}