package Chess;

import Chess.Chess;

public class ChessTest {
    public static void main(String[] args) {
        Chess gm = new Chess();
        ViewControl window = new ViewControl(gm);
        window.setVisible(true);
    }
}
