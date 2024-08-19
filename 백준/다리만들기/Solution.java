package 백준.다리만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int[][] map;
    static boolean[][] check;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        check = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        identifyIsland();

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] > 0) {
                    check = new boolean[n][n];
                    int result = bfs(i, j);

                    if(result != -1) min = Math.min(min, result);
                }
            }
        }

        System.out.println(min - 1);
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        check[x][y] = true;

        int currentIsland = map[x][y];
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];
            int bridgeCount = current[2];

            if(map[cx][cy] != 0 && map[cx][cy] != currentIsland) return bridgeCount;

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(validateRange(nx, ny) && map[nx][ny] != currentIsland && !check[nx][ny]) {
                    q.add(new int[]{nx, ny, bridgeCount + 1});
                    check[nx][ny] = true;
                }
            }
        }

        return -1;
    }

    static void identifyIsland() {
        int index = 2;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!check[i][j] && map[i][j] > 0) {
                    q.add(new int[]{i, j});
                    check[i][j] = true;
                    map[i][j] = index;

                    while(!q.isEmpty()) {
                        int[] current = q.poll();

                        for(int k = 0; k < 4; k++) {
                            int nx = current[0] + dx[k];
                            int ny = current[1] + dy[k];

                            if(validateRange(nx, ny) && map[nx][ny] == 1 && !check[nx][ny]) {
                                q.add(new int[]{nx, ny});
                                check[nx][ny] = true;
                                map[nx][ny] = index;
                            }
                        }
                    }
                    index++;
                }
            }
        }
    }

    static boolean validateRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}
