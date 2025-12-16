package 백준.스도쿠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[9][9];
        
        for(int i = 0; i < 9; i++) {
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }
        
        int emptyCellCount = findEmptyCells(board);
        solveSudoku(board, emptyCellCount);
    }

    private static int findEmptyCells(int[][] board) {
        int count = 0;
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    } 

    private static void solveSudoku(int[][] board, int emptyCellCount) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] == 0) {
                    for(int num = 1; num <= 9; num++) {
                        if(isValid(board, i, j, num)) {
                            board[i][j] = num;
                            if(emptyCellCount - 1 == 0) {
                                printBoard(board);
                                return;
                            }
                            solveSudoku(board, emptyCellCount - 1);
                            board[i][j] = 0; // 백트래킹
                        }
                    }
                    return;
                }
            }
        }
    }

    private static boolean isValid(int[][] board, int row, int col, int num) {
        for(int i = 0; i < 9; i++) {
            if(board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {
                if(board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printBoard(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

}
