package 백준.ACMCraft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * - 리스트에 각 연결된 이전 노드들을 담아놓고 타겟 노드에서 dfs진행
 */

/**
 * testInput
 * 1
 * 5 5
 * 10 20 30 40 50
 * 1 2
 * 1 3
 * 2 4
 * 3 4
 * 5 4
 * 4
 */

public class Solution {

    static int testCase;
    static int[] dp;
    static int[] time;
    static LinkedList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int currentTestCase = 0;
        while (currentTestCase < testCase) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            dp = new int[n + 1];
            time = new int[n + 1];
            graph = new LinkedList[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                dp[i] = -1;
                time[i] = Integer.parseInt(st.nextToken());
                graph[i] = new LinkedList<>();
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[b].add(a);
            }

            int target = Integer.parseInt(br.readLine());
            dfs(target);

            sb.append(dp[target]).append("\n");
            currentTestCase++;
        }
        System.out.println(sb);
    }

    private static int dfs(int node) {
        if (dp[node] != -1) return dp[node];

        int timeMax = 0;
        for (Integer nextNode : graph[node]) {
            timeMax = Math.max(dfs(nextNode), timeMax);
        }

        timeMax += time[node];
        return dp[node] = timeMax;
    }
}
