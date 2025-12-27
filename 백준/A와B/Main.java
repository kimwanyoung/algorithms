package 백준.A와B;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        
        String current = br.readLine();
        String target = br.readLine();

        System.out.println(canConvert(current, target) ? 1 : 0);
    }

    private static boolean canConvert(String s, String t) {
        if (s.length() == t.length()) {
            return s.equals(t);
        }
        if (t.length() < s.length()) {
            return false;
        }
        if (t.endsWith("A")) {
            return canConvert(s, t.substring(0, t.length() - 1));
        }
        if (t.endsWith("B")) {
            String reversed = new StringBuilder(t.substring(0, t.length() - 1)).reverse().toString();
            return canConvert(s, reversed);
        }
        return false;
    }
}
