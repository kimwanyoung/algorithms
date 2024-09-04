package 백준.치즈2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * - 0, 0부터 bfs 수행
 * - 범위를 벗어나지 않으면서 다음 위치에 치즈가 존재하면 graph[ny][nx] += 1
 * - 그렇지 않다면(치즈가 아니라면), queue에 넣어주고 방문처리
 * - 모든 치즈가 녹을 때까지 bfs수행 answer++;
 * - flag가 true가 아니면 계속해서 현재 치즈 개수 업데이트. 결국 마지막에 업데이트 되는 치즈가 한시간 전 치즈 개수
 * - 다 녹았다면 반복문 탈출 answer 출력
 */
public class Solution {

    static int answer = 0;
    static int lastCheese = 0;
    static int n;
    static int m;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx ={1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            bfs();
            if(melt()) {
                System.out.println(answer);
                System.out.println(lastCheese);
                break;
            } else {
                answer++;
            }
        }
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited = new boolean[n][m];
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int cy = current[0];
            int cx = current[1];

            for(int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if(isValidRange(ny, nx) && !visited[ny][nx]) {
                    if(graph[ny][nx] >= 1) graph[ny][nx] += 1;
                    else {
                        q.offer(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }

    static boolean isValidRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }

    static boolean melt() {
        int cheeseCount = 0;
        boolean flag = true;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(graph[i][j] >= 2) {
                    cheeseCount++;
                    graph[i][j] = 0;
                    flag = false;
                }
            }
        }
        if(!flag) lastCheese = cheeseCount;
        return flag;
    }
}
