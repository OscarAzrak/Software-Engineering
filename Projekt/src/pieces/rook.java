package pieces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;

import Chess.Square;

public class rook extends Piece {
    private int x;
    private int y;

    public rook(String color, int i, int j) {
        super(color, i, j);
        if (this.color.equals("WHITE")) {
            this.image = new ImageIcon("src/image_pieces/white/rook.png");
        } else {
            this.image = new ImageIcon("src/image_pieces/black/rook.png");
        }
    }

    public boolean isValidMove(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return false;
        }
        if (x == this.x || y == this.y) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Rook";
    }
}
