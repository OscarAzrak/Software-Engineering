package Games;

import Tools.Boardgame;

import java.util.Objects;

public class TicTacToe implements Boardgame{
    private String currentMessage = "Welcome to TicTacToe";
    private String[][] board = new String[3][3];   // the game pad
    private int turn, countO, countX;// index to the empty square

    public TicTacToe() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                board[x][y] = "-";
            }
        }
        turn = 1;
    }
    @Override
    public boolean move(int x, int y) {
        try {
            if ((turn % 2) == 1) {
                //player one
                if (countO < 3) {
                    if (Objects.equals(board[x][y], "-")) {
                        board[x][y] = "O";
                        countO += 1;
                        currentMessage = "Player 2, make your Move!";
                        turn += 1;
                    }
                }else if (Objects.equals(board[x][y], "O")) {
                        board[x][y] = "-";
                        countO -= 1;
                        currentMessage = "Player 1, put down your piece!";
                }
            }
             else {
                //player two
                if (countX < 3) {
                    if (Objects.equals(board[x][y], "-")) {
                        board[x][y] = "X";
                        countX += 1;
                        currentMessage = "Player 1, make your Move!";
                        turn += 1;
                    }
                }else if (Objects.equals(board[x][y], "X")) {
                        board[x][y] = "-";
                        countX -= 1;
                        currentMessage = "Player 2, put down your piece!";
                }
            }
            return true;
            }catch(Exception e){
                currentMessage = "Choose a valid square";
                return false;
            }
        }
    @Override
    public String getStatus(int x, int y) {
        return board[x][y];
    }
    @Override
    public String getMessage() {
        return currentMessage;
    }
}
