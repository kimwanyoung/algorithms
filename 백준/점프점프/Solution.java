package 백준.점프점프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        graph = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }

        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int pos = current[0];
            int count = current[1];

            if(pos == N - 1) return count;
            if(!visited[pos] && pos < N) {
                for(int i = 1; i <= graph[pos]; i++) {
                    q.offer(new int[]{pos + i, count + 1});
                    visited[pos] = true;
                }
            }
        }

        return -1;
    }
}
