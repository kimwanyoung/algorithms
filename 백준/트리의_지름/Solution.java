package 백준.트리의_지름;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static int max = 0;
    static int node;
    static int v;
    static boolean[] visited;
    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[v + 1];
        for(int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            while(true) {
                int b = Integer.parseInt(st.nextToken());
                if(b == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                graph[a].add(new Node(b, dist));
            }
        }

        visited = new boolean[v + 1];
        dfs(1, 0);

        visited = new boolean[v + 1];
        dfs(node, 0);

        System.out.println(max);
    }

    private static void dfs(int x, int dist) {
        if(dist > max) {
            max = dist;
            node = x;
        }
        visited[x] = true;

        for(int i = 0; i < graph[x].size(); i++) {
            Node n = graph[x].get(i);
            if(!visited[n.e]) {
                dfs(n.e, n.cost + dist);
            }
        }
    }

    public static class Node {
        int e;
        int cost;

        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }
}
