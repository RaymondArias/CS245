import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
public class Calculator implements ActionListener{
	private Stack <Integer> operatorStack;
	private Stack <String> operandStack;
	private boolean isNewNumber;
	JLabel calcScreen;
	String [] buttonIcons = {"7" , "8", "9", "/", "4", "5", "6", "x", "1", "2", "3", "-", "0", "C", "=", "+"};
	
	public Calculator()
	{
		operatorStack = new Stack<>();
		operandStack = new Stack<>();
		isNewNumber = false;
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
			if(buttonIcons[i].equals("="))
				frame.getRootPane().setDefaultButton(calcButtons);
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
			if(calcScreen.getText().equals("0") || isNewNumber)
			{
				calcScreen.setText(ae.getActionCommand());
				isNewNumber = false;
			}
			else
			{
				if(!isError(null))
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
			isNewNumber = true;
			
		
		}
		else if(ae.getActionCommand().equals("C"))
		{
			if((ae.getModifiers() & ActionEvent.CTRL_MASK) != 0)
			{
				calcScreen.setText("(c) 2015 Raymond Arias");
			}
			else
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
		}
		
	}
	public boolean isOperand(String buttonPress)
	{
		return buttonPress.equals("+") || buttonPress.equals("-") 
				|| buttonPress.equals("x") || buttonPress.equals("/");
	}
	public Integer doOperation()
	{
		int newOutput;
		if(!operandStack.empty())
		{
			if(operandStack.peek().equals("+"))
			{
				newOutput = operatorStack.peek() + Integer.parseInt(calcScreen.getText());
				calcScreen.setText(Integer.toString(newOutput));
				operatorStack.pop();
				operandStack.pop();
				return newOutput;
			}
			else if(operandStack.peek().equals("-"))
			{
				newOutput = operatorStack.peek() - Integer.parseInt(calcScreen.getText());
				calcScreen.setText(Integer.toString(newOutput));
				operatorStack.pop();
				operandStack.pop();
				return newOutput;
			}
			else if(operandStack.peek().equals("x"))
			{
				newOutput = operatorStack.peek() * Integer.parseInt(calcScreen.getText());
				calcScreen.setText(Integer.toString(newOutput));
				operatorStack.pop();
				operandStack.pop();
				return newOutput;
				
			}
			else
			{
				newOutput = operatorStack.peek() / Integer.parseInt(calcScreen.getText());
				calcScreen.setText(Integer.toString(newOutput));
				operatorStack.pop();
				operandStack.pop();
				return newOutput;
			}
			
		}
		return null;
		
	}
	public void pushOperation(String tempOperand)
	{
		if(tempOperand.equals("+"))
		{
			operatorStack.push(Integer.parseInt(calcScreen.getText()));
			operandStack.push(tempOperand);
		}
		else if(tempOperand.equals("-"))
		{
			operatorStack.push(Integer.parseInt(calcScreen.getText()));
			operandStack.push(tempOperand);
		}
		else if(tempOperand.equals("x"))
		{
			operatorStack.push(Integer.parseInt(calcScreen.getText()));
			operandStack.push(tempOperand);
		}
		else
		{
			operatorStack.push(Integer.parseInt(calcScreen.getText()));
			operandStack.push(tempOperand);
		}
	}
	public boolean isError(Integer denominator)
	{
		
		if(calcScreen.getText().length() >= 10)
		{
			calcScreen.setText("Overflow");
			return true;
		}
		if(denominator == null)
			return false;
		if(denominator == 0)
		{
			calcScreen.setText("Div by 0");
			return true;
			
		}
		return false;
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
