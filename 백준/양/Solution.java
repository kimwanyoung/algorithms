package 백준.양;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int r, c;
    static int sheep = 0;
    static int wolf = 0;
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = row[j];
                if (row[j] == 'o') sheep++;
                else if (row[j] == 'v') wolf++;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j] == 'v' && !visited[i][j]) {
                    YardState state = bfs(i, j, 1, 0);
                    if(state.isAllSheepDead()) sheep -= state.sheep;
                    else wolf -= state.wolf;
                }
                if(map[i][j] == 'o' && !visited[i][j]) {
                    YardState state = bfs(i, j, 0, 1);
                    if(state.isAllSheepDead()) sheep -= state.sheep;
                    else wolf -= state.wolf;
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    public static YardState bfs(int y, int x, int cw, int cs) {
        int currentWolf = cw;
        int currentSheep = cs;

        Queue<YardPos> q = new LinkedList<>();

        q.offer(new YardPos(y, x));
        visited[y][x] = true;

        while(!q.isEmpty()) {
            YardPos current = q.poll();

            for(int i = 0; i < 4; i++) {
                int nextPosY = current.posY + dy[i];
                int nextPosX = current.posX + dx[i];

                if(isValid(y, x) && !visited[nextPosY][nextPosX] && map[nextPosY][nextPosX] != '#') {
                    if(map[nextPosY][nextPosX] == 'v') currentWolf++;
                    if(map[nextPosY][nextPosX] == 'o') currentSheep++;

                    visited[nextPosY][nextPosX] = true;
                    q.offer(new YardPos(nextPosY, nextPosX));
                }
            }
        }

        return new YardState(currentWolf, currentSheep);
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < r && 0 <= x && x < c;
    }

    static class YardPos {
        private int posY;
        private int posX;

        public YardPos(int posY, int posX) {
            this.posY = posY;
            this.posX = posX;
        }
    }

    static class YardState {
        private int wolf;
        private int sheep;

        public YardState(int wolf, int sheep) {
            this.wolf = wolf;
            this.sheep = sheep;
        }

        public boolean isAllSheepDead() {
            return sheep <= wolf;
        }
    }
}
