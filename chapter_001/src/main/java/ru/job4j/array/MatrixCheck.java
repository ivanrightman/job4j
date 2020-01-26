package ru.job4j.array;

public class MatrixCheck {
    public static boolean monoHorizontal(char[][] board, int row) {
        boolean result = false;
        for (; row < board.length; row++) {
            for (int n = 0; n < board.length; n++) {
                if (board[row][n] == 'X') {
                    result = true;
                }
                else {
                    result = false;
                }
                //тоже самое одной строкой - result = board[i][n] == 'X';
            }
            break;
        }
        return result;
    }
}
