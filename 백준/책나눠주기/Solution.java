package 백준.책나눠주기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

    static int testcase, N, M, count;
    static boolean[] bookStatus;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        testcase = Integer.parseInt(br.readLine());

        int currentTestCase = 0;
        while(currentTestCase < testcase) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            bookStatus = new boolean[N + 1];
            count = 0;

            ArrayList<int[]> student = new ArrayList<>();
            for(int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                student.add(new int[]{a, b});
            }

            student.sort((a, b) -> {
                if(a[1] == b[1]) return a[0] - b[0];
                return a[1] - b[1];
            });

            for(int[] t : student) {
                for(int i = t[0]; i <= t[1]; i++) {
                    if(!bookStatus[i]) {
                        bookStatus[i] = true;
                        count++;
                        break;
                    }
                }
            }

            currentTestCase++;
            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }
}

