package 백준.개리맨더링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int result = Integer.MAX_VALUE;
    static int N;
    static int[] peoples;
    static boolean[] check;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        peoples = new int[N];
        check = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            peoples[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for(int j = 0; j < count; j++) {
                int adjacencyCount = Integer.parseInt(st.nextToken());
                graph.get(i).add(adjacencyCount - 1);
            }
        }

        subset(0);
        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }

    static void subset(int idx) {
        if(idx == N) {
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();

            for(int i = 0; i < N; i++) {
                if(check[i]) a.add(i);
                else b.add(i);
            }

            if(a.isEmpty() || b.isEmpty()) return;
            if(bfs(a) && bfs(b)) diff();

            return;
        }
        check[idx] = true;
        subset(idx + 1);
        check[idx] = false;
        subset(idx + 1);
    }

    static boolean bfs(List<Integer> list) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[N];
        visited[list.get(0)] = true;
        q.offer(list.get(0));

        int count = 1;
        while (!q.isEmpty()) {
            int current = q.poll();
            for(int i = 0; i < graph.get(current).size(); i++) {
                int y = graph.get(current).get(i);
                if(list.contains(y) && !visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                    count++;
                }
            }
        }

        return count == list.size();
    }

    static void diff() {
        int a = 0, b = 0;
        for(int i = 0; i < N; i++) {
            if(check[i]) a += peoples[i];
            else b += peoples[i];
        }

        result = Math.min(result, Math.abs(a - b));
    }
}
