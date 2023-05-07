/**
 * Class Purpose: This class is responsible for creating the methods that will run the game
 * Autor: Felipe Didone / Jessica Pereira / Pedro Henrique Laranjeira Magalhães
 * Date: 04/09/2023
 * Time: 2pm
 */

import java.util.Scanner;

public class HashGame {

	

	//Create a single dimensional array to store players names
	private String[] players = new String[2];

	//Getters and setters for the players name
	public String setPlayer(int index, String name) {
		return players[index] = name;
	}
	public String getPlayer(int index) {
		return players[index];
	}

	//Variable to alternate the turns of play between players
	private int player = 1;
	
	/*play() method takes two arguments (column and row) and returns a boolean value. If the values passed to these arguments are outside the allowed range (1 to 3), the function returns false, indicating that the move is invalid. Otherwise, the function checks if the chosen position has already been occupied by a player previously. If so, it also returns false. If the move is valid, it places the corresponding symbol of the current player on the game board and alternates the turn of play between players*/
	public boolean play(int column, int row) {
		
		if (Board.hashGameBoard[column -1][row -1] != 0) {
			return false;
		}
		Board.hashGameBoard[column -1][row -1] = player;
			if (player == 1) {
				player = 2;
			} else {
				player = 1;
			}
			return true;
	}
	
	
	
	
	/*The start() method runs the game. It prompts the users to enter their names and takes turns in prompting each player to enter the column and row of their move. If the move is invalid, the program prints a message indicating so. */
	public void start() {
		Scanner scan = new Scanner(System.in);

		/*Receive players name through scan (input) and use get and set to change players names from the single array*/
		System.out.println("Enter Player 1 name: ");
		String player1 = setPlayer(0, scan.nextLine());
		System.out.println("Enter Player 2 name: ");
		String player2 = setPlayer(0, scan.nextLine());

		//While game has no winner or a draw

		do {
		try {
			//Try to run the code below
			//Ask player for column and row numbers and check if a valid move 
			//Print update board and player name after each move
			System.out.println(Board.boardToString());
			if (player == 1) {
				System.out.println(player1);
			} else {
				System.out.println(player2);
			}
			
			System.out.println("Enter the ROW and press enter: ");
			int row = scan.nextInt();
			System.out.println("Enter the COLUMN and press enter: ");
			int column = scan.nextInt();
			System.out.println("_____________________________________________________");
			System.out.println("");
			if (!play(column, row)) {
				System.out.println("This move was already done");
			}
		}
			//Handle any code exception with an invalid move message
			catch(ArrayIndexOutOfBoundsException ex) {
				System.out.println("You need to choose a value between 1 and 3");
			}
		}
		while (Board.winner() == 0);
		
		//Checks if the game ended with a winner or a draw and prints the message correctly
		System.out.println(Board.boardToString());
		int winner = Board.winner();
		if (winner == 1) {
			System.out.println(player1 + " is the winner!");
		} else if (winner == 2) {
			System.out.println(player2 + " is the winner!");
		} else if (winner == 3) {
			System.out.println("It's a draw!");
		}
		scan.close();
	}
}