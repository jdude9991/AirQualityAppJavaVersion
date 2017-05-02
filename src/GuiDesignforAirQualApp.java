import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JPanel tempA;
	private JPanel tempB;
	private JPanel tempLabel;
	private JPanel tempBox;
	private JPanel paneAdd;
		
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
		paneAdd = new JPanel();
		pane = new JScrollPane(paneAdd);
		
		//makes all text boxes uneditable
		date.setEditable(false);
		time.setEditable(false);
		partTypeBox.setEditable(false);
		concBox.setEditable(false);
		
		//puts info into text box
		date.setText(getAndFormatDate());
		time.setText(getTime());
		partTypeBox.setText(getParticle());
		concBox.setText(getConc());
		
		//sets scroll bars on scroll pane
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		//sets up map panel
		pan_Map.setLayout(new FlowLayout());
		pan_Map.add(mapImg);
		
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
		
		paneAdd.setLayout(new GridLayout(2,1));
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
	
	//main
	public static void main(String[] args) {
		new GuiDesignforAirQualApp();
	}

}
