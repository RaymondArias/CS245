//Name:	Arias, Raymond
//Project: 2
//Due: 10/30/15
//Course: CS-245-01-f15
//Description:
//				An integer calculator that can do
//				simple mathematical operations.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Stack;
public class Calculator implements ActionListener{
	private Stack <Long> operatorStack;
	private Stack <String> operandStack;
	private boolean isNewNumber;
	private boolean inErrorState; 
	JLabel calcScreen;
	String [] buttonIcons = {"7" , "8", "9", "/", "4", "5", "6", "x", "1", "2", "3", "-", "0", "C", "=", "+"};
	
	/**
	 * Constructor which creates frame and components used in 
	 * frame, it also sets all initial values
	 */
	public Calculator()
	{
		operatorStack = new Stack<>();
		operandStack = new Stack<>();
		isNewNumber = false;
		inErrorState = false;
		
		JFrame frame = new JFrame("Raymond Arias' Calculator");
		try {
			
			URL iconURL = new URL("http://www.cpp.edu/~tvnguyen7/courses/cs245f15/projs/Calculator.png");
			ImageIcon img = new ImageIcon(iconURL);
			frame.setIconImage(img.getImage());
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		frame.setSize(500, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new GridLayout(2,1));
		
		JPanel display = new JPanel();
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(4,4));
		display.setLayout(new BorderLayout());
		
		
		for(int i = 0; i < buttonIcons.length; i++)
		{
			JButton calcButtons = new JButton(buttonIcons[i]);
			calcButtons.addActionListener(this);
			if(buttonIcons[i].equals("C"))
				calcButtons.setMnemonic('C');
			if(buttonIcons[i].equals("="))
				frame.getRootPane().setDefaultButton(calcButtons);
			buttons.add(calcButtons);
		}
		
		calcScreen = new JLabel("0", FlowLayout.RIGHT);
		Font font = new Font("SANS_SERIF", Font.ROMAN_BASELINE, 30);
		calcScreen.setFont(font);
		display.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		display.add(calcScreen, BorderLayout.EAST);
		display.setBackground(Color.WHITE);
		frame.add(display);
		frame.add(buttons);
		
		frame.setVisible(true);
	}
	

