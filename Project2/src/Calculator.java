import javax.swing.*;
import java.awt.*;
public class Calculator {
	JLabel calcScreen;
	String [] buttonsIcons = {"0" , "1", "2", "3", "4", "5",
							  "6", "7", "8", "9", "+", "-", "*", "/", "=", "C"};
	public Calculator()
	{
		JFrame frame = new JFrame("Raymond Arias' Calculator");
		frame.setSize(600, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new GridLayout(2,1));
		
		JPanel display = new JPanel();
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(4,4));
		
		calcScreen = new JLabel("0");
		display.add(calcScreen);
		frame.add(display);
		
		frame.setVisible(true);
	}
	public static void main(String []args)
	{
		SwingUtilities.invokeLater(new Runnable(){
			
			public void run()
			{
				new Calculator();
			}
			
		});
	
	}

}
