package 백준.좌석배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] seats = initializeSeats(br.readLine());
        int customerCount = Integer.parseInt(br.readLine());

        validateCustomerNumber(seats, customerCount);
        fillSeats(seats, customerCount);
    }

    private static int[][] initializeSeats(String readLine) {
        String[] sizeInfo = readLine.split(" ");
        int row = Integer.parseInt(sizeInfo[0]);
        int col = Integer.parseInt(sizeInfo[1]);

        int[][] seats = new int[row][col];
        return seats;
    }

    private static void validateCustomerNumber(int[][] seats, int customerNumber) {
        int totalSeats = seats.length * seats[0].length;
        if(customerNumber > totalSeats) {
            System.out.println("0");
            System.exit(0);
        }
    }

    private static void fillSeats(int[][] seats, int customerNumber) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int dir = 0;
        int x = 0, y = 0;

        for (int i = 1; i <= seats.length * seats[0].length; i++) {
            seats[y][x] = i;
            checkCustomerIsMatch(customerNumber, seats[y][x], y, x);

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= seats[0].length || ny < 0 || ny >= seats.length || seats[ny][nx] != 0) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;
        }
    }

    private static void checkCustomerIsMatch(int targetCustomerNumber, int currentSeatNumber, int y, int x) {
        if(targetCustomerNumber == currentSeatNumber) {
            System.out.println((y + 1) + " " + (x + 1));
            System.exit(0);
        }
    }
}
