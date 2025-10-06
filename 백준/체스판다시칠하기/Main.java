import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static boolean arr[][];
    private static int min = 64;
    private static int N;
    private static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        initializeBoard(br);

        findMinRepaint();
        System.out.println(min);
    }

    private static void initializeBoard(BufferedReader br) throws Exception {
        arr = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                if(line.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }
    }

    private static void findMinRepaint() {
        for(int i = 0; i <= N - 8; i++) {
            for(int j = 0; j <= M - 8; j++) {
                checkBoard(i, j);
            }
        }
    }

    private static void checkBoard(int x, int y) {
        int count1 = 0;
        int count2 = 0;

        for(int i = x; i < x + 8; i++) {
            for(int j = y; j < y + 8; j++) {
                if((i + j) % 2 == 0) {
                    if(!arr[i][j]) {
                        count1++;
                    } else {
                        count2++;
                    }
                } else {
                    if(arr[i][j]) {
                        count1++;
                    } else {
                        count2++;
                    }
                }
            }
        }
        min = Math.min(min, Math.min(count1, count2));
    }
}