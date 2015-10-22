import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Calculator implements ActionListener{
	JLabel calcScreen;
	String [] buttonIcons = {"7" , "8", "9", "/", "4", "5", "6", "x", "1", "2", "3", "-", "0", "C", "=", "+"};
	public Calculator()
	{
		JFrame frame = new JFrame("Raymond Arias' Calculator");
		frame.setSize(600, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new GridLayout(2,1));
		
		JPanel display = new JPanel();
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(4,4));
		
		for(int i = 0; i < buttonIcons.length; i++)
		{
			JButton calcButtons = new JButton(buttonIcons[i]);
			buttons.add(calcButtons);
		}
		
		calcScreen = new JLabel("0");
		display.add(calcScreen);
		
		frame.add(display);
		frame.add(buttons);
		
		frame.setVisible(true);
	}

	
	public void actionPerformed(ActionEvent ae) 
	{
		
		if(Character.isDigit(ae.getActionCommand().charAt(0)))
		{
			//Make method to get button push and add to label
		}
		
		
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
