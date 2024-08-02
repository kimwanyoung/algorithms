package 백준.여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        for(int i = 0; i <= n; i++) parent[i] = i;

        StringTokenizer st;
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                int isConnect = Integer.parseInt(st.nextToken());
                if(isConnect != 0) union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int current = find(Integer.parseInt(st.nextToken()));

        boolean flag = true;
        for(int i = 1; i < m; i++) {
            int node = Integer.parseInt(st.nextToken());
            if(current != find(node)) flag = false;
        }

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return true;

        if(x <= y) parent[y] = x;
        else parent[x] = y;
        return false;
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
}
