import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton extends JButton implements ActionListener //Uppgift 4B
{

	private static final long serialVersionUID = 1L;
	
	Color c1;
	Color c2;
	String s1;
	String s2;
	
	//Constructor
	MyButton(Color c1, Color c2, String s1, String s2) {
		
		super(s1); //initiates a button with a certain string written in it
		this.c1 = c1;
		this.c2 = c2;
		this.s1 = s1;
		this.s2 = s2;
		
		setPreferredSize(new Dimension(200, 100)); //set size for buttons
		setBackground(c1);
		setOpaque(true);
		setBorderPainted(false); //had to put this since it only filled the borders with color otherwise
		addActionListener(this);	//uppgift 4B
	}

	public void togglestate() {
		if (this.getText()==this.s1) {
			this.setBackground(c2);
			this.setText(s2);
			
		} else {
			this.setBackground(c1);
			this.setText(s1);
			
		}
		
	}
	@Override
	//Upggift 4B
	public void actionPerformed(ActionEvent e) {
		this.togglestate();
	}
//	}
}
