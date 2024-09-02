package 백준.수강신청;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < l; i++) {
            String current = br.readLine();
            if (set.contains(current)) {
                set.remove(current);
            }
            set.add(current);
        }

        List<String> arr = new ArrayList<>(set);
        int size = Math.min(arr.size(), k);
        for(int i = 0; i < size; i++) {
            System.out.println(arr.get(i));
        }
    }
}
