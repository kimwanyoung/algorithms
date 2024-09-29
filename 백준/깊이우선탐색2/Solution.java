package 백준.깊이우선탐색2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int n, m;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] sequences;
    static int seq = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        sequences = new int[n + 1];

        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            graph[i].sort(Comparator.reverseOrder());
        }

        dfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(sequences[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int r) {
        visited[r] = true;
        sequences[r] = seq;
        for (int next : graph[r]) {
            if (!visited[next]) {
                seq++;
                dfs(next);
            }
        }
    }
}
