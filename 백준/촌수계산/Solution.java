package 백준.촌수계산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());
        list = new ArrayList[total + 1];
        visited = new boolean[total + 1];
        for (int i = 1; i < total + 1; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(br.readLine());

        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        System.out.println(bfs(n, m));
    }

    private static int bfs(int current, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{current, 0});
        visited[current] = true;

        while (!queue.isEmpty()) {
            int[] currentState = queue.poll();
            int now = currentState[0];
            int relations = currentState[1];
            if (now == target) return relations;

            for (int i = 0; i < list[now].size(); i++) {
                int next = list[now].get(i);
                if (!visited[next]) {
                    queue.offer(new int[]{next, relations + 1});
                    visited[next] = true;
                }
            }
        }
        return -1;
    }
}
