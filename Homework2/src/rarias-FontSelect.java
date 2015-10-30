//Name: Arias Raymond
//Homework: 2
//Due 10/30/15
//Course: cs-245-01-f15
//Description:
//				Font Selector that read the font from windows system.
//				and display them in JList.
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class FontSelect implements ActionListener {
	private JList systemList;
	private JList selectedList;
	private String [] fontList;
	private DefaultListModel <String>selectedDefaultModel;
	private DefaultListModel <String>systemDefaultModel;
	public FontSelect()
	{
		JFrame frame = new JFrame("Font Select");
		frame.setSize(600, 200);
		frame.setLayout(new GridLayout(1,3));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fontList = getFontList();
		
		
		//Make left panel
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		JLabel leftLabel = new JLabel("System Fonts");
		leftLabel.setHorizontalAlignment(JLabel.CENTER);
		systemDefaultModel = new DefaultListModel();
		for(int i = 0; i < fontList.length; i++)
		{
			systemDefaultModel.addElement(fontList[i]);
		}
		systemList = new JList(systemDefaultModel);
		JScrollPane sysPane = new JScrollPane(systemList);
		leftPanel.add(leftLabel, BorderLayout.NORTH);
		leftPanel.add(sysPane, BorderLayout.CENTER);
		frame.add(leftPanel);
		
		//Make center panel
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2,1));
		JButton add = new JButton("Add");
		add.addActionListener(this);
		JButton print = new JButton("Print");
		print.addActionListener(this);
		centerPanel.add(add);
		centerPanel.add(print);
		frame.add(centerPanel);
		
		//make right panel
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		JLabel selected = new JLabel("Selected");
		selected.setHorizontalAlignment(JLabel.CENTER);
		selectedDefaultModel = new DefaultListModel<>();
		selectedList = new JList(selectedDefaultModel);
		JScrollPane selectedPane = new JScrollPane(selectedList);
		rightPanel.add(selected, BorderLayout.NORTH);
		rightPanel.add(selectedPane, BorderLayout.CENTER);
		frame.add(rightPanel);
		
		frame.setVisible(true);
	
		
	}
	public String [] getFontList()
	{
		File filePath = new File("C:\\Windows\\Fonts");
		String [] listOfFiles = filePath.list();
		ArrayList <String> retList = new ArrayList<>();
		for(int i = 0; i < listOfFiles.length; i++)
		{
			if(listOfFiles[i].substring(listOfFiles[i].length()-3, listOfFiles[i].length()).equals("ttf"))
			{
				retList.add(listOfFiles[i]);	
			}
		}
		return retList.toArray(new String[retList.size()]);
	}
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getActionCommand().equals("Add"))
		{
			int []selectedIndice = systemList.getSelectedIndices();
			if(selectedIndice == null)
				return;
			
			for(int i = 0; i < selectedIndice.length; i++)
			{
				
				//Object data =systemDefaultModel.toArray();
				selectedDefaultModel.addElement(systemDefaultModel.getElementAt(selectedIndice[i]));
				systemDefaultModel.remove(selectedIndice[i]);
				
				
				
			}
			
		}
		else
		{
			for(int i = 0; i < selectedDefaultModel.size(); i++)
			{
				System.out.println(selectedDefaultModel.getElementAt(i));
				
			}
			selectedDefaultModel.clear();
			systemDefaultModel.clear();
			for(int i = 0; i < fontList.length; i++)
			{
				systemDefaultModel.addElement(fontList[i]);
			}
		}
	}

	public static void main(String []args)
	{
		SwingUtilities.invokeLater(new Runnable(){

			
			public void run() {
				new FontSelect();
				
			}
			
		});
		
		
	}
}
