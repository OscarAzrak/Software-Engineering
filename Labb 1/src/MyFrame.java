import java.awt.*; 
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame //implements ActionListener
{ //4A
	private static final long serialVersionUID = 1L;
	public MyButton button;
	public MyButton button2;

  // constructor
  MyFrame()
  {
    super();// invoke the JFrame constructor
    setTitle("Alperen och Oscar");
    setSize(500, 500);
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); //If this is not prominent, have to close program manually
    
    setLayout(new FlowLayout() );       // set the layout manager, fixes the label
    getContentPane().setBackground(Color.YELLOW); //Cool color
    setVisible(true); //ask it to become visible
    
  }

  public MyFrame(MyButton button, MyButton button2) {
	  this();
	  this.button = button;
	  this.button2 = button2;
	  //button.addActionListener(this); //4A
	  //button2.addActionListener(this); //4A
	  add(button);
	  add(button2);
  }
  
  	//uppgift 4A
	/*@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			button.togglestate();
			}
		if(e.getSource() == button2) {
			button2.togglestate();
		}

	
	}*/
}
