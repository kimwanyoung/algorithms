package 백준.ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int n, m;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 0; i < n; i++) {
            if(answer == 0) {
                dfs(i, 1);
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int pos, int count) {
        if(count == 5){
            answer = 1;
            return;
        }

        visited[pos] = true;
        for(int nextPos : graph[pos]) {
            if(!visited[nextPos]) {
                dfs(nextPos, count + 1);
                visited[pos] = false;
            }
        }
    }
}
