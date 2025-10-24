package 백준.죽음의게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int participants = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] students = new int[participants];
        boolean[] visited = new boolean[participants];
        for(int i = 0; i < participants; i++) {
            students[i] = Integer.parseInt(br.readLine());
        }

        int depth = 0;
        int current = 0;
        while(!visited[current]) {
            if(current == target) {
                System.out.println(depth);
                return;
            }

            visited[current] = true;
            current = students[current];
            depth++;
        }

        System.out.println(-1);
    }
}
