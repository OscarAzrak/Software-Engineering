package Games;

import Tools.Boardgame;

public class MockGame implements Boardgame{
    private String currentMessage = "No message yet";
    private String[][] board;
    private int num;                        // index to the empty square


    public MockGame(){
        board = new String[5][5];

    }

    @Override
    public boolean move(int x, int y) {
        board[x][y] = Integer.toString(num);
        num += 1;
        return true;
    }

    @Override
    public String getStatus(int x, int y) {
        return board[x][y];
    }

    @Override
    public String getMessage() {
        return "No message yet";
    }
}
