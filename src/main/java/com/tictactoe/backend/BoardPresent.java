package com.tictactoe.backend;

import java.util.Arrays;

public class BoardPresent {

    String[][] board = {
            {"7","|","8","|","9"}
            ,{"-+-+-"}
            ,{"4","|","5","|","6"}
            ,{"-+-+-"}
            ,{"1","|","2","|","3"}
    };

    public String[][] getBoard() {
        return board;
    }

    @Override
    public String toString() {
        return "BoardPresent{" +
                "board=" + Arrays.toString(board) +
                '}';
    }
}
