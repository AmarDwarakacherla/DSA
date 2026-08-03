package _5_AM;

//import org.junit.Assert;

import java.util.Arrays;

public class _36_Valid_Sudoku {
    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        }));
//        Assert.assertTrue(isValidSudoku(new char[][]{
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        }));
    }
    public static boolean isValidSudoku(char[][] board) {
        if (board.length <= 0)
            return false;
        int freq[] = new int[10];
        //rows
        for (char[] ch : board) {
            Arrays.fill(freq, 0);
            for (char c : ch) {
                if (c != '.')
                    freq[c - '0']++;
            }
            for (int i : freq) {
                if (i > 1) {
                    return false;
                }
            }
        }
        //coloumns
        for (int i = 0; i < 9; i++) {
            Arrays.fill(freq, 0);
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.')
                    freq[board[j][i] - '0']++;
            }
            for (int t : freq) {
                if (t > 1) {
                    return false;
                }
            }
        }
        //for 3x3 box;
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Arrays.fill(freq, 0);
                for (int row = i; row < i+3; row++) {
                    for (int col = j; col < j+3; col++) {
                        if (board[row][col] != '.') {
                            freq[board[row][col] - '0']++;
                        }
                    }
                }
                for (int t : freq) {
                    if (t > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
