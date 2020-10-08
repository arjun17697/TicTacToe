package com.bridgelabz.main;

public class TicTacToeGame {
	char[] boardElement = new char[10];

	public char[] UC1_createBoard() {
		for (int i = 1; i < 10; i++) {
			boardElement[i] = ' ';
		}
		return boardElement;
	}

	public static void main(String[] args) {
		TicTacToeGame ticTacToe = new TicTacToeGame();
		char[] boardElement = ticTacToe.UC1_createBoard();
	}
}
