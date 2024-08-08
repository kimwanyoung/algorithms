package 백준.중량제한;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int answer;
    static List<City>[] list;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[a].add(new City(b, w));
            list[b].add(new City(a, w));
            right = Math.max(right, w);
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        while(left <= right) {
            int mid = (left + right) / 2;
            answer = -1;
            check = new boolean[N + 1];
            dfs(from, to, mid);
            if(answer != -1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }

    private static void dfs(int pos, int target, int limit) {
        if(pos == target) {
            answer = pos;
            return;
        }
        check[pos] = true;
        for(City c: list[pos]) {
            if(!check[c.to] && limit <= c.w) {
                dfs(c.to, target, limit);
            }
        }
    }
}

class City {
    int to;
    int w;

    public City(int to, int w) {
        this.to = to;
        this.w = w;
    }
}
