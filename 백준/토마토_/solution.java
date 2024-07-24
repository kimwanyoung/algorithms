package 백준.토마토_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class TomatoPosition {
    int x;
    int y;
    int z;

    public TomatoPosition(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class solution {

    static final int[] dy = {1, -1, 0, 0, 0, 0};
    static final int[] dx = {0, 0, -1, 1, 0, 0};
    static final int[] dz = {0, 0, 0, 0, -1, 1};

    static int n;
    static int m;
    static int h;
    static int[][][] box;
    static Queue<TomatoPosition> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[h][m][n];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < n; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k] == 1) {
                        queue.offer(new TomatoPosition(k, j, i));
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        while (!queue.isEmpty()){
            TomatoPosition current = queue.poll();

            for(int i = 0 ; i < 6; i++){
                int next_z = current.z + dz[i];
                int next_y = current.y + dy[i];
                int next_x = current.x + dx[i];

                if(checkRange(next_z, next_y, next_x)){
                    queue.add(new TomatoPosition(next_x, next_y, next_z));
                    box[next_z][next_y][next_x] = box[current.z][current.y][current.x] + 1;
                }
            }
        }
        int result = Integer.MIN_VALUE;

        for(int i = 0; i < h; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < n; k++){
                    if(box[i][j][k] == 0) return -1;
                    result = Math.max(result, box[i][j][k]);
                }
            }
        }

        if(result == 1) return 0;
        else return (result - 1);
    }

    private static boolean checkRange(int z, int y, int x) {
        boolean is_valid_z = z < 0 || z >= h;
        boolean is_valid_y = y < 0 || y >= m;
        boolean is_valid_x = x < 0 || x >= n;

        if(is_valid_x || is_valid_y || is_valid_z) return false;
        return box[z][y][x] == 0;
    }
}
