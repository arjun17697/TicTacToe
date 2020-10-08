package com.bridgelabz.main;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
	static char[] boardElement = new char[10];
	static char compKey;
	static char playerKey;
	static int position;
	static int rand_int1;
	static char turn;
	static boolean flag = false;
	static int totalMoves = 0;

	public static int getRand_int1() {
		return rand_int1;
	}

	// Assigning Board Elements
	public char[] UC1_createBoard() {
		for (int i = 1; i < 10; i++) {
			boardElement[i] = ' ';
		}
		return boardElement;
	}

//Method to choose between X and O
	public static void UC2_chooseKey() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for choosing X as your key or 2 for choosing O as your key");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			compKey = 'O';
			playerKey = 'X';
			System.out.println("Player Key:" + playerKey);
			System.out.println("Computer Key:" + compKey);
			break;
		case 2:
			compKey = 'X';
			playerKey = 'O';
			System.out.println("Player Key:" + playerKey);
			System.out.println("Computer Key:" + compKey);
			break;
		default:
			System.out.println("Invalid Input.Please enter again");
			UC2_chooseKey();
			break;
		}

	}

	/**
	 * Method to show the TicTacToe Board
	 */
	public static void showBoard_UC3() {
		System.out.println(boardElement[1] + "|" + boardElement[2] + "|" + boardElement[3]);
		System.out.println("~~~~~~~~~~~~~~");
		System.out.println(boardElement[4] + "|" + boardElement[5] + "|" + boardElement[6]);
		System.out.println("~~~~~~~~~~~~~~");
		System.out.println(boardElement[7] + "|" + boardElement[8] + "|" + boardElement[9]);
	}

	/**
	 * Method to move to the desired position
	 */
	public static void makeMove() {
		if (rand_int1 == 1) {
			moveOnBoardandAssignKeyUC4_5(playerKey);
		} else {
			playComputerMove();
		}
	}

	public static void moveOnBoardandAssignKeyUC4_5(char turn) {
		Scanner sc = new Scanner(System.in);
		// int toss_result = getRand_int1();
		System.out.println("Enter the position you want to move to: ");
		position = sc.nextInt();
		if (position > 9 || position < 1 && boardElement[position] != ' ') {
			System.out.println("You have entered invalid position.Please enter again");
			moveOnBoardandAssignKeyUC4_5(playerKey);

		} else {
			boardElement[position] = playerKey;
			showBoard_UC3();
			winningCondition_UC7();
			totalMoves++;
			turn = compKey;
			playComputerMove();

		}
	}

	/**
	 * Method to determine who plays first
	 * 
	 * @return the choice of first player
	 */
	public static int toss_UC6() {
		Random toss = new Random();
		rand_int1 = toss.nextInt(2);
		if (rand_int1 == 1) {
			System.out.println("User Plays first");
			turn = playerKey;
		} else {
			System.out.println("Computer Plays first");
			turn = compKey;
		}
		return rand_int1;
	}

	public static boolean winningCondition_UC7() {

		if (((boardElement[1] == playerKey) && (boardElement[2] == playerKey) && (boardElement[3] == playerKey))
				|| ((boardElement[4] == playerKey) && (boardElement[5] == playerKey) && (boardElement[6] == playerKey))
				|| ((boardElement[7] == playerKey) && (boardElement[8] == playerKey) && (boardElement[9] == playerKey))
				|| ((boardElement[1] == playerKey) && (boardElement[4] == playerKey) && (boardElement[7] == playerKey))
				|| ((boardElement[2] == playerKey) && (boardElement[5] == playerKey) && (boardElement[8] == playerKey))
				|| ((boardElement[3] == playerKey) && (boardElement[6] == playerKey) && (boardElement[9] == playerKey))
				|| ((boardElement[1] == playerKey) && (boardElement[5] == playerKey) && (boardElement[9] == playerKey))
				|| ((boardElement[3] == playerKey) && (boardElement[5] == playerKey)
						&& (boardElement[7] == playerKey))) {
			System.out.println("Player has won");
			flag = true;
			return flag;

		}

		else if (((boardElement[1] == compKey) && (boardElement[2] == compKey) && (boardElement[3] == compKey))
				|| ((boardElement[4] == compKey) && (boardElement[5] == compKey) && (boardElement[6] == compKey))
				|| ((boardElement[7] == compKey) && (boardElement[8] == compKey) && (boardElement[9] == compKey))
				|| ((boardElement[1] == compKey) && (boardElement[4] == compKey) && (boardElement[7] == compKey))
				|| ((boardElement[2] == compKey) && (boardElement[5] == compKey) && (boardElement[8] == compKey))
				|| ((boardElement[3] == compKey) && (boardElement[6] == compKey) && (boardElement[9] == compKey))
				|| ((boardElement[1] == compKey) && (boardElement[5] == compKey) && (boardElement[9] == compKey))
				|| ((boardElement[3] == compKey) && (boardElement[5] == compKey) && (boardElement[7] == compKey))) {
			System.out.println("Computer has won");
			flag = true;
			return flag;
		} else {
			System.out.println("Match is a draw or move forward");
			flag = false;
			return flag;
		}

	}

	public static void playComputerMove() {

		if (totalMoves < 2) {
			placeRandomly();

		} else {
			// rows:
			// row1
			if (boardElement[1] == compKey && boardElement[2] == compKey && boardElement[3] == ' ')
				boardElement[3] = compKey;
			else if (boardElement[1] == compKey && boardElement[3] == compKey && boardElement[2] == ' ')
				boardElement[2] = compKey;
			else if (boardElement[2] == compKey && boardElement[3] == compKey && boardElement[1] == ' ')
				boardElement[1] = compKey;
			// row2
			else if (boardElement[4] == compKey && boardElement[5] == compKey && boardElement[6] == ' ')
				boardElement[6] = compKey;
			else if (boardElement[5] == compKey && boardElement[6] == compKey && boardElement[4] == ' ')
				boardElement[4] = compKey;
			else if (boardElement[4] == compKey && boardElement[6] == compKey && boardElement[5] == ' ')
				boardElement[5] = compKey;
			// row3
			else if (boardElement[7] == compKey && boardElement[8] == compKey && boardElement[9] == ' ')
				boardElement[9] = compKey;
			else if (boardElement[8] == compKey && boardElement[9] == compKey && boardElement[7] == ' ')
				boardElement[7] = compKey;
			else if (boardElement[7] == compKey && boardElement[9] == compKey && boardElement[8] == ' ')
				boardElement[8] = compKey;
			// columns:
			// column1:
			else if (boardElement[1] == compKey && boardElement[4] == compKey && boardElement[7] == ' ')
				boardElement[7] = compKey;
			else if (boardElement[1] == compKey && boardElement[7] == compKey && boardElement[4] == ' ')
				boardElement[4] = compKey;
			else if (boardElement[4] == compKey && boardElement[7] == compKey && boardElement[1] == ' ')
				boardElement[1] = compKey;
			// column2
			else if (boardElement[2] == compKey && boardElement[5] == compKey && boardElement[8] == ' ')
				boardElement[8] = compKey;
			else if (boardElement[2] == compKey && boardElement[8] == compKey && boardElement[5] == ' ')
				boardElement[5] = compKey;
			else if (boardElement[5] == compKey && boardElement[8] == compKey && boardElement[2] == ' ')
				boardElement[2] = compKey;
			// column3
			else if (boardElement[3] == compKey && boardElement[6] == compKey && boardElement[9] == ' ')
				boardElement[9] = compKey;
			else if (boardElement[3] == compKey && boardElement[9] == compKey && boardElement[6] == ' ')
				boardElement[6] = compKey;
			else if (boardElement[6] == compKey && boardElement[9] == compKey && boardElement[3] == ' ')
				boardElement[3] = compKey;
			// diagonals
			// diagonal1
			else if (boardElement[1] == compKey && boardElement[5] == compKey && boardElement[9] == ' ')
				boardElement[9] = compKey;
			else if (boardElement[1] == compKey && boardElement[9] == compKey && boardElement[5] == ' ')
				boardElement[5] = compKey;
			else if (boardElement[5] == compKey && boardElement[9] == compKey && boardElement[1] == ' ')
				boardElement[1] = compKey;
			// diagonal2
			else if (boardElement[3] == compKey && boardElement[5] == compKey && boardElement[7] == ' ')
				boardElement[7] = compKey;
			else if (boardElement[3] == compKey && boardElement[7] == compKey && boardElement[5] == ' ')
				boardElement[5] = compKey;
			else if (boardElement[5] == compKey && boardElement[7] == compKey && boardElement[3] == ' ')
				boardElement[3] = compKey;
			else if (boardElement[1] == playerKey && boardElement[2] == playerKey && boardElement[3] == ' ')
				boardElement[3] = compKey;
			else if (boardElement[1] == playerKey && boardElement[3] == playerKey && boardElement[2] == ' ')
				boardElement[2] = compKey;
			else if (boardElement[2] == playerKey && boardElement[3] == playerKey && boardElement[1] == ' ')
				boardElement[1] = compKey;
			// row2
			else if (boardElement[4] == playerKey && boardElement[5] == playerKey && boardElement[6] == ' ')
				boardElement[6] = compKey;
			else if (boardElement[5] == playerKey && boardElement[6] == playerKey && boardElement[4] == ' ')
				boardElement[4] = compKey;
			else if (boardElement[4] == playerKey && boardElement[6] == playerKey && boardElement[5] == ' ')
				boardElement[5] = compKey;
			// row3
			else if (boardElement[7] == playerKey && boardElement[8] == playerKey && boardElement[9] == ' ')
				boardElement[9] = compKey;
			else if (boardElement[8] == playerKey && boardElement[9] == playerKey && boardElement[7] == ' ')
				boardElement[7] = compKey;
			else if (boardElement[7] == playerKey && boardElement[9] == playerKey && boardElement[8] == ' ')
				boardElement[8] = compKey;
			// columns:
			// column1:
			else if (boardElement[1] == playerKey && boardElement[4] == playerKey && boardElement[7] == ' ')
				boardElement[7] = compKey;
			else if (boardElement[1] == playerKey && boardElement[7] == playerKey && boardElement[4] == ' ')
				boardElement[4] = compKey;
			else if (boardElement[4] == playerKey && boardElement[7] == playerKey && boardElement[1] == ' ')
				boardElement[1] = compKey;
			// column2
			else if (boardElement[2] == playerKey && boardElement[5] == playerKey && boardElement[8] == ' ')
				boardElement[8] = compKey;
			else if (boardElement[2] == playerKey && boardElement[8] == playerKey && boardElement[5] == ' ')
				boardElement[5] = compKey;
			else if (boardElement[5] == playerKey && boardElement[8] == playerKey && boardElement[2] == ' ')
				boardElement[2] = compKey;
			// column3
			else if (boardElement[3] == playerKey && boardElement[6] == playerKey && boardElement[9] == ' ')
				boardElement[9] = compKey;
			else if (boardElement[3] == playerKey && boardElement[9] == playerKey && boardElement[6] == ' ')
				boardElement[6] = compKey;
			else if (boardElement[6] == playerKey && boardElement[9] == playerKey && boardElement[3] == ' ')
				boardElement[3] = compKey;
			// diagonals
			// diagonal1
			else if (boardElement[1] == playerKey && boardElement[5] == playerKey && boardElement[9] == ' ')
				boardElement[9] = compKey;
			else if (boardElement[1] == playerKey && boardElement[9] == playerKey && boardElement[5] == ' ')
				boardElement[5] = compKey;
			else if (boardElement[5] == playerKey && boardElement[9] == playerKey && boardElement[1] == ' ')
				boardElement[1] = compKey;
			// diagonal2
			else if (boardElement[3] == playerKey && boardElement[5] == playerKey && boardElement[7] == ' ')
				boardElement[7] = compKey;
			else if (boardElement[3] == playerKey && boardElement[7] == playerKey && boardElement[5] == ' ')
				boardElement[5] = compKey;
			else if (boardElement[5] == playerKey && boardElement[7] == playerKey && boardElement[3] == ' ')
				boardElement[3] = compKey;

			else
				placeRandomly();
		}
		winningCondition_UC7();

	}

	public static void placeRandomly() {
		int computerTurn = 0;
		while (true) {
			computerTurn = 1 + (int) (Math.random() * 10) % 9;
			if (boardElement[computerTurn] == ' ') {
				boardElement[computerTurn] = compKey;
				showBoard_UC3();
				moveOnBoardandAssignKeyUC4_5(playerKey);

				break;
			}
		}
	}

	public static void main(String[] args) {
		TicTacToeGame ticTacToe = new TicTacToeGame();
		char[] boardElement = ticTacToe.UC1_createBoard();

		UC2_chooseKey();
		toss_UC6();
		makeMove();
		showBoard_UC3();
		moveOnBoardandAssignKeyUC4_5(turn);

	}
}
