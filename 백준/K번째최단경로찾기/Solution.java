package 백준.K번째최단경로찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int n;
    static int m;
    static int k;

    static List<Node>[] graph;
    static Queue<Integer>[] allDistances;

    static class Node implements Comparable<Node>{
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        allDistances = new PriorityQueue[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            allDistances[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, cost));
        }

        dijkstra();

        for (int i = 1; i <= n; i++) {
            if (k == allDistances[i].size()) System.out.println(allDistances[i].peek());
            else System.out.println(-1);
        }
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        allDistances[1].add(0);

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            for (Node next : graph[current.v]) {
                if(allDistances[next.v].size() < k) {
                    allDistances[next.v].add(current.cost + next.cost);
                    pq.add(new Node(next.v, current.cost + next.cost));
                } else if(allDistances[next.v].peek() > current.cost + next.cost) {
                    allDistances[next.v].poll();
                    allDistances[next.v].offer(current.cost + next.cost);
                    pq.add(new Node(next.v, current.cost + next.cost));
                }
            }
        }
    }
}
