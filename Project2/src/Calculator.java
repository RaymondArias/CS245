import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Calculator implements ActionListener{
	
	private String operator1;
	private String operand;
	
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
			calcButtons.addActionListener(this);
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
		//Button pushed was number
		if(Character.isDigit(ae.getActionCommand().charAt(0)))
		{
			//Make method to get button push and add to label
			if(calcScreen.getText().equals("0"))
			{
				calcScreen.setText(ae.getActionCommand());
			}
			else
			{
				calcScreen.setText(calcScreen.getText()+ ae.getActionCommand());
			}
		}
		else if(isOperand(ae.getActionCommand()))
		{
			String operand = ae.getActionCommand();
			if(operand.equals("+"))
			{
				operator1 = calcScreen.getText();
				operand = ae.getActionCommand();
			}
			else if(operand.equals("-"))
			{
				operator1 = calcScreen.getText();
				operand = ae.getActionCommand();
			}
			else if(operand.equals("x"))
			{
				operator1 = calcScreen.getText();
				operand = ae.getActionCommand();
			}
			else
			{
				operator1 = calcScreen.getText();
				operand = ae.getActionCommand();
			}
		}
		else if(ae.getActionCommand().equals("="))
		{
			if(operand != null)
			{
				if(operand.equals("+"))
				{
					int newOutput = Integer.parseInt(operator1) + Integer.parseInt(calcScreen.getText());
					calcScreen.setText(Integer.toString(newOutput));
					operator1 = null;
					operand = null;
				}
			}
		}
		
	}
	public boolean isOperand(String buttonPress)
	{
		return buttonPress.equals("+") || buttonPress.equals("-") 
				|| buttonPress.equals("x") || buttonPress.equals("/");
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
