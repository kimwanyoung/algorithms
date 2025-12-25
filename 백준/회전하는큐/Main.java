package 백준.회전하는큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

public class Main {

    private static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        
        String line = br.readLine();
        N = Integer.parseInt(line.split(" ")[0]);
        M = Integer.parseInt(line.split(" ")[1]);

        LinkedList<Integer> deque = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int[] targetNumbers = new int[M];
        String[] targets = br.readLine().split(" ");
        for(int i = 0; i < M; i++) {
            targetNumbers[i] = Integer.parseInt(targets[i]);
        }

        int totalOperations = 0;
        for(int i = 0; i < M; i++) {
            int targetIdx = deque.indexOf(targetNumbers[i]);
            int halfIdx;

            if(deque.size() % 2 == 0) {
                halfIdx = deque.size() / 2 - 1;
            } else {
                halfIdx = deque.size() / 2;
            }

            if (targetIdx <= halfIdx) {
                for(int j = 0; j < targetIdx; j++) {
                    deque.offerLast(deque.pollFirst());
                    totalOperations++;
                }
            } else {
                for(int j = 0; j < deque.size() - targetIdx; j++) {
                    deque.offerFirst(deque.pollLast());
                    totalOperations++;
                }
            }

            deque.pollFirst();
        }

        System.out.println(totalOperations);
    }

}
