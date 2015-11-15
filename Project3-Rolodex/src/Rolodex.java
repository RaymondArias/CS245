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
	private JDialog aboutDialog;
	private ImageIcon appIcon;
	
	public Rolodex()
	{
		//Assign input data to contact.txt url
		inputData = "http://www.cpp.edu/~tvnguyen7/courses/cs245f15/projs/Rolodex-res/contacts.txt";
		picUrl = new String[9];
		//initialize and set up Frame
		frame = new JFrame("Rolodex");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
		
		//set frame icon
		try {
			URL applicationIcon = new URL("http://www.cpp.edu/~tvnguyen7/courses/cs245f15/projs/Rolodex-res/Rolodex.png");
			appIcon = new ImageIcon(applicationIcon);
			frame.setIconImage(appIcon.getImage());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setMenu();
		createAboutDialog();
		loadPictureURLs();
		tabPane = new JTabbedPane();
		tabPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		addTab("Raymond", "Arias", "rarias2010@yahoo.com", "https://media.licdn.com/mpr/mpr/shrinknp_400_400/p/6/005/092/193/3695da9.jpg");
		readData();
		frame.add(tabPane);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	/**
	 * Method is used to set up menu bar
	 * for Rolodex application
	 * @param frame
	 */
	public void setMenu()
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
		open.setEnabled(false);
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
		defaults.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
                InputEvent.CTRL_MASK));
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
	public void addTab(String firstName, String lastName, String email, String pic)
	{
		JPanel newTab = new JPanel();
		newTab.setBackground(Color.WHITE);
		newTab.setLayout(new GridLayout(1,2));
		ImageIcon photo = null;
		try {
			if(pic == null)
			{
				pic = "http://www.cpp.edu/~tvnguyen7/courses/cs245f15/projs/Rolodex-res/nopic.jpg";
			}
			URL pictureURL = new URL(pic);
			photo = new ImageIcon(pictureURL);
			//image = photo.getImage();
			//scaledImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			//photo = new ImageIcon(scaledImage);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JLabel pictureSlot = new JLabel(photo);
		JPanel strPanel = new JPanel();
		strPanel.setBackground(Color.WHITE);
		strPanel.setLayout(new BorderLayout());
		String nameSlot = "<html>Name: " +firstName + " " + lastName+ "<br>";
		String emailSlot = "Email: " + email + "</html>";
		JLabel data = new JLabel(nameSlot + emailSlot);
		data.setHorizontalAlignment(JLabel.CENTER);
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
				String inputLine = input.readLine();
				while(inputLine != null)
				{
					
					contactInfo = inputLine.split(":");
					String []name = contactInfo[0].split(",");
					
					addTab(name[1], name[0], contactInfo[1], getPicURL(contactInfo[2]));
					inputLine = input.readLine();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			return;
		}
	}
	/**
	 * Assign indices of picUrl to url's from
	 * project three folder
	 */
	public void loadPictureURLs()
	{
		picUrl[0] = "http://www.cpp.edu/~tvnguyen7/courses/cs245f15/projs/Rolodex-res/bgates.jpg";
		picUrl[1] = "http://www.cpp.edu/~tvnguyen7/courses/cs245f15/projs/Rolodex-res/mzuckerberg.jpg";
		picUrl[2] = "http://www.cpp.edu/~tvnguyen7/courses/cs245f15/projs/Rolodex-res/bjoy.jpg";
		picUrl[3] = "http://www.cpp.edu/~tvnguyen7/courses/cs245f15/projs/Rolodex-res/sjobs.jpg";
		picUrl[4] = "http://www.cpp.edu/~tvnguyen7/courses/cs245f15/projs/Rolodex-res/dknuth.jpg";
		picUrl[5] = "http://www.cpp.edu/~tvnguyen7/courses/cs245f15/projs/Rolodex-res/jdorsey.jpg";
		picUrl[6] = "http://www.cpp.edu/~tvnguyen7/courses/cs245f15/projs/Rolodex-res/lpage.jpg";
		picUrl[7] = null;
		
	}
	/**
	 * Returns the url for picture assigned to the name passed in
	 * @param name
	 * @return
	 */
	public String getPicURL(String name)
	{
		if(name.equals("bgates.jpg"))
			return picUrl[0];
		else if(name.equals("mzuckerberg.jpg"))
			return picUrl[1];
		else if(name.equals("bjoy.jpg"))
			return picUrl[2];
		else if (name.equals("sjobs.jpg"))
			return picUrl[3];
		else if(name.equals("dknuth.jpg"))
			return picUrl[4];
		else if(name.equals("jdorsey.jpg"))
			return picUrl[5];
		else if(name.equals("lpage.jpg"))
			return picUrl[6];
		else if(name.equals("alovelace.jpg"))
			return picUrl[7];
			
		return null;
	}
	/**
	 * Creates about dialog and sets intial values
	 */
	public void createAboutDialog()
	{
		aboutDialog = new JDialog(frame, "About");
		aboutDialog.setSize(250, 100);
		aboutDialog.setLayout(new FlowLayout());
		aboutDialog.getContentPane().setBackground(Color.WHITE);
		aboutDialog.setLocationRelativeTo(frame);
		aboutDialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		JLabel dialogIcon = new JLabel(appIcon);
		JLabel text = new JLabel("<html> Rolodex verison 0.1 <br> Copyright (c) R.Arias</html>");
		aboutDialog.add(dialogIcon);
		aboutDialog.add(text);
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Exit"))
		{
			System.exit(0);
		}
		else if(ae.getActionCommand().equals("Top"))
		{
			tabPane.setTabPlacement(JTabbedPane.TOP);
		}
		else if(ae.getActionCommand().equals("Bottom"))
		{
			tabPane.setTabPlacement(JTabbedPane.BOTTOM);
		}
		else if(ae.getActionCommand().equals("Right"))
		{
			tabPane.setTabPlacement(JTabbedPane.RIGHT);
		}
		else if(ae.getActionCommand().equals("Left"))
		{
			tabPane.setTabPlacement(JTabbedPane.LEFT);
		}
		else if(ae.getActionCommand().equals("Scroll"))
		{
			tabPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		}
		else if(ae.getActionCommand().equals("Wrap"))
		{
			tabPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		}
		else if(ae.getActionCommand().equals("Defaults"))
		{
			tabPane.setTabPlacement(JTabbedPane.TOP);
			tabPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			
		}
		else if(ae.getActionCommand().equals("About"))
		{
			aboutDialog.setVisible(true);
		}
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
