package pieces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;

import Chess.Square;


import javax.swing.*;
import java.awt.*;

public class king extends Piece {
    private int x;
    private int y;
 // implement king from chess
    public king(String color, int i, int j) {
        super(color, i, j);
        if (this.color.equals("WHITE")) {
            this.image = new ImageIcon("src/image_pieces/white/king.png");
        } else {
            this.image = new ImageIcon("src/images/black/king.png");
        }
    }

    public boolean isValidMove(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return false;
        }
        if (Math.abs(x - this.x) == 1 && Math.abs(y - this.y) == 1) {
            return true;
        }
        return false;
    }

    

}