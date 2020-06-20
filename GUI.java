import java.awt.Dimension;

import javax.swing.JFrame;

public class GUI {
	
	private Board board;
	private Player player;
	private JFrame frame;
	
	public GUI() {
		this.board = new Board();
		this.frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setVisible(true); 
	}
	
	public static void main(String args[]) {
		GUI g = new GUI();
	}
}