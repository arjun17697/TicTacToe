package com.bridgelabz.main;

import java.util.Scanner;

public class TicTacToeGame {
	char[] boardElement = new char[10];
	static char compKey;
	static char playerKey;
//Assigning Board Elements
	public char[] UC1_createBoard() {
		for (int i = 1; i < 10; i++) {
			boardElement[i] = ' ';
		}
		return boardElement;
	}
	
//Method to choose between X and O
	public static void UC2_chooseKey() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Press 1 for choosing X as your key or 2 for choosing O as your key");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			compKey='O';
			playerKey= 'X';
			System.out.println("Player Key:"+playerKey);
			System.out.println("Computer Key" +compKey);
			break;
		case 2:
			compKey='X';
			playerKey= 'O';
			System.out.println("Player Key:"+playerKey);
			System.out.println("Computer Key" +compKey);
			break;
		default: 
			System.out.println("Invalid Input.Please enter again");
			UC2_chooseKey();
			break;	
		}
		
	}

	public static void main(String[] args) {
		TicTacToeGame ticTacToe = new TicTacToeGame();
		char[] boardElement = ticTacToe.UC1_createBoard();
		
		UC2_chooseKey();
		
	}
}
