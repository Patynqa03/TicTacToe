package com.tictactoe.backend;

public class GameWithHuman {


    private Board boardObject = new Board();
    private String[][] board = boardObject.getBoard();
    private BoardMechanics boardMechanics = new BoardMechanics(board);


    public void game() {

        boolean gameStatus = false;

        System.out.println("Zaczyna X");

        while (true) {

            boardMechanics.showBoard(board);
            System.out.println("Ruch X");
            boardMechanics.xMove(boardMechanics.getNextMove());
            boardMechanics.showBoard(board);

            gameStatus = boardMechanics.winnerCheck(board);
            if (boardMechanics.boardIsFull()) {
                System.out.println("Remis");
                break;


            }
            if (gameStatus) {
                System.out.println("WYGRANA X !!!");
                break;

            }
            System.out.println("Ruch O");
            boardMechanics.oMove(boardMechanics.getNextMove());


            gameStatus = boardMechanics.winnerCheck(board);
            if (boardMechanics.boardIsFull()) {
                System.out.println("Remis");
                break;


            }
            if (gameStatus) {
                boardMechanics.showBoard(board);
                System.out.println("WYGRANA O !!!");
                break;

            }


        }
    }
}
