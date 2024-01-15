package Tools;

import Games.TicTacToe;

public class TicViewTest {
    public static void main(String[] args) {
        TicTacToe gm = new TicTacToe();
        ViewControl window = new ViewControl(gm, 3, 400, 400, "Welcome to TicTacToe");
        window.setVisible(true);
    }
}
