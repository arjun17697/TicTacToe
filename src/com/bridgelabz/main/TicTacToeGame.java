package com.bridgelabz.main;

import java.util.Scanner;

public class TicTacToeGame {
	static char[] boardElement = new char[10];
	static char compKey;
	static char playerKey;
	static int position;

//Assigning Board Elements
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
			System.out.println("Computer Key" + compKey);
			break;
		case 2:
			compKey = 'X';
			playerKey = 'O';
			System.out.println("Player Key:" + playerKey);
			System.out.println("Computer Key" + compKey);
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
	 * @return 
	 */
	public static int moveOnBoardandAssignKeyUC4_5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the position you want to move to: ");
		position = sc.nextInt();
		if (position > 9 || position < 1 && boardElement[position] != ' ') {
			System.out.println("You have entered invalid position.Please enter again");
			moveOnBoardandAssignKeyUC4_5();
			return 0;
		
		} else
			boardElement[position]= playerKey;
			return position;
		}

	public static void main(String[] args) {
		TicTacToeGame ticTacToe = new TicTacToeGame();
		char[] boardElement = ticTacToe.UC1_createBoard();

		UC2_chooseKey();
		showBoard_UC3();
		moveOnBoardandAssignKeyUC4_5();
		showBoard_UC3();

	}
}
