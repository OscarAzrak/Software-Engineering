package Tools;

import javax.swing.*;

public class Square extends JButton {

	private static final long serialVersionUID = 1L;
	private int x;
	private int y;

	Square(int row, int column, String display){
		x = row;
		y = column;
		setText(display);
	}
	public void changedisp(String d){
		setText(d);
	}


}



