/*
 * PROGRAM NAME:	Library Management System
 * VERSION:			DEMO VERSION
 * 
 * AUTHOR:			Mohammad Zunayed Hassan
 * EMAIL:			zunayedhassan88@gmail.com
 * PHONE:			+8801741284439
 * 
 * NOTE:			This program has made as our project for "Object Oriented Programming
 * 					Course 1"  (Java)  and  "Introduction  to  Database  1"  in  American
 * 					International University - Bangladesh (AIUB)
 * 
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import javax.swing.table.*;
import java.awt.print.*;
import java.text.*;
import com.toedter.calendar.*;

class Settings {
	// Splash screen waiting duration settings
	int splashScreenDuration;

	// Login Window settings
	int loginFrameWidth;
	int loginFrameHeight;
	
	// JDBC Connection related settings
	public String connectionString;
	String dataBaseName;
	String dbUserName;
	String dbPassword;
	String driver;
	
	// Login constraints
	int minUsrIdLength;
	int minUsrPwdLength;
	
	// User login settings
	public String userId;
	public String userPassword;
	
	// Connection
	public boolean connectionEstablished;
	
	// MDI Form settings
	int mdiFrameWidth;								// MDI Frame
	int mdiFrameHeight;
	
	Dimension deskMinPaneSize = new Dimension();	// Desktop Pane
	
	String softwareInfo;							// for infoPanel
	
	int intFrameWidth;								// Internal frame
	int intFrameHeight;
	int intFrameCounter;
	int intFrameSpacing;
	
	// Add new entry wizard frame settings
	int newEntryWizardFrameWidth;
	int newEntryWizardFrameHeight;
	
	// Add new user frame settings
	int addNewUserFrameWidth;
	int addNewUserFrameHeight;
	
	// Add new book frame settings
	int addNewBookFrameWidth;
	int addNewBookFrameHeight;
	
	// Add new reservation frame settings
	int addNewResrvEntryFrameWidth;
	int addNewResrvEntryFrameHeight;
	
	// Search frame settings
	int seacrhFrameWidth;
	int searchFrameHeight;
	
	String searchKeyword;
	
	// User Info Frame Settings
	int userInfoFrameWidth;
	int userInfoFrameHeight;
	
	Date minDate;									// Selectable date range for DateChooser (JCalender)
	Date maxDate;
	
	// Change Password Frame Settings
	int chngPwdFrameWidth;
	int chngPwdFrameHeight;
	
	// About Window Settings
	int aboutMenuWidth;								
	int aboutMenuHeight;
	
	// book_info table constraints
	int min_isbn;
	int min_book_title;
	int min_author;
	int min_publisher;
	int min_pages;
	
	// user_info table constraints
	int min_user_name_first;
	int min_user_name_last;
	int min_user_name;
	int min_phone;
	int min_email;
	int min_adrs_house_no;
	int min_adrs_street;
	int min_adrs_city;
	int min_zip;

	int finePerDay;
	
	String userType;
	
	Settings() {
		this.splashScreenDuration = 1000;			// Nanoseconds
		
		this.loginFrameWidth = 325;
		this.loginFrameHeight = 220;
		
		this.connectionString = "jdbc:mysql://127.0.0.1/";
		this.dbUserName = "root";
		this.dataBaseName = "lmsDB";
		this.dbPassword = "zhp.lin";
		this.driver = "com.mysql.jdbc.Driver";
		
		this.minUsrIdLength = 7;
		this.minUsrPwdLength = 5;
		
		this.connectionEstablished = false;
		
		this.mdiFrameWidth = 800;
		this.mdiFrameHeight = 630;
		
		this.newEntryWizardFrameWidth = this.loginFrameWidth;
		this.newEntryWizardFrameHeight = this.loginFrameHeight + 40;
		
		this.addNewUserFrameWidth = 400;
		this.addNewUserFrameHeight = 450;
		
		this.addNewBookFrameWidth = 300;
		this.addNewBookFrameHeight = 300;
		
		this.addNewResrvEntryFrameWidth = 400;
		this.addNewResrvEntryFrameHeight = 250;
		
		this.seacrhFrameWidth = 360;
		this.searchFrameHeight = 135;
		
		this.searchKeyword = "";
		
		this.userInfoFrameWidth = 480;
		this.userInfoFrameHeight = 480;
		
		this.minDate = new Date("Jan 01, 1950");
		this.maxDate = new Date("Dec 31, 2099");
		
		this.aboutMenuWidth = 280;
		this.aboutMenuHeight = 490;
		
		this.deskMinPaneSize.width = 450;
		this.deskMinPaneSize.height = 240;
		
		this.softwareInfo = "Mohammad Zunayed Hassan, 2010. email: zunayedhassan88@gmail.com";
		
		this.intFrameWidth = 400;
		this.intFrameHeight = 220;
		this.intFrameSpacing = 40;
		
		this.min_isbn = 10;
		this.min_book_title = 1;
		this.min_author = 3;
		this.min_publisher = 4;
		this.min_pages = 30;
		
		this.min_user_name_first = 1;
		this.min_user_name_last = 2;
		this.min_user_name = 3;
		this.min_phone = 5;
		this.min_email = 6;
		this.min_adrs_house_no = 1;
		this.min_adrs_street = 3;
		this.min_adrs_city = 3;
		this.min_zip = 4;
		
		this.finePerDay = 3;
		
		this.chngPwdFrameWidth = 380;
		this.chngPwdFrameHeight = 195;
	}
}

class SplashScreen extends JWindow {
	SplashScreen(int duration) {
		Settings splashSettings = new Settings();
		
		JPanel splashPanel = (JPanel) getContentPane();
		splashPanel.setBackground(Color.WHITE);
			
		// Set the window's bounds, centering the window
		int splashWidth = 516;
        int splashHeight = 344;
	        
       	Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
       	int x = (screenDimension.width - splashWidth) / 2;
       	int y = (screenDimension.height - splashHeight) / 2;
	        
       	setBounds(x, y, splashWidth, splashHeight);
	        
       	// Build the splash screen
       	JLabel splashLabel = new JLabel(new ImageIcon("splash.png"));
        JLabel splashInfoLabel = new JLabel(splashSettings.softwareInfo, JLabel.CENTER);
       	splashInfoLabel.setFont(new Font("Sans-Serif", Font.BOLD, 12));
       	splashPanel.add(splashLabel, BorderLayout.CENTER);
       	splashPanel.add(splashInfoLabel, BorderLayout.SOUTH);
       	Color oraRed = new Color(156, 20, 20,  255);
       	splashPanel.setBorder(BorderFactory.createLineBorder(oraRed, 5));
	        
	   	// Display it
       	setVisible(true);
	        
	   	// Wait a little while, maybe while loading resources
	   	try {
    		Thread.sleep(duration);
	    } catch (Exception exp) {
	   		JOptionPane.showMessageDialog(null, "ERROR: Threding problem !!!", "Error", JOptionPane.ERROR_MESSAGE);
	   	}
	        
	   	// Closing splash screen
    	setVisible(false);
    	dispose();
	}
}

class ImagePanel extends JPanel {
	Image image;
	int positionX;
	int positionY;
	
	public ImagePanel(String fileName, int posX, int posY) throws IOException {
		this.positionX = posX;
		this.positionY = posY;
		
		try {
			image = ImageIO.read(new File(fileName));
		} catch (IOException exp) {
			exp.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics grph) {
		super.paintComponents(grph);
		if(image == null)
			return;
		else
			grph.drawImage(image, this.positionX, this.positionY, null);
	}
}

class PrintUtilities implements Printable {
	private Component componentToBePrinted;

	public static void printComponent(Component c) {
		new PrintUtilities(c).print();
	}
	  
	public PrintUtilities(Component componentToBePrinted) {
		this.componentToBePrinted = componentToBePrinted;
	}
	  
	public void print() {
		PrinterJob printJob = PrinterJob.getPrinterJob();
	    printJob.setPrintable(this);
	    
	    if (printJob.printDialog()) {
	    	try {
	    		printJob.print();
	    	} catch(PrinterException pe) {
	    		System.out.println("Error printing: " + pe);
	    	}
	    }
	}

	public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
		if (pageIndex > 0) {
			return(NO_SUCH_PAGE);
	    }
		else {
			Graphics2D g2d = (Graphics2D)g;
			g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
			disableDoubleBuffering(componentToBePrinted);
			componentToBePrinted.paint(g2d);
			enableDoubleBuffering(componentToBePrinted);
			return(PAGE_EXISTS);
		}
	}

	public static void disableDoubleBuffering(Component c) {
		RepaintManager currentManager = RepaintManager.currentManager(c);
	    currentManager.setDoubleBufferingEnabled(false);
	}

	public static void enableDoubleBuffering(Component c) {
		RepaintManager currentManager = RepaintManager.currentManager(c);
	    currentManager.setDoubleBufferingEnabled(true);
	}
}

public class LibraryManagementSystem_gui {
	// Declaring settings
	public static final Settings lmsDefaultSettings = new Settings();
	public static final Settings currentUsrSettings = new Settings();
	public static final JDesktopPane deskPane = new JDesktopPane();
	public static final String countryName[] = new String[] { "Afganistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Beliz", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgeria", "Burkina Faso", "Burma (Myanmar)", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Republic", "Chad", "Chiele", "China", "Colombia", "Comoros", "Congo", "Costa Rica", "Crotia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salbador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethopia", "Fiji", "Finland", "France", "French Polyynesia", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhastan", "Kenya", "Kiribati", "Korea, North", "Korea, South", "Kuwait", "Kyrgystan", "Laos", "Lativa", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Island", "Mauritania", "Mauritius", "Mexico", "Micronesi, Federated States of", "Moldova", "Monaco", "Mongolia", "Morocco", "Mozambique", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Northern Cyprus", "Northern Mariana Island", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "St. Kitts and Nevis", "St. Lucia", "St. Vincent and Grendines", "San Marino", "Sao Tome Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Island", "Somalia", "South Africa", "Spain", "Sri Lanca", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikstan", "Tanzania", "Thiland", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkemenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Western Sahara", "Western Samoa", "Yemen", "Yugoslavia", "Zaire", "Zambia", "Zimbabwe" };
	
	public static final class CreateIntFrame extends JInternalFrame {
		JInternalFrame intrlFrame;
		JTable table;
		String tableName = new String();
		
		CreateIntFrame(String intFrameTitle, String tableName, String customizedSQL) {
			this.intrlFrame = new JInternalFrame();
	       	intrlFrame.setClosable(true);
	       	intrlFrame.setMaximizable(true);
	       	intrlFrame.setIconifiable(true);
	       	intrlFrame.setResizable(true);
	       	intrlFrame.setSize(currentUsrSettings.intFrameWidth, currentUsrSettings.intFrameHeight);
	       	intrlFrame.setLocation(currentUsrSettings.intFrameSpacing * currentUsrSettings.intFrameCounter, currentUsrSettings.intFrameSpacing * currentUsrSettings.intFrameCounter);
	       	
	       	currentUsrSettings.intFrameCounter++;
			intrlFrame.setTitle(intFrameTitle);
			
			this.tableName = tableName;
			
			try {
				Class.forName(currentUsrSettings.driver);
				Connection conn = DriverManager.getConnection(currentUsrSettings.connectionString + currentUsrSettings.dataBaseName, currentUsrSettings.dbUserName, currentUsrSettings.dbPassword);
				
				try {
					final Statement st = conn.createStatement();
					ResultSet result;
					if(customizedSQL.equals("null")) {
						result = st.executeQuery("SELECT * FROM " + tableName + ";");
					}
					else {
						result = st.executeQuery(customizedSQL);
					}
					ResultSetMetaData md = result.getMetaData();
					
					int columnCount = md.getColumnCount();
					Vector columns = new Vector(columnCount);
					
					//store column names
					for(int i = 1; i <= columnCount; i++)
						columns.add(md.getColumnName(i));

					Vector data = new Vector();
					Vector row;
					
					//store row data
					while(result.next()) {
						row = new Vector(columnCount);
						
						for(int i=1; i<=columnCount; i++) {
							row.add(result.getString(i));
						}
						
						data.add(row);
					}
					
					DefaultTableModel model = new DefaultTableModel(data, columns);
					
					this.table = new JTable(model);
					table.setAutoCreateRowSorter(true);
					
				} catch(SQLException exp) {
					JOptionPane.showMessageDialog(null, "ERROR: Can't execute SQL statement.", "Error", JOptionPane.ERROR_MESSAGE);
					exp.printStackTrace();
				}
				
			} catch(Exception exp) {
				JOptionPane.showMessageDialog(null, "ERROR: Can't connect with the database. PLease check your connection again.", "Error", JOptionPane.ERROR_MESSAGE);
				exp.printStackTrace();
			}
			
	       	intrlFrame.add(new JScrollPane(table), BorderLayout.NORTH);
		}
	}
	
	public static final CreateIntFrame bookWindow = new CreateIntFrame("Book Table", "book_info", "null");		// Book Table
	public static final CreateIntFrame userWindow = new CreateIntFrame("User Table", "user_info", "null");		// User Table
	public static final CreateIntFrame issueWindow = new CreateIntFrame("Issue Table", "null", "SELECT user_info.user_id, user_info.user_name_first, user_info.user_name_middle, user_info.user_name_last, issue.isbn, book_info.title, book_info.author, book_info.publisher, issue.issue_date, issue.due_date FROM user_info, issue, book_info WHERE user_info.user_id = issue.user_id AND issue.isbn = book_info.isbn;");		// Issue Table
	public static final CreateIntFrame userIssueWindow = new CreateIntFrame("User Issue Table", "null", "SELECT user_info.user_id, user_info.user_name_first, user_info.user_name_middle, user_info.user_name_last, issue.isbn, book_info.title, book_info.author, book_info.publisher, issue.issue_date, issue.due_date FROM user_info, issue, book_info WHERE user_info.user_id = issue.user_id AND issue.isbn = book_info.isbn AND issue.user_id = " + currentUsrSettings.userId + ";");		// Only for member
	
	public static final class ErrorChecker {
		boolean checkNumber(String examineString) {
			try {
				int number = Integer.parseInt(examineString);
				
				if(number > 0) {
					return true;
				}
				else {
					return false;
				}
			} catch(NumberFormatException exp) {
				return false;
			}
		}
		
		boolean checkEmail(String examineString) {
			if(((examineString.endsWith(".com") == true) || (examineString.endsWith(".org") == true) || (examineString.endsWith(".net") == true) || (examineString.endsWith(".edu") == true)) && (examineString.lastIndexOf('@') != -1) && (examineString.indexOf('!') == -1) && (examineString.indexOf('#') == -1) && (examineString.indexOf('$') == -1) && (examineString.indexOf('%') == -1) && (examineString.indexOf('^') == -1) && (examineString.indexOf('&') == -1) && (examineString.indexOf('*') == -1) && (examineString.indexOf('(') == -1) && (examineString.indexOf(')') == -1) && (examineString.indexOf('{') == -1) && (examineString.indexOf('}') == -1) && (examineString.indexOf('[') == -1) && (examineString.indexOf(']') == -1) && (examineString.indexOf('|') == -1) && (examineString.indexOf('\\') == -1) && (examineString.indexOf('/') == -1) && (examineString.indexOf(',') == -1) && (examineString.indexOf(';') == -1) && (examineString.indexOf(':') == -1) && (examineString.indexOf('"') == -1) && (examineString.indexOf('?') == -1) && (examineString.indexOf('~') == -1) && (examineString.indexOf('`') == -1) && (examineString.indexOf('<') == -1) && (examineString.indexOf('>') == -1) && !(examineString.charAt(0) == '@') && !(examineString.charAt(0) == '.')) {
				boolean correctness = false;
				int atFound = 0;
				int fsFound = 0;
				
				for(int index = 0; index < examineString.length(); index++) {
					if(examineString.charAt(index) == '@') {
						atFound = atFound + 1;
						if(atFound > 1) {
							correctness = false;
							break;
						}
						else {
							correctness = true;
							
							if(examineString.charAt(index) == '.') {
								fsFound = fsFound + 1;
								if(fsFound > 1) {
									correctness = false;
									break;
								}
								else {
									correctness = true;
								}
							}
						}
					}
				}
				
				return correctness;
			}
			else {
				return false;
			}
		}
		
		boolean checkPhoneNo(String examineString) {
			boolean correctness = false;
			for(int index = 0; index < examineString.length(); index++) {
				if((examineString.charAt(index) > '0' - 1) && (examineString.charAt(index) < '9' + 1))
					correctness = true;
				else {
					correctness = false;
					break;
				}
			}
			
			return correctness;
		}
	}
	
	// This method will return a DATE as medium date format from MySQL date format. (Example: 2010-12-25 to 25 Dec, 2010)
	public static final Date mysqlDateConverter(String mysqlDate) {
		int monthNo = Integer.parseInt(String.valueOf(mysqlDate.substring(5, 7)));
		String month = new String();
		
		if(monthNo == 1)
			month = "Jan";
		else if(monthNo == 2)
			month = "Feb";
		else if(monthNo == 3)
			month = "Mar";
		else if(monthNo == 4)
			month = "Apr";
		else if(monthNo == 5)
			month = "May";
		else if(monthNo == 6)
			month = "Jun";
		else if(monthNo == 7)
			month = "Jul";
		else if(monthNo == 8)
			month = "Aug";
		else if(monthNo == 9)
			month = "Sep";
		else if(monthNo == 10)
			month = "Oct";
		else if(monthNo == 11)
			month = "Nov";
		else if(monthNo == 12)
			month = "Dec";
		
		Date convertedDate = new Date(month + " " + mysqlDate.substring(8, 10) + ", " + mysqlDate.substring(0, 4));
		
		return convertedDate;
	}
	
	public static final void refreshBookInfoTable() {
		try {
			Class.forName(currentUsrSettings.driver);
			Connection conn = DriverManager.getConnection(currentUsrSettings.connectionString + currentUsrSettings.dataBaseName, currentUsrSettings.dbUserName, currentUsrSettings.dbPassword);
			try {
				final Statement st = conn.createStatement();
				ResultSet result = st.executeQuery("SELECT * FROM book_info;");
				ResultSetMetaData md = result.getMetaData();
				
				int columnCount = md.getColumnCount();
				Vector columns = new Vector(columnCount);
				
				//store column names
				for(int i = 1; i <= columnCount; i++)
					columns.add(md.getColumnName(i));

				Vector data = new Vector();
				Vector row;
				
				//store row data
				while(result.next()) {
					row = new Vector(columnCount);
					
					for(int i=1; i<=columnCount; i++) {
						row.add(result.getString(i));
					}
					
					data.add(row);
				}
				
				DefaultTableModel currentTableModel = new DefaultTableModel(data, columns);
				bookWindow.table.setModel(currentTableModel);
				
			} catch (SQLException exp) {
				JOptionPane.showMessageDialog(null, "ERROR: Can't execute SQL statement.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch(Exception exp) {
			JOptionPane.showMessageDialog(null, "ERROR: Can't connect to the database. Please, check your connection again.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static final void refreshUserInfoTable() {
		try {
			Class.forName(currentUsrSettings.driver);
			Connection conn = DriverManager.getConnection(currentUsrSettings.connectionString + currentUsrSettings.dataBaseName, currentUsrSettings.dbUserName, currentUsrSettings.dbPassword);
			try {
				final Statement st = conn.createStatement();
				ResultSet result = st.executeQuery("SELECT * FROM user_info;");
				ResultSetMetaData md = result.getMetaData();
				
				int columnCount = md.getColumnCount();
				Vector columns = new Vector(columnCount);
				
				//store column names
				for(int i = 1; i <= columnCount; i++)
					columns.add(md.getColumnName(i));

				Vector data = new Vector();
				Vector row;
				
				//store row data
				while(result.next()) {
					row = new Vector(columnCount);
					
					for(int i=1; i<=columnCount; i++) {
						row.add(result.getString(i));
					}
					
					data.add(row);
				}
				
				DefaultTableModel currentTableModel = new DefaultTableModel(data, columns);
				userWindow.table.setModel(currentTableModel);
				
			} catch (SQLException exp) {
				JOptionPane.showMessageDialog(null, "ERROR: Can't execute SQL statement.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch(Exception exp) {
			JOptionPane.showMessageDialog(null, "ERROR: Can't connect to the database. Please, check your connection again.", "Error", JOptionPane.ERROR_MESSAGE);
			exp.printStackTrace();
		}
	}
	
	public static final void refreshIssueTable() {
		try {
			Class.forName(currentUsrSettings.driver);
			Connection conn = DriverManager.getConnection(currentUsrSettings.connectionString + currentUsrSettings.dataBaseName, currentUsrSettings.dbUserName, currentUsrSettings.dbPassword);
			try {
				final Statement st = conn.createStatement();
				ResultSet result = st.executeQuery("SELECT user_info.user_id, user_info.user_name_first, user_info.user_name_middle, user_info.user_name_last, issue.isbn, book_info.title, book_info.author, book_info.publisher, issue.issue_date, issue.due_date FROM user_info, issue, book_info WHERE user_info.user_id = issue.user_id AND issue.isbn = book_info.isbn;");
				ResultSetMetaData md = result.getMetaData();
				
				int columnCount = md.getColumnCount();
				Vector columns = new Vector(columnCount);
				
				//store column names
				for(int i = 1; i <= columnCount; i++)
					columns.add(md.getColumnName(i));

				Vector data = new Vector();
				Vector row;
				
				//store row data
				while(result.next()) {
					row = new Vector(columnCount);
					
					for(int i=1; i<=columnCount; i++) {
						row.add(result.getString(i));
					}
					
					data.add(row);
				}
				
				DefaultTableModel currentTableModel = new DefaultTableModel(data, columns);
				issueWindow.table.setModel(currentTableModel);
				
			} catch (SQLException exp) {
				JOptionPane.showMessageDialog(null, "ERROR: Can't execute SQL statement.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch(Exception exp) {
			JOptionPane.showMessageDialog(null, "ERROR: Can't connect to the database. Please, check your connection again.", "Error", JOptionPane.ERROR_MESSAGE);
			exp.printStackTrace();
		}
	}
	
	public static final void refreshuserIssueTable() {
		try {
			Class.forName(currentUsrSettings.driver);
			Connection conn = DriverManager.getConnection(currentUsrSettings.connectionString + currentUsrSettings.dataBaseName, currentUsrSettings.dbUserName, currentUsrSettings.dbPassword);
			try {
				final Statement st = conn.createStatement();
				ResultSet result = st.executeQuery("SELECT user_info.user_id, user_info.user_name_first, user_info.user_name_middle, user_info.user_name_last, issue.isbn, book_info.title, book_info.author, book_info.publisher, issue.issue_date, issue.due_date FROM user_info, issue, book_info WHERE user_info.user_id = issue.user_id AND issue.isbn = book_info.isbn AND issue.user_id = " + currentUsrSettings.userId + ";");
				ResultSetMetaData md = result.getMetaData();
				
				int columnCount = md.getColumnCount();
				Vector columns = new Vector(columnCount);
				
				//store column names
				for(int i = 1; i <= columnCount; i++)
					columns.add(md.getColumnName(i));

				Vector data = new Vector();
				Vector row;
				
				//store row data
				while(result.next()) {
					row = new Vector(columnCount);
					
					for(int i=1; i<=columnCount; i++) {
						row.add(result.getString(i));
					}
					
					data.add(row);
				}
				
				DefaultTableModel currentTableModel = new DefaultTableModel(data, columns);
				userIssueWindow.table.setModel(currentTableModel);
				
			} catch (SQLException exp) {
				JOptionPane.showMessageDialog(null, "ERROR: Can't execute SQL statement.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch(Exception exp) {
			JOptionPane.showMessageDialog(null, "ERROR: Can't connect to the database. Please, check your connection again.", "Error", JOptionPane.ERROR_MESSAGE);
			exp.printStackTrace();
		}
	}
	
	public static final void refreshAllTable() {	
		refreshBookInfoTable();
		refreshUserInfoTable();
		refreshIssueTable();
		refreshuserIssueTable();
	}
	
	public static final void showSearchWindow(String userType) {	
		final JFrame searchFrame = new JFrame("Search");
		searchFrame.setDefaultCloseOperation(searchFrame.DISPOSE_ON_CLOSE);
		searchFrame.setSize(currentUsrSettings.seacrhFrameWidth, currentUsrSettings.searchFrameHeight);
		searchFrame.setResizable(false);
			
		// Setting up icon for searchFrame
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image searchFrameIcon = kit.getImage("find_small.png");
		searchFrame.setIconImage(searchFrameIcon);
			
		// Setting up the position of the SEARCH FRAME at the middle of the screen
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenDimension.width - currentUsrSettings.seacrhFrameWidth) / 2;
       	int y = (screenDimension.height - currentUsrSettings.searchFrameHeight) / 2;    
       	searchFrame.setBounds(x, y, currentUsrSettings.seacrhFrameWidth, currentUsrSettings.searchFrameHeight);
       	
       	// Setting up location for new Internal Frame
       	currentUsrSettings.intFrameCounter = 1;
       	
       	// Adding components
       	JPanel searchPanel = new JPanel();
       	searchPanel.setLayout(null);
       	
       	Dimension size;
	    Insets insets = searchPanel.getInsets();
       	
   		final JComboBox categoryComBox = new JComboBox();
       	categoryComBox.addItem("ISBN");
       	categoryComBox.addItem("Book Title");
       	categoryComBox.addItem("Genre");
       	if(userType.equals("Administrator") == true) {
       		categoryComBox.addItem("User ID");
           	categoryComBox.addItem("User Name");
       	}
       	categoryComBox.setEditable(false);
       	size = categoryComBox.getPreferredSize();
       	categoryComBox.setBounds(10 + insets.left, 10 + insets.top, size.width, size.height);
       	searchPanel.add(categoryComBox);
       	
       	JLabel searchLabel = new JLabel("Search: ");
       	size = searchLabel.getPreferredSize();
       	searchLabel.setBounds(140 + insets.left, 15 + insets.top, size.width, size.height);
       	searchPanel.add(searchLabel);
       	
       	final JTextField searchTxtField = new JTextField(12);
       	size = searchTxtField.getPreferredSize();
       	searchTxtField.setBounds(200 + insets.left, 15 + insets.top, size.width, size.height);
       	searchPanel.add(searchTxtField);
       	
       	final JCheckBox matchCaseChkBox = new JCheckBox("Match case");
       	matchCaseChkBox.setSelected(false);
       	size = matchCaseChkBox.getPreferredSize();
       	matchCaseChkBox.setBounds(180 + insets.left, 35 + insets.top, size.width, size.height);
       	searchPanel.add(matchCaseChkBox);
       	
       	JButton closeButton = new JButton("Close");
       	size = closeButton.getPreferredSize();
       	closeButton.setBounds(170 + insets.left, 65 + insets.top, size.width, size.height);
       	searchPanel.add(closeButton);
       	
       	JButton searchButton = new JButton("Search");
       	size = searchButton.getPreferredSize();
       	searchButton.setBounds(250 + insets.left, 65 + insets.top, size.width, size.height);
       	searchPanel.add(searchButton);
       	
       	searchFrame.add(searchPanel);
			
	   	// Adding action listener
       	closeButton.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			searchFrame.dispose();
       		}
       	});
       	
       	searchButton.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			if(!searchTxtField.getText().trim().equals("")) {
       				// ISBN
           			if((categoryComBox.getSelectedItem() == "ISBN") && (matchCaseChkBox.isSelected() == false)) {
           				currentUsrSettings.searchKeyword = "%" + searchTxtField.getText().trim() + "%";
           				CreateIntFrame searchIsbnInfoWindow = new CreateIntFrame("Search Result: Book Information by ISBN", "null", "SELECT * FROM book_info WHERE isbn LIKE '" + currentUsrSettings.searchKeyword + "';");
           				deskPane.add(searchIsbnInfoWindow.intrlFrame);
           				searchIsbnInfoWindow.intrlFrame.setVisible(true);
           			}
           			else if((categoryComBox.getSelectedItem() == "ISBN") && (matchCaseChkBox.isSelected() == true)) {
           				currentUsrSettings.searchKeyword = searchTxtField.getText().trim();
           				CreateIntFrame searchIsbnInfoWindow = new CreateIntFrame("Search Result: Book Information by ISBN", "null", "SELECT * FROM book_info WHERE isbn LIKE '" + currentUsrSettings.searchKeyword + "';");
           				deskPane.add(searchIsbnInfoWindow.intrlFrame);
           				searchIsbnInfoWindow.intrlFrame.setVisible(true);
           			}
           			
           			// Book Title
           			if((categoryComBox.getSelectedItem() == "Book Title") && (matchCaseChkBox.isSelected() == false)) {
           				currentUsrSettings.searchKeyword = "%" + searchTxtField.getText().trim() + "%";
           				CreateIntFrame searchBookTitleInfoWindow = new CreateIntFrame("Search Result: Book Information by Book Title", "null", "SELECT * FROM book_info WHERE title LIKE '" + currentUsrSettings.searchKeyword + "';");
           				deskPane.add(searchBookTitleInfoWindow.intrlFrame);
           				searchBookTitleInfoWindow.intrlFrame.setVisible(true);
           			}
           			else if((categoryComBox.getSelectedItem() == "Book Title") && (matchCaseChkBox.isSelected() == true)) {
           				currentUsrSettings.searchKeyword = searchTxtField.getText().trim();
           				CreateIntFrame searchBookTitleInfoWindow = new CreateIntFrame("Search Result: Book Information by Book Title", "null", "SELECT * FROM book_info WHERE title LIKE '" + currentUsrSettings.searchKeyword + "';");
           				deskPane.add(searchBookTitleInfoWindow.intrlFrame);
           				searchBookTitleInfoWindow.intrlFrame.setVisible(true);
           			}
           			
           			// Genre
           			if((categoryComBox.getSelectedItem() == "Genre") && (matchCaseChkBox.isSelected() == false)) {
           				currentUsrSettings.searchKeyword = "%" + searchTxtField.getText().trim() + "%";
           				CreateIntFrame searchBookCategoryInfoWindow = new CreateIntFrame("Search Result: Book Information by Book Category", "null", "SELECT * FROM book_info WHERE genre LIKE '" + currentUsrSettings.searchKeyword + "';");
           				deskPane.add(searchBookCategoryInfoWindow.intrlFrame);
           				searchBookCategoryInfoWindow.intrlFrame.setVisible(true);
           			}
           			else if((categoryComBox.getSelectedItem() == "Genre") && (matchCaseChkBox.isSelected() == true)) {
           				currentUsrSettings.searchKeyword = searchTxtField.getText().trim();
           				CreateIntFrame searchBookCategoryInfoWindow = new CreateIntFrame("Search Result: Book Information by Book Category", "null", "SELECT * FROM book_info WHERE genre LIKE '" + currentUsrSettings.searchKeyword + "';");
           				deskPane.add(searchBookCategoryInfoWindow.intrlFrame);
           				searchBookCategoryInfoWindow.intrlFrame.setVisible(true);
           			}
           			
           			// User ID
           			if((categoryComBox.getSelectedItem() == "User ID") && (matchCaseChkBox.isSelected() == false)) {
           				currentUsrSettings.searchKeyword = "%" + searchTxtField.getText().trim() + "%";
           				CreateIntFrame searchUserIdInfoWindow = new CreateIntFrame("Search Result: User Information by ID", "null", "SELECT * FROM user_info WHERE user_id LIKE '" + currentUsrSettings.searchKeyword + "';");
           				deskPane.add(searchUserIdInfoWindow.intrlFrame);
           				searchUserIdInfoWindow.intrlFrame.setVisible(true);

           			}
           			else if((categoryComBox.getSelectedItem() == "User ID") && (matchCaseChkBox.isSelected() == true)) {
           				currentUsrSettings.searchKeyword = searchTxtField.getText().trim();
           				CreateIntFrame searchUserIdInfoWindow = new CreateIntFrame("Search Result: User Information by ID", "null", "SELECT * FROM user_info WHERE user_id LIKE '" + currentUsrSettings.searchKeyword + "';");
           				deskPane.add(searchUserIdInfoWindow.intrlFrame);
           				searchUserIdInfoWindow.intrlFrame.setVisible(true);
           			}
           			
           			// User Name
           			if((categoryComBox.getSelectedItem() == "User Name") && (matchCaseChkBox.isSelected() == false)) {
           				currentUsrSettings.searchKeyword = "%" + searchTxtField.getText().trim() + "%";
           				CreateIntFrame searchUserNameInfoWindow = new CreateIntFrame("Search Result: User Information by User Name", "null", "SELECT * FROM user_info WHERE user_name_first LIKE '"+ currentUsrSettings.searchKeyword + "' OR user_name_middle LIKE '" + currentUsrSettings.searchKeyword + "' OR user_name_last LIKE '" + currentUsrSettings.searchKeyword + "';");
           				deskPane.add(searchUserNameInfoWindow.intrlFrame);
           				searchUserNameInfoWindow.intrlFrame.setVisible(true);
           			}
           			else if((categoryComBox.getSelectedItem() == "User Name") && (matchCaseChkBox.isSelected() == true)) {
           				currentUsrSettings.searchKeyword = searchTxtField.getText().trim();
           				CreateIntFrame searchUserNameInfoWindow = new CreateIntFrame("Search Result: User Information by User Name", "null", "SELECT * FROM user_info WHERE user_name_first LIKE '"+ currentUsrSettings.searchKeyword + "' OR user_name_middle LIKE '" + currentUsrSettings.searchKeyword + "' OR user_name_last LIKE '" + currentUsrSettings.searchKeyword + "';");
           				deskPane.add(searchUserNameInfoWindow.intrlFrame);
           				searchUserNameInfoWindow.intrlFrame.setVisible(true);
           			}
       			}
       			else {
       				JOptionPane.showMessageDialog(null, "ERROR: Please, type something on search box.", "Error", JOptionPane.ERROR_MESSAGE);
       			}
       		}
       	});
       	
       	// Keystroke: If user press ENTER searchButton will perform its action automatically.
       	searchButton.registerKeyboardAction(searchButton.getActionForKeyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false)), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), JComponent.WHEN_IN_FOCUSED_WINDOW);
       	searchButton.registerKeyboardAction(searchButton.getActionForKeyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true)), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), JComponent.WHEN_IN_FOCUSED_WINDOW);
       	
			
		searchFrame.setVisible(true);
	}
	
	public static final void showLoginWindow() throws IOException {
		// Now opening a Login window for getting User ID and Password. It also displays connection settings as an advanced option.
		final JFrame loginFrame = new JFrame("Login");
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Setting up LOGIN FRAME icon
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image loginFrameIcon = kit.getImage("login_small.png");
		loginFrame.setIconImage(loginFrameIcon);
		
		// Setting up the position of the LOGIN FRAME at the middle of the screen
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenDimension.width - lmsDefaultSettings.loginFrameWidth) / 2;
       	int y = (screenDimension.height - lmsDefaultSettings.loginFrameHeight) / 2;    
       	loginFrame.setBounds(x, y, lmsDefaultSettings.loginFrameWidth, lmsDefaultSettings.loginFrameHeight);
       	loginFrame.setResizable(false);
       	
       	// Adding a panel with header image (optional)
       	ImagePanel loginPanel = new ImagePanel("loginFrame_header.png", 0, 0);
       	loginPanel.setLayout(null);
       	loginFrame.add(loginPanel);
       	
       	/* Adding components to LOGIN PANEL
       	 * There will be two parts. First one is for User ID and Passwords and other one is for
       	 * advanced option such as Connection string, database name/ID/password or connection string etc.
       	 */
       	Dimension size;
       	Insets insets = loginPanel.getInsets();
       	
       	// Adding Login components
       	JLabel loginUserIdLabel = new JLabel("User ID: ");
       	loginPanel.add(loginUserIdLabel);
       	size = loginUserIdLabel.getPreferredSize();
       	loginUserIdLabel.setBounds(22 + insets.left, 80 + insets.top, size.width, size.height);
       	
       	final JTextField loginUserIdTextField = new JTextField(14);
       	loginPanel.add(loginUserIdTextField);
       	size = loginUserIdTextField.getPreferredSize();
       	loginUserIdTextField.setBounds(125 + insets.left, 80 + insets.top, size.width, size.height);
       	
       	JLabel loginPasswordLabel = new JLabel("Password: ");
       	loginPanel.add(loginPasswordLabel);
       	size = loginPasswordLabel.getPreferredSize();
       	loginPasswordLabel.setBounds(22 + insets.left, 110 + insets.top, size.width, size.height);
       	
       	final JPasswordField loginPassWrdField = new JPasswordField(14);
       	loginPanel.add(loginPassWrdField);
       	size = loginPassWrdField.getPreferredSize();
       	loginPassWrdField.setBounds(125 + insets.left, 110 + insets.top, size.width, size.height);
       	
       	// Now adding MORE/LESS, CLOSE, LOGIN button
       	final JButton moreButton = new JButton("More >>");
       	loginPanel.add(moreButton);
       	size = moreButton.getPreferredSize();
       	moreButton.setBounds(20 + insets.left, 145 + insets.top, size.width, size.height);
       	
       	JButton closeButton = new JButton("Close");
       	loginPanel.add(closeButton);
       	size = closeButton.getPreferredSize();
       	closeButton.setBounds(132 + insets.left, 145 + insets.top, size.width, size.height);
       	
       	final JButton loginButton = new JButton("Login");
       	loginPanel.add(loginButton);
       	size = loginButton.getPreferredSize();
       	loginButton.setBounds(212 + insets.left, 145 + insets.top, size.width, size.height);
       	
       	// Now adding some advanced options
       	JLabel connectionStringLabel = new JLabel("Connection String: ");
       	loginPanel.add(connectionStringLabel);
       	size = connectionStringLabel.getPreferredSize();
       	connectionStringLabel.setBounds(22 + insets.left, 185 + insets.top, size.width, size.height);
       	
       	final JTextField connectionStringTextField = new JTextField(10);
       	connectionStringTextField.setText(lmsDefaultSettings.connectionString);
       	loginPanel.add(connectionStringTextField);
       	size = connectionStringTextField.getPreferredSize();
       	connectionStringTextField.setBounds(168 + insets.left, 185 + insets.top, size.width, size.height);
       	
       	// Adding action listener for each component
       	moreButton.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			Dimension loginFrameSize = new Dimension();
       			
       			if(loginFrame.getSize().height == lmsDefaultSettings.loginFrameHeight) {
       				loginFrameSize.width = lmsDefaultSettings.loginFrameWidth;
           			loginFrameSize.height = lmsDefaultSettings.loginFrameHeight + 40;
           			
           			loginFrame.setSize(loginFrameSize);
           			
           			moreButton.setText("<< Less");
       			}
       			else {
       				loginFrameSize.width = lmsDefaultSettings.loginFrameWidth;
           			loginFrameSize.height = lmsDefaultSettings.loginFrameHeight;
           			
           			loginFrame.setSize(loginFrameSize);
           			
           			moreButton.setText("More >>");
       			}
       		}
       	});
       	
       	closeButton.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			System.exit(JFrame.EXIT_ON_CLOSE);
       		}
       	});
       	
       	// Keystroke: If user press ENTER loginButton will perform its action automatically.
       	loginButton.registerKeyboardAction(loginButton.getActionForKeyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false)), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), JComponent.WHEN_IN_FOCUSED_WINDOW);
       	loginButton.registerKeyboardAction(loginButton.getActionForKeyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true)), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), JComponent.WHEN_IN_FOCUSED_WINDOW);
       	
       	// Here is the task of Login Button
       	loginButton.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			String userId = loginUserIdTextField.getText().trim();
       			String userPassword = new String(loginPassWrdField.getPassword());		// JPasswordField is a character array, so we convert character array to string directly
       			String connectionString = connectionStringTextField.getText().trim();
       			
       			// Now after getting login information, this method returns a settings for user
       			if((connectionString.length() > 12) && ((userId.length() >= lmsDefaultSettings.minUsrIdLength) || (userPassword.length() >= lmsDefaultSettings.minUsrPwdLength))) {
       				currentUsrSettings.connectionString = connectionString;
       				currentUsrSettings.userId = userId;
       				currentUsrSettings.userPassword = userPassword;
       				
       				// Checking connection
       				Connection con = null;
       				
       				try {
       					Class.forName (currentUsrSettings.driver).newInstance();
       					con = DriverManager.getConnection (currentUsrSettings.connectionString + currentUsrSettings.dataBaseName, currentUsrSettings.dbUserName, currentUsrSettings.dbPassword);
       					
       					// Now, when connection is established, then its time check User ID and Password
       					currentUsrSettings.connectionEstablished = true;
       					
       					try {
       						Statement st = con.createStatement();
           					ResultSet res = st.executeQuery("SELECT * FROM  user_info WHERE user_id = "+ currentUsrSettings.userId + " AND user_password = '"+ currentUsrSettings.userPassword + "';");
           					
           					String tempDBUsrId = new String();
           					String tempDBUsrPwd = new String();
           					String tempDBUsrNameFirst = new String();
           					String tempDBUsrNameMid = new String();
           					String tempDBUsrNameLast = new String();
           					String tempDBUsrType = new String();
           					
           					while(res.next()) {
           						tempDBUsrId = res.getString("user_id");
           						tempDBUsrPwd = res.getString("user_password");
           						tempDBUsrNameFirst = res.getString("user_name_first");
           						tempDBUsrNameMid = res.getString("user_name_middle");
           						tempDBUsrNameLast = res.getString("user_name_last");
           						tempDBUsrType = res.getString("user_type");
           					}
           					
           					// Checking User ID and Password between Login field and Database Table.
           					if(tempDBUsrId.equals(currentUsrSettings.userId) == true && tempDBUsrPwd.equals(currentUsrSettings.userPassword) == true) {
           						loginButton.setEnabled(false);
           						JOptionPane.showMessageDialog(null, "Congratulation " + tempDBUsrNameFirst + " " + tempDBUsrNameMid + " " + tempDBUsrNameLast + " !!! You have logged in successfully.", "Login successfull !!!", JOptionPane.INFORMATION_MESSAGE);
           						
           						String userName = tempDBUsrNameFirst + " " + tempDBUsrNameMid + " " + tempDBUsrNameLast;
           						
           						// Once login is successful, now showing Multiple Document Interface (MDI) Form
           						showMdiForm(tempDBUsrType, userName);
           						loginFrame.dispose();			// ... and closing Login Window
           					}
           					else {
           						JOptionPane.showMessageDialog(null, "ERROR: Please check your User ID and Password again.", "Error", JOptionPane.ERROR_MESSAGE);
           					}
           					
       					} catch(SQLException exp) {
       						JOptionPane.showMessageDialog(null, "ERROR: Can't execute SQL statement.", "Error", JOptionPane.ERROR_MESSAGE);
       						exp.printStackTrace();
       					}
       					
       					
       				} catch(Exception exp) {
       					JOptionPane.showMessageDialog(null, "ERROR: Can't establish connection to the database. Please check your Connection string again or make sure that you are connected with the database.", "Error", JOptionPane.ERROR_MESSAGE);
       					exp.printStackTrace();
       				}
       			}
       			else {
       				JOptionPane.showMessageDialog(null, "ERROR: Please type your User ID, Password or Connection string correctly.", "Error", JOptionPane.ERROR_MESSAGE);
       			}
       		}
       	});
		
		loginFrame.setVisible(true);
	}
	
	public static final void showMdiForm(final String userType, final String userName) {
		// Showing MDI Form
		final JFrame mdiFrame = new JFrame("["+ userName + "] - Library Management System");
		mdiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mdiFrame.setSize(currentUsrSettings.mdiFrameWidth, currentUsrSettings.mdiFrameHeight);
		
		// Setting up LOGIN FRAME icon
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image mdiFrameIcon = kit.getImage("icon.png");
		mdiFrame.setIconImage(mdiFrameIcon);
		
		// Setting up the position of the LOGIN FRAME at the middle of the screen
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenDimension.width - currentUsrSettings.mdiFrameWidth) / 2;
       	int y = (screenDimension.height - currentUsrSettings.mdiFrameHeight) / 2;    
       	mdiFrame.setBounds(x, y, currentUsrSettings.mdiFrameWidth, currentUsrSettings.mdiFrameHeight);
       	
       	// Design (general): [Menu] --> [Tool Bar] --> [Multiple Table Window] --> [Info/Edit Panel]
       	JMenuBar menuBar = new JMenuBar();
       	mdiFrame.setJMenuBar(menuBar);
       	
       	JMenu fileMenu = new JMenu("File");
       	JMenu editMenu = new JMenu("Edit");
       	JMenu viewMenu = new JMenu("View");
       	JMenu helpMenu = new JMenu("Help");
       	
       	menuBar.add(fileMenu);
       	if(userType.equals("Administrator") == true) {
       		menuBar.add(editMenu);
       	}
       	menuBar.add(viewMenu);
       	menuBar.add(helpMenu);
       	
       	// Adding short-cut key for menu
       	fileMenu.setMnemonic('F');
       	editMenu.setMnemonic('E');
       	viewMenu.setMnemonic('V');
       	helpMenu.setMnemonic('H');
       	
       	// Menu Structure:
       	// [File Menu]: [[Add] --> [User] <--> [Administrator] <-||-> [Book]](only for admin) <--> [[Print] --> [Book Table] <--> [[User Table] <--> [Issue Table]](only for admin) <-||-> [Table Information Panel]] <-||-> [Exit]
       	JMenu addMenu = new JMenu("Add");
       	final JMenuItem newUserMenuItm = new JMenuItem("New User");
       	final JMenuItem newBookMenuItm = new JMenuItem("New Book");
       	final JMenuItem newRsvrEntryMenuItm = new JMenuItem("New Reservation Entry");
       	
       	if(userType.equals("Administrator")) {
           	fileMenu.add(addMenu);
           	addMenu.add(newUserMenuItm);
           	addMenu.add(newBookMenuItm);
           	addMenu.addSeparator();
           	addMenu.add(newRsvrEntryMenuItm);
       	}
       	
       	JMenu printMenu = new JMenu("Print");
       	fileMenu.add(printMenu);
       	
       	JMenuItem bookTablePrintMenuItm = new JMenuItem("Book Table");
       	printMenu.add(bookTablePrintMenuItm);
       	
       	final JMenuItem userTablePrintMenuItm = new JMenuItem("User Table");
       	final JMenuItem issueTablePrintMenuItm = new JMenuItem("Issue Table");
       	
       	if(userType.equals("Administrator") == true) {
           	printMenu.add(userTablePrintMenuItm);
           	printMenu.add(issueTablePrintMenuItm);
       	}
       	
       	printMenu.addSeparator();
       	
       	final JMenuItem tableInfoPanelPrintMenuItm = new JMenuItem("Table Information Panel");
       	printMenu.add(tableInfoPanelPrintMenuItm);
       	
       	fileMenu.addSeparator();
       	
       	JMenuItem exitMenuItm = new JMenuItem("Exit");
       	fileMenu.add(exitMenuItm);
       	
       	// [Edit Menu]: [ [Edit selected row] <--> [Delete selected row] <--> [Save selected row] ] (only for admin)
   		final JMenuItem editSelectedRowMenuItm = new JMenuItem("Edit selected row");
   		editSelectedRowMenuItm.setEnabled(false);
       	editMenu.add(editSelectedRowMenuItm);
       	
       	final JMenuItem deleteSelectedRowMenuItm = new JMenuItem("Delete selected row");
       	deleteSelectedRowMenuItm.setEnabled(false);
       	editMenu.add(deleteSelectedRowMenuItm);
       	
       	final JMenuItem saveSelectedRowMenuItm = new JMenuItem("Save selected row");
       	saveSelectedRowMenuItm.setEnabled(false);
       	editMenu.add(saveSelectedRowMenuItm);
       	
       	// [View Menu]: [User Profile] <--> [Refresh all table] <-||-> [x][Book Table] <--> [[x][User Table] <--> [x][Issue Table]] (only for admin) <--> [find]
       	JMenuItem userProfileMenuItm = new JMenuItem("User Profile");
       	viewMenu.add(userProfileMenuItm);
       	
       	JMenuItem refreshAllTableMenuItm = new JMenuItem("Refresh All Table");
       	viewMenu.add(refreshAllTableMenuItm);
       	
       	viewMenu.addSeparator();
       	
       	final JCheckBox bookTableMenuItm = new JCheckBox("Book Table");
       	bookTableMenuItm.setSelected(true);
       	viewMenu.add(bookTableMenuItm);
       	
       	final JCheckBox userTableMenuItm = new JCheckBox("User Table");
       	userTableMenuItm.setSelected(true);
       	
       	final JCheckBox issueTableMenuItm = new JCheckBox("Issue Table");
       	issueTableMenuItm.setSelected(true);
       	
       	if(userType.equals("Administrator")) {
       		viewMenu.add(userTableMenuItm);
       		viewMenu.add(issueTableMenuItm);
       	}
       	
       	viewMenu.addSeparator();
       	
       	final JMenuItem findMenuItm = new JMenuItem("Find");
       	viewMenu.add(findMenuItm);
       	
       	// [Help Menu]: [Contents] <-||-> [About]
       	JMenuItem contentsMenuItm = new JMenuItem("Contents");
       	helpMenu.add(contentsMenuItm);
       	
       	helpMenu.addSeparator();
       	
       	JMenuItem aboutMenuItm = new JMenuItem("About");
       	helpMenu.add(aboutMenuItm);
       	
       	// Now adding toolbar and its buttons
       	JToolBar toolbar = new JToolBar("MDI Main Toolbar");
       	mdiFrame.add(toolbar, BorderLayout.NORTH);
       	
       	JButton addButton = new JButton(new ImageIcon("add.png"));
       	if(userType.equals("Administrator")) {
       		addButton.setToolTipText("Add new Book or new user");
       		toolbar.add(addButton);
       	}
       	
       	final JButton printButton = new JButton(new ImageIcon("print.png"));
       	printButton.setToolTipText("Print current table");
       	toolbar.add(printButton);
       	
       	toolbar.addSeparator();
       	
       	JButton reloadButton = new JButton(new ImageIcon("reload.png"));
       	reloadButton.setToolTipText("Reloads all table");
       	toolbar.add(reloadButton);
       	
       	final JButton saveEntryButton = new JButton(new ImageIcon("save.png"));
       	saveEntryButton.setToolTipText("Save current entry");
       	saveEntryButton.setEnabled(false);
       	
       	final JButton editEntryButton = new JButton(new ImageIcon("editEntry.png"));
       	editEntryButton.setToolTipText("Edit current entry");
       	editEntryButton.setEnabled(false);
       	
       	final JButton deleteEntryButton = new JButton(new ImageIcon("deleteEntry.png"));
       	deleteEntryButton.setToolTipText("Delete current entry");
       	deleteEntryButton.setEnabled(false);
 	
       	JButton searchButton = new JButton(new ImageIcon("search.png"));
       	searchButton.setToolTipText("Click to search by category");
       	toolbar.add(searchButton);
       	
       	if(userType.equals("Administrator") == true) {
       		toolbar.add(saveEntryButton);
       		toolbar.add(editEntryButton);
       		toolbar.add(deleteEntryButton);
       	}
       	
       	toolbar.addSeparator();
       	
       	final JButton borrowButton = new JButton(new ImageIcon("borrow_book.png"));
       	borrowButton.setEnabled(false);
       	borrowButton.setToolTipText("Click to borrow new Book");
       	if(userType.equals("Member") == true) {
       		toolbar.add(borrowButton);
       	}
       	
       	JButton statsButton = new JButton(new ImageIcon("stats.png"));
       	statsButton.setToolTipText("Shows borrowed books by user");
       	if(userType.equals("Member") == true) {
       		toolbar.add(statsButton);
       	}
       	
       	JButton showUserInfoButton = new JButton(new ImageIcon("userInfo.png"));
       	showUserInfoButton.setToolTipText("Shows current user information");
       	toolbar.add(showUserInfoButton);
       	
       	JButton exitButton = new JButton(new ImageIcon("exit.png"));
       	exitButton.setToolTipText("Click to exit this program");
       	toolbar.add(exitButton);
       	
       	toolbar.addSeparator();
       	
       	JButton helpButton = new JButton(new ImageIcon("help.png"));
       	helpButton.setToolTipText("Click to get help for this program");
       	toolbar.add(helpButton);
       	
       	JButton aboutButton = new JButton(new ImageIcon("about.png"));
       	aboutButton.setToolTipText("About");
       	toolbar.add(aboutButton);
       	
       	// Now adding a split pane to divide the window into two parts. Top half is for showing table at desktop pane and the rest one is for showing data of selected row.
       	deskPane.setBackground(Color.GRAY);
       	deskPane.setMinimumSize(currentUsrSettings.deskMinPaneSize);
       	
       	final JPanel panel = new JPanel();
       	panel.setLayout(new BorderLayout());
       	
       	JSplitPane spltPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, deskPane, panel);
       	mdiFrame.add(spltPane, BorderLayout.CENTER);
       	
       	// Panel will show detail information about selected row from table
       	final JPanel titlePanel = new JPanel();
       	panel.add(titlePanel, BorderLayout.NORTH);
       	
	    final JPanel tableInfoPanel = new JPanel();
	    panel.add(tableInfoPanel, BorderLayout.CENTER);
	    
	    final JLabel titlePaneLabel = new JLabel();
	    titlePaneLabel.setText("NOTE: Select a table to view details.");
	    titlePanel.add(titlePaneLabel);

       	bookWindow.table.addMouseListener(new MouseAdapter() {
       		public void mousePressed(MouseEvent mouseEvent) {
       			if(mouseEvent.getClickCount() == 1) {
       				titlePaneLabel.setText("Book Table");
       				
       				titlePanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
       				
       				tableInfoPanel.setLayout(null);
       				tableInfoPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
       				
       				Dimension size;
           	       	Insets insets = tableInfoPanel.getInsets();
           	       	final int rowIndex = bookWindow.table.getSelectedRow();
       				
           	       	tableInfoPanel.removeAll();
           	       	
           	       	// ISBN
           	       	JLabel isbnLabel = new JLabel("ISBN: ");
    				size = isbnLabel.getPreferredSize();
    				isbnLabel.setBounds(10 + insets.left, 10 + insets.top, size.width, size.height);
    				tableInfoPanel.add(isbnLabel);
    				
    				final JTextField isbnTextField = new JTextField(18);
    				isbnTextField.setEditable(false);
    				isbnTextField.setText(String.valueOf(bookWindow.table.getModel().getValueAt(rowIndex, 0)));
    				size = isbnTextField.getPreferredSize();
    				isbnTextField.setBounds(150 + insets.left, 10 + insets.top, size.width, size.height);
    				tableInfoPanel.add(isbnTextField);
    				
    				// Book Title
    				JLabel titleLabel = new JLabel("Book Title: ");
    				size = titleLabel.getPreferredSize();
    				titleLabel.setBounds(10 + insets.left, 35 + insets.top, size.width, size.height);
    				tableInfoPanel.add(titleLabel);
    				
    				final JTextField bookTitleTextField = new JTextField(18);
    				bookTitleTextField.setEditable(false);
    				bookTitleTextField.setText(String.valueOf(bookWindow.table.getModel().getValueAt(rowIndex, 1)));
    				size = bookTitleTextField.getPreferredSize();
    				bookTitleTextField.setBounds(150 + insets.left, 35 + insets.top, size.width, size.height);
    				tableInfoPanel.add(bookTitleTextField);
    				
    				// Author
    				JLabel authorLabel = new JLabel("Author: ");
    				size = authorLabel.getPreferredSize();
    				authorLabel.setBounds(10 + insets.left, 60 + insets.top, size.width, size.height);
    				tableInfoPanel.add(authorLabel);
    				
    				final JTextField authorTextField = new JTextField(18);
    				authorTextField.setEditable(false);
    				authorTextField.setText(String.valueOf(bookWindow.table.getModel().getValueAt(rowIndex, 2)));
    				size = authorTextField.getPreferredSize();
    				authorTextField.setBounds(150 + insets.left, 60 + insets.top, size.width, size.height);
    				tableInfoPanel.add(authorTextField);
    				
    				// Publisher
    				JLabel publisherLabel = new JLabel("Publisher: ");
    				size = publisherLabel.getPreferredSize();
    				publisherLabel.setBounds(10 + insets.left, 85 + insets.top, size.width, size.height);
    				tableInfoPanel.add(publisherLabel);
    				
    				final JTextField publisherTextField = new JTextField(18);
    				publisherTextField.setEditable(false);
    				publisherTextField.setText(String.valueOf(bookWindow.table.getModel().getValueAt(rowIndex, 3)));
    				size = publisherTextField.getPreferredSize();
    				publisherTextField.setBounds(150 + insets.left, 85 + insets.top, size.width, size.height);
    				tableInfoPanel.add(publisherTextField);
    				
    				// Publication Date
    				JLabel publicationDateLabel = new JLabel("Publication Date: ");
    				size = publicationDateLabel.getPreferredSize();
    				publicationDateLabel.setBounds(10 + insets.left, 110 + insets.top, size.width, size.height);
    				tableInfoPanel.add(publicationDateLabel);
    				
    				final JDateChooser publicationDateChooser = new JDateChooser();
    				publicationDateChooser.setDate(mysqlDateConverter(String.valueOf(bookWindow.table.getModel().getValueAt(rowIndex, 4))));
	               	size = publicationDateChooser.getPreferredSize();
	               	publicationDateChooser.setBounds(150 + insets.left, 110 + insets.top, size.width, size.height);
	               	tableInfoPanel.add(publicationDateChooser);
    				
    				// Pages
    				JLabel pagesLabel = new JLabel("Pages: ");
    				size = pagesLabel.getPreferredSize();
    				pagesLabel.setBounds(10 + insets.left, 135 + insets.top, size.width, size.height);
    				tableInfoPanel.add(pagesLabel);
    				
    				final JTextField pagesTextField = new JTextField(18);
    				pagesTextField.setEditable(false);
    				pagesTextField.setText(String.valueOf(bookWindow.table.getModel().getValueAt(rowIndex, 5)));
    				size = pagesTextField.getPreferredSize();
    				pagesTextField.setBounds(150 + insets.left, 135 + insets.top, size.width, size.height);
    				tableInfoPanel.add(pagesTextField);
    				
    				// Genre
    				JLabel genureLabel = new JLabel("Genre: ");
    				size = genureLabel.getPreferredSize();
    				genureLabel.setBounds(10 + insets.left, 160 + insets.top, size.width, size.height);
    				tableInfoPanel.add(genureLabel);
    				
    				final JTextField genreTextField = new JTextField(18);
    				genreTextField.setEditable(false);
    				genreTextField.setText(String.valueOf(bookWindow.table.getModel().getValueAt(rowIndex, 6)));
    				size = genreTextField.getPreferredSize();
    				genreTextField.setBounds(150 + insets.left, 160 + insets.top, size.width, size.height);
    				tableInfoPanel.add(genreTextField);
    				
    				tableInfoPanel.revalidate();
    				
    				final String currentIsbn = isbnTextField.getText().trim();		// Required for edit, delete and saving data
    				
    				saveSelectedRowMenuItm.setEnabled(false);
    				saveEntryButton.setEnabled(false);
    				borrowButton.setEnabled(true);
       				
       				if(userType.equals("Administrator") == true) {
       					editSelectedRowMenuItm.setEnabled(true);
       					deleteSelectedRowMenuItm.setEnabled(true);
       					
       					editEntryButton.setEnabled(true);
       					deleteEntryButton.setEnabled(true);
       					
       					// Edit
       					editSelectedRowMenuItm.addActionListener(new ActionListener() {
       						public void actionPerformed(ActionEvent event) {
       							bookTitleTextField.setEditable(true);
       							authorTextField.setEditable(true);
       							publisherTextField.setEditable(true);
       							pagesTextField.setEditable(true);
       							genreTextField.setEditable(true);
       							
       							saveSelectedRowMenuItm.setEnabled(true);
       							editSelectedRowMenuItm.setEnabled(false);
       							deleteEntryButton.setEnabled(false);
       							
       							saveEntryButton.setEnabled(true);
       							editEntryButton.setEnabled(false);
       							deleteEntryButton.setEnabled(true);
       						}
       					});
       					
       					editEntryButton.addActionListener(new ActionListener() {
       						public void actionPerformed(ActionEvent event) {
       							bookTitleTextField.setEditable(true);
       							authorTextField.setEditable(true);
       							publisherTextField.setEditable(true);
       							pagesTextField.setEditable(true);
       							genreTextField.setEditable(true);
       							
       							saveSelectedRowMenuItm.setEnabled(true);
       							editSelectedRowMenuItm.setEnabled(false);
       							deleteEntryButton.setEnabled(false);
       							
       							saveEntryButton.setEnabled(true);
       							editEntryButton.setEnabled(false);
       							deleteEntryButton.setEnabled(false);
       						}
       					});
       					
       					// Save
       					saveSelectedRowMenuItm.addActionListener(new ActionListener() {
       						public void actionPerformed(ActionEvent event) {	
	       								saveSelectedRowMenuItm.setEnabled(false);
		       							editSelectedRowMenuItm.setEnabled(false);
		       							deleteSelectedRowMenuItm.setEnabled(false);
		       							
		       							saveEntryButton.setEnabled(false);
		       							editEntryButton.setEnabled(false);
		       							deleteEntryButton.setEnabled(false);
		       							
		       							saveSelectedRowMenuItm.removeActionListener(this);
		       							
		       							Connection conn = null;
		       							
		       							try {
		       								Class.forName (currentUsrSettings.driver).newInstance();
		       								conn = DriverManager.getConnection (currentUsrSettings.connectionString + currentUsrSettings.dataBaseName, currentUsrSettings.dbUserName, currentUsrSettings.dbPassword);
		       								
		       								try {
		       									Statement st = conn.createStatement();
		       									st.executeUpdate("UPDATE book_info SET title = '" + bookTitleTextField.getText().trim() + "', author = '" + authorTextField.getText().trim() + "', publisher = '" + publisherTextField.getText().trim() + "', publication_year = '" + String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(publicationDateChooser.getDate())) + "', pages = " + pagesTextField.getText().trim() + ", genre = '" + genreTextField.getText().trim() + "' WHERE isbn = '" + isbnTextField.getText().trim() + "';");
		       								} catch (SQLException exp) {
		       									exp.printStackTrace();
		       									saveSelectedRowMenuItm.removeActionListener(this);
		       								} finally {
		       									isbnTextField.setText(null);
		       									bookTitleTextField.setText(null);
		       									authorTextField.setText(null);
		       									publisherTextField.setText(null);
		       									pagesTextField.setText(null);
		       									genreTextField.setText(null);
		       									conn.close();
		       									saveSelectedRowMenuItm.removeActionListener(this);
		       									refreshAllTable();
		       								}
		            					
		       							} catch(Exception exp) {
		       								exp.printStackTrace();
		       								saveSelectedRowMenuItm.removeActionListener(this);
		       							}
		       							
		       							saveSelectedRowMenuItm.removeActionListener(this);
	       						}
       					});
       					
       					saveEntryButton.addActionListener(new ActionListener() {
       						public void actionPerformed(ActionEvent event) {	
       								saveSelectedRowMenuItm.setEnabled(false);
	       							editSelectedRowMenuItm.setEnabled(false);
	       							deleteSelectedRowMenuItm.setEnabled(false);
	       							
	       							saveEntryButton.setEnabled(false);
	       							editEntryButton.setEnabled(false);
	       							deleteEntryButton.setEnabled(false);
	       							
	       							saveEntryButton.removeActionListener(this);
	       							
	       							Connection conn = null;
	       							
	       							try {
	       								Class.forName (currentUsrSettings.driver).newInstance();
	       								conn = DriverManager.getConnection (currentUsrSettings.connectionString + currentUsrSettings.dataBaseName, currentUsrSettings.dbUserName, currentUsrSettings.dbPassword);
	       								
	       								try {
	       									Statement st = conn.createStatement();
	       									st.executeUpdate("UPDATE book_info SET title = '" + bookTitleTextField.getText().trim() + "', author = '" + authorTextField.getText().trim() + "', publisher = '" + publisherTextField.getText().trim() + "', publication_year = '" + String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(publicationDateChooser.getDate())) + "', pages = " + pagesTextField.getText().trim() + ", genre = '" + genreTextField.getText().trim() + "' WHERE isbn = '" + isbnTextField.getText().trim() + "';");
	       								} catch (SQLException exp) {
	       									exp.printStackTrace();
	       									saveEntryButton.removeActionListener(this);
	       								} finally {
	       									isbnTextField.setText(null);
	       									bookTitleTextField.setText(null);
	       									authorTextField.setText(null);
	       									publisherTextField.setText(null);
	       									pagesTextField.setText(null);
	       									genreTextField.setText(null);
	       									conn.close();
	       									saveEntryButton.removeActionListener(this);
	       									refreshAllTable();
	       								}
	            					
	       							} catch(Exception exp) {
	       								exp.printStackTrace();
	       								saveEntryButton.removeActionListener(this);
	       							}
	       							
	       							saveEntryButton.removeActionListener(this);
       						}
       					});
       					
       					// Delete
       					deleteSelectedRowMenuItm.addActionListener(new ActionListener() {
       						public void actionPerformed(ActionEvent event) {
       							int response = JOptionPane.showConfirmDialog(null, "Are you sure to delete " + String.valueOf(bookWindow.table.getModel().getValueAt(rowIndex, 1)) + " (" + String.valueOf(bookWindow.table.getModel().getValueAt(rowIndex, 0)) + ") entry ?" , "Confirmation Message", JOptionPane.YES_NO_OPTION);
       							
       							if(response == JOptionPane.YES_OPTION) {
       								Connection conn = null;
       								
       								try {
       									Class.forName (currentUsrSettings.driver).newInstance();
       									conn = DriverManager.getConnection (currentUsrSettings.connectionString + currentUsrSettings.dataBaseName, currentUsrSettings.dbUserName, currentUsrSettings.dbPassword);
	       								
	       								try {
	       									Statement st = conn.createStatement();
	       									st.executeUpdate("DELETE FROM book_info WHERE isbn = '" + isbnTextField.getText() + "';");
	       									
	       								} catch (SQLException exp) {
	       									JOptionPane.showMessageDialog(null, "This book has been issued by other user already. Can't delete the book right now.", "Warning", JOptionPane.WARNING_MESSAGE);
	       									exp.printStackTrace();
	       								} finally {
	       									conn.close();
	       									deleteSelectedRowMenuItm.removeActionListener(this);
	       									refreshAllTable();
	       								}
       									
       								} catch (Exception exp) {
       									deleteSelectedRowMenuItm.removeActionListener(this);
       									exp.printStackTrace();
       								}
       							}
       							
       							deleteSelectedRowMenuItm.removeActionListener(this);
       							
       							saveSelectedRowMenuItm.setEnabled(false);
	       						editSelectedRowMenuItm.setEnabled(false);
	       						deleteEntryButton.setEnabled(false);
	       							
	       						saveEntryButton.setEnabled(false);
	       						editEntryButton.setEnabled(false);
	       						deleteEntryButton.setEnabled(false);
       						}
       					});
       					
       					deleteEntryButton.addActionListener(new ActionListener() {
       						public void actionPerformed(ActionEvent event) {
       							int response = JOptionPane.showConfirmDialog(null, "Are you sure to delete " + String.valueOf(bookWindow.table.getModel().getValueAt(rowIndex, 1)) + " (" + String.valueOf(bookWindow.table.getModel().getValueAt(rowIndex, 0)) + ") entry ?" , "Confirmation Message", JOptionPane.YES_NO_OPTION);
       							
       							if(response == JOptionPane.YES_OPTION) {
       								Connection conn = null;
       								
       								try {
       									Class.forName (currentUsrSettings.driver).newInstance();
       									conn = DriverManager.getConnection (currentUsrSettings.connectionString + currentUsrSettings.dataBaseName, currentUsrSettings.dbUserName, currentUsrSettings.dbPassword);
	       								
	       								try {
	       									Statement st = conn.createStatement();
	       									st.executeUpdate("DELETE FROM book_info WHERE isbn = '" + isbnTextField.getText() + "';");
	       									
	       								} catch (SQLException exp) {
	       									JOptionPane.showMessageDialog(null, "This book has been issued by other user already. Can't delete the book right now.", "Warning", JOptionPane.WARNING_MESSAGE);
	       									exp.printStackTrace();
	       								} finally {
	       									conn.close();
	       									deleteEntryButton.removeActionListener(this);
	       									refreshAllTable();
	       								}
       									
       								} catch (Exception exp) {
       									deleteEntryButton.removeActionListener(this);
       									exp.printStackTrace();
       								}
       							}
       							
       							deleteEntryButton.removeActionListener(this);
       							
       							saveSelectedRowMenuItm.setEnabled(false);
	       						editSelectedRowMenuItm.setEnabled(false);
	       						deleteEntryButton.setEnabled(false);
	       							
	       						saveEntryButton.setEnabled(false);
	       						editEntryButton.setEnabled(false);
	       						deleteEntryButton.setEnabled(false);
       						}
       					});
       				}
       				else {
       					borrowButton.addActionListener(new ActionListener() {
       						public void actionPerformed(ActionEvent event) {
       							Connection conn = null;
       							
       							borrowButton.removeActionListener(this);
       							
       							try {
       								Class.forName(currentUsrSettings.driver);
       								conn = DriverManager.getConnection(currentUsrSettings.connectionString + currentUsrSettings.dataBaseName, currentUsrSettings.dbUserName, currentUsrSettings.dbPassword);
       								
       								try {
       									final Statement st = conn.createStatement();
       									ResultSet result = st.executeQuery("SELECT * FROM issue WHERE user_id = " + currentUsrSettings.userId + " AND isbn = '" + isbnTextField.getText() + "';");
       									
       									String selectedIsbn = new String();
       									
       									while(result.next()) {
       										selectedIsbn = result.getString("isbn");
       									}
       									
       									if(selectedIsbn.equals(isbnTextField.getText()) == false) {
       										int response = JOptionPane.showConfirmDialog(null, "Are you sure to borrow this book ?", "Confirmation", JOptionPane.YES_NO_OPTION);
       										
       										if(response == JOptionPane.YES_OPTION) {
       											st.executeUpdate("INSERT INTO issue VALUES(" + currentUsrSettings.userId + ", '" + isbnTextField.getText() + "', curdate(), date_add(curdate(), INTERVAL 3 DAY));");
       											isbnTextField.setText(null);
       											conn.close();
       											borrowButton.removeActionListener(this);
       											borrowButton.setEnabled(false);
       											refreshAllTable();
       										}
       									}
       									else {
       										JOptionPane.showMessageDialog(null, "WARNING: You have already borrowed this book.", "Warning", JOptionPane.WARNING_MESSAGE);
       										borrowButton.removeActionListener(this);
       									}
       									
       								} catch(SQLException exp) {
       									exp.printStackTrace();
       									borrowButton.removeActionListener(this);
       								}
       								
       							} catch(Exception exp) {
       								exp.printStackTrace();
       								borrowButton.removeActionListener(this);
       							}
       							
       							borrowButton.removeActionListener(this);
       						}
       					});
       				}
       			}
       		}
       	});
       	
       	userWindow.table.addMouseListener(new MouseAdapter() {
       		public void mousePressed(MouseEvent mouseEvent) {
       			if(mouseEvent.getClickCount() == 1) {
       				titlePaneLabel.setText("User Table");
       				
       				titlePanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
       				
       				tableInfoPanel.setLayout(null);
       				tableInfoPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
       				
       				Dimension size;
           	       	Insets insets = tableInfoPanel.getInsets();
           	       	final int rowIndex = userWindow.table.getSelectedRow();
           	       	
           	       	tableInfoPanel.removeAll();
           	       	
           	       	// User ID
           	       	JLabel userIdLabel = new JLabel("User ID: ");
           	       	size = userIdLabel.getPreferredSize();
           	       	userIdLabel.setBounds(10 + insets.left, 10 + insets.top, size.width, size.height);
           	       	tableInfoPanel.add(userIdLabel);
           	       	
           	       	final JTextField userIdTextField = new JTextField(18);
           	       	userIdTextField.setEditable(false);
           	       	userIdTextField.setText(String.valueOf(userWindow.table.getModel().getValueAt(rowIndex, 0)));
           	       	size = userIdTextField.getPreferredSize();
           	       	userIdTextField.setBounds(150 + insets.left, 10 + insets.top, size.width, size.height);
           	       	tableInfoPanel.add(userIdTextField);
           	       	
           	       	// Name
           	       	JLabel nameLabel = new JLabel("Name: ");
        	       	size = nameLabel.getPreferredSize();
        	       	nameLabel.setBounds(10 + insets.left, 35 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(nameLabel);
        	       	
        	       	final JTextField userNameFirstTextField = new JTextField(7);
        	       	userNameFirstTextField.setEditable(false);
        	       	userNameFirstTextField.setText(String.valueOf(userWindow.table.getModel().getValueAt(rowIndex, 1)));
           	       	size = userNameFirstTextField.getPreferredSize();
           	       	userNameFirstTextField.setBounds(90 + insets.left, 35 + insets.top, size.width, size.height);
           	       	tableInfoPanel.add(userNameFirstTextField);
           	       	
           	       	final JTextField userNameMidTextField = new JTextField(7);
           	       	userNameMidTextField.setEditable(false);
           	       	userNameMidTextField.setText(String.valueOf(userWindow.table.getModel().getValueAt(rowIndex, 2)));
        	       	size = userNameMidTextField.getPreferredSize();
        	       	userNameMidTextField.setBounds(180 + insets.left, 35 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(userNameMidTextField);
        	       	
        	       	final JTextField userNameLastTextField = new JTextField(7);
        	       	userNameLastTextField.setEditable(false);
        	       	userNameLastTextField.setText(String.valueOf(userWindow.table.getModel().getValueAt(rowIndex, 3)));
        	       	size = userNameLastTextField.getPreferredSize();
        	       	userNameLastTextField.setBounds(270 + insets.left, 35 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(userNameLastTextField);
        	       	
        	       	// User Type
        	       	JLabel userTypeLabel = new JLabel("User Type: ");
        	       	size = userTypeLabel.getPreferredSize();
        	       	userTypeLabel.setBounds(10 + insets.left, 60 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(userTypeLabel);
        	       	
        	       	JComboBox userTypeComBox = new JComboBox();
        	       	userTypeComBox.addItem("Administrator");
        	       	userTypeComBox.addItem("Member");
        	       	userTypeComBox.setEditable(false);
        	       	userTypeComBox.setSelectedItem(userWindow.table.getModel().getValueAt(rowIndex, 4));
        	       	size = userTypeComBox.getPreferredSize();
        	       	userTypeComBox.setBounds(150 + insets.left, 60 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(userTypeComBox);
        	       	
        	       	// User Password
        	       	JLabel passwordLabel = new JLabel("Password: ");
        	       	size = passwordLabel.getPreferredSize();
        	       	passwordLabel.setBounds(10 + insets.left, 90 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(passwordLabel);
        	       	
        	       	final String selectedUserPassword = String.valueOf(userWindow.table.getModel().getValueAt(rowIndex, 5));
        	       	String tempPwdMask = new String();
        	       	for(int echo = 1; echo <= selectedUserPassword.length(); echo++) {
        	       		tempPwdMask = tempPwdMask + "*";
        	       	}
        	       	final String pwdMask = tempPwdMask;
        	       	
        	       	final JTextField passwordTextField = new JTextField(18);
        	       	passwordTextField.setEditable(false);
        	       	passwordTextField.setText(pwdMask);
           	       	size = passwordTextField.getPreferredSize();
           	       	passwordTextField.setBounds(150 + insets.left, 90 + insets.top, size.width, size.height);
           	       	tableInfoPanel.add(passwordTextField);
           	       	
           	       	final JCheckBox maskPwdChkBox = new JCheckBox("Mask password");
           	       	maskPwdChkBox.setSelected(true);
           	       	maskPwdChkBox.addActionListener(new ActionListener() {
           	       		public void actionPerformed(ActionEvent event) {
           	       			if(maskPwdChkBox.isSelected() == true) {
           	       				passwordTextField.setText(pwdMask);
           	       			}
           	       			else {
           	       				passwordTextField.setText(selectedUserPassword);
           	       			}
           	       		}
           	       	});
           	       	size = maskPwdChkBox.getPreferredSize();
           	       	maskPwdChkBox.setBounds(145 + insets.left, 110 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(maskPwdChkBox);
        	       	
        	       	// Gender
        	       	JLabel genderLabel = new JLabel("Gender: ");
        	       	size = genderLabel.getPreferredSize();
        	       	genderLabel.setBounds(10 + insets.left, 135 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(genderLabel);
        	       	
        	       	final JComboBox genderComBox = new JComboBox();
        	       	genderComBox.addItem("Male");
        	       	genderComBox.addItem("Female");
        	       	genderComBox.setEditable(false);
        	       	genderComBox.setSelectedItem(userWindow.table.getModel().getValueAt(rowIndex, 6));
        	       	size = genderComBox.getPreferredSize();
        	       	genderComBox.setBounds(150 + insets.left, 135 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(genderComBox);
        	       	
        	       	// Date of Birth
        	       	JLabel dateOfBirthLabel = new JLabel("Date of Birth: ");
        	       	size = dateOfBirthLabel.getPreferredSize();
        	       	dateOfBirthLabel.setBounds(10 + insets.left, 165 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(dateOfBirthLabel);
        	       	
        	       	final JDateChooser dateOfBirthChooser = new JDateChooser();
	               	dateOfBirthChooser.setSelectableDateRange(currentUsrSettings.minDate, currentUsrSettings.maxDate);
	               	dateOfBirthChooser.setDate(mysqlDateConverter(String.valueOf(userWindow.table.getModel().getValueAt(rowIndex, 7))));
	               	size = dateOfBirthChooser.getPreferredSize();
	               	dateOfBirthChooser.setBounds(150 + insets.left, 165 + insets.top, size.width, size.height);
	               	tableInfoPanel.add(dateOfBirthChooser);
	               	
	               	// Phone No.
        	       	JLabel phoneNoLabel = new JLabel("Phone No: ");
        	       	size = phoneNoLabel.getPreferredSize();
        	       	phoneNoLabel.setBounds(400 + insets.left, 10 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(phoneNoLabel);
        	       	
        	       	final JTextField phoneNotTextField = new JTextField(22);
        	       	phoneNotTextField.setEditable(false);
        	       	phoneNotTextField.setText(String.valueOf(userWindow.table.getModel().getValueAt(rowIndex, 8)));
        	       	size = phoneNotTextField.getPreferredSize();
        	       	phoneNotTextField.setBounds(500 + insets.left, 10 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(phoneNotTextField);
        	       	
        	       	// Email
        	       	JLabel emailLabel = new JLabel("Email: ");
        	       	size = emailLabel.getPreferredSize();
        	       	emailLabel.setBounds(400 + insets.left, 35 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(emailLabel);
        	       	
        	       	final JTextField emailTextField = new JTextField(22);
        	       	emailTextField.setEditable(false);
        	       	emailTextField.setText(String.valueOf(userWindow.table.getModel().getValueAt(rowIndex, 9)));
        	       	size = emailTextField.getPreferredSize();
        	       	emailTextField.setBounds(500 + insets.left, 35 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(emailTextField);
        	       	
        	       	// Address
        	       	JLabel addressLabel = new JLabel("Address ");
        	       	size = addressLabel.getPreferredSize();
        	       	addressLabel.setBounds(400 + insets.left, 60 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(addressLabel);
        	       	
        	       	JLabel houseNoLabel = new JLabel("House No:");
        	       	size = houseNoLabel.getPreferredSize();
        	       	houseNoLabel.setBounds(400 + insets.left, 85 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(houseNoLabel);
        	       	
        	       	final JTextField houseNoTextField = new JTextField(22);
        	       	houseNoTextField.setEditable(false);
        	       	houseNoTextField.setText(String.valueOf(userWindow.table.getModel().getValueAt(rowIndex, 10)));
        	       	size = houseNoTextField.getPreferredSize();
        	       	houseNoTextField.setBounds(500 + insets.left, 85 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(houseNoTextField);
        	       	
        	       	JLabel streetLabel = new JLabel("Street:");
        	       	size = streetLabel.getPreferredSize();
        	       	streetLabel.setBounds(400 + insets.left, 110 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(streetLabel);
        	       	
        	       	final JTextField streetTextField = new JTextField(22);
        	       	streetTextField.setEditable(false);
        	       	streetTextField.setText(String.valueOf(userWindow.table.getModel().getValueAt(rowIndex, 11)));
        	       	size = streetTextField.getPreferredSize();
        	       	streetTextField.setBounds(500 + insets.left, 110 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(streetTextField);
        	       	
        	       	JLabel cityLabel = new JLabel("City:");
        	       	size = cityLabel.getPreferredSize();
        	       	cityLabel.setBounds(400 + insets.left, 135 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(cityLabel);
        	       	
        	       	final JTextField cityTextField = new JTextField(22);
        	       	cityTextField.setEditable(false);
        	       	cityTextField.setText(String.valueOf(userWindow.table.getModel().getValueAt(rowIndex, 12)));
        	       	size = cityTextField.getPreferredSize();
        	       	cityTextField.setBounds(500 + insets.left, 135 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(cityTextField);
        	       	
        	       	JLabel zipLabel = new JLabel("Zip:");
        	       	size = zipLabel.getPreferredSize();
        	       	zipLabel.setBounds(400 + insets.left, 160 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(zipLabel);
        	       	
        	       	final JTextField zipTextField = new JTextField(22);
        	       	zipTextField.setEditable(false);
        	       	zipTextField.setText(String.valueOf(userWindow.table.getModel().getValueAt(rowIndex, 13)));
        	       	size = zipTextField.getPreferredSize();
        	       	zipTextField.setBounds(500 + insets.left, 160 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(zipTextField);
        	       	
        	       	JLabel countryLabel = new JLabel("Country:");
        	       	size = countryLabel.getPreferredSize();
        	       	countryLabel.setBounds(400 + insets.left, 185 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(countryLabel);
        	       	
        	       	final JComboBox countryComBox = new JComboBox();
        	       	for(int index = 0; index < countryName.length; index++) {
        	       		countryComBox.addItem(countryName[index]);
        	       	}
        	       	countryComBox.setEditable(false);
        	       	size = countryComBox.getPreferredSize();
        	       	countryComBox.setSelectedItem(userWindow.table.getModel().getValueAt(rowIndex, 14));
        	       	countryComBox.setBounds(500 + insets.left, 185 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(countryComBox);
	               	
        	       	tableInfoPanel.revalidate();
        	       	
        	       	saveSelectedRowMenuItm.setEnabled(false);
    				saveEntryButton.setEnabled(false);
    				
    				if(userType.equals("Administrator") == true) {
       					editSelectedRowMenuItm.setEnabled(true);
       					deleteSelectedRowMenuItm.setEnabled(true);
       					
       					editEntryButton.setEnabled(true);
       					deleteEntryButton.setEnabled(true);
       					
       					// Edit
       					editSelectedRowMenuItm.addActionListener(new ActionListener() {
       						public void actionPerformed(ActionEvent event) {
       							userNameFirstTextField.setEditable(true);
       							userNameMidTextField.setEditable(true);
       							userNameLastTextField.setEditable(true);
       							phoneNotTextField.setEditable(true);
       							passwordTextField.setEditable(true);
       							passwordTextField.setText(selectedUserPassword);
       							maskPwdChkBox.setEnabled(false);
       							phoneNotTextField.setEditable(true);
       							emailTextField.setEditable(true);
       							houseNoTextField.setEditable(true);
       							streetTextField.setEditable(true);
       							cityTextField.setEditable(true);
       							zipTextField.setEditable(true);
       							
       							saveSelectedRowMenuItm.setEnabled(true);
       							editSelectedRowMenuItm.setEnabled(false);
       							deleteEntryButton.setEnabled(false);
       							
       							saveEntryButton.setEnabled(true);
       							editEntryButton.setEnabled(false);
       							deleteEntryButton.setEnabled(true);
       						}
       					});
       					
       					editEntryButton.addActionListener(new ActionListener() {
       						public void actionPerformed(ActionEvent event) {
       							userNameFirstTextField.setEditable(true);
       							userNameMidTextField.setEditable(true);
       							userNameLastTextField.setEditable(true);
       							phoneNotTextField.setEditable(true);
       							passwordTextField.setEditable(true);
       							passwordTextField.setText(selectedUserPassword);
       							maskPwdChkBox.setEnabled(false);
       							phoneNotTextField.setEditable(true);
       							emailTextField.setEditable(true);
       							houseNoTextField.setEditable(true);
       							streetTextField.setEditable(true);
       							cityTextField.setEditable(true);
       							zipTextField.setEditable(true);
       							
       							saveSelectedRowMenuItm.setEnabled(true);
       							editSelectedRowMenuItm.setEnabled(false);
       							deleteEntryButton.setEnabled(false);
       							
       							saveEntryButton.setEnabled(true);
       							editEntryButton.setEnabled(false);
       							deleteEntryButton.setEnabled(true);
       						}
       					});
       					
       					// Save
       					saveSelectedRowMenuItm.addActionListener(new ActionListener() {
       						public void actionPerformed(ActionEvent event) {
       							saveSelectedRowMenuItm.setEnabled(false);
       							editSelectedRowMenuItm.setEnabled(false);
       							deleteSelectedRowMenuItm.setEnabled(false);
       							
       							saveEntryButton.setEnabled(false);
       							editEntryButton.setEnabled(false);
       							deleteEntryButton.setEnabled(false);
       							
       							saveSelectedRowMenuItm.removeActionListener(this);
       							
       							Connection conn = null;
       							
       							try {
       								Class.forName (currentUsrSettings.driver).newInstance();
       								conn = DriverManager.getConnection (currentUsrSettings.connectionString + currentUsrSettings.dataBaseName, currentUsrSettings.dbUserName, currentUsrSettings.dbPassword);
       								
       								try {
       									Statement st = conn.createStatement();
       									st.executeUpdate("UPDATE user_info SET user_name_first = '" + userNameFirstTextField.getText().trim() + "', user_name_middle = '" + userNameMidTextField.getText().trim() + "', user_name_last = '" + userNameLastTextField.getText().trim() + "', user_password = '" + passwordTextField.getText().trim() + "', gender = '" + genderComBox.getSelectedItem() + "', date_of_birth = '" + String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(dateOfBirthChooser.getDate())) + "', phone = '" + phoneNotTextField.getText().trim() + "', email = '" + emailTextField.getText().trim() + "', address_house_no = '" + houseNoTextField.getText().trim() + "', address_street = '" + streetTextField.getText().trim() + "', address_city = '" + cityTextField.getText().trim() + "', address_zip = " + zipTextField.getText().trim() + ", country = '" + countryComBox.getSelectedItem() + "' WHERE user_id = " + userIdTextField.getText().trim() + ";");

       								} catch(SQLException exp) {
       									exp.printStackTrace();
       									saveSelectedRowMenuItm.removeActionListener(this);
       								} finally {
       									userIdTextField.setText(null);
       									userNameFirstTextField.setText(null);
       									userNameMidTextField.setText(null);
       									userNameLastTextField.setText(null);
       									passwordTextField.setText(null);
       									phoneNotTextField.setText(null);
       									emailTextField.setText(null);
       									houseNoTextField.setText(null);
       									streetTextField.setText(null);
       									cityTextField.setText(null);
       									zipTextField.setText(null);
       									conn.close();
       									saveSelectedRowMenuItm.removeActionListener(this);
       									refreshAllTable();
       								}
       								
       							} catch(Exception exp) {
       								exp.printStackTrace();
       								saveSelectedRowMenuItm.removeActionListener(this);
       							}
       							
       							saveSelectedRowMenuItm.removeActionListener(this);
       						}
       					});
       					
       					saveEntryButton.addActionListener(new ActionListener() {
       						public void actionPerformed(ActionEvent event) {
       							saveSelectedRowMenuItm.setEnabled(false);
       							editSelectedRowMenuItm.setEnabled(false);
       							deleteSelectedRowMenuItm.setEnabled(false);
       							
       							saveEntryButton.setEnabled(false);
       							editEntryButton.setEnabled(false);
       							deleteEntryButton.setEnabled(false);
       							
       							saveEntryButton.removeActionListener(this);
       							
       							Connection conn = null;
       							
       							try {
       								Class.forName (currentUsrSettings.driver).newInstance();
       								conn = DriverManager.getConnection (currentUsrSettings.connectionString + currentUsrSettings.dataBaseName, currentUsrSettings.dbUserName, currentUsrSettings.dbPassword);
       								
       								try {
       									Statement st = conn.createStatement();
       									st.executeUpdate("UPDATE user_info SET user_name_first = '" + userNameFirstTextField.getText().trim() + "', user_name_middle = '" + userNameMidTextField.getText().trim() + "', user_name_last = '" + userNameLastTextField.getText().trim() + "', user_password = '" + passwordTextField.getText().trim() + "', gender = '" + genderComBox.getSelectedItem() + "', date_of_birth = '" + String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(dateOfBirthChooser.getDate())) + "', phone = '" + phoneNotTextField.getText().trim() + "', email = '" + emailTextField.getText().trim() + "', address_house_no = '" + houseNoTextField.getText().trim() + "', address_street = '" + streetTextField.getText().trim() + "', address_city = '" + cityTextField.getText().trim() + "', address_zip = " + zipTextField.getText().trim() + ", country = '" + countryComBox.getSelectedItem() + "' WHERE user_id = " + userIdTextField.getText().trim());

       								} catch(SQLException exp) {
       									exp.printStackTrace();
       									saveEntryButton.removeActionListener(this);
       								} finally {
       									userIdTextField.setText(null);
       									userNameFirstTextField.setText(null);
       									userNameMidTextField.setText(null);
       									userNameLastTextField.setText(null);
       									passwordTextField.setText(null);
       									phoneNotTextField.setText(null);
       									emailTextField.setText(null);
       									houseNoTextField.setText(null);
       									streetTextField.setText(null);
       									cityTextField.setText(null);
       									zipTextField.setText(null);
       									conn.close();
       									saveEntryButton.removeActionListener(this);
       									refreshAllTable();
       								}
       								
       							} catch(Exception exp) {
       								exp.printStackTrace();
       								saveEntryButton.removeActionListener(this);
       							}
       							
       							saveEntryButton.removeActionListener(this);
       						}
       					});
       					
       					// Delete
       					deleteSelectedRowMenuItm.addActionListener(new ActionListener() {
       						public void actionPerformed(ActionEvent event) {
       							int response = JOptionPane.showConfirmDialog(null, "Are you sure to delete " + String.valueOf(userWindow.table.getModel().getValueAt(rowIndex, 1)) + " " + String.valueOf(userWindow.table.getModel().getValueAt(rowIndex, 2)) + " " + String.valueOf(userWindow.table.getModel().getValueAt(rowIndex, 3)) + " (" + String.valueOf(userWindow.table.getModel().getValueAt(rowIndex, 0)) + ") entry ?" , "Confirmation Message", JOptionPane.YES_NO_OPTION);
       							
       							if((response == JOptionPane.YES_OPTION) && (currentUsrSettings.userId.equals(userIdTextField.getText()) == false)) {
       								Connection conn = null;
       								
       								try {
       									Class.forName (currentUsrSettings.driver).newInstance();
       									conn = DriverManager.getConnection (currentUsrSettings.connectionString + currentUsrSettings.dataBaseName, currentUsrSettings.dbUserName, currentUsrSettings.dbPassword);
	       								
	       								try {
	       									Statement st = conn.createStatement();
	       									st.executeUpdate("DELETE FROM user_info WHERE user_id = '" + userIdTextField.getText() + "';");
	       									
	       								} catch (SQLException exp) {
	       									JOptionPane.showMessageDialog(null, "WARNING: This user has been borrowed one or more books already. Can't delete this user now.", "Warning", JOptionPane.WARNING_MESSAGE);
	       									exp.printStackTrace();
	       								} finally {
	       									conn.close();
	       									deleteSelectedRowMenuItm.removeActionListener(this);
	       									refreshAllTable();
	       								}
       									
       								} catch (Exception exp) {
       									exp.printStackTrace();
       									deleteSelectedRowMenuItm.removeActionListener(this);
       								}
       							}
       							
       							deleteSelectedRowMenuItm.removeActionListener(this);
       							
       							saveSelectedRowMenuItm.setEnabled(false);
	       						editSelectedRowMenuItm.setEnabled(false);
	       						deleteEntryButton.setEnabled(false);
	       							
	       						saveEntryButton.setEnabled(false);
	       						editEntryButton.setEnabled(false);
	       						deleteEntryButton.setEnabled(false);
       						}
       					});
       					
       					deleteEntryButton.addActionListener(new ActionListener() {
       						public void actionPerformed(ActionEvent event) {
       							int response = JOptionPane.showConfirmDialog(null, "Are you sure to delete " + String.valueOf(userWindow.table.getModel().getValueAt(rowIndex, 1)) + " " + String.valueOf(userWindow.table.getModel().getValueAt(rowIndex, 2)) + " " + String.valueOf(userWindow.table.getModel().getValueAt(rowIndex, 3)) + " (" + String.valueOf(userWindow.table.getModel().getValueAt(rowIndex, 0)) + ") entry ?" , "Confirmation Message", JOptionPane.YES_NO_OPTION);
       							
       							if((response == JOptionPane.YES_OPTION) && (currentUsrSettings.userId.equals(userIdTextField.getText()) == false)) {
       								Connection conn = null;
       								
       								try {
       									Class.forName (currentUsrSettings.driver).newInstance();
       									conn = DriverManager.getConnection (currentUsrSettings.connectionString + currentUsrSettings.dataBaseName, currentUsrSettings.dbUserName, currentUsrSettings.dbPassword);
	       								
	       								try {
	       									Statement st = conn.createStatement();
	       									st.executeUpdate("DELETE FROM user_info WHERE user_id = '" + userIdTextField.getText() + "';");
	       									
	       								} catch (SQLException exp) {
	       									JOptionPane.showMessageDialog(null, "WARNING: This user has been borrowed one or more books already. Can't delete this user now.", "Warning", JOptionPane.WARNING_MESSAGE);
	       									exp.printStackTrace();
	       								} finally {
	       									conn.close();
	       									deleteEntryButton.removeActionListener(this);
	       									refreshAllTable();
	       								}
       									
       								} catch (Exception exp) {
       									exp.printStackTrace();
       									deleteEntryButton.removeActionListener(this);
       								}
       							}
       							
       							deleteEntryButton.removeActionListener(this);
       							
       							saveSelectedRowMenuItm.setEnabled(false);
	       						editSelectedRowMenuItm.setEnabled(false);
	       						deleteEntryButton.setEnabled(false);
	       							
	       						saveEntryButton.setEnabled(false);
	       						editEntryButton.setEnabled(false);
	       						deleteEntryButton.setEnabled(false);
       						}
       					});
       				}
       			}
       		}
       	});
       	
       	issueWindow.table.addMouseListener(new MouseAdapter() {
       		public void mousePressed(MouseEvent mouseEvent) {
       			if(mouseEvent.getClickCount() == 1) {
       				titlePaneLabel.setText("Issue Table");
       				
       				titlePanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
       				
       				tableInfoPanel.setLayout(null);
       				tableInfoPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
       				
       				Dimension size;
           	       	Insets insets = tableInfoPanel.getInsets();
           	       	final int rowIndex = issueWindow.table.getSelectedRow();
           	       	
           	       	tableInfoPanel.removeAll();
           	       	
           	       	// User ID
           	       	JLabel userIdLabel = new JLabel("User ID: ");
        	       	size = userIdLabel.getPreferredSize();
        	       	userIdLabel.setBounds(10 + insets.left, 10 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(userIdLabel);
        	       	
        	       	final JTextField userIdTextField = new JTextField(18);
        	       	userIdTextField.setEditable(false);
        	       	userIdTextField.setText(String.valueOf(issueWindow.table.getModel().getValueAt(rowIndex, 0)));
        	       	size = userIdTextField.getPreferredSize();
        	       	userIdTextField.setBounds(150 + insets.left, 10 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(userIdTextField);
        	       	
        	       	// Name
           	       	JLabel nameLabel = new JLabel("Name: ");
        	       	size = nameLabel.getPreferredSize();
        	       	nameLabel.setBounds(10 + insets.left, 35 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(nameLabel);
        	       	
        	       	final JTextField userNameFirstTextField = new JTextField(7);
        	       	userNameFirstTextField.setEditable(false);
        	       	userNameFirstTextField.setText(String.valueOf(issueWindow.table.getModel().getValueAt(rowIndex, 1)));
           	       	size = userNameFirstTextField.getPreferredSize();
           	       	userNameFirstTextField.setBounds(90 + insets.left, 35 + insets.top, size.width, size.height);
           	       	tableInfoPanel.add(userNameFirstTextField);
           	       	
           	       	final JTextField userNameMidTextField = new JTextField(7);
           	       	userNameMidTextField.setEditable(false);
           	       	userNameMidTextField.setText(String.valueOf(issueWindow.table.getModel().getValueAt(rowIndex, 2)));
        	       	size = userNameMidTextField.getPreferredSize();
        	       	userNameMidTextField.setBounds(180 + insets.left, 35 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(userNameMidTextField);
        	       	
        	       	final JTextField userNameLastTextField = new JTextField(7);
        	       	userNameLastTextField.setEditable(false);
        	       	userNameLastTextField.setText(String.valueOf(issueWindow.table.getModel().getValueAt(rowIndex, 3)));
        	       	size = userNameLastTextField.getPreferredSize();
        	       	userNameLastTextField.setBounds(270 + insets.left, 35 + insets.top, size.width, size.height);
        	       	tableInfoPanel.add(userNameLastTextField);
        	       	
        	       	// ISBN
           	       	JLabel isbnLabel = new JLabel("ISBN: ");
    				size = isbnLabel.getPreferredSize();
    				isbnLabel.setBounds(10 + insets.left, 90 + insets.top, size.width, size.height);
    				tableInfoPanel.add(isbnLabel);
    				
    				final JTextField isbnTextField = new JTextField(18);
    				isbnTextField.setEditable(false);
    				isbnTextField.setText(String.valueOf(issueWindow.table.getModel().getValueAt(rowIndex, 4)));
    				size = isbnTextField.getPreferredSize();
    				isbnTextField.setBounds(150 + insets.left, 90 + insets.top, size.width, size.height);
    				tableInfoPanel.add(isbnTextField);
    				
    				// Book Title
    				JLabel titleLabel = new JLabel("Book Title: ");
    				size = titleLabel.getPreferredSize();
    				titleLabel.setBounds(10 + insets.left, 115 + insets.top, size.width, size.height);
    				tableInfoPanel.add(titleLabel);
    				
    				final JTextField bookTitleTextField = new JTextField(18);
    				bookTitleTextField.setEditable(false);
    				bookTitleTextField.setText(String.valueOf(issueWindow.table.getModel().getValueAt(rowIndex, 5)));
    				size = bookTitleTextField.getPreferredSize();
    				bookTitleTextField.setBounds(150 + insets.left, 115 + insets.top, size.width, size.height);
    				tableInfoPanel.add(bookTitleTextField);
    				
    				// Author
    				JLabel authorLabel = new JLabel("Author: ");
    				size = authorLabel.getPreferredSize();
    				authorLabel.setBounds(10 + insets.left, 140 + insets.top, size.width, size.height);
    				tableInfoPanel.add(authorLabel);
    				
    				JTextField authorTextField = new JTextField(18);
    				authorTextField.setEditable(false);
    				authorTextField.setText(String.valueOf(issueWindow.table.getModel().getValueAt(rowIndex, 6)));
    				size = authorTextField.getPreferredSize();
    				authorTextField.setBounds(150 + insets.left, 140 + insets.top, size.width, size.height);
    				tableInfoPanel.add(authorTextField);
    				
    				// Publisher
    				JLabel publisherLabel = new JLabel("Publisher: ");
    				size = publisherLabel.getPreferredSize();
    				publisherLabel.setBounds(10 + insets.left, 165 + insets.top, size.width, size.height);
    				tableInfoPanel.add(publisherLabel);
    				
    				JTextField publisherTextField = new JTextField(18);
    				publisherTextField.setEditable(false);
    				publisherTextField.setText(String.valueOf(issueWindow.table.getModel().getValueAt(rowIndex, 7)));
    				size = publisherTextField.getPreferredSize();
    				publisherTextField.setBounds(150 + insets.left, 165 + insets.top, size.width, size.height);
    				tableInfoPanel.add(publisherTextField);
    				
    				// Issue Date
    				JLabel issueDateLabel = new JLabel("Issue Date: ");
    				size = issueDateLabel.getPreferredSize();
    				issueDateLabel.setBounds(400 + insets.left, 10 + insets.top, size.width, size.height);
    				tableInfoPanel.add(issueDateLabel);
	               	
    				final JDateChooser issueDateChooser = new JDateChooser();
	    			issueDateChooser.setDate(mysqlDateConverter(String.valueOf(issueWindow.table.getModel().getValueAt(rowIndex, 8))));
		           	size = issueDateChooser.getPreferredSize();
		           	issueDateChooser.setBounds(500 + insets.left, 10 + insets.top, size.width, size.height);
		           	tableInfoPanel.add(issueDateChooser);
    				
	               	JLabel dueDateLabel = new JLabel("Due Date: ");
    				size = dueDateLabel.getPreferredSize();
    				dueDateLabel.setBounds(400 + insets.left, 35 + insets.top, size.width, size.height);
    				tableInfoPanel.add(dueDateLabel);
	               	
    				final JDateChooser dueDateChooser = new JDateChooser();
	    			dueDateChooser.setDate(mysqlDateConverter(String.valueOf(issueWindow.table.getModel().getValueAt(rowIndex, 9))));
		          	size = dueDateChooser.getPreferredSize();
		           	dueDateChooser.setBounds(500 + insets.left, 35 + insets.top, size.width, size.height);
	            	tableInfoPanel.add(dueDateChooser);
	            	
	            	Connection conn = null;
	               	
	               	try {
	               		Class.forName(currentUsrSettings.driver);
	        			conn = DriverManager.getConnection(currentUsrSettings.connectionString + currentUsrSettings.dataBaseName, currentUsrSettings.dbUserName, currentUsrSettings.dbPassword);
	        			
	        			try {
	        				final Statement st = conn.createStatement();
	        				ResultSet result = st.executeQuery("SELECT user_info.user_id, user_info.user_name_first, user_info.user_name_middle, user_info.user_name_last, issue.isbn, book_info.title, book_info.author, issue.issue_date, issue.due_date, (curdate() - issue.due_date) * " + currentUsrSettings.finePerDay + " AS 'fine_tk' FROM user_info, issue, book_info WHERE user_info.user_id = issue.user_id AND issue.isbn = book_info.isbn AND (curdate() - issue.due_date) > 0;");
	        				DatabaseMetaData dbm = conn.getMetaData();
	        				
	        				// Fine (if exists)
	        				while(result.next()) {
	        					JLabel fineLabel = new JLabel("Fine (BDT): ");
	            				size = fineLabel.getPreferredSize();
	            				fineLabel.setBounds(400 + insets.left, 90 + insets.top, size.width, size.height);
	            				tableInfoPanel.add(fineLabel);
	            				
	            				JTextField fineTextField = new JTextField(18);
	            				fineTextField.setEditable(false);
	            				fineTextField.setText(result.getString("fine_tk"));
	            				size = fineTextField.getPreferredSize();
	            				fineTextField.setBounds(500 + insets.left, 90 + insets.top, size.width, size.height);
	            				tableInfoPanel.add(fineTextField);
	        				}
	        				
	        			} catch (SQLException exp) {
	        				exp.printStackTrace();
	        			}
	        			
	               	} catch(Exception exp) {
	               		exp.printStackTrace();
	               	}
	               	
	               	tableInfoPanel.revalidate();
	               	
	               	saveSelectedRowMenuItm.setEnabled(false);
					editSelectedRowMenuItm.setEnabled(false);
					deleteEntryButton.setEnabled(true);
							
					saveEntryButton.setEnabled(false);
					editEntryButton.setEnabled(false);
					deleteEntryButton.setEnabled(true);
   					
   					// Delete	
   					deleteSelectedRowMenuItm.addActionListener(new ActionListener() {
   						public void actionPerformed(ActionEvent event) {
   							deleteSelectedRowMenuItm.removeActionListener(this);
   							
   							Connection conn = null;
								
								try {
									Class.forName (currentUsrSettings.driver).newInstance();
									conn = DriverManager.getConnection (currentUsrSettings.connectionString + currentUsrSettings.dataBaseName, currentUsrSettings.dbUserName, currentUsrSettings.dbPassword);
   								
   								try {
   									Statement st = conn.createStatement();
   									st.executeUpdate("DELETE FROM issue WHERE isbn = '" + isbnTextField.getText() + "' AND user_id = " + userIdTextField.getText() + ";");
   									
   								} catch (SQLException exp) {
   									exp.printStackTrace();
   								} finally {
   									conn.close();
   									deleteSelectedRowMenuItm.removeActionListener(this);
   									refreshAllTable();
   								}
									
								} catch (Exception exp) {
									exp.printStackTrace();
									deleteSelectedRowMenuItm.removeActionListener(this);
								}
   							
   							deleteEntryButton.removeActionListener(this);
   							
   							saveSelectedRowMenuItm.setEnabled(false);
       						editSelectedRowMenuItm.setEnabled(false);
       						deleteEntryButton.setEnabled(false);
       							
       						saveEntryButton.setEnabled(false);
       						editEntryButton.setEnabled(false);
       						deleteEntryButton.setEnabled(false);
   						}
   					});
   					
   					deleteEntryButton.removeActionListener(null);
   					
   					deleteEntryButton.addActionListener(new ActionListener() {
   						public void actionPerformed(ActionEvent event) {
   							deleteEntryButton.removeActionListener(this);
   							
   							Connection conn = null;
								
								try {
									Class.forName (currentUsrSettings.driver).newInstance();
									conn = DriverManager.getConnection (currentUsrSettings.connectionString + currentUsrSettings.dataBaseName, currentUsrSettings.dbUserName, currentUsrSettings.dbPassword);
   								
   								try {
   									Statement st = conn.createStatement();
   									st.executeUpdate("DELETE FROM issue WHERE isbn = '" + isbnTextField.getText() + "' AND user_id = " + userIdTextField.getText() + ";");
   									
   								} catch (SQLException exp) {
   									exp.printStackTrace();
   								} finally {
   									conn.close();
   									deleteEntryButton.removeActionListener(this);
   									refreshAllTable();
   								}
									
								} catch (Exception exp) {
									exp.printStackTrace();
									deleteEntryButton.removeActionListener(this);
								}
   							
   							deleteEntryButton.removeActionListener(this);
   							
   							saveSelectedRowMenuItm.setEnabled(false);
       						editSelectedRowMenuItm.setEnabled(false);
       						deleteEntryButton.setEnabled(false);
       							
       						saveEntryButton.setEnabled(false);
       						editEntryButton.setEnabled(false);
       						deleteEntryButton.setEnabled(false);
   						}
   					});
       			}
       		}
       	});
       	
       	// ... and an additional panel is also added at the south to show operational information
       	JPanel infoPanel = new JPanel();
       	infoPanel.setBackground(Color.LIGHT_GRAY);
       	mdiFrame.add(infoPanel, BorderLayout.SOUTH);
       	JLabel infoLabel = new JLabel();
       	infoLabel.setText(currentUsrSettings.softwareInfo);
       	infoPanel.add(infoLabel);
       	
       	// Adding internal frame with table
       	showBookTable(deskPane);			// Book Table
       	
       	if(userType.equals("Administrator")) {
       		showUserTable(deskPane);		// User Table
       		showIssueTable(deskPane);		// Issue Table
       	}
       	
		mdiFrame.setVisible(true);
		
		// Adding action listener for Menu Items
		// [File] --> [Add] --> [New User]
		newUserMenuItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				showAddNewUserWindow();
			}
		});
		
		// [File] --> [Add] --> [New Book]
		newBookMenuItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				showAddNewBookWindow();
			}
		});
		
		// [File] --> [Add] --> [New Reservation Entry]
		newRsvrEntryMenuItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				showNewReservationEntryWindow();
			}
		});
		
		// [File] --> [Print] --> [Book Table]
		bookTablePrintMenuItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					bookWindow.table.print();
					editEntryButton.setEnabled(false);
					deleteEntryButton.setEnabled(false);
				} catch (PrinterException exp) {
					exp.printStackTrace();
				}
			}
		});
		
		// [File] --> [Print] --> [User Table] (only for admin)
		userTablePrintMenuItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					userWindow.table.print();
					editEntryButton.setEnabled(false);
					deleteEntryButton.setEnabled(false);
				} catch (PrinterException exp) {
					exp.printStackTrace();
				}
			}
		});
		
		// [File] --> [Print] --> [Issue Table] (only for admin)
		userTablePrintMenuItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					issueWindow.table.print();
					editEntryButton.setEnabled(false);
					deleteEntryButton.setEnabled(false);
				} catch (PrinterException exp) {
					exp.printStackTrace();
				}
			}
		});
		
		// [File] --> [Print] --> [Table Information Panel]
		tableInfoPanelPrintMenuItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				PrintUtilities printUtil = new PrintUtilities(tableInfoPanel);
       			printUtil.print();
       			editEntryButton.setEnabled(false);
				deleteEntryButton.setEnabled(false);
			}
		});
		
       	// [File] --> [Exit]
       	exitMenuItm.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			System.exit(mdiFrame.EXIT_ON_CLOSE);
       		}
       	});
       	
       	// [View] --> [User Profile] <--> [Refresh all table] <-||-> [x][Book Table] --> [[x]User Table --> [x]Issue Table]] (only for admin) <-||-> [Find]
       	userProfileMenuItm.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			showUserInfoFrame(userName);
       		}
       	});
       	
       	refreshAllTableMenuItm.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			refreshAllTable();
       		}
       	});
       	
       	bookTableMenuItm.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			try {
       				if((bookTableMenuItm.isSelected() == true)) {
           				showBookTable(deskPane);
           			}
           			else {
           				bookWindow.intrlFrame.dispose();
           			}
       			} catch(IllegalArgumentException exp) {
       				exp.printStackTrace();
       			}
       		}
       	});
       	
       	userTableMenuItm.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			try {
       				if((userTableMenuItm.isSelected() == true)) {
           				showUserTable(deskPane);
           			}
           			else {
           				userWindow.intrlFrame.dispose();
           			}
       			} catch(IllegalArgumentException exp) {
       				exp.printStackTrace();
       			}
       		}
       	});
       	
       	issueTableMenuItm.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			try {
       				if((issueTableMenuItm.isSelected() == true)) {
           				showIssueTable(deskPane);
           			}
           			else {
           				issueWindow.intrlFrame.dispose();
           			}
       			} catch(IllegalArgumentException exp) {
       				exp.printStackTrace();
       			}
       		}
       	});
       	
       	findMenuItm.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			showSearchWindow(userType);
       		}
       	});
       	
       	// [Help] --> [Contents]
       	contentsMenuItm.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			showHelpWindow();
       		}
       	});
       	
       	// [Help] --> [About]
       	aboutMenuItm.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			LibraryManagementSystem_gui.showAboutWindow();
       		}
       	});
       	
       	// Adding action listener for toolbar button
       	addButton.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			final JFrame addNewEntryWizardFrame = new JFrame("Add New Entry Wizard");
       			addNewEntryWizardFrame.setDefaultCloseOperation(addNewEntryWizardFrame.DISPOSE_ON_CLOSE);
       			addNewEntryWizardFrame.setSize(currentUsrSettings.newEntryWizardFrameWidth, currentUsrSettings.newEntryWizardFrameHeight);
       			addNewEntryWizardFrame.setResizable(false);
       			
       			Toolkit kit = Toolkit.getDefaultToolkit();
       			
       			//Setting up icon
       	        Image img = kit.getImage("add.png");
       	        addNewEntryWizardFrame.setIconImage(img);
       	        
       	        // Setting up the position at the middle of the screen
       			Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
       			int x = (screenDimension.width - currentUsrSettings.newEntryWizardFrameWidth) / 2;
       	       	int y = (screenDimension.height - currentUsrSettings.newEntryWizardFrameHeight) / 2;    
       	       	addNewEntryWizardFrame.setBounds(x, y, currentUsrSettings.newEntryWizardFrameWidth, currentUsrSettings.newEntryWizardFrameHeight);
       			
       			// Adding components
       	       	try {
       	       		// wizardPanel
       	       		ImagePanel wizardPanel = new ImagePanel("add_new_entry_frame_header.png", 0, 0);
       	       		wizardPanel.setLayout(null);
       	       		
       	       		Dimension size;
       	       		Insets insets = panel.getInsets();
       	       		
       	       		final JRadioButton newUserRadioButton = new JRadioButton("Add new user");
       	       		size = newUserRadioButton.getPreferredSize();
       	       		newUserRadioButton.setBounds(80 + insets.left, 75 + insets.top, size.width, size.height);
       	       		wizardPanel.add(newUserRadioButton);
       	       		
       	       		final JRadioButton newBookRadioButton = new JRadioButton("Add new book");
       	       		size = newBookRadioButton.getPreferredSize();
       	       		newBookRadioButton.setBounds(80 + insets.left, 100 + insets.top, size.width, size.height);
       	       		wizardPanel.add(newBookRadioButton);
       	       		
       	       		final JRadioButton newBookReservationButton = new JRadioButton("Add new issue");
       	       		size = newBookReservationButton.getPreferredSize();
       	       		newBookReservationButton.setBounds(80 + insets.left, 125 + insets.top, size.width, size.height);
       	       		wizardPanel.add(newBookReservationButton);
       	       		
       	       		ButtonGroup group = new ButtonGroup();
       	       		group.add(newUserRadioButton);
       	       		group.add(newBookRadioButton);
       	       		group.add(newBookReservationButton);
       	       		
       	       		// buttonPanel
       	       		JPanel buttonPanel = new JPanel();
       	       		
       	       		JButton nextButton = new JButton("Next");
       	       		nextButton.addActionListener(new ActionListener() {
       	       			public void actionPerformed(ActionEvent event) {
       	       				if(newUserRadioButton.isSelected()) {
       	       					showAddNewUserWindow();
       	       					addNewEntryWizardFrame.dispose();
       	       				}
       	       				else if(newBookRadioButton.isSelected()) {
       	       					showAddNewBookWindow();
       	       					addNewEntryWizardFrame.dispose();
       	       				}
       	       				else if(newBookReservationButton.isSelected()) {
       	       					showNewReservationEntryWindow();
       	       					addNewEntryWizardFrame.dispose();
       	       				}
       	       			}
       	       		});
       	       		buttonPanel.add(nextButton);
       	       		
       	       		JButton cancelButton = new JButton("Cancel");
       	       		cancelButton.addActionListener(new ActionListener() {
       	       			public void actionPerformed(ActionEvent event) {
       	       				addNewEntryWizardFrame.dispose();
       	       			}
       	       		});
       	       		buttonPanel.add(cancelButton);
       	       		
       	       		addNewEntryWizardFrame.add(wizardPanel, BorderLayout.CENTER);
       	       		addNewEntryWizardFrame.add(buttonPanel, BorderLayout.SOUTH);
       	       		
       	       	} catch (IOException exp) {
       	       		exp.printStackTrace();
       	       	}
       	       	
       			addNewEntryWizardFrame.setVisible(true);
       		}
       	});
       	
       	// These are for print button
       	// creating popup menu for printButton
       	final JPopupMenu printPopup = new JPopupMenu();
       	
       	printPopup.add(new JMenuItem(new AbstractAction("Book Table") {
            public void actionPerformed(ActionEvent event) {
                try {
                	bookWindow.table.print();
                } catch(PrinterException exp) {
                	exp.printStackTrace();
                } finally {
                	saveEntryButton.setEnabled(false);
                	editEntryButton.setEnabled(false);
                	deleteEntryButton.setEnabled(false);
                }
            }
        }));
       	
       	if(userType.endsWith("Administrator") == true) {
       		printPopup.add(new JMenuItem(new AbstractAction("User Table") {
                public void actionPerformed(ActionEvent event) {
                	try {
                    	userWindow.table.print();
                    } catch(PrinterException exp) {
                    	exp.printStackTrace();
                    } finally {
                    	saveEntryButton.setEnabled(false);
                    	editEntryButton.setEnabled(false);
                    	deleteEntryButton.setEnabled(false);
                    }
                }
            }));
       		
       		printPopup.add(new JMenuItem(new AbstractAction("Issue Table") {
                public void actionPerformed(ActionEvent event) {
                	try {
                    	issueWindow.table.print();
                    } catch(PrinterException exp) {
                    	exp.printStackTrace();
                    } finally {
                    	saveEntryButton.setEnabled(false);
                    	editEntryButton.setEnabled(false);
                    	deleteEntryButton.setEnabled(false);
                    }
                }
            }));
       	}
       	
       	printPopup.addSeparator();
       	
       	printPopup.add(new JMenuItem(new AbstractAction("Table Information Panel") {
            public void actionPerformed(ActionEvent e) {
            	PrintUtilities printUtil = new PrintUtilities(tableInfoPanel);
       			printUtil.print();
       			
       			saveEntryButton.setEnabled(false);
            	editEntryButton.setEnabled(false);
            	deleteEntryButton.setEnabled(false);
            }
        }));

       	printButton.addMouseListener(new MouseAdapter() {
       		public void mousePressed(MouseEvent event) {
       			printPopup.show(event.getComponent(), event.getX(), event.getY());
       		}
       	});
       	
       	reloadButton.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			refreshAllTable();
       		}
       	});
       	
       	searchButton.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			showSearchWindow(userType);
       		}
       	});
       	
       	showUserInfoButton.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			showUserInfoFrame(userName);
       		}
       	});
       	
       	statsButton.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			deskPane.add(userIssueWindow.intrlFrame);
       			userIssueWindow.intrlFrame.setVisible(true);
       			refreshAllTable();
       		}
       	});
       	
       	exitButton.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			System.exit(mdiFrame.EXIT_ON_CLOSE);
       		}
       	});
       	
       	helpButton.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			showHelpWindow();
       		}
       	});
       	
       	aboutButton.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			LibraryManagementSystem_gui.showAboutWindow();
       		}
       	});
	}
	
	public static final void showBookTable(JDesktopPane deskPane) {
		deskPane.add(bookWindow.intrlFrame);
       	bookWindow.intrlFrame.setVisible(true);
	}
	
	public static final void showUserTable(JDesktopPane deskPane) {
		deskPane.add(userWindow.intrlFrame);
       	userWindow.intrlFrame.setVisible(true);
	}
	
	public static final void showIssueTable(JDesktopPane deskPane) {
		deskPane.add(issueWindow.intrlFrame);
       	issueWindow.intrlFrame.setVisible(true);
	}
	
	public static final void showAddNewUserWindow() {
		final JFrame addNewUserFrame = new JFrame("Add New User");
		addNewUserFrame.setDefaultCloseOperation(addNewUserFrame.DISPOSE_ON_CLOSE);
		addNewUserFrame.setSize(currentUsrSettings.addNewUserFrameWidth, currentUsrSettings.addNewUserFrameHeight);
		addNewUserFrame.setResizable(false);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		//Setting up icon
        Image img = kit.getImage("new_user_small.png");
        addNewUserFrame.setIconImage(img);
        
        // Setting up the position at the middle of the screen
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenDimension.width - currentUsrSettings.addNewUserFrameWidth) / 2;
       	int y = (screenDimension.height - currentUsrSettings.addNewUserFrameHeight) / 2;    
       	addNewUserFrame.setBounds(x, y, currentUsrSettings.addNewUserFrameWidth, currentUsrSettings.addNewUserFrameHeight);
		
       	// Adding components
		JPanel titlePanel = new JPanel();
		JLabel titleLabel = new JLabel("Add New User");
		Font font = new Font("Sans", Font.BOLD, 22);
		titleLabel.setFont(font);
		titlePanel.add(titleLabel);
		addNewUserFrame.add(titlePanel, BorderLayout.NORTH);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setLayout(null);
		
		Dimension size;
   		Insets insets = bodyPanel.getInsets();
		
   		// User Name
		JLabel userNameLabel = new JLabel("User Name: ");
		size = userNameLabel.getPreferredSize();
		userNameLabel.setBounds(10 + insets.left, 10 + insets.top, size.width, size.height);
		bodyPanel.add(userNameLabel);
		
		final JTextField userNameFirstTextField = new JTextField(7);
		size = userNameFirstTextField.getPreferredSize();
		userNameFirstTextField.setBounds(110 + insets.left, 10 + insets.top, size.width, size.height);
		bodyPanel.add(userNameFirstTextField);
		
		final JTextField userNameMidTextField = new JTextField(7);
		size = userNameMidTextField.getPreferredSize();
		userNameMidTextField.setBounds(200 + insets.left, 10 + insets.top, size.width, size.height);
		bodyPanel.add(userNameMidTextField);
		
		final JTextField userNameLastTextField = new JTextField(7);
		size = userNameLastTextField.getPreferredSize();
		userNameLastTextField.setBounds(290 + insets.left, 10 + insets.top, size.width, size.height);
		bodyPanel.add(userNameLastTextField);
		
		// User Type
		JLabel userTypeLabel = new JLabel("User Type: ");
		size = userTypeLabel.getPreferredSize();
		userTypeLabel.setBounds(10 + insets.left, 35 + insets.top, size.width, size.height);
		bodyPanel.add(userTypeLabel);
		
		final JComboBox userTypeComBox = new JComboBox();
		userTypeComBox.addItem("Member");
		userTypeComBox.addItem("Administrator");
		userTypeComBox.setEditable(false);
		size = userTypeComBox.getPreferredSize();
		userTypeComBox.setBounds(110 + insets.left, 35 + insets.top, size.width, size.height);
		bodyPanel.add(userTypeComBox);
		
		// Password
		JLabel passwordLabel = new JLabel("Password: ");
		size = passwordLabel.getPreferredSize();
		passwordLabel.setBounds(10 + insets.left, 70 + insets.top, size.width, size.height);
		bodyPanel.add(passwordLabel);
		
		final JPasswordField newPwdField = new JPasswordField(15);
		size = newPwdField.getPreferredSize();
		newPwdField.setBounds(110 + insets.left, 70 + insets.top, size.width, size.height);
		bodyPanel.add(newPwdField);
		
		JLabel repeatPwdLabel = new JLabel("Repeat: ");
		size = repeatPwdLabel.getPreferredSize();
		repeatPwdLabel.setBounds(10 + insets.left, 95 + insets.top, size.width, size.height);
		bodyPanel.add(repeatPwdLabel);
		
		final JPasswordField repPwdField = new JPasswordField(15);
		size = repPwdField.getPreferredSize();
		repPwdField.setBounds(110 + insets.left, 95 + insets.top, size.width, size.height);
		bodyPanel.add(repPwdField);
		
		// Gender
		JLabel genderLabel = new JLabel("Gender: ");
		size = genderLabel.getPreferredSize();
		genderLabel.setBounds(10 + insets.left, 120 + insets.top, size.width, size.height);
		bodyPanel.add(genderLabel);
		
		final JComboBox genderComBox = new JComboBox();
		genderComBox.addItem("Male");
		genderComBox.addItem("Female");
		genderComBox.setEditable(false);
		size = genderComBox.getPreferredSize();
		genderComBox.setBounds(110 + insets.left, 120 + insets.top, size.width, size.height);
		bodyPanel.add(genderComBox);
		
		// Date of Birth
		JLabel dateOfBirthLabel = new JLabel("Date of Birth: ");
		size = dateOfBirthLabel.getPreferredSize();
		dateOfBirthLabel.setBounds(10 + insets.left, 155 + insets.top, size.width, size.height);
		bodyPanel.add(dateOfBirthLabel);
		
		final JDateChooser dateOfBirthChooser = new JDateChooser();
		dateOfBirthChooser.setSelectableDateRange(currentUsrSettings.minDate, currentUsrSettings.maxDate);
		size = dateOfBirthLabel.getPreferredSize();
		dateOfBirthChooser.setBounds(110 + insets.left, 155 + insets.top, size.width, size.height);
		bodyPanel.add(dateOfBirthChooser);
		
		// Phone
		JLabel phoneLabel = new JLabel("Phone: ");
		size = phoneLabel.getPreferredSize();
		phoneLabel.setBounds(10 + insets.left, 180 + insets.top, size.width, size.height);
		bodyPanel.add(phoneLabel);
		
		final JTextField phoneNoTextField = new JTextField(15);
		size = phoneNoTextField.getPreferredSize();
		phoneNoTextField.setBounds(110 + insets.left, 180 + insets.top, size.width, size.height);
		bodyPanel.add(phoneNoTextField);
		
		// Email
		JLabel emailLabel = new JLabel("Email: ");
		size = emailLabel.getPreferredSize();
		emailLabel.setBounds(10 + insets.left, 205 + insets.top, size.width, size.height);
		bodyPanel.add(emailLabel);
		
		final JTextField emailTextField = new JTextField(15);
		size = emailTextField.getPreferredSize();
		emailTextField.setBounds(110 + insets.left, 205 + insets.top, size.width, size.height);
		bodyPanel.add(emailTextField);
		
		// Address
		JLabel addressLabel = new JLabel("Address");
		size = addressLabel.getPreferredSize();
		addressLabel.setBounds(10 + insets.left, 230 + insets.top, size.width, size.height);
		bodyPanel.add(addressLabel);
		
		JLabel houseNoLabel = new JLabel("House No: ");
		size = houseNoLabel.getPreferredSize();
		houseNoLabel.setBounds(10 + insets.left, 255 + insets.top, size.width, size.height);
		bodyPanel.add(houseNoLabel);
		
		final JTextField houseNoTextField = new JTextField(8);
		size = houseNoTextField.getPreferredSize();
		houseNoTextField.setBounds(110 + insets.left, 255 + insets.top, size.width, size.height);
		bodyPanel.add(houseNoTextField);
		
		JLabel streetLabel = new JLabel("Street: ");
		size = streetLabel.getPreferredSize();
		streetLabel.setBounds(220 + insets.left, 255 + insets.top, size.width, size.height);
		bodyPanel.add(streetLabel);
		
		final JTextField streetTextField = new JTextField(8);
		size = streetTextField.getPreferredSize();
		streetTextField.setBounds(280 + insets.left, 255 + insets.top, size.width, size.height);
		bodyPanel.add(streetTextField);
		
		JLabel cityLabel = new JLabel("City: ");
		size = cityLabel.getPreferredSize();
		cityLabel.setBounds(10 + insets.left, 280 + insets.top, size.width, size.height);
		bodyPanel.add(cityLabel);
		
		final JTextField cityTextField = new JTextField(8);
		size = cityTextField.getPreferredSize();
		cityTextField.setBounds(110 + insets.left, 280 + insets.top, size.width, size.height);
		bodyPanel.add(cityTextField);
		
		JLabel zipLabel = new JLabel("Zip: ");
		size = zipLabel.getPreferredSize();
		zipLabel.setBounds(220 + insets.left, 280 + insets.top, size.width, size.height);
		bodyPanel.add(zipLabel);
		
		final JTextField zipTextField = new JTextField(8);
		size = zipTextField.getPreferredSize();
		zipTextField.setBounds(280 + insets.left, 280 + insets.top, size.width, size.height);
		bodyPanel.add(zipTextField);
		
		JLabel countryLabel = new JLabel("Country: ");
		size = countryLabel.getPreferredSize();
		countryLabel.setBounds(10 + insets.left, 305 + insets.top, size.width, size.height);
		bodyPanel.add(countryLabel);
		
		final JComboBox countryComBox = new JComboBox();
		for(int index = 0; index < countryName.length; index++) {
			countryComBox.addItem(countryName[index]);
		}
		countryComBox.setEditable(false);
		countryComBox.setSelectedItem("Bangladesh");
		size = countryComBox.getPreferredSize();
		countryComBox.setBounds(110 + insets.left, 305 + insets.top, size.width, size.height);
		bodyPanel.add(countryComBox);
		
		addNewUserFrame.add(bodyPanel, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		
		JButton addButton = new JButton("Add");
		buttonPanel.add(addButton);
		
		JButton closeButton = new JButton("Close");
		buttonPanel.add(closeButton);
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String user_name_first = userNameFirstTextField.getText().trim();
				String user_name_middle = userNameMidTextField.getText().trim();
				String user_name_last = userNameLastTextField.getText().trim();
				String user_type = String.valueOf(userTypeComBox.getSelectedItem());
				String user_password = new String(newPwdField.getPassword());
				String repeatPassword = new String(repPwdField.getPassword());
				String gender = String.valueOf(genderComBox.getSelectedItem());
				String date_of_birth = String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(dateOfBirthChooser.getDate()));
				String phone = phoneNoTextField.getText().trim();
				String email = emailTextField.getText().trim();
				String address_house_no = houseNoTextField.getText().trim();
				String address_street = streetTextField.getText().trim();
				String address_city = cityTextField.getText().trim();
				String address_zip = zipTextField.getText().trim();
				String country = String.valueOf(countryComBox.getSelectedItem());
				
				// Now checking general constraints
				boolean userInfoCorrect = false;
       			String errorSpot = new String();
       			
       			// Checking general condition
       			if(((user_name_first.length() > currentUsrSettings.min_user_name_first - 1) && (user_name_last.length() > currentUsrSettings.min_user_name_last - 1) && ((user_name_first.length() + user_name_middle.length() + user_name_last.length()) > currentUsrSettings.min_user_name - 1)) && (phone.length() > currentUsrSettings.min_phone - 1) && (email.length() > currentUsrSettings.min_email - 1) && (address_house_no.length() > currentUsrSettings.min_adrs_house_no - 1) && (address_street.length() > currentUsrSettings.min_adrs_street - 1) && (address_city.length() > currentUsrSettings.min_adrs_city - 1) && (address_zip.length() > currentUsrSettings.min_zip - 1)) {
       				ErrorChecker userInfoErrChkr = new ErrorChecker();
       				// Now checking email address
       				if(userInfoErrChkr.checkEmail(email) == false) {
       					userInfoCorrect = false;
       					errorSpot = "email address";
       				}
       				else {
       					userInfoCorrect = true;
       				}
       				
       				// Now checking phone number
       				if(userInfoErrChkr.checkPhoneNo(phone) == false) {
       					userInfoCorrect = false;
       					errorSpot = errorSpot + " phone no";
       				}
       				
       				// Now checking password
       				if(user_password.equals(repeatPassword) == false) {
       					userInfoCorrect = false;
       					errorSpot = errorSpot + " password";
       				}
       				
       				// Checking zip
       				if(userInfoErrChkr.checkNumber(address_zip) == false) {
       					userInfoCorrect = false;
       					errorSpot = errorSpot + " Zip";
       				}
       				
       				if(userInfoCorrect == true) {
       					try {
       						Class.forName(currentUsrSettings.driver);
       						Connection conn = DriverManager.getConnection(currentUsrSettings.connectionString + currentUsrSettings.dataBaseName, currentUsrSettings.dbUserName, currentUsrSettings.dbPassword);
       						
       						try {
       							final Statement st = conn.createStatement();
           						st.executeUpdate("INSERT INTO user_info(user_name_first, user_name_middle, user_name_last, user_type, user_password, gender, date_of_birth, phone, email, address_house_no, address_street, address_city, address_zip, country) VALUES('" + user_name_first + "', '" + user_name_middle + "', '" + user_name_last + "', '" + user_type + "', '" + user_password + "', '" + gender + "', '" + date_of_birth + "', '" + phone + "', '" + email + "', '" + address_house_no + "', '" + address_street + "', '" + address_city + "', " + address_zip + ", '" + country + "');");
           						
           						// Now getting new User ID from database
           						ResultSet result = st.executeQuery("SELECT user_id FROM user_info WHERE user_name_first = '" + user_name_first + "' AND user_name_last = '" + user_name_last + "' AND date_of_birth = '" + date_of_birth + "' AND address_house_no = '" + address_house_no + "';");
           						String newUserId = new String();
           						
           						while(result.next()) {
           							newUserId = result.getString("user_id");
           						}
           						
           						JOptionPane.showMessageDialog(null, "User added successfuly and the new User ID is " + newUserId);
           						
           					} catch (SQLException exp) {
           						JOptionPane.showMessageDialog(null, "ERROR: Can't execute SQL statement. Please, check your connection again.", "ERROR", JOptionPane.ERROR_MESSAGE);
           						exp.printStackTrace();
           					} finally {
           						userNameFirstTextField.setText(null);
           						userNameMidTextField.setText(null);
           						userNameLastTextField.setText(null);
           						newPwdField.setText(null);
           						repPwdField.setText(null);
           						phoneNoTextField.setText(null);
           						emailTextField.setText(null);
           						houseNoTextField.setText(null);
           						streetTextField.setText(null);
           						cityTextField.setText(null);
           						zipTextField.setText(null);
    	               			
    	               			refreshAllTable();
           					}
       						
       					} catch(Exception exp) {
       						exp.printStackTrace();
       					}
       				}
       				else {
       					JOptionPane.showMessageDialog(null, "ERROR: Please, check your " + errorSpot + " correctly.", "Error", JOptionPane.ERROR_MESSAGE);
       				}
       			}
       			else {
       				JOptionPane.showMessageDialog(null, "ERROR: Please, type your information correctly.", "ERROR", JOptionPane.ERROR_MESSAGE);
       			}
			}
		});
		
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				addNewUserFrame.dispose();
			}
		});
		
		addNewUserFrame.add(buttonPanel, BorderLayout.SOUTH);
		
		addNewUserFrame.setVisible(true);
	}
	
	public static final void showAddNewBookWindow() {
		final JFrame newBookEntryFrame = new JFrame("Add new Book");
		newBookEntryFrame.setDefaultCloseOperation(newBookEntryFrame.DISPOSE_ON_CLOSE);
		newBookEntryFrame.setSize(currentUsrSettings.addNewBookFrameWidth, currentUsrSettings.addNewBookFrameHeight);
		newBookEntryFrame.setResizable(false);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		//Setting up icon
        Image img = kit.getImage("new_book_small.png");
        newBookEntryFrame.setIconImage(img);
        
        // Setting up the position at the middle of the screen
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenDimension.width - currentUsrSettings.addNewBookFrameWidth) / 2;
       	int y = (screenDimension.height - currentUsrSettings.addNewBookFrameHeight) / 2;    
       	newBookEntryFrame.setBounds(x, y, currentUsrSettings.addNewBookFrameWidth, currentUsrSettings.addNewBookFrameHeight);
       	
       	// Adding components
       	// titlePanel
       	JPanel titlePanel = new JPanel();
       	newBookEntryFrame.add(titlePanel, BorderLayout.NORTH);
       	
       	JLabel titleLabel = new JLabel("Add New Book");
       	Font font = new Font("Sans", Font.BOLD, 22);
       	titleLabel.setFont(font);
       	titlePanel.add(titleLabel);
       	
       	// bodyPanel
       	JPanel bodyPanel = new JPanel();
       	bodyPanel.setLayout(null);
       	
       	Dimension size;
   		Insets insets = bodyPanel.getInsets();
       	
   		// ISBN
       	JLabel isbnLabel = new JLabel("ISBN: ");
       	size = isbnLabel.getPreferredSize();
       	isbnLabel.setBounds(10 + insets.left, 10 + insets.top, size.width, size.height);
		bodyPanel.add(isbnLabel);
		
		final JTextField isbnTextField = new JTextField(15);
		size = isbnTextField.getPreferredSize();
		isbnTextField.setBounds(100 + insets.left, 10 + insets.top, size.width, size.height);
		bodyPanel.add(isbnTextField);
		
		// Book Title
		JLabel bookTitleLabel = new JLabel("Book Title: ");
		size = bookTitleLabel.getPreferredSize();
		bookTitleLabel.setBounds(10 + insets.left, 35 + insets.top, size.width, size.height);
		bodyPanel.add(bookTitleLabel);
		
		final JTextField bookTitleTextField = new JTextField(15);
		size = bookTitleTextField .getPreferredSize();
		bookTitleTextField.setBounds(100 + insets.left, 35 + insets.top, size.width, size.height);
		bodyPanel.add(bookTitleTextField );
		
		// Author
		JLabel authorLabel = new JLabel("Author: ");
		size = authorLabel.getPreferredSize();
		authorLabel.setBounds(10 + insets.left, 60 + insets.top, size.width, size.height);
		bodyPanel.add(authorLabel);
		
		final JTextField authorTextField = new JTextField(15);
		size = authorTextField.getPreferredSize();
		authorTextField.setBounds(100 + insets.left, 60 + insets.top, size.width, size.height);
		bodyPanel.add(authorTextField);
		
		// Publisher
		JLabel publisherLabel = new JLabel("Publisher: ");
		size = publisherLabel.getPreferredSize();
		publisherLabel.setBounds(10 + insets.left, 85 + insets.top, size.width, size.height);
		bodyPanel.add(publisherLabel);
		
		final JTextField publisherTextField = new JTextField(15);
		size = publisherTextField.getPreferredSize();
		publisherTextField.setBounds(100 + insets.left, 85 + insets.top, size.width, size.height);
		bodyPanel.add(publisherTextField);
		
		// Publication Date
		JLabel publicationDateLabel = new JLabel("Publication year: ");
		size = publicationDateLabel.getPreferredSize();
		publicationDateLabel.setBounds(10 + insets.left, 110 + insets.top, size.width, size.height);
		bodyPanel.add(publicationDateLabel);
		
		final JDateChooser publicationDateChooser = new JDateChooser();
		size = publicationDateChooser.getPreferredSize();
		publicationDateChooser.setBounds(170 + insets.left, 110 + insets.top, size.width, size.height);
		bodyPanel.add(publicationDateChooser);
		
		// Pages
		JLabel pagesLabel = new JLabel("Pages: ");
		size = pagesLabel.getPreferredSize();
		pagesLabel.setBounds(10 + insets.left, 135 + insets.top, size.width, size.height);
		bodyPanel.add(pagesLabel);
		
		final JTextField pagesTextField = new JTextField(15);
		size = pagesTextField.getPreferredSize();
		pagesTextField.setBounds(100 + insets.left, 135 + insets.top, size.width, size.height);
		bodyPanel.add(pagesTextField);
		
		// Genre
		JLabel genreLabel = new JLabel("Genre: ");
		size = genreLabel.getPreferredSize();
		genreLabel.setBounds(10 + insets.left, 160 + insets.top, size.width, size.height);
		bodyPanel.add(genreLabel);
		
		final JTextField genreTextField = new JTextField(15);
		size = genreTextField.getPreferredSize();
		genreTextField.setBounds(100 + insets.left, 160 + insets.top, size.width, size.height);
		bodyPanel.add(genreTextField);
       	
       	newBookEntryFrame.add(bodyPanel, BorderLayout.CENTER);
       	
       	// buttonPanel
       	JPanel buttonPanel = new JPanel();
       	
       	JButton addButton = new JButton("Add");
       	buttonPanel.add(addButton);
       	
       	JButton closeButton = new JButton("Close");
       	buttonPanel.add(closeButton);
       	
       	addButton.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			ErrorChecker bookInfoChecker = new ErrorChecker();
       			
       			if(((isbnTextField.getText().trim()).length() >= currentUsrSettings.min_isbn) && ((bookTitleTextField.getText().trim()).length() >= currentUsrSettings.min_book_title) && ((authorTextField.getText().trim()).length() >= currentUsrSettings.min_author) && ((publisherTextField.getText().trim()).length() >= currentUsrSettings.min_publisher) && (bookInfoChecker.checkNumber(pagesTextField.getText().trim()) == true)) {
       				Connection conn = null;
       				
       				try {
       					Class.forName(currentUsrSettings.driver);
       					conn = DriverManager.getConnection(currentUsrSettings.connectionString + currentUsrSettings.dataBaseName, currentUsrSettings.dbUserName, currentUsrSettings.dbPassword);
       		       		
       					try {
       						Statement st = conn.createStatement();
       						st.executeUpdate("INSERT INTO book_info VALUES('" + isbnTextField.getText().trim() + "', '" + bookTitleTextField.getText().trim() + "', '" + authorTextField.getText().trim() + "', '" + publisherTextField.getText().trim() + "', '" + String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(publicationDateChooser.getDate())) + "', " + pagesTextField.getText().trim() + ", '" + genreTextField.getText().trim()  + "');");
       						JOptionPane.showMessageDialog(null, "New book added successfully");
       						
       					} catch(SQLException exp) {
       						JOptionPane.showMessageDialog(null, "WARNING: You have probably entered which is already in the database. Duplication of same book is not allowed.", "Warning", JOptionPane.WARNING_MESSAGE);
       						exp.printStackTrace();
       					} finally {
       						refreshAllTable();
       						
       						isbnTextField.setText(null);
       						bookTitleTextField.setText(null);
       						authorTextField.setText(null);
       						publisherTextField.setText(null);
       						pagesTextField.setText(null);
       						genreTextField.setText(null);
       					}
       					
       				}  catch(Exception exp) {
       					exp.printStackTrace();
       				}
       			}
       			else {
       				JOptionPane.showMessageDialog(null, "ERROR: Please, check your entered data carefully !!!", "Error", JOptionPane.ERROR_MESSAGE);
       			}
       		}
       	});
       	
       	closeButton.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			newBookEntryFrame.dispose();
       		}
       	});
       	
       	newBookEntryFrame.add(buttonPanel, BorderLayout.SOUTH);
       	
       	newBookEntryFrame.setVisible(true);
	}
	
	public static void showNewReservationEntryWindow() {
		try {	
			final JFrame newResrvEntryFrame = new JFrame("Add New Reservation");
			newResrvEntryFrame.setDefaultCloseOperation(newResrvEntryFrame.DISPOSE_ON_CLOSE);
			newResrvEntryFrame.setSize(currentUsrSettings.addNewResrvEntryFrameWidth, currentUsrSettings.addNewResrvEntryFrameHeight);
			newResrvEntryFrame.setResizable(false);
			
			Toolkit kit = Toolkit.getDefaultToolkit();
			
			//Setting up icon
	        Image img = kit.getImage("borrow_book.png");
	        newResrvEntryFrame.setIconImage(img);
	        
	        // Setting up the position at the middle of the screen
			Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
			int x = (screenDimension.width - currentUsrSettings.addNewResrvEntryFrameWidth) / 2;
	       	int y = (screenDimension.height - currentUsrSettings.addNewResrvEntryFrameHeight) / 2;    
	       	newResrvEntryFrame.setBounds(x, y, currentUsrSettings.addNewResrvEntryFrameWidth, currentUsrSettings.addNewResrvEntryFrameHeight);
			
	       	// Adding components
	       	// titlePanel
	       	JPanel titlePanel = new JPanel();
	       	
	       	JLabel titleLabel = new JLabel("Add New Reservation");
	       	Font font = new Font("Sans", Font.BOLD, 18);
	       	titleLabel.setFont(font);
	       	titlePanel.add(titleLabel);
	       	
	       	// bodyPanel
	       	Connection conn = null;
			Class.forName(currentUsrSettings.driver);
			conn = DriverManager.getConnection(currentUsrSettings.connectionString + currentUsrSettings.dataBaseName, currentUsrSettings.dbUserName, currentUsrSettings.dbPassword);
	       	
	       	JPanel bodyPanel = new JPanel();
	       	bodyPanel.setLayout(null);
	       	
	       	Dimension size;
	   		Insets insets = bodyPanel.getInsets();
	       	
	   		// User ID
	       	JLabel userIdLabel = new JLabel("User ID: ");
	       	size = userIdLabel.getPreferredSize();
	       	userIdLabel.setBounds(10 + insets.left, 10 + insets.top, size.width, size.height);
			bodyPanel.add(userIdLabel);
			
			final JComboBox userIdComBox = new JComboBox();
			try {
				Statement st = conn.createStatement();
				ResultSet result = st.executeQuery("SELECT user_id FROM user_info WHERE user_type = 'Member';");
				
				while(result.next()) {
					userIdComBox.addItem(result.getString("user_id"));
				}
				
			} catch(SQLException exp) {
				exp.printStackTrace();
			}
			size = userIdComBox.getPreferredSize();
			userIdComBox.setBounds(100 + insets.left, 10 + insets.top, size.width, size.height);
			bodyPanel.add(userIdComBox);
			
			final JTextField userIdTextField = new JTextField(10);
			size = userIdTextField.getPreferredSize();
			userIdTextField.setBounds(260 + insets.left, 10 + insets.top, size.width, size.height);
			bodyPanel.add(userIdTextField);
	       	
			// ISBN
			JLabel isbnLabel = new JLabel("ISBN: ");
	       	size = isbnLabel.getPreferredSize();
	       	isbnLabel.setBounds(10 + insets.left, 50 + insets.top, size.width, size.height);
			bodyPanel.add(isbnLabel);
			
			final JComboBox isbnComBox = new JComboBox();
			try {
				Statement st = conn.createStatement();
				ResultSet result = st.executeQuery("SELECT isbn FROM book_info;");
				
				while(result.next()) {
					isbnComBox.addItem(result.getString("isbn"));
				}
				
			} catch(SQLException exp) {
				exp.printStackTrace();
			}
			size = isbnComBox.getPreferredSize();
			isbnComBox.setBounds(100 + insets.left, 50 + insets.top, size.width, size.height);
			bodyPanel.add(isbnComBox);
			
			final JTextField isbnTextField = new JTextField(10);
			size = isbnTextField.getPreferredSize();
			isbnTextField.setBounds(260 + insets.left, 50 + insets.top, size.width, size.height);
			bodyPanel.add(isbnTextField);
			
			// Issue Date
			JLabel issueDateLabel = new JLabel("Issue Date: ");
			size = issueDateLabel.getPreferredSize();
			issueDateLabel.setBounds(10 + insets.left, 90 + insets.top, size.width, size.height);
			bodyPanel.add(issueDateLabel);
			
			final JDateChooser issueDateChooser = new JDateChooser();
			size = issueDateChooser.getPreferredSize();
			issueDateChooser.setBounds(100 + insets.left, 90 + insets.top, size.width, size.height);
			bodyPanel.add(issueDateChooser);
			
			// Due Date
			JLabel dueDateLabel = new JLabel("Due Date: ");
			size = dueDateLabel.getPreferredSize();
			dueDateLabel.setBounds(10 + insets.left, 115 + insets.top, size.width, size.height);
			bodyPanel.add(dueDateLabel);
			
			final JDateChooser dueDateChooser = new JDateChooser();
			size = dueDateChooser.getPreferredSize();
			dueDateChooser.setBounds(100 + insets.left, 115 + insets.top, size.width, size.height);
			bodyPanel.add(dueDateChooser);
			
			// buttonPanel
			JPanel buttonPanel = new JPanel();
			
			JButton addButton = new JButton("Add");
			buttonPanel.add(addButton);
			
			JButton closeButton = new JButton("Close");
			buttonPanel.add(closeButton);
			
	       	newResrvEntryFrame.add(titlePanel, BorderLayout.NORTH);
	       	newResrvEntryFrame.add(bodyPanel, BorderLayout.CENTER);
	       	newResrvEntryFrame.add(buttonPanel, BorderLayout.SOUTH);
	       	
	       	newResrvEntryFrame.setVisible(true);
	       	
	       	// Adding action listener
	       	userIdComBox.addActionListener(new ActionListener() {
	       		public void actionPerformed(ActionEvent event) {
	       			userIdTextField.setText(String.valueOf(userIdComBox.getSelectedItem()));
	       		}
	       	});
	       	
	       	isbnComBox.addActionListener(new ActionListener() {
	       		public void actionPerformed(ActionEvent event) {
	       			isbnTextField.setText(String.valueOf(isbnComBox.getSelectedItem()));
	       		}
	       	});
	       	
	       	addButton.addActionListener(new ActionListener() {
	       		public void actionPerformed(ActionEvent event) {
	       			ErrorChecker newResrvEntryErrChkr = new ErrorChecker();
	       			
	       			if((newResrvEntryErrChkr.checkNumber(userIdTextField.getText().trim()) == true) && ((isbnTextField.getText().trim()).length() >= currentUsrSettings.min_isbn)) {
	       				String issue_date = String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(issueDateChooser.getDate()));
	       				String due_date = String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(dueDateChooser.getDate()));
	       				
	       				Connection conn = null;
	       				
	       				try {
	       					Class.forName(currentUsrSettings.driver);
       						conn = DriverManager.getConnection(currentUsrSettings.connectionString + currentUsrSettings.dataBaseName, currentUsrSettings.dbUserName, currentUsrSettings.dbPassword);

	       					try {
		       					Statement st = conn.createStatement();
		       					ResultSet result = st.executeQuery("SELECT issue.user_id, issue.isbn FROM issue;");
		       					
		       					String tempUserId = new String();
		       					String tempIsbn = new String();
		       					
		       					while(result.next()) {
		       						tempUserId = result.getString("user_id");
		       						tempIsbn = result.getString("isbn");
		       					}
		       					
		       					if((tempUserId.equals(userIdTextField.getText().trim()) == false) || (tempIsbn.equals(isbnTextField.getText().trim()) == false)) {
		       						try {
		       							st.executeUpdate("INSERT INTO issue VALUES(" + userIdTextField.getText().trim() + ", '" + isbnTextField.getText().trim() + "', '" + issue_date + "', '" + due_date + "');");
			       						JOptionPane.showMessageDialog(null, "New reservation entry added successfully.");
		       							
		       						} catch(SQLException exp) {
		       							JOptionPane.showMessageDialog(null, "ERROR: Please, check your information correctly.", "Error", JOptionPane.ERROR_MESSAGE);
		       						} finally {
		       							refreshAllTable();
		       						}
		       					}
		       					else {
		       						JOptionPane.showMessageDialog(null, "WARNING: User already had borrowed this book.", "Warning", JOptionPane.WARNING_MESSAGE);
		       					}
	       						
		       				} catch(SQLException exp) {
		       					exp.printStackTrace();
		       				}
		       				
	       				} catch(Exception exp) {
	       					exp.printStackTrace();
	       				}
	       			}
	       		}
	       	});
	       	
	       	closeButton.addActionListener(new ActionListener() {
	       		public void actionPerformed(ActionEvent event) {
	       			newResrvEntryFrame.dispose();
	       		}
	       	});
	       	
		} catch(Exception exp) {
			exp.printStackTrace();
		}
	}
	
	public static final void showUserInfoFrame(final String userName) {
		final JFrame userInfoFrame = new JFrame(userName + " - [User Information]");
		userInfoFrame.setDefaultCloseOperation(userInfoFrame.DISPOSE_ON_CLOSE);
		userInfoFrame.setSize(currentUsrSettings.userInfoFrameWidth, currentUsrSettings.userInfoFrameHeight);
       	userInfoFrame.setResizable(false);
		
		//Setting up icon
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("userInfo.png");
        userInfoFrame.setIconImage(img);
		
		// Setting up the position of the ABOUT FRAME at the middle of the screen
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenDimension.width - currentUsrSettings.userInfoFrameWidth) / 2;
       	int y = (screenDimension.height - currentUsrSettings.userInfoFrameHeight) / 2;    
       	userInfoFrame.setBounds(x, y, currentUsrSettings.userInfoFrameWidth, currentUsrSettings.userInfoFrameHeight);
       	
       	try {
       		Class.forName(currentUsrSettings.driver);
			Connection con = DriverManager.getConnection(currentUsrSettings.connectionString + currentUsrSettings.dataBaseName, currentUsrSettings.dbUserName, currentUsrSettings.dbPassword);
       		
           	try {
           		final Statement st = con.createStatement();
				ResultSet result = st.executeQuery("SELECT * FROM user_info WHERE user_id = " + currentUsrSettings.userId + " AND user_password = '" + currentUsrSettings.userPassword + "';");
				DatabaseMetaData dbm = con.getMetaData();
				
				while(result.next()) {
					// Adding components to userInfoFrame and displaying data from database (lmsDB.user_info)
					JPanel titlePanel = new JPanel();
					
					Font font = new Font("Sans", Font.BOLD, 24);				// titlePanel
					JLabel titleLabel = new JLabel("User Information");
					titleLabel.setFont(font);
					titlePanel.add(titleLabel);
					
	               	final JPanel userInfoPanel = new JPanel();
	               	userInfoPanel.setLayout(null);
	               	
	               	JPanel buttonPanel = new JPanel();
	               	
	               	Dimension size;
		       		Insets insets = userInfoPanel.getInsets();
	               	
		       		// userInfoPanel
		       		// User ID
	               	JLabel userIdLabel = new JLabel("User ID: ");
	               	size = userIdLabel.getPreferredSize();
	               	userIdLabel.setBounds(60 + insets.left, 15 + insets.top, size.width, size.height);
	               	userInfoPanel.add(userIdLabel);
	               	
	               	final JTextField userIdTextField = new JTextField(22);
	               	userIdTextField.setText(String.valueOf(result.getInt("user_id")));
	               	userIdTextField.setEditable(false);
	               	size = userIdTextField.getPreferredSize();
	               	userIdTextField.setBounds(150 + insets.left, 15 + insets.top, size.width, size.height);
	               	userInfoPanel.add(userIdTextField);
	               	
	               	// Name
	               	JLabel nameLabel = new JLabel("Name: ");
	               	size = nameLabel.getPreferredSize();
	               	nameLabel.setBounds(60 + insets.left, 45 + insets.top, size.width, size.height);
	               	userInfoPanel.add(nameLabel);
	               	
	               	final JTextField userNameFirstTextField = new JTextField(7);
	               	userNameFirstTextField.setText(result.getString("user_name_first"));
	               	userNameFirstTextField.setEditable(false);
	               	size = userNameFirstTextField.getPreferredSize();
	               	userNameFirstTextField.setBounds(150 + insets.left, 45 + insets.top, size.width, size.height);
	               	userInfoPanel.add(userNameFirstTextField);
	               	
	               	final JTextField userNameMidTextField = new JTextField(6);
	               	userNameMidTextField.setText(result.getString("user_name_middle"));
	               	userNameMidTextField.setEditable(false);
	               	size = userNameMidTextField.getPreferredSize();
	               	userNameMidTextField.setBounds(237 + insets.left, 45 + insets.top, size.width, size.height);
	               	userInfoPanel.add(userNameMidTextField);
	               	
	               	final JTextField userNameLastTextField = new JTextField(7);
	               	userNameLastTextField.setText(result.getString("user_name_last"));
	               	userNameLastTextField.setEditable(false);
	               	size = userNameLastTextField.getPreferredSize();
	               	userNameLastTextField.setBounds(315 + insets.left, 45 + insets.top, size.width, size.height);
	               	userInfoPanel.add(userNameLastTextField);
	               	
	               	// User Type
	               	JLabel userTypeLabel = new JLabel("User Type: ");
	               	size = userTypeLabel.getPreferredSize();
	               	userTypeLabel.setBounds(60 + insets.left, 75 + insets.top, size.width, size.height);
	               	userInfoPanel.add(userTypeLabel);
	               	
	               	JTextField userTypeTextField = new JTextField(21);
	               	userTypeTextField.setText(result.getString("user_type"));
	               	userTypeTextField.setEditable(false);
	               	size = userTypeTextField.getPreferredSize();
	               	userTypeTextField.setBounds(162 + insets.left, 75 + insets.top, size.width, size.height);
	               	userInfoPanel.add(userTypeTextField);
	               	
	               	// Gender
	               	JLabel genderLabel = new JLabel("Gender: ");
	               	size = genderLabel.getPreferredSize();
	               	genderLabel.setBounds(60 + insets.left, 105 + insets.top, size.width, size.height);
	               	userInfoPanel.add(genderLabel);
	               	
	               	final JComboBox genderComBox = new JComboBox();
	               	genderComBox.addItem("Male");
	               	genderComBox.addItem("Female");
	               	genderComBox.setSelectedItem(result.getString("gender"));
	               	genderComBox.setEditable(false);
	               	genderComBox.setBounds(162 + insets.left, 105 + insets.top, size.width, size.height);
	               	userInfoPanel.add(genderComBox);
	               	
	               	// Date of Birth
	               	JLabel dateOfBirthLabel = new JLabel("Date of Birth: ");
	               	size = dateOfBirthLabel.getPreferredSize();
	               	dateOfBirthLabel.setBounds(60 + insets.left, 135 + insets.top, size.width, size.height);
	               	userInfoPanel.add(dateOfBirthLabel);
	               	
	               	final JDateChooser dateOfBirthChooser = new JDateChooser();
	               	dateOfBirthChooser.setSelectableDateRange(currentUsrSettings.minDate, currentUsrSettings.maxDate);
	               	dateOfBirthChooser.setDate(result.getDate("date_of_birth"));
	               	size = dateOfBirthChooser.getPreferredSize();
	               	dateOfBirthChooser.setBounds(162 + insets.left, 135 + insets.top, size.width, size.height);
	               	userInfoPanel.add(dateOfBirthChooser);
	               	
	               	// Phone
	               	JLabel phoneLabel = new JLabel("Phone: ");
	               	size = phoneLabel.getPreferredSize();
	               	phoneLabel.setBounds(60 + insets.left, 165 + insets.top, size.width, size.height);
	               	userInfoPanel.add(phoneLabel);
	               	
	               	final JTextField phoneTextField = new JTextField(21);
	               	phoneTextField.setText(result.getString("phone"));
	               	phoneTextField.setEditable(false);
	               	size = phoneTextField.getPreferredSize();
	               	phoneTextField.setBounds(162 + insets.left, 165 + insets.top, size.width, size.height);
	               	userInfoPanel.add(phoneTextField);
	               	
	               	// Email
	               	JLabel emailLabel = new JLabel("Email: ");
	               	size = emailLabel.getPreferredSize();
	               	emailLabel.setBounds(60 + insets.left, 195 + insets.top, size.width, size.height);
	               	userInfoPanel.add(emailLabel);
	               	
	               	final JTextField emailTextField = new JTextField(21);
	               	emailTextField.setText(result.getString("email"));
	               	emailTextField.setEditable(false);
	               	size = emailTextField.getPreferredSize();
	               	emailTextField.setBounds(162 + insets.left, 195 + insets.top, size.width, size.height);
	               	userInfoPanel.add(emailTextField);
	               	
	               	// Address
	               	JLabel addresslLabel = new JLabel("Address");
	               	size = addresslLabel.getPreferredSize();
	               	addresslLabel.setBounds(60 + insets.left, 230 + insets.top, size.width, size.height);
	               	userInfoPanel.add(addresslLabel);
	               	
	               	JLabel houseNoLabel = new JLabel("House No: ");
	               	size = houseNoLabel.getPreferredSize();
	               	houseNoLabel.setBounds(60 + insets.left, 255 + insets.top, size.width, size.height);
	               	userInfoPanel.add(houseNoLabel);
	               	
	               	final JTextField houseNoTextField = new JTextField(21);
	               	houseNoTextField.setText(result.getString("address_house_no"));
	               	houseNoTextField.setEditable(false);
	               	size = houseNoTextField.getPreferredSize();
	               	houseNoTextField.setBounds(162 + insets.left, 255 + insets.top, size.width, size.height);
	               	userInfoPanel.add(houseNoTextField);
	               	
	               	JLabel streetLabel = new JLabel("Street: ");
	               	size = streetLabel.getPreferredSize();
	               	streetLabel.setBounds(60 + insets.left, 280 + insets.top, size.width, size.height);
	               	userInfoPanel.add(streetLabel);
	               	
	               	final JTextField streetTextField = new JTextField(21);
	               	streetTextField.setText(result.getString("address_street"));
	               	streetTextField.setEditable(false);
	               	size = streetTextField.getPreferredSize();
	               	streetTextField.setBounds(162 + insets.left, 280 + insets.top, size.width, size.height);
	               	userInfoPanel.add(streetTextField);
	               	
	               	JLabel cityLabel = new JLabel("City: ");
	               	size = cityLabel.getPreferredSize();
	               	cityLabel.setBounds(60 + insets.left, 305 + insets.top, size.width, size.height);
	               	userInfoPanel.add(cityLabel);
	               	
	               	final JTextField cityTextField = new JTextField(10);
	               	cityTextField.setText(result.getString("address_city"));
	               	cityTextField.setEditable(false);
	               	size = cityTextField.getPreferredSize();
	               	cityTextField.setBounds(130 + insets.left, 305 + insets.top, size.width, size.height);
	               	userInfoPanel.add(cityTextField);
	               	
	               	JLabel zipLabel = new JLabel("Zip: ");
	               	size = zipLabel.getPreferredSize();
	               	zipLabel.setBounds(250 + insets.left, 305 + insets.top, size.width, size.height);
	               	userInfoPanel.add(zipLabel);
	               	
	               	final JTextField zipTextField = new JTextField(10);
	               	zipTextField.setText(result.getString("address_zip"));
	               	zipTextField.setEditable(false);
	               	size = zipTextField.getPreferredSize();
	               	zipTextField.setBounds(285 + insets.left, 305 + insets.top, size.width, size.height);
	               	userInfoPanel.add(zipTextField);
	               	
	               	JLabel countryLabel = new JLabel("Country: ");
	               	size = countryLabel.getPreferredSize();
	               	countryLabel.setBounds(60 + insets.left, 330 + insets.top, size.width, size.height);
	               	userInfoPanel.add(countryLabel);
	               	
	               	final JComboBox countryComBox = new JComboBox();
	               	int totalNoOfCountry = countryName.length;
	               	for(int index = 0; index < totalNoOfCountry; index++) {
	               		countryComBox.addItem(countryName[index]);
	               	}
	               	countryComBox.setEditable(false);
	               	countryComBox.setSelectedItem(result.getString("country"));
	               	size = countryComBox.getPreferredSize();
	               	countryComBox.setBounds(150 + insets.left, 330 + insets.top, size.width, size.height);
	               	userInfoPanel.add(countryComBox);
	               	
	               	// buttonPanel
	               	final JButton chngPwdButton = new JButton("Change Password");
	               	final JButton editButton = new JButton("Edit");
	               	final JButton saveButton = new JButton("Save");
	               	JButton printButton = new JButton("Print");
	               	JButton closeButton = new JButton("Close");
	               	
	               	saveButton.setEnabled(false);
	               	
	               	chngPwdButton.addActionListener(new ActionListener() {
	               		public void actionPerformed(ActionEvent event) {
	               			final JFrame chngPwdFrame = new JFrame(userName + " - [Change Password]");
	               			chngPwdFrame.setDefaultCloseOperation(chngPwdFrame.DISPOSE_ON_CLOSE);
	               			chngPwdFrame.setSize(currentUsrSettings.loginFrameWidth, currentUsrSettings.loginFrameHeight);
	               			chngPwdFrame.setResizable(false);
	               			
	               			// Setting up frame location at the middle of the screen
	               			Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	               			int x = (screenDimension.width - currentUsrSettings.chngPwdFrameWidth) / 2;
	               	       	int y = (screenDimension.height - currentUsrSettings.chngPwdFrameHeight) / 2;    
	               	       	chngPwdFrame.setBounds(x, y, currentUsrSettings.chngPwdFrameWidth, currentUsrSettings.chngPwdFrameHeight);
	               			
	               	       	// Setting up CHANGE PASSWORD FRAME icon
	               			Toolkit kit = Toolkit.getDefaultToolkit();
	               			Image loginFrameIcon = kit.getImage("login_small.png");
	               			chngPwdFrame.setIconImage(loginFrameIcon);
	               	       	
	               	       	try {
	               	       		// Adding components
	               	       		// chngPwdPanel
		               	       	ImagePanel chngPwdPanel = new ImagePanel("login.png", 5, 25);
		               	       	chngPwdPanel.setLayout(null);
		               	       	
		               	       	Dimension size;
		               	       	Insets insets = userInfoPanel.getInsets();
		               	       	
		               	       	JLabel currentPwdLabel = new JLabel("Current Password: ");
		               	       	size = currentPwdLabel.getPreferredSize();
		               	       	currentPwdLabel.setBounds(60 + insets.left, 10 + insets.top, size.width, size.height);
		               	       	chngPwdPanel.add(currentPwdLabel);
		               	       	
		               	       	final JTextField currentPwdTextField = new JTextField(10);
		               	       	String echoPwd = new String();
		               	       	for(int i = 1; i <= currentUsrSettings.userPassword.length(); i++) {
		               	       		echoPwd = echoPwd + '*';
		               	       	}
		               	       	currentPwdTextField.setText(echoPwd);
		               	       	currentPwdTextField.setBounds(210 + insets.left, 10 + insets.top, size.width, size.height);
		               	       	chngPwdPanel.add(currentPwdTextField);
		               	       	
		               	       	final JCheckBox maskPwdChkBox = new JCheckBox("Mask password");
		               	       	maskPwdChkBox.setSelected(true);
		               	       	maskPwdChkBox.setBounds(190 + insets.left, 35 + insets.top, size.width, size.height);
		               	       	final String currentEchoPwd = echoPwd;
		               	       	maskPwdChkBox.addActionListener(new ActionListener() {
		               	       		public void actionPerformed(ActionEvent event) {
		               	       			if(maskPwdChkBox.isSelected() == true) {
		               	       				currentPwdTextField.setText(currentEchoPwd);
		               	       			}
		               	       			else {
		               	       				currentPwdTextField.setText(currentUsrSettings.userPassword);
		               	       			}
		               	       		}
		               	       	});
		               	       	chngPwdPanel.add(maskPwdChkBox);
		               	       	
		               	       	JLabel newPwdLabel = new JLabel("New Password: ");
		               	       	size = newPwdLabel.getPreferredSize();
		               	       	newPwdLabel.setBounds(60 + insets.left, 70 + insets.top, size.width, size.height);
		               	       	chngPwdPanel.add(newPwdLabel);
		               	       	
		               	       	final JPasswordField newPwdField = new JPasswordField(12);
		               	       	size = newPwdField.getPreferredSize();
		               	       	newPwdField.setBounds(210 + insets.left, 70 + insets.top, size.width, size.height);
		               	       	chngPwdPanel.add(newPwdField);
		               	       	
		               	       	JLabel confirmPwdLabel = new JLabel("Confirm Password: ");
		               	       	size = confirmPwdLabel.getPreferredSize();
		               	       	confirmPwdLabel.setBounds(60 + insets.left, 95 + insets.top, size.width, size.height);
		               	       	chngPwdPanel.add(confirmPwdLabel);
		               	       	
		               	       	final JPasswordField confirmPwdField = new JPasswordField(12);
		               	       	size = confirmPwdField.getPreferredSize();
		               	       	confirmPwdField.setBounds(210 + insets.left, 95 + insets.top, size.width, size.height);
		               	       	chngPwdPanel.add(confirmPwdField);
		               	       	
		               	       	// chngPwdButtonPanel
		               	       	JPanel chngPwdButtonPanel = new JPanel();
		               	       	
		               	       	JButton saveButton = new JButton("Save");
		               	       	saveButton.addActionListener(new ActionListener() {
		               	       		public void actionPerformed(ActionEvent event) {
		               	       			String newPassword = new String(newPwdField.getPassword());
		               	       			
		               	       			if((newPassword.trim().length() >= currentUsrSettings.minUsrPwdLength) && (newPassword.trim().equals(new String(confirmPwdField.getPassword()).trim()))) {
		               	       				try {
		               	       					st.executeUpdate("UPDATE user_info SET user_password = '" + newPassword + "' WHERE user_id = " + currentUsrSettings.userId + " AND user_password = '" + currentUsrSettings.userPassword + "';");
		               	       					currentUsrSettings.userPassword = newPassword;
		               	       					JOptionPane.showMessageDialog(null, "Password has been changed successfuly.");
		               	       					chngPwdFrame.dispose();
		               	       				} catch (SQLException exp) {
		               	       					exp.printStackTrace();
		               	       				} finally {
		               	       					refreshAllTable();
		               	       				}
		               	       			}
		               	       			else {
		               	       				JOptionPane.showMessageDialog(null, "ERROR: Password mismatched !!!", "Error", JOptionPane.ERROR_MESSAGE);
		               	       				confirmPwdField.setText("");
		               	       			}
		               	       		}
		               	       	});
		               	       	chngPwdButtonPanel.add(saveButton);
		               	       	
		               	       	// Keystroke: If user press ENTER saveButton will perform its action automatically.
		               	       	saveButton.registerKeyboardAction(saveButton.getActionForKeyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false)), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), JComponent.WHEN_IN_FOCUSED_WINDOW);
		               	       	saveButton.registerKeyboardAction(saveButton.getActionForKeyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true)), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), JComponent.WHEN_IN_FOCUSED_WINDOW);
		               	       	
		               	       	JButton cancelButton = new JButton("Cancel");
		               	       	cancelButton.addActionListener(new ActionListener() {
		               	       		public void actionPerformed(ActionEvent event) {
		               	       			chngPwdFrame.dispose();
		               	       		}
		               	       	});
		               	       	chngPwdButtonPanel.add(cancelButton);
		               	       	
		               	       	chngPwdFrame.add(chngPwdPanel, BorderLayout.CENTER);
		               	       	chngPwdFrame.add(chngPwdButtonPanel, BorderLayout.SOUTH);
		               			chngPwdFrame.setVisible(true);
	               	       	} catch(IOException exp) {
	               	       		exp.printStackTrace();
	               	       	}
	               		}
	               	});
	               	buttonPanel.add(chngPwdButton);
	               	
	               	editButton.addActionListener(new ActionListener() {
	               		public void actionPerformed(ActionEvent event) {
	               			saveButton.setEnabled(true);
	               			editButton.setEnabled(false);

	               			userNameFirstTextField.setEditable(true);
	               			userNameMidTextField.setEditable(true);
	               			userNameLastTextField.setEditable(true);
	               			phoneTextField.setEditable(true);
	               			emailTextField.setEditable(true);
	               			houseNoTextField.setEditable(true);
	               			streetTextField.setEditable(true);
	               			cityTextField.setEditable(true);
	               			zipTextField.setEditable(true);
	               		}
	               	});
	               	buttonPanel.add(editButton);
	               	
	               	saveButton.addActionListener(new ActionListener() {
	               		public void actionPerformed(ActionEvent event) {
	               			saveButton.setEnabled(false);
	               			editButton.setEnabled(true);
	               			
	               			String user_name_first = userNameFirstTextField.getText().trim();
	               			String user_name_middle = userNameMidTextField.getText().trim();
	               			String user_name_last = userNameLastTextField.getText().trim();
	               			String gender = String.valueOf(genderComBox.getSelectedItem());
	               			SimpleDateFormat mysqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");	// Converting Java date format to MySQL date format.
	               			Date dob = dateOfBirthChooser.getDate();
	               			String date_of_birth = mysqlDateFormat.format(dob);
	               			String phone = phoneTextField.getText().trim();
	               			String email = emailTextField.getText().trim();
	               			String address_house_no = houseNoTextField.getText().trim();
	               			String address_street = streetTextField.getText().trim();
	               			String address_city = cityTextField.getText().trim();
	               			String address_zip = zipTextField.getText().trim();
	               			String country = String.valueOf(countryComBox.getSelectedItem());
	
	               			boolean userInfoCorrect = false;
	               			String errorSpot = new String();
	               			
	               			// Checking general condition
	               			if(((user_name_first.length() > currentUsrSettings.min_user_name_first - 1) && (user_name_last.length() > currentUsrSettings.min_user_name_last - 1) && ((user_name_first.length() + user_name_middle.length() + user_name_last.length()) > currentUsrSettings.min_user_name - 1)) && (phone.length() > currentUsrSettings.min_phone - 1) && (email.length() > currentUsrSettings.min_email - 1) && (address_house_no.length() > currentUsrSettings.min_adrs_house_no - 1) && (address_street.length() > currentUsrSettings.min_adrs_street - 1) && (address_city.length() > currentUsrSettings.min_adrs_city - 1) && (address_zip.length() > currentUsrSettings.min_zip - 1)) {
	               				ErrorChecker userInfoErrChkr = new ErrorChecker();
	               				// Now checking email address
	               				if(userInfoErrChkr.checkEmail(email) == false) {
	               					userInfoCorrect = false;
	               					errorSpot = "email address";
	               					saveButton.setEnabled(true);
	    	               			editButton.setEnabled(false);
	               				}
	               				else {
	               					userInfoCorrect = true;
	               				}
	               				
	               				// Now checking phone number
	               				if(userInfoErrChkr.checkPhoneNo(phone) == false) {
	               					userInfoCorrect = false;
	               					errorSpot = errorSpot + " phone no";
	               					saveButton.setEnabled(true);
	    	               			editButton.setEnabled(false);
	               				}
	               				
	               				if(userInfoCorrect == true) {
	               					try {
	               						st.executeUpdate("UPDATE user_info SET user_name_first = '" + user_name_first + "', user_name_middle = '" + user_name_middle + "', user_name_last = '" + user_name_last + "', gender = '" + gender + "', date_of_birth = '" + date_of_birth + "', phone = '" + phone + "', email = '" + email + "', address_house_no = '" + address_house_no + "', address_street = '" + address_street + "', address_city = '" + address_city + "', address_zip = '" + address_zip + "', country = '" + country + "' WHERE user_id = " + currentUsrSettings.userId + " AND user_password = '" + currentUsrSettings.userPassword + "';");
	               						JOptionPane.showMessageDialog(null, "Data updated successfuly.");
	               					} catch (SQLException exp) {
	               						JOptionPane.showMessageDialog(null, "ERROR: Can't execute SQL statement. Please, check your connection again.", "ERROR", JOptionPane.ERROR_MESSAGE);
	               						exp.printStackTrace();
	               					} finally {
	        	               			userNameFirstTextField.setEditable(false);
	        	               			userNameMidTextField.setEditable(false);
	        	               			userNameLastTextField.setEditable(false);
	        	               			phoneTextField.setEditable(false);
	        	               			emailTextField.setEditable(false);
	        	               			houseNoTextField.setEditable(false);
	        	               			streetTextField.setEditable(false);
	        	               			cityTextField.setEditable(false);
	        	               			zipTextField.setEditable(false);
	        	               			
	        	               			refreshAllTable();
	               					}
	               				}
	               				else {
	               					JOptionPane.showMessageDialog(null, "ERROR: Please, check your " + errorSpot + " correctly.", "Error", JOptionPane.ERROR_MESSAGE);
	               				}
	               			}
	               			else {
	               				JOptionPane.showMessageDialog(null, "ERROR: Please, type your information correctly.", "ERROR", JOptionPane.ERROR_MESSAGE);
	               			}
	               		}
	               	});
	               	buttonPanel.add(saveButton);
	               	
	               	printButton.addActionListener(new ActionListener() {
	               		public void actionPerformed(ActionEvent event) {
	               			PrintUtilities printUtil = new PrintUtilities(userInfoPanel);
	               			printUtil.print();
	               		}
	               	});
	               	buttonPanel.add(printButton);
	               	               	
	               	closeButton.addActionListener(new ActionListener() {
	               		public void actionPerformed(ActionEvent event) {
	               			userInfoFrame.dispose();
	               		}
	               	});
	               	buttonPanel.add(closeButton);
	               	
	               	userInfoFrame.add(titlePanel, BorderLayout.NORTH);
	               	userInfoFrame.add(userInfoPanel, BorderLayout.CENTER);
	               	userInfoFrame.add(buttonPanel, BorderLayout.SOUTH);
				}
				
           	} catch(SQLException exp) {
           		exp.printStackTrace();
           	}
           	
       	} catch(Exception exp) {
       		exp.printStackTrace();
       	}
		
		userInfoFrame.setVisible(true);
	}
	
	public static final void showHelpWindow() {
		JOptionPane.showMessageDialog(null, "WARNING: Help feature is not included in DEMO VERSION. ", "Warning", JOptionPane.WARNING_MESSAGE);
	}
	
	public static final void showAboutWindow() {
		final JFrame aboutFrame = new JFrame("About");
			aboutFrame.setDefaultCloseOperation(aboutFrame.HIDE_ON_CLOSE);
			aboutFrame.setSize(currentUsrSettings.aboutMenuWidth, currentUsrSettings.aboutMenuHeight);
			
			//Setting up icon
			Toolkit kit = Toolkit.getDefaultToolkit();
			Image img = kit.getImage("about.png");
			aboutFrame.setIconImage(img);
			
			// Setting up the position of the ABOUT FRAME at the middle of the screen
			Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
			int x = (screenDimension.width - currentUsrSettings.aboutMenuWidth) / 2;
	       	int y = (screenDimension.height - currentUsrSettings.aboutMenuHeight) / 2;    
	       	aboutFrame.setBounds(x, y, currentUsrSettings.aboutMenuWidth, currentUsrSettings.aboutMenuHeight);
	       	aboutFrame.setResizable(false);
	       	
	       	// Adding Panel and other components
	       	try {
	       		ImagePanel aboutPanel = new ImagePanel("icon.png", 65, 30);
	       		aboutPanel.setLayout(null);
	       		aboutFrame.add(aboutPanel);
	       		
	       		Dimension size;
	       		Insets insets = aboutPanel.getInsets();
	       		Font softTitleFont = new Font("Sans-Serif", Font.BOLD, 18);
	       		
	       		JLabel softTitleLabel1 = new JLabel("Library Management");
	       		softTitleLabel1.setFont(softTitleFont);
	       		size = softTitleLabel1.getPreferredSize();
	       		softTitleLabel1.setBounds(25 + insets.left, 180 + insets.top, size.width, size.height);
	       		
	       		aboutPanel.add(softTitleLabel1);
	       		
	       		JLabel softTitleLabel2 = new JLabel("System (Demo Version)");
	       		softTitleLabel2.setFont(softTitleFont);
	       		size = softTitleLabel2.getPreferredSize();
	       		softTitleLabel2.setBounds(14 + insets.left, 202 + insets.top, size.width, size.height);
	       		
	       		aboutPanel.add(softTitleLabel2);
	       		
	       		JLabel softTitleLabel3 = new JLabel("Free, Simple and Easy");
	       		size = softTitleLabel2.getPreferredSize();
	       		softTitleLabel3.setBounds(54 + insets.left, 228 + insets.top, size.width, size.height);
      		
	       		aboutPanel.add(softTitleLabel3);
	       		
	       		JLabel softTitleLabel4 = new JLabel("Credits");
	       		size = softTitleLabel4.getPreferredSize();
	       		softTitleLabel4.setBounds(105 + insets.left, 280 + insets.top, size.width, size.height);
   		
	       		aboutPanel.add(softTitleLabel4);
	       		
	       		JLabel softTitleLabel5 = new JLabel("Mohammad Zunayed Hassan");
	       		size = softTitleLabel5.getPreferredSize();
	       		softTitleLabel5.setBounds(35 + insets.left, 310 + insets.top, size.width, size.height);
		
	       		aboutPanel.add(softTitleLabel5);
	       		
	       		JLabel softTitleLabel6 = new JLabel("Mehedi Sakhawat");
	       		size = softTitleLabel6.getPreferredSize();
	       		softTitleLabel6.setBounds(68 + insets.left, 328 + insets.top, size.width, size.height);
		
	       		aboutPanel.add(softTitleLabel6);
	       		
	       		JLabel softTitleLabel7 = new JLabel("Yeasmin Habiba");
	       		size = softTitleLabel7.getPreferredSize();
	       		softTitleLabel7.setBounds(75 + insets.left, 346 + insets.top, size.width, size.height);
	
	       		aboutPanel.add(softTitleLabel7);
	       		
	       		JLabel softTitleLabel8 = new JLabel("Tania Tahmina Akhter");
	       		size = softTitleLabel8.getPreferredSize();
	       		softTitleLabel8.setBounds(53 + insets.left, 364 + insets.top, size.width, size.height);

	       		aboutPanel.add(softTitleLabel8);
	       		
	       		JButton closeButton = new JButton("Close");
	       		size = closeButton.getPreferredSize();
	       		closeButton.setBounds(100 + insets.left, 400 + insets.top, size.width, size.height);
	       		
	       		// Keystroke: If user press ENTER closeButton, aboutFrame will close automatically.
	       		closeButton.registerKeyboardAction(closeButton.getActionForKeyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false)), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), JComponent.WHEN_IN_FOCUSED_WINDOW);
	       		closeButton.registerKeyboardAction(closeButton.getActionForKeyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true)), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), JComponent.WHEN_IN_FOCUSED_WINDOW);
       	       	
	       		
	       		aboutPanel.add(closeButton);
	       		
	       		// Adding action listener on closButton
	       		closeButton.addActionListener(new ActionListener() {
	       			public void actionPerformed(ActionEvent event) {
	       				aboutFrame.dispose();
	       			}
	       		});
	       		
	       		
	       	} catch(IOException exp) {
	       		exp.printStackTrace();
	       	}
	        
			aboutFrame.setVisible(true);
	}
	
	public static void main(String[] args) throws IOException {
		// Show splash screen for 1 seconds
		SplashScreen lmsSplashScreen = new SplashScreen(lmsDefaultSettings.splashScreenDuration);
		
		showLoginWindow();
	}
}