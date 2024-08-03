package 백준.영역구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};
    static int N;
    static int M;
    static int K;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int bottom_x = Integer.parseInt(st.nextToken());
            int bottom_y = Integer.parseInt(st.nextToken());
            int top_x = Integer.parseInt(st.nextToken());
            int top_y = Integer.parseInt(st.nextToken());

            for(int j = bottom_x; j < top_x; j++) {
                for(int k = bottom_y; k < top_y; k++) {
                    visited[k][j] = true;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j]) {
                    int area = bfs(i, j);
                    result.add(area);
                }
            }
        }

        result.sort(Comparator.naturalOrder());

        String allAreas = result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(result.size());
        System.out.println(allAreas);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        int area = 0;
        visited[x][y] = false;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int next_x = current[0] + dx[i];
                int next_y = current[1] + dy[i];

                if(isValidRange(next_x, next_y) && !visited[next_x][next_y]) {
                    area += 1;
                    queue.add(new int[]{next_x, next_y});
                    visited[next_x][next_y] = true;
                }
            }
        }

        if(area == 0) area += 1;
        return area;
    }

    private static boolean isValidRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
