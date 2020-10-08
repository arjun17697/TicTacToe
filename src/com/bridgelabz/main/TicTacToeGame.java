package com.bridgelabz.main;

import java.util.Scanner;

public class TicTacToeGame {
	char[] boardElement = new char[10];
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
			char compKey='O';
			char playerKey= 'X';
			System.out.println("Player Key:"+playerKey);
			System.out.println("Computer Key" +compKey);
			break;
		
		
		case 2:
			char compKey2='X';
			char playerKey2= 'O';
			System.out.println("Player Key:"+playerKey2);
			System.out.println("Computer Key" +compKey2);
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
