package com.tictactoe.backend;

public class Board {
    public String[][] generateBoard(int size) {
        int numb = size * 2 - 1;

        String[][] board = new String[numb][numb];

        for (int i = 0; i < numb; i++) {
            for (int j = 0; j < numb; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    board[i][j] = " ";
                } else if (i % 2 == 0) {
                    board[i][j] = "|";
                } else {
                    board[i][j] = "-";
                }
            }
        }
        return board;
    }
}
