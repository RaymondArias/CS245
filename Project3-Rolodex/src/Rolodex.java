import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Rolodex implements ActionListener
{
	private String inputData;
	private String []picUrl;
	private JTabbedPane tabPane;
	private JFrame frame;
	
	public Rolodex()
	{
		inputData = "http://www.cpp.edu/~tvnguyen7/courses/cs245f15/projs/Rolodex-res/contacts.txt";
		picUrl = new String[9];
		loadPictureURLs();
		//initialize and set up Frame
		frame = new JFrame("Rolodex");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
		
		//set frame icon
		try {
			URL applicationIcon = new URL("http://www.cpp.edu/~tvnguyen7/courses/cs245f15/projs/Rolodex-res/Rolodex.png");
			ImageIcon appIcon = new ImageIcon(applicationIcon);
			frame.setIconImage(appIcon.getImage());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setMenu(frame);
		tabPane = new JTabbedPane();
		tabPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		addTab(tabPane, "Lindsy", "Montano", "Test", "C:\\Users\\rayar\\Dropbox\\Camera Uploads\\2013-12-25 14.25.08.jpg");
		readData();
		frame.add(tabPane);
		frame.setVisible(true);
	}
	/**
	 * Method is used to set up menu bar
	 * for Rolodex application
	 * @param frame
	 */
	public void setMenu(JFrame frame)
	{
		JMenuBar jmb = new JMenuBar();
		
		//File menu
		JMenu file = new JMenu("File");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem exit = new JMenuItem("Exit");
		open.setMnemonic(KeyEvent.VK_O);
		exit.setMnemonic(KeyEvent.VK_I);
		file.setMnemonic(KeyEvent.VK_F);
		open.addActionListener(this);
		exit.addActionListener(this);
		file.add(open);
		file.addSeparator();
		file.add(exit);
		
		//Tabs menu
		JMenu tab = new JMenu("Tabs");
		//Placement submenu
		JMenu placement = new JMenu("Placement");
		JMenuItem top = new JMenuItem("Top");
		JMenuItem right = new JMenuItem("Right");
		JMenuItem bottom = new JMenuItem("Bottom");
		JMenuItem left = new JMenuItem("Left");
		tab.setMnemonic(KeyEvent.VK_T);
		placement.setMnemonic(KeyEvent.VK_P);
		top.setMnemonic(KeyEvent.VK_T);
		right.setMnemonic(KeyEvent.VK_R);
		bottom.setMnemonic(KeyEvent.VK_B);
		left.setMnemonic(KeyEvent.VK_L);
		top.addActionListener(this);
		right.addActionListener(this);
		bottom.addActionListener(this);
		left.addActionListener(this);
		placement.add(top);
		placement.add(right);
		placement.add(bottom);
		placement.add(left);
		tab.add(placement);
		//Layout submenu
		JMenu layout = new JMenu("Layout");
		JMenuItem scroll = new JMenuItem("Scroll");
		JMenuItem wrap = new JMenuItem("Wrap");
		layout.setMnemonic(KeyEvent.VK_L);
		scroll.setMnemonic(KeyEvent.VK_S);
		wrap.setMnemonic(KeyEvent.VK_W);
		scroll.addActionListener(this);
		wrap.addActionListener(this);
		layout.add(scroll);
		layout.add(wrap);
		tab.add(layout);
		tab.addSeparator();
		//Default submenu
		JMenuItem defaults = new JMenuItem("Defaults");
		defaults.setMnemonic(KeyEvent.VK_D);
		defaults.addActionListener(this);
		tab.add(defaults);

		//Help Menu
		JMenu help = new JMenu("Help");
		JMenuItem about = new JMenuItem("About");
		help.setMnemonic(KeyEvent.VK_H);
		about.setMnemonic(KeyEvent.VK_A);
		about.addActionListener(this);
		help.add(about);
		
		
		jmb.add(file);
		jmb.add(tab);
		jmb.add(help);
		frame.setJMenuBar(jmb);
		
	}
	/**
	 * Adds new tab to rolodex
	 * @param tabPane
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param pic
	 */
	public void addTab(JTabbedPane tabPane, String firstName, String lastName, String email, String pic)
	{
		JPanel newTab = new JPanel();
		newTab.setLayout(new GridLayout(1,2));
		ImageIcon photo = new ImageIcon(pic);
		Image image = photo.getImage();
		Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		photo = new ImageIcon(scaledImage);
		
		if(photo == null)
		{
			try {
				URL defaultPic = new URL("http://www.cpp.edu/~tvnguyen7/courses/cs245f15/projs/Rolodex-res/nopic.jpg");
			} catch (MalformedURLException e) {
			}
		}
		
		JLabel pictureSlot = new JLabel(photo);
		JPanel strPanel = new JPanel();
		strPanel.setLayout(new BorderLayout());
		String nameSlot = "<html>Name: " +firstName + " " + lastName+ "<br>";
		String emailSlot = "Email: " + email + "</html>";
		JLabel data = new JLabel(nameSlot + emailSlot);
		strPanel.add(data,BorderLayout.CENTER);
		newTab.add(pictureSlot);
		newTab.add(strPanel);
	
		tabPane.addTab(lastName + ", " + firstName, newTab);
	}
	/**
	 * Reads data from contact.txt
	 * and add new tab to tab pane with data
	 * @throws IOException 
	 */
	public void readData()
	{
		URL contactTxt;
		BufferedReader input;
		String []contactInfo = new String[4];
		try {
			contactTxt = new URL(inputData);
			try {
				input = new BufferedReader(new InputStreamReader(contactTxt.openStream()));
				String inputLine;
				while(input.readLine() != null)
				{
					inputLine = input.readLine();
					contactInfo = inputLine.split(":");
					String []name = contactInfo[0].split(",");
					addTab(tabPane,name[1], name[0], contactInfo[1], contactInfo[2]);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			return;
		}
		
		for(int i = 0; i < contactInfo.length; i++)
		{
			System.out.println(contactInfo[i]);
		}
		
		
	}
	public void loadPictureURLs()
	{
		picUrl[0] = "http://www.cpp.edu/~tvnguyen7/courses/cs245f15/projs/Rolodex-res/bgates.jpg";
		picUrl[1] = "http://www.cpp.edu/~tvnguyen7/courses/cs245f15/projs/Rolodex-res/mzuckerberg.jpg";
		picUrl[2] = "http://www.cpp.edu/~tvnguyen7/courses/cs245f15/projs/Rolodex-res/bjoy.jpg";
		picUrl[3] = "http://www.cpp.edu/~tvnguyen7/courses/cs245f15/projs/Rolodex-res/sjobs.jpg";
		picUrl[4] = "http://www.cpp.edu/~tvnguyen7/courses/cs245f15/projs/Rolodex-res/dknuth.jpg";
		picUrl[5] = "http://www.cpp.edu/~tvnguyen7/courses/cs245f15/projs/Rolodex-res/jdorsey.jpg";
		picUrl[6] = "http://www.cpp.edu/~tvnguyen7/courses/cs245f15/projs/Rolodex-res/lpage.jpg";
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String []args)
	{
		SwingUtilities.invokeLater(new Runnable(){
			public void run()
			{
				new Rolodex();
			}
		});
	}
	

}
