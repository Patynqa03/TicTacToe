package com.tictactoe.backend;

import java.util.Random;
import java.util.Scanner;

public class BoardMechanics {


    private final String X = "X";
    private final String O = "O";

    private String[][] board;
    public BoardMechanics(String[][] board) {
        this.board = board;
    }

    public void showBoard(String[][] board)
    {
        for (int i = 0; i < board.length; i++) {
            System.out.println();
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
        }
        System.out.println();
    }
    public int getNextMove() {

        Scanner nextMoveScanner = new Scanner(System.in);
        int move = 0;
        boolean validMove = false;

        while (!validMove) {
            try {

                move = nextMoveScanner.nextInt();


                validMove = true;

                if (move > 9) {
                    System.out.println("Prosze wybierz liczbe z zakresu od 1 do 9");
                    validMove = false;
                    nextMoveScanner.nextLine();

                }

            } catch (Exception e) {
                System.out.println("Prosze wybierz liczbe z zakresu od 1 do 9");
                nextMoveScanner.nextLine();
            }
        }

        return move;

    }

    public boolean winnerCheck(String[][] board) {

        for (int i = 0; i < board.length; i++) {
            if ((board[i][0].equals(X) && board[i][2].equals(X) && board[i][4].equals(X))
                    || (board[i][0].equals(O) && board[i][2].equals(O) && board[i][4].equals(O))) {
                return true;
            }
        }

        for (int j = 0; j < board.length; j++) {
            if ((board[0][j].equals(X) && board[2][j].equals(X) && board[4][j].equals(X))
                    || (board[0][j].equals(O) && board[2][j].equals(O) && board[4][j].equals(O))) {
                return true;
            }
        }

        if ((board[0][0].equals(X) && board[2][2].equals(X) && board[4][4].equals(X))
                || (board[0][0].equals(O) && board[2][2].equals(O) && board[4][4].equals(O))) {
            return true;
        }

        if ((board[4][0].equals(X) && board[2][2].equals(X) && board[0][4].equals(X))
                || (board[4][0].equals(O) && board[2][2].equals(O) && board[0][4].equals(O))) {
            return true;
        }

        return false;
    }

    public boolean boardIsFull() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
    public String[][] Move(int move, char symbol) {
        if (move == 7 && !board[0][0].equals(X) && !board[0][0].equals(O)) {
            board[0][0] = String.valueOf(symbol);

        } else if (move == 8 && !board[0][2].equals(X) && !board[0][2].equals(O)) {
            board[0][2] = String.valueOf(symbol);

        } else if (move == 9 && !board[0][4].equals(X) && !board[0][4].equals(O)) {
            board[0][4] = String.valueOf(symbol);

        } else if (move == 4 && !board[2][0].equals(X) && !board[2][0].equals(O)) {
            board[2][0] = String.valueOf(symbol);

        } else if (move == 5 && !board[2][2].equals(X) && !board[2][2].equals(O)) {
            board[2][2] = String.valueOf(symbol);

        } else if (move == 6 && !board[2][4].equals(X) && !board[2][4].equals(O)) {
            board[2][4] = String.valueOf(symbol);

        } else if (move == 1 && !board[4][0].equals(X) && !board[4][0].equals(O)) {
            board[4][0] = String.valueOf(symbol);

        } else if (move == 2 && !board[4][2].equals(X) && !board[4][2].equals(O)) {
            board[4][2] = String.valueOf(symbol);

        } else if (move == 3 && !board[4][4].equals(X) && !board[4][4].equals(O)) {
            board[4][4] = String.valueOf(symbol);

        } else {
            System.out.println("Wybierz inne pole");
            move = getNextMove();
            return Move(move,symbol);
        }
        return board;
    }
}
