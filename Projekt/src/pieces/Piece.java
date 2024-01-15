package pieces;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;

import Chess.Square;

//implement piece moves from chess

public class Piece {
	public String color;
	public int i,j;
	public Icon image;
	public boolean showMoves = false;
	public String opposite;
	//	public String path;
	
	public Piece(String color, int i, int j) {
		this.color = color;
		this.i = i;
		this.j = j;
		
		if (this.color.equals("WHITE")){
			this.opposite = "BLACK";
		}else {
			this.opposite = "WHITE";
		}
	}
	
	public Square[][] move(int i, int j, Square[][] board) {
		// Check for knight moves.
		// Check so new square isn't your own piece
		this.i = i;
		this.j = j;
		//board[i][j].piece = this;
		return board;
	}
	
	public boolean validateMove(Square[][] board, int toI, int toJ) {
		
		if (this.getAvailableMoves(board).contains(Arrays.asList(toI, toJ))) {
			return true;
		}
		
		return false;
	}
	
	public void showMoves(Square[][] board, List<List<Integer>> availableMoves) {
	}
	
	public List<List<Integer>> getAvailableMoves(Square[][] board){
		List<List<Integer>> availableMoves = new ArrayList<>();
		return availableMoves;
	}

}