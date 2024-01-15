import java.awt.Color;


public class Main {
	
	public static void main(String[] args) {
				
		MyButton button = new MyButton(Color.red,Color.blue,"Alperen" ,"Oscar");
		MyButton button2 = new MyButton(Color.white,Color.green, "On", "Off");


		MyFrame test_frame = new MyFrame(button, button2);
		test_frame.setVisible(true);
		
		
	}

}
