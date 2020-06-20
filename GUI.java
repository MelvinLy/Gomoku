import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
	
	private Board board;
	private Player player;
	private JFrame frame;
	private JPanel panel;
	
	public GUI() {
		this.board = new Board();
		this.frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		createGridLayout();
		frame.setVisible(true);
	}
	
	public void createGridLayout() {
		this.panel = new JPanel();
		this.panel.setLayout(new GridLayout(Board.SIZE, Board.SIZE));
		this.frame.add(panel);
		//Add some buttons in array to be accessed
	}
	
	public static void main(String args[]) {
		GUI g = new GUI();
	}
}