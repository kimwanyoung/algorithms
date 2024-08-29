package 백준.$2147483648게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static final int SIZE = 8;
    static long[][] map;
    static long[][] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new long[SIZE][SIZE];
        answer = new long[SIZE][SIZE];
        for(int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < SIZE; j++) {
                long current = Long.parseLong(st.nextToken());
                map[i][j] = current;
            }
        }

        String command = br.readLine();
        board(command);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void board(String command) {
        Queue<Long> q;
        if("U".equals(command)) {
            for(int i = 0; i < SIZE; i++) {
                q = new LinkedList<>();
                for(int j = 0; j < SIZE; j++) {
                    if(map[j][i] != 0) q.offer(map[j][i]);
                }
                fillRow(q, i, 0);
            }
        }
        if("D".equals(command)) {
            for(int i = 0; i < SIZE; i++) {
                q = new LinkedList<>();
                for(int j = SIZE - 1; j >= 0; j--) {
                    if(map[j][i] != 0) q.offer(map[j][i]);
                }
                fillRow(q, i, SIZE - 1);
            }
        }
        if("L".equals(command)) {
            for(int i = 0; i < SIZE; i++) {
                q = new LinkedList<>();
                for(int j = 0; j < SIZE; j++) {
                    if(map[i][j] != 0) q.offer(map[i][j]);
                }
                fillColumn(q, i, 0);
            }
        }
        if("R".equals(command)) {
            for(int i = 0; i < SIZE; i++) {
                q = new LinkedList<>();
                for(int j = SIZE - 1; j >= 0; j--) {
                    if(map[i][j] != 0) q.offer(map[i][j]);
                }
                fillColumn(q, i, SIZE - 1);
            }
        }
    }

    static void fillRow(Queue<Long> queue, int c, int start) {
        int idx = start;
        while(!queue.isEmpty()) {
            long tmp = queue.poll();
            if(queue.peek() == null) {
                answer[idx][c] = tmp;
                queue.poll();
            } else {
                long next = queue.peek();
                if(tmp == next) {
                    answer[start == 0 ? idx++ : idx--][c] = tmp * 2;
                    queue.poll();
                } else {
                    answer[start == 0 ? idx++ : idx--][c] = tmp;
                }
            }
        }
    }

    static void fillColumn(Queue<Long> queue, int r, int start){
        int idx = start;
        while(!queue.isEmpty()) {
            long tmp = queue.poll();
            if(queue.peek() == null) {
                answer[r][idx] = tmp;
                queue.poll();
            } else {
                long next = queue.peek();
                if(tmp == next) {
                    answer[r][start == 0 ? idx++ : idx--] = tmp * 2;
                    queue.poll();
                } else {
                    answer[r][start == 0 ? idx++ : idx--] = tmp;
                }
            }
        }
    }
}
