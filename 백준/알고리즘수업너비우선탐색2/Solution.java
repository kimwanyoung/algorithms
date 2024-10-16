package 백준.알고리즘수업너비우선탐색2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int n, m, r;
    static List<Integer>[] graph;
    static int[] visitedOrder;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        visitedOrder = new int[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 0; i <= n; i++) graph[i].sort(Comparator.reverseOrder());

        bfs();

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) sb.append(visitedOrder[i]).append("\n");

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        int count = 1;

        q.offer(r);
        visited[r] = true;
        visitedOrder[r] = count++;

        while (!q.isEmpty()) {
            int node = q.poll();

            for(int nextNode : graph[node]) {
                if(!visited[nextNode]) {
                    q.offer(nextNode);
                    visited[nextNode] = true;
                    visitedOrder[nextNode] = count++;
                }
            }
        }
    }
}
