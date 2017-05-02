import java.awt.FlowLayout;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 * GuiDesignforAirQualApp
 * @author Jacob Miller
 *
 * This contains the gui design and function of the app that will be built in android studio
 */
@SuppressWarnings("all")
public class GuiDesignforAirQualApp extends JFrame {

	//necessary objects
	private JPanel pan_Map;
	private JLabel mapImg;
	private JPanel infoPan;
	private JLabel dAndT;
	private JTextField date;
	private JTextField time;
	private JLabel partType;
	private JTextField partTypeBox;
	private JLabel concentration;
	private JTextField concBox;
	private JScrollPane pane;
		
	//Constructor
	GuiDesignforAirQualApp() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("OzAware");
		addItems();
		pack();
		setVisible(true);
	}
	
	//sets up and add items to the pane
	private void addItems() {
		//creates items
		pane = new JScrollPane();
		pan_Map = new JPanel();
		mapImg = new JLabel("camera-angle-45-shot.png");
		infoPan = new JPanel();
		dAndT = new JLabel("Date and Time of Last Update:");
		JPanel tempA = new JPanel();
		date = new JTextField(10);
		time = new JTextField(10);
		JPanel tempB = new JPanel();
		partType = new JLabel("Particle Type: ");
		partTypeBox = new JTextField(75);
		concentration = new JLabel("Concentration: ");
		concBox = new JTextField(6);
		
		//makes all text boxes uneditable
		date.setEditable(false);
		time.setEditable(false);
		partTypeBox.setEditable(false);
		concBox.setEditable(false);
		
		//puts info into text box
		date.setText(getAndFormatDate());
		time.setText(""+getTime());
		partTypeBox.setText(getParticle());
		concBox.setText(getConc());
		
		//sets scroll bars on scroll pane
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		//sets up map panel
		pan_Map = new JPanel();
		pan_Map.setLayout(new FlowLayout());
		pan_Map.add(mapImg);
		
		//sets up info panel
		
		
	}
	
	//Gets and formats date
	public String getAndFormatDate(){
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		return dateFormat.format(date);		
	}
	
	//Gets Time
	public long getTime(){
		Date time = new Date();
		return time.getTime();
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
	public static void main(String[] args) {
		new GuiDesignforAirQualApp();
	}

}
