import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
		enableFrame();
		
		//After connections
		
		/*
		JPanel tmp = createGridLayout();
		replacePanel(tmp);
		*/
	}
	
	public static void sleep(int x) throws InterruptedException {
		TimeUnit.SECONDS.sleep(x);
	}
	
	public void setUpGUI() {
		JLabel ipDesc = new JLabel("Host's IP (Blank if you are host)");
		ipDesc.setAlignmentX(Component.CENTER_ALIGNMENT);
		JTextField ipField = new JTextField();
		ipField.setMaximumSize(new Dimension(500, 30));
		ipField.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel portDesc = new JLabel("Port");
		portDesc.setAlignmentX(Component.CENTER_ALIGNMENT);
		JTextField portField = new JTextField();
		portField.setMaximumSize(new Dimension(500, 30));
		portField.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton connect = new JButton("Connect");
		connect.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				//Code to connect
			}
			
			public void mousePressed(MouseEvent e) {}

			public void mouseReleased(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {}
			
			public void mouseExited(MouseEvent e) {}
		});
		connect.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		
		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
		this.panel.add(ipDesc);
		this.panel.add(ipField);
		this.panel.add(portDesc);
		this.panel.add(portField);
		this.panel.add(connect);
		this.frame.add(panel);
	}
	
	public void replacePanel(JPanel newPanel) {
		frame.remove(panel);
		this.panel = newPanel;
		frame.add(panel);
		frame.invalidate();
		frame.validate();
		frame.repaint();
	}
	
	public void enableFrame() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 750);
		frame.setVisible(true);
	}
	
	public void createFrame() {
		this.board = new Board();
		this.frame = new JFrame("Gomoku");
	}
	
	public JPanel createGridLayout() {
		JPanel tmp = new JPanel();
		tmp.setLayout(new GridLayout(Board.SIZE, Board.SIZE));
		this.buttons = new JButton[Board.SIZE * Board.SIZE];
		createButtons(tmp);
		return tmp;
	}
	
	public void createButtons(JPanel tmp) {
		for(int a = 0; a < Board.SIZE * Board.SIZE; a++) {
			this.buttons[a] = new JButton();
			tmp.add(this.buttons[a]);
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