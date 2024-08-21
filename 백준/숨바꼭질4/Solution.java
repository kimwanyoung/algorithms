package 백준.숨바꼭질4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int n, m;
    static int[] moveMethod = {-1, 1, 2};
    static int[] graph = new int[100_001];
    static boolean[] visited = new boolean[100_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        MoveInfo moveInfo = bfs();

        Stack<Integer> stack = new Stack<>();
        stack.push(m);
        int idx = m;
        while(idx != n) {
            stack.push(graph[idx]);
            idx = graph[idx];
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(moveInfo.sec);
        System.out.println(sb);
    }

    static MoveInfo bfs() {
        Queue<MoveInfo> queue = new LinkedList<>();
        queue.add(new MoveInfo(n, 0));
        visited[n] = true;

        while (!queue.isEmpty()) {
            MoveInfo mi = queue.poll();

            if(mi.current == m) return mi;

            for(int i = 0; i < 3; i++) {
                int nx;
                if(moveMethod[i] > 1) nx = mi.current * moveMethod[i];
                else nx = mi.current + moveMethod[i];

                if(0 <= nx && nx <= 100_000 && !visited[nx]) {
                    queue.add(new MoveInfo(nx, mi.sec + 1));
                    graph[nx] = mi.current;
                    visited[nx] = true;
                }
            }
        }

        return new MoveInfo(-1, -1);
    }

    static class MoveInfo {
        int current, sec;

        public MoveInfo(int current, int sec) {
            this.current = current;
            this.sec = sec;
        }
    }
}