	/**
	 * Event Listener which handles all the event
	 * the calculator programe uses
	 */
	public void actionPerformed(ActionEvent ae) 
	{
		//Program is in an error state
		//User must press "C" to escape error state
		if(inErrorState)
		{
			if(ae.getActionCommand().equals("C"))
			{
				clearOperation();
				inErrorState = false;
			}
			return;
		}
		
		//Button pushed was number
		if(Character.isDigit(ae.getActionCommand().charAt(0)))
		{
			//Make method to get button push and add to label
			if(calcScreen.getText().equals("0") || isNewNumber)
			{
				calcScreen.setText(ae.getActionCommand());
				isNewNumber = false;
			}
			else
			{
				if(calcScreen.getText().length() < 10)
				{
					calcScreen.setText(calcScreen.getText()+ ae.getActionCommand());
				}
			}
		}
		else if(isOperand(ae.getActionCommand()))
		{
		
			if(operandStack.isEmpty())
			{
				//Push number onto operator stack and operand
				//onto operand stack
				pushOperation(ae.getActionCommand());
				isNewNumber = true;
			}
			else
			{
				//There is operand on stack that needs to be evaluated
				//then the new number needs to pushed onto to stack
				operatorStack.push(doOperation());
				pushOperation(ae.getActionCommand());
				isNewNumber = true;
			}
			
		}
		else if(ae.getActionCommand().equals("="))
		{
			doOperation();
			while (!operatorStack.isEmpty())
			{
				operatorStack.pop();
			}
			while(!operandStack.empty())
			{
				operandStack.pop();
			}
			
			isNewNumber = true;
		}
		else if(ae.getActionCommand().equals("C"))
		{
			if((ae.getModifiers() & ActionEvent.CTRL_MASK) != 0)
			{
				calcScreen.setText("(c) 2015 Raymond Arias");
				inErrorState = true;
				return;
			}
			else
			{
				clearOperation();
			}
		}
		if(isError(null))
			return;
		
	}
	/**
	 * Boolean method which checks to if see event was an operand button
	 * @param buttonPress
	 * @return
	 */
	public boolean isOperand(String buttonPress)
	{
		return buttonPress.equals("+") || buttonPress.equals("-") 
				|| buttonPress.equals("x") || buttonPress.equals("/");
	}
	/**
	 * Method used to do all mathematical operations
	 * and returns values that may need to be push onto
	 * operand stack
	 * @return
	 */
	public Long doOperation()
	{
		Long newOutput;
		if(!operandStack.empty())
		{
			if(operandStack.peek().equals("+"))
			{
				newOutput = operatorStack.peek() + Long.parseLong(calcScreen.getText());
				calcScreen.setText(Long.toString(newOutput));
				operatorStack.pop();
				operandStack.pop();
				return newOutput;
			}
			else if(operandStack.peek().equals("-"))
			{
				newOutput = operatorStack.peek() - Long.parseLong(calcScreen.getText());
				calcScreen.setText(Long.toString(newOutput));
				operatorStack.pop();
				operandStack.pop();
				return newOutput;
			}
			else if(operandStack.peek().equals("x"))
			{
				newOutput = operatorStack.peek() * Long.parseLong(calcScreen.getText());
				calcScreen.setText(Long.toString(newOutput));
				operatorStack.pop();
				operandStack.pop();
				return newOutput;
				
			}
			else
			{
				if(isError(Integer.parseInt(calcScreen.getText())))
					return null;
				newOutput = operatorStack.peek() / Long.parseLong(calcScreen.getText());
				calcScreen.setText(Long.toString(newOutput));
				operatorStack.pop();
				operandStack.pop();
				return newOutput;
			}
			
		}
		return null;
		
	}
	/**
	 * Pushes data from calculator screen onto operand stack
	 * and operators onto operator stack
	 * @param tempOperand
	 */
	public void pushOperation(String tempOperand)
	{
		if(inErrorState || isError(null))
			return;
		
		
		if(tempOperand.equals("+"))
		{
			operatorStack.push(Long.parseLong((calcScreen.getText())));
			operandStack.push(tempOperand);
		}
		else if(tempOperand.equals("-"))
		{
			operatorStack.push(Long.parseLong((calcScreen.getText())));
			operandStack.push(tempOperand);
		}
		else if(tempOperand.equals("x"))
		{
			operatorStack.push(Long.parseLong((calcScreen.getText())));
			operandStack.push(tempOperand);
		}
		else
		{
			operatorStack.push(Long.parseLong((calcScreen.getText())));
			operandStack.push(tempOperand);
		}
	}
	/**
	 * Checks if calculator has any errors, either overflow
	 * caused by going over the 10 digit limit or division by
	 * zero. If either error occurs program outputs an error 
	 * message and enters error state.
	 * @param denominator
	 * @return
	 */
	public boolean isError(Integer denominator)
	{
		
		if(calcScreen.getText().length() > 10)
		{
			calcScreen.setText("Overflow");
			inErrorState = true;
			return true;
		}
		if(denominator == null)
			return false;
		if(denominator == 0)
		{
			calcScreen.setText("Div by 0");
			inErrorState = true;
			return true;
			
		}
		return false;
	}
	/**
	 * Clears the data in both stacks, set screen to "0",
	 * and set isNewNumber flag to true
	 */
	public void clearOperation()
	{
		calcScreen.setText("0");
		isNewNumber = true;
		while (!operatorStack.isEmpty())
		{
			operatorStack.pop();
		}
		while(!operandStack.empty())
		{
			operandStack.pop();
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
