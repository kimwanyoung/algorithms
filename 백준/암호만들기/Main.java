package 백준.암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int l, c;
    static char[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[c];
        visited = new boolean[c];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        dfs(0, 0, "");
    }

    static void dfs(int idx, int depth, String result) {
        if(depth == l) {
            if(isValid(result)) {
                System.out.println(result);
            }
            return;
        }

        for(int i = idx; i < c; i++) {
            dfs(i + 1, depth + 1, result + arr[i]);
        }
    }

    static boolean isValid(String result) {
        int vowelCount = 0;
        int consonantCount = 0;

        for(int i = 0; i < result.length(); i++) {
            char ch = result.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }

        return vowelCount >= 1 && consonantCount >= 2;
    }
}
