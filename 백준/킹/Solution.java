package 백준.킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static final int BOARD_SIZE = 8;
    static int[] kingPos;
    static int[] stonePos;
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static String[] commands = {"R", "L", "B", "T", "RT", "LT", "RB", "LB"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        kingPos = positionConverter(st.nextToken());
        stonePos = positionConverter(st.nextToken());

        int test = Integer.parseInt(st.nextToken());
        for (int i = 0; i < test; i++) {
            String command = br.readLine();
            move(command, kingPos);
        }

        System.out.println((char)(kingPos[1] + 'A') + "" + (kingPos[0] + 1));
        System.out.println((char)(stonePos[1] + 'A') + "" + (stonePos[0] + 1));
    }

    static void move(String command, int[] piecePos) {
        for (int i = 0; i < 8; i++) {
            if (command.equals(commands[i])) {
                int nr = piecePos[0] + dy[i];
                int nc = piecePos[1] + dx[i];

                if(isValid(nr, nc)) {
                    if(isStonePos(nr, nc) && isValid(stonePos[0] + dy[i], stonePos[1] + dx[i])) {
                        stonePos[0] += dy[i];
                        stonePos[1] += dx[i];

                        kingPos[0] = nr;
                        kingPos[1] = nc;
                    }

                    if(!isStonePos(nr, nc)) {
                        kingPos[0] = nr;
                        kingPos[1] = nc;
                    }
                }
            }
        }
    }

    static int rowConverter(char r) {
        return r - 'A';
    }

    static int[] positionConverter(String pos) {
        int[] piecePos = new int[2];
        char[] splitedPos = pos.toCharArray();
        int r = Character.getNumericValue(splitedPos[1]);
        int c = rowConverter(splitedPos[0]);
        piecePos[0] = r - 1;
        piecePos[1] = c;

        return piecePos;
    }

    static boolean isValid(int r, int c) {
        return 0 <= r && r < BOARD_SIZE && 0 <= c && c < BOARD_SIZE;
    }

    static boolean isStonePos(int r, int c) {
        return stonePos[0] == r && stonePos[1] == c;
    }
}
