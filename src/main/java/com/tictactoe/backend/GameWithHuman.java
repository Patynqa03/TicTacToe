package com.tictactoe.backend;

public class GameWithHuman {


    private Board boardObject = new Board();
    private String[][] board = boardObject.generateBoard(3);
    private BoardMechanics boardMechanics = new BoardMechanics(board);


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
            boardMechanics.Move(boardMechanics.getNextMove(),'O');

            gameStatus = boardMechanics.winnerCheck(board);

            if (gameStatus) {
                boardMechanics.showBoard(board);
                System.out.println("WYGRANA O !!!");
                break;
            }

            if (boardMechanics.boardIsFull()) {
                System.out.println("Remis");
                break;
            }
        }
    }
}
