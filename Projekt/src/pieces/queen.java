package pieces;

import javax.swing.ImageIcon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import Chess.Square;

public class queen extends Piece{
    private int x;
    private int y;
    
    public queen(String color, int i, int j) {
        super(color, i, j);
        if (this.color.equals("WHITE")){
            this.image = new ImageIcon("src/image_pieces/white/queen.png");
        }else {
            this.image = new ImageIcon("src/image_pieces/black/queen.png");
        }
    }
    
    public boolean isValidMove(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return false;
        }
        if (Math.abs(x - this.x) == Math.abs(y - this.y)) {
            return true;
        }
        return false;
    }
    
    public String toString() {
        return "Queen";
    }
}
