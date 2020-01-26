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

    public static boolean monoVertical(char[][] board, int column) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            for (int n = 0; n < board.length; n++) {
                result = board[i][column] == 'X';
                break;
            }
        }
        return result;

        /* enhanced for
        for (char[] chars : board) {
            for (int n = 0; n < board.length; n++) {
                if (chars[column] == 'X') {
                    result = true;
                } else {
                    result = false;
                }
                break;
            }
         */
    }
}
