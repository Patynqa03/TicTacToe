package com.tictactoe.backend;

import java.util.Arrays;

public class Board {

    String[][] board = {
            {" ","|"," ","|"," "}
            ,{"-+-+-"}
            ,{" ","|"," ","|"," "}
            ,{"-+-+-"}
            ,{" ","|"," ","|"," "}
    };


    public String[][] getBoard() {
        return board;
    }

    @Override
    public String toString() {
        return "Board{" +
                "board=" + Arrays.toString(board) +
                '}';
    }
}
