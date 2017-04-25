import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("all")
public class GuiDesignforAirQualApp extends JFrame {

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
	
	GuiDesignforAirQualApp() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Oz-A-Wear");
		addItems();
		pack();
		setVisible(true);
	}
	
	private void addItems() {
		pane = new JScrollPane();
		pan_Map = new JPanel();
		mapImg = new JLabel("camera-angle-45-shot.png");
		infoPan = new JPanel();
		dAndT = new JLabel("Date and Time of Last Update:");
		JPanel temp = new JPanel();
		date = new JTextField(10);
		time = new JTextField(10);
		
		
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		pan_Map = new JPanel();
		pan_Map.setLayout(new FlowLayout());
		
		
	}
		
	
	public static void main(String[] args) {
		
	}

}
