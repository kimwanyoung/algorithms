package 백준.부분수열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] list;
    static int count = 0;
    static int n, s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        list = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if(s == 0) {
            count--;
        }
        System.out.println(count);
    }    

    static void dfs(int idx, int sum){
        if(sum == s) count++;

        for(int i = idx; i < n; i++) {                
            dfs(i + 1, sum + list[i]);
        }
    }
}
