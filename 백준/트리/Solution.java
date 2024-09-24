package 백준.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int root = 0;
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int node = Integer.parseInt(st.nextToken());
            if (node == -1) {
                root = i;
                continue;
            }
            tree.get(node).add(i);
        }

        int remove = Integer.parseInt(br.readLine());
        if (remove == root)
            answer = 0;
        else
            search(remove, root);

        System.out.println(answer);
    }

    static void search(int remove, int node) {
        if (tree.get(node).contains(remove))
            tree.get(node).remove(Integer.valueOf(remove));

        if (tree.get(node).isEmpty()) {
            answer++;
            return;
        }

        for (int next : tree.get(node)) {
            search(remove, next);
        }
    }
}
