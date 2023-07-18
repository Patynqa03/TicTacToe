package com.tictactoe.backend;

import java.util.Random;

public class GameWithPC {

    private Board boardObject = new Board();
    private String[][] board = boardObject.generateBoard(3);
    private BoardMechanics boardMechanics = new BoardMechanics(board);

    public int randomComputerMoves(){

        Random random = new Random();

        int move = random.nextInt(9)+1;

        return  move;

    }

    public void game() {
        boolean gameStatus = false;

        System.out.println("Zaczyna X");

        while (true) {

            boardMechanics.showBoard(board);

            System.out.println("Ruch X");

            boardMechanics.Move(boardMechanics.getNextMove(),'X');
            boardMechanics.showBoard(board);

            gameStatus = boardMechanics.winnerCheck(board);

            if (gameStatus) {
                System.out.println("WYGRANA X !!!");
                break;
            }
            System.out.println("Ruch O");
            boardMechanics.Move(randomComputerMoves(),'O');


            gameStatus = boardMechanics.winnerCheck(board);
            if (boardMechanics.boardIsFull()) {

                System.out.println("Remis");
                break;
            }
            if (gameStatus) {
                boardMechanics.showBoard(board);
                System.out.println("WYGRYWA O !!!");
                break;
            }
            if (boardMechanics.boardIsFull()) {

                System.out.println("Remis");
                break;
            }
        }
    }
}
