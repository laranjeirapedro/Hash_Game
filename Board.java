/**
 * Class Purpose: this class is responsible for setting the board where the game is going to happen
 * Autor: Felipe Didone / Jessica Pereira / Pedro Henrique Laranjeira Magalhães
 * Date: 04/09/2023
 * Time: 2pm
 */

public class Board{

    //Create a bidimensional array to create the game board
	//Static variable
	public static int [][] hashGameBoard = new int[3][3];

    /*The boardToString() method returns a string representation of the game board using the symbols "O" and "X" for players 1 and 2, respectively. */
	//Static Method
    public static String boardToString() {
		String out = "";
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				switch (hashGameBoard[column][row]) {
					case 0:
						out += " ";
						break;
					case 1:
						out += "O";
						break;
					case 2:
						out += "X";
						break;
				}
				if (column != 2) {
					out += " | ";
				}
			}
			out += "\n";
			if (row != 2) {
				out += "---------\n";
			}
		}
		return out;
	}

    /*The winner() method checks the game board for any winning combination of symbols or a draw. It returns an integer value indicating which player won (1 or 2), a draw (3), or 0 if the game is still ongoing */
    //Static method
    public static int winner() {

		//this main for loop will iterate twice, to check if one of the two players have won tha game
		for (int player = 1; player < 3; player++) {

			// Test the rows
			for (int row = 0; row < 3; row++) {
				boolean endGame = true;
				for (int column = 0; column < 3; column++) {
					if (hashGameBoard[row][column] != player) {
						endGame = false;
					}
				}
				if (endGame) {
					return player;
				}
			}

			// Test the columns
			for (int column = 0; column < 3; column++) {
				boolean endGame = true;
				for (int row = 0; row < 3; row++) {
					if (hashGameBoard[row][column] != player) {
						endGame = false;
					}
				}
				if (endGame) {
					return player;
				}
			}
		
			// Test diagonals
			boolean endGame = true;
			for (int diagonal = 0; diagonal < 3; diagonal++) {
				if (hashGameBoard[diagonal][diagonal] != player) {
					endGame = false;
				}
			}
			if (endGame) {
				return player;
			}
			endGame = true;
			for (int diagonal = 2; diagonal >= 0; diagonal--) {
				if (hashGameBoard[diagonal][2 - diagonal] != player) {
					endGame = false;
				}
			}
			if (endGame) {
				return player;
			}
		}
			
		// Test draw
		boolean draw = true;
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				if (hashGameBoard[row][column] == 0) {
					draw = false;
				}
			}
		}
		if (draw) {
			return 3;
		}
		return 0;
	}
}