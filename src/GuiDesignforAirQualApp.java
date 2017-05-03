import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;

/**
 * GuiDesignforAirQualApp
 * @author Jacob Miller
 *
 * This contains the gui design and function of the app that will be built in android studio
 */
@SuppressWarnings("all")
public class GuiDesignforAirQualApp extends JFrame {

	//necessary objects
	static String url="jdbc:mysql://localhost:3044/capstonedatabase";
	static String user="root";
	static String password="Team3044";
	
	Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    
    private JPanel dDownPan;
    private JComboBox dropDown;
	private JPanel pan_Map;
	private JLabel mapData;
	private JPanel infoPan;
	private JLabel dAndT;
	private JTextField date;
	private JTextField time;
	private JLabel partType;
	private JTextField partTypeBox;
	private JLabel concentration;
	private JTextField concBox;
	private JScrollPane pane;
	private JPanel tempA;
	private JPanel tempB;
	private JPanel tempLabel;
	private JPanel tempBox;
	private JPanel paneAdd;
	private JTextField latLong;
	
	private String[] testDrop = {"1", "2", "3", "4"};
	
	//Constructor
	GuiDesignforAirQualApp() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("OzAware Database + Net Internals Test");
		addItems();
		pack();
		setVisible(true);
	}
	
	//sets up and add items to the pane
	private void addItems() {
		//creates items
		pane = new JScrollPane();
		dDownPan = new JPanel();
		dropDown = new JComboBox(testDrop);
		pan_Map = new JPanel();
		mapData = new JLabel("Longitude and Lattitude: ");
		infoPan = new JPanel();
		dAndT = new JLabel("Date and Time of Last Update:");
		tempA = new JPanel();
		date = new JTextField(10);
		time = new JTextField(10);
		tempB = new JPanel();
		partType = new JLabel("Particle Type: ");
		partTypeBox = new JTextField(75);
		concentration = new JLabel("Concentration: ");
		concBox = new JTextField(6);
		infoPan = new JPanel();
		pan_Map = new JPanel();
		tempLabel = new JPanel();
		tempBox = new JPanel();
		tempA = new JPanel();
		tempB = new JPanel();
		latLong = new JTextField(50);
		paneAdd = new JPanel();
		pane = new JScrollPane(paneAdd);
		
		//makes all text boxes uneditable
		date.setEditable(false);
		time.setEditable(false);
		partTypeBox.setEditable(false);
		concBox.setEditable(false);
		latLong.setEditable(false);
		
		//puts test info into text box
		date.setText(getAndFormatDate());
		time.setText(getTime());
		partTypeBox.setText(getParticle());
		concBox.setText(getConc());
		latLong.setText(getLatLong());
		
		//sets scroll bars on scroll pane
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		//set up dD panel
		dDownPan.setLayout(new FlowLayout());
		dDownPan.add(dropDown);
		
		//sets up map panel
		pan_Map.setLayout(new GridLayout(1,2));
		pan_Map.add(mapData);
		pan_Map.add(latLong);
		
		//sets up info panel
		infoPan.setLayout(new GridLayout(2,1));
		
		tempLabel.setLayout(new FlowLayout());
		tempLabel.add(dAndT);
		
		tempBox.setLayout(new GridLayout(2,1));
		tempBox.add(date);
		tempBox.add(time);
		
		tempA.setLayout(new GridLayout(1,2));
		tempA.add(tempLabel);
		tempA.add(tempBox);
		
		tempB.setLayout(new GridLayout(2,2));
		tempB.add(partType);
		tempB.add(partTypeBox);
		tempB.add(concentration);
		tempB.add(concBox);
		
		infoPan.add(tempA);
		infoPan.add(tempB);
		
		paneAdd.setLayout(new GridLayout(3,1));
		paneAdd.add(dDownPan);
		paneAdd.add(infoPan);
		paneAdd.add(pan_Map);
		
		//adds paneAdd to pane
		pane.setLayout(new ScrollPaneLayout());
		
		//adds pane to frame
		add(pane);
	}
	
	//Gets and formats date
	public String getAndFormatDate(){
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		return dateFormat.format(date);		
	}
	
	//Gets Time
	public String getTime(){
		DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		Date time = new Date();
		return timeFormat.format(time);
	}
	
	//Gets the present particles
	public String getParticle(){
		String part = "Carbon Monoxide";
		return part;
	}
		
	//Gets the concentration
	public String getConc(){
		double concent = 2.5;
		String toReturn = concent + " PPM";
		return toReturn;
	}
	
	public String getLatLong(){
		String lat = "14.235601";
		String longit = "-45.235634";
		return longit + " " + lat;
	}
	
	//Gets data from DB
	public void getInfoAndSaveToString(){
		//set database to capstonemapdata
		try {
			st.execute("use capstonedatabase;");
		} catch (SQLException e) {JOptionPane.showMessageDialog(null, "An error has occured in executing the query: \"use capstonemapdata\"");}
		
		//execute query in DB
		try {
			st.executeQuery("SELECT Latitude, Longitude, ParticleInfo, Concentration FROM capstonemapdata.appinfo;");
		} catch (SQLException e) {JOptionPane.showMessageDialog(null, "An error has occured in executing the query: \"SELECT Latitude, Longitude, ParticleInfo, Concentration FROM capstonemapdata.appinfo;\"");}
		
		/* TODO
		 * Saves data to variables
		 * Puts data in text boxes
		 * Rebuild info
		 */
	}
	
	//main
	public static void main(String[] args) {
		 //Connect to database
		  try{
		        String configBase = new File("").getAbsolutePath();
		        BufferedReader configFile = new BufferedReader(new FileReader(new File(configBase + "\\setUp.cfg")));
		        url= configFile.readLine();
		        user=configFile.readLine();
		        password=configFile.readLine();
		        }catch (Exception ex){JOptionPane.showMessageDialog(null, "There was an error connecting to the database");}
		
		  //creates GUI
		new GuiDesignforAirQualApp();
	}

}
