import java.awt.GridLayout;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
	
	private Board board;
	private Player player;
	private JFrame frame;
	private JPanel panel;
	private JButton[] buttons;
	
	public GUI() throws InterruptedException {
		createGameGUI();
		createGridLayout();
		createButtons();
		enableGameGUI();
		
	}
	
	public void setUpGUI() {
		
	}
	
	public void enableGameGUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 750);
		frame.setVisible(true);
	}
	
	public void createGameGUI() {
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