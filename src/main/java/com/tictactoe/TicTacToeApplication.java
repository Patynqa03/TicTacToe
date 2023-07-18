package com.tictactoe;

import com.tictactoe.backend.*;
import java.util.InputMismatchException;
import java.util.Scanner;


public class TicTacToeApplication {
	public static void main(String[] args) {

		BoardSout boardSout = new BoardSout();
		boardSout.boardPrev();
		boardSout.beforeGame();
		Scanner nextMoveScanner = new Scanner(System.in);

		boolean gameModeValid = false;
		int gameMode = 0;
		while (!gameModeValid) {
			try {
				gameMode = nextMoveScanner.nextInt();
				if (gameMode == 1 || gameMode == 2) {
					gameModeValid = true;
				} else {
					System.out.println("Wybierz właściwy tryb");
				}
			} catch (InputMismatchException e) {
				System.out.println("Wybierz właściwy tryb");
				nextMoveScanner.next();
			}
		}

		if(gameMode == 1) {
			GameWithHuman gameWithHuman = new GameWithHuman();
			gameWithHuman.game();

		}else if (gameMode == 2) {
			GameWithPC gameWithPC = new GameWithPC();
			gameWithPC.game();
		}
	}
}
