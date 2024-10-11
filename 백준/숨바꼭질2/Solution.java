package 백준.숨바꼭질2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static class MoveInfo {
        int position, time;

        public MoveInfo(int position, int time) {
            this.position = position;
            this.time = time;
        }
    }

    static int n, k;
    static int[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new int[100001];

        if (n >= k) {
            System.out.println((n - k) + "\n1");
            return;
        }

        bfs();

        System.out.println(visited[k]);
        System.out.println(count);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.offer(n);
        while (!q.isEmpty()) {
            Integer current = q.poll();
            if(current == k) {
                count++;
            }

            int[] nextPosition = new int[]{current + 1, current - 1, current * 2};
            for(int next : nextPosition) {

                if (next < 0 || next > 100000) continue;

                if(visited[next] == 0 || visited[next] == visited[current] + 1) {
                    q.offer(next);
                    visited[next] = visited[current] + 1;
                }
            }
        }
    }
}
