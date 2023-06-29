package com.tictactoe.backend;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BoardMechanics {

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

    public String[][] xMove(int move) {





            if (move == 7 && !board[0][0].equals("X") && !board[0][0].equals("O")) {
                board[0][0] = "X";

            } else if (move == 8 && !board[0][2].equals("X") && !board[0][2].equals("O")) {
                board[0][2] = "X";

            } else if (move == 9 && !board[0][4].equals("X") && !board[0][4].equals("O")) {
                board[0][4] = "X";

            } else if (move == 4 && !board[2][0].equals("X") && !board[2][0].equals("O")) {
                board[2][0] = "X";

            } else if (move == 5 && !board[2][2].equals("X") && !board[2][2].equals("O")) {
                board[2][2] = "X";

            } else if (move == 6 && !board[2][4].equals("X") && !board[2][4].equals("O")) {
                board[2][4] = "X";

            } else if (move == 1 && !board[4][0].equals("X") && !board[4][0].equals("O")) {
                board[4][0] = "X";

            } else if (move == 2 && !board[4][2].equals("X") && !board[4][2].equals("O")) {
                board[4][2] = "X";

            } else if (move == 3 && !board[4][4].equals("X") && !board[4][4].equals("O")) {
                board[4][4] = "X";

            } else {

                System.out.println("Wybierz inne pole");
                move = getNextMove();
                return xMove(move);
            }

        return board;
    }

    public String[][] oMove(int move) {

        System.out.println("Ruch X");

        if (move == 7 && !board[0][0].equals("X") && !board[0][0].equals("O")) {
            board[0][0] = "O";

        } else if (move == 8 && !board[0][2].equals("X") && !board[0][2].equals("O")) {
            board[0][2] = "O";

        } else if (move == 9 && !board[0][4].equals("X") && !board[0][4].equals("O")) {
            board[0][4] = "O";

        } else if (move == 4 && !board[2][0].equals("X") && !board[2][0].equals("O")) {
            board[2][0] = "O";

        } else if (move == 5 && !board[2][2].equals("X") && !board[2][2].equals("O")) {
            board[2][2] = "O";

        } else if (move == 6 && !board[2][4].equals("X") && !board[2][4].equals("O")) {
            board[2][4] = "O";

        } else if (move == 1 && !board[4][0].equals("X") && !board[4][0].equals("O")) {
            board[4][0] = "O";

        } else if (move == 2 && !board[4][2].equals("X") && !board[4][2].equals("O")) {
            board[4][2] = "O";

        } else if (move == 3 && !board[4][4].equals("X") && !board[4][4].equals("O")) {
            board[4][4] = "O";

        } else {

            System.out.println("Wybierz inne pole");
            move = getNextMove();
            return oMove(move);
        }

        return board;
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

        boolean winnerCheck;


            if ((board[0][0] == "X" && board[0][2] == "X" && board[0][4] == "X")
                    || (board[0][0] == "O" && board[0][2] == "O" && board[0][4] == "O") ) {


                winnerCheck = true;


            } else if ((board[2][0] == "X" && board[2][2] == "X" && board[2][4] == "X")
                    || (board[2][0] == "O" && board[2][2] == "O" && board[2][4] == "O")) {


                winnerCheck = true;

            } else if ((board[4][0] == "X" && board[4][2] == "X" && board[4][4] == "X")
                    || (board[4][0] == "O" && board[4][2] == "O" && board[4][4] == "O")) {


                winnerCheck = true;

            }else if ((board[0][0] == "X" && board[2][0] == "X" && board[4][0] == "X")
                    || (board[0][0] == "O" && board[2][0] == "O" && board[4][0] == "O")) {


            winnerCheck = true;


            }else if ((board[0][2] == "X" && board[2][2] == "X" && board[4][2] == "X")
                    || (board[0][2] == "O" && board[2][2] == "O" && board[4][2] == "O")) {


            winnerCheck = true;


            }else if ((board[0][4] == "X" && board[2][4] == "X" && board[4][4] == "X")
                    || (board[0][4] == "O" && board[2][4] == "O" && board[4][4] == "O")) {


            winnerCheck = true;


            }else if ((board[0][0] == "X" && board[2][2] == "X" && board[4][4] == "X")
                    || (board[0][0] == "O" && board[2][2] == "O" && board[4][4] == "O")) {


            winnerCheck = true;


            }else if ((board[0][4] == "X" && board[2][2] == "X" && board[4][0] == "X")
                || (board[0][4] == "O" && board[2][2] == "O" && board[4][0] == "O"))
                     {


                winnerCheck = true;



            } else {

               winnerCheck = false;

            }

        return winnerCheck;
    }

    public String[][] randomComputerMoves(){

        Random random = new Random();

        int move = random.nextInt(9)+1;



        if (move == 7 && !board[0][0].equals("X") && !board[0][0].equals("O")) {
            board[0][0] = "O";

        } else if (move == 8 && !board[0][2].equals("X") && !board[0][2].equals("O")) {
            board[0][2] = "O";

        } else if (move == 9 && !board[0][4].equals("X") && !board[0][4].equals("O")) {
            board[0][4] = "O";

        } else if (move == 4 && !board[2][0].equals("X") && !board[2][0].equals("O")) {
            board[2][0] = "O";

        } else if (move == 5 && !board[2][2].equals("X") && !board[2][2].equals("O")) {
            board[2][2] = "O";

        } else if (move == 6 && !board[2][4].equals("X") && !board[2][4].equals("O")) {
            board[2][4] = "O";

        } else if (move == 1 && !board[4][0].equals("X") && !board[4][0].equals("O")) {
            board[4][0] = "O";

        } else if (move == 2 && !board[4][2].equals("X") && !board[4][2].equals("O")) {
            board[4][2] = "O";

        } else if (move == 3 && !board[4][4].equals("X") && !board[4][4].equals("O")) {
            board[4][4] = "O";

        } else {

            return randomComputerMoves();
        }


        return board;


    }

    public boolean boardIsFull() {

        if(!board[0][0].equals(" ") && !board[0][2].equals(" ") && !board[0][4].equals(" ")
                && !board[2][0].equals(" ") && !board[2][2].equals(" ") && !board[2][4].equals(" ")
                && !board[4][0].equals(" ") && !board[4][2].equals(" ") && !board[4][4].equals(" ")){

            return true;

        }else {
            return  false;
        }

    }

}
