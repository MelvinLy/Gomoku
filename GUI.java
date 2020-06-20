import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class GUI {
	
	private Board board;
	private Player player;
	private JFrame frame;
	private JPanel panel;
	private JButton[] buttons;
	
	public GUI() throws InterruptedException {
		createFrame();
		setUpGUI();
		//setUpGUI();
		//createGridLayout();
		//createButtons();
		enableFrame();
	}
	
	public static void sleep(int x) throws InterruptedException {
		TimeUnit.SECONDS.sleep(x);
	}
	
	public void setUpGUI() {
		JLabel ipDesc = new JLabel("Host's IP (Blank if you are host)");
		ipDesc.setAlignmentX(Component.CENTER_ALIGNMENT);
		JTextField ipField = new JTextField();
		ipField.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel portDesc = new JLabel("Port");
		ipField.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
		this.panel.add(ipDesc);
		this.panel.add(ipField);
		this.panel.add(portDesc);
		this.frame.add(panel);
	}
	
	public void replacePanel(JPanel newPanel) {
		frame.remove(panel);
		this.panel = newPanel;
		frame.add(panel);
		frame.repaint();
	}
	
	public void enableFrame() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 750);
		frame.setVisible(true);
	}
	
	public void createFrame() {
		this.board = new Board();
		this.frame = new JFrame();
	}
	
	public void createGridLayout() {
		this.panel = new JPanel();
		this.panel.setLayout(new GridLayout(Board.SIZE, Board.SIZE));
		this.buttons = new JButton[Board.SIZE * Board.SIZE];
		this.frame.add(panel);
		//Add some buttons in array to be accessed
	}
	
	public void createButtons() {
		for(int a = 0; a < Board.SIZE * Board.SIZE; a++) {
			this.buttons[a] = new JButton();
			this.panel.add(this.buttons[a]);
		}
	}
	
	public JButton getButton(int row, int col) {
		if(row < Board.SIZE && row >= 0 && col < Board.SIZE && col >= 0) {
			return buttons[row * Board.SIZE + col];
		}
		return null;
	}
	
	public static void main(String args[]) throws InterruptedException {
		GUI g = new GUI();
	}
}