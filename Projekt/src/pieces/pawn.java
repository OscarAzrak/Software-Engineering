package pieces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;

import Chess.Square;

public class pawn extends Piece{
    private int x;
    private int y;

    //implement pawn moves from chess
    public pawn(String color, int i, int j) {
        super(color, i, j);
        if (this.color.equals("WHITE")){
            this.image = new ImageIcon("src/image_pieces/white/pawn.png");
        }else {
            this.image = new ImageIcon("src/image_pieces/black/pawn.png");
        }
    }
    
}
