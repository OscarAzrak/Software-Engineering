package Games;

import Tools.Boardgame;
//import javafx.util.Pair;



public class Fifteen implements Boardgame {
	private String currentMessage = "No message yet";
	private String[][] board = new String[4][4];   // the game pad
	private int iemp, jemp;                        // index to the empty square

	//Make a constructor
	public Fifteen() {
		//Create
		int n = 0;
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				if (n == 0) {
					iemp = x;
					jemp = y;
					board[x][y] = "  ";
				}
				else if (n < 10) {
					board[x][y] = " " + Integer.toString(n); //padding
				}

				else{
					board[x][y] = Integer.toString(n);
				}
				n++;
			}
		}


		int randomSituation;
		for (int i = 0; i < 100; i++) {
			randomSituation = (int) (Math.random() * 4);
			if (randomSituation == 0) {
				  move(iemp - 1, jemp);
			} else if (randomSituation == 1) {
				  move(iemp + 1, jemp);
			} else if (randomSituation == 2) {
				  move(iemp, jemp - 1);
			} else if (randomSituation == 3) {
				  move(iemp, jemp + 1);
			}
		}
	}


	@Override
	public boolean move(int x, int y) {
		currentMessage="Choose a square next to the empty square";
		try {
			if (((x >= 0) && (x < 4)) &&  ((y >= 0) && (y < 4))){ //checks if the input is within gameboard
				if (x - 1 == iemp && y == jemp) {
					board[iemp][jemp] = board[x][y];
					board[x][y] = "  ";
					iemp = x;
					currentMessage="OK";
					return true;
				}
				else if (x + 1 == iemp && y == jemp) {
					board[iemp][jemp] = board[x][y];
					board[x][y] = "  ";
					iemp = x;
					currentMessage="OK";
					return true;
				}
				else if (x == iemp && y == jemp - 1)  { //gives true or false
					board[iemp][jemp] = board[x][y];
					board[x][y] = "  ";
					jemp = y;
					currentMessage="OK";
					return true;
				}
				else if (x == iemp && y == jemp + 1){
					board[iemp][jemp] = board[x][y];
					board[x][y] = "  ";
					jemp = y;
					currentMessage="OK";
					return true;
				}
				else {
					currentMessage="Choose a square next to the empty square";
					return false;
				}
			}
			else {
				currentMessage="Please choose a position within the board!";
				return false;
			}
		}

		catch (Exception e) {
			currentMessage="Choose a square next to the empty square";
			return false;
		}
	}

	public String getStatus(int x, int y) {
		return board[x][y];
	}

	@Override
	public String getMessage() {
		return currentMessage;
	}
}