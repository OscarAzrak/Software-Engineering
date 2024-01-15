package labb1Extra1;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton extends JButton //implements ActionListener
{ 


	private static final long serialVersionUID = 1L;
	
	String s1;
	String s2;
	
	//Constructor
	MyButton(String s1, String s2) {
		
		super(s1); //initiates a button with a certain string written in it

		this.s1 = s1;
		this.s2 = s2;
		
		setPreferredSize(new Dimension(200, 100)); //set size for buttons
		setOpaque(true);
		setBorderPainted(false); //had to put this since it only filled the borders with color otherwise
	}

	public void togglestate() {
		if (this.getText() == this.s1) {
			this.setText(s2);
			
		} else {
			this.setText(s1);
			
		}
		
	}
}
