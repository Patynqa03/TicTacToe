package com.tictactoe;


import com.tictactoe.backend.Board;
import com.tictactoe.backend.BoardMechanics;
import com.tictactoe.backend.BoardPresent;

import java.util.Arrays;
import java.util.Scanner;


public class TicTacToeApplication {

	public static void main(String[] args) {

		Board boardObject = new Board();
		String[][] board = boardObject.getBoard();

		BoardPresent boardPresent = new BoardPresent();
		String[][] boardPrev = boardPresent.getBoard();


		BoardMechanics boardMechanics = new BoardMechanics(board);

		boardMechanics.showBoard(boardPrev);
		System.out.println();
		System.out.println("Gracze stawiają na przemian kółko i krzyżyk dążąc do zajęcia trzech pól w jednej linii.");
		System.out.println("Wygrywa ten z graczy, któremu jako pierwszemu uda ułożyć się trzy znaki w jednej linii.");
		System.out.println("Ruchy wykonywane są na podstawie planszy umieszczonej powyzej");
		System.out.println();
		System.out.println("Wybierz proszę czy chcesz grać z kimś (1) lub  z komputerem (2) ");
		Scanner nextMoveScanner = new Scanner(System.in);
		int gameMode = nextMoveScanner.nextInt();
		if(gameMode == 1) {

			boolean gameStatus = false;

			System.out.println("Zaczyna X");

			while (true) {

				boardMechanics.showBoard(board);
				boardMechanics.xMove(boardMechanics.getNextMove());
				boardMechanics.showBoard(board);

				gameStatus = boardMechanics.winnerCheck(board);
				if (boardMechanics.boardIsFull()) {
					System.out.println("Remis");
					break;


				}
				if (gameStatus) {
					System.out.println("WYGRANA!!!");
					break;

				}
				boardMechanics.oMove(boardMechanics.getNextMove());


				gameStatus = boardMechanics.winnerCheck(board);
				if (boardMechanics.boardIsFull()) {
					System.out.println("Remis");
					break;


				}
				if (gameStatus) {
					System.out.println("WYGRANA!!!");
					break;

				}

			}

		}else if (gameMode == 2) {

			System.out.println("Soon");

		}

	}
}
