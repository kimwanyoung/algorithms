package 백준.N과M_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static int[] copy;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        copy = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0, 0);
    }

    static void dfs(int idx, int depth) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                System.out.print(copy[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = idx; i < N; i++) {
            copy[depth] = arr[i];
            dfs(i, depth + 1);
        }
    }
    
}
