package 백준._222폴링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. 입력을 받는다.
        // 2. 입력 받은 값을 기준으로 2차원 배열을 생성한다.
        // 3. 입력받은 n이 2보다 크다면, 절반씩 나눠 4개의 배열로 자른다.
        // 4. 각 배열을 재귀적으로 탐색한다.
        // 5. 마지막으로 남은 2x2배열에서 2번째로 큰 수 반환

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        System.out.println(divide(arr, n, 0, 0));
    }

    private static int divide(int[][] arr, int n, int x, int y) {
        if (n == 2) {
            int[] temp = new int[4];
            temp[0] = arr[x][y];
            temp[1] = arr[x][y + 1];
            temp[2] = arr[x + 1][y];
            temp[3] = arr[x + 1][y + 1];

            Arrays.sort(temp);
            return temp[2];
        }

        int size = n / 2;
        int a = divide(arr, size, x, y);
        int b = divide(arr, size, x, y + size);
        int c = divide(arr, size, x + size, y);
        int d = divide(arr, size, x + size, y + size);

        int[] temp = new int[]{a, b, c, d};
        Arrays.sort(temp);
        return temp[2];
    }
}
