import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class GUI {

	private Board board;
	private Player player;
	private JFrame frame;
	private JPanel panel;
	private JButton[] buttons;
	private boolean isServer;
	private boolean isTurn;
	private String incoming;
	private boolean success;
	private boolean gameOver = false;

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
		JTextField ipField = new JTextField("");
		ipField.setMaximumSize(new Dimension(500, 30));
		ipField.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel portDesc = new JLabel("Port");
		portDesc.setAlignmentX(Component.CENTER_ALIGNMENT);
		JTextField portField = new JTextField("");
		portField.setMaximumSize(new Dimension(500, 30));
		portField.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel spacing = new JLabel(" ");
		spacing.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton connect = new JButton("Connect/Host");
		connect.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				if(!portField.getText().equals("")) {
					if(ipField.getText().equals("")) {
						isServer = true;
					}
					success = false;
					//Host player
					if(isServer) {
						try {
							player = new Player(Integer.parseInt(portField.getText()));
							isTurn = false;
							success = true;
						}
						catch(Exception error) {
							System.out.println(error);
						}
						if(success) {
							panel.remove(connect);
							new Thread() {
								public void run() {
									while(true) {
										try {
											incoming = player.getServer().listen();
											if(incoming.equals("p2Connected")) {
												JPanel tmp = createGridLayout();
												replacePanel(tmp);
												break;
											}
											System.out.println(incoming);
										}
										catch (IOException e) {
											System.out.println(e);
										}
									}
								}
							}.start();
						}
					}
					//Connecting player
					else {
						try {
							player = new Player(ipField.getText(), Integer.parseInt(portField.getText()));
							isTurn = true;
							success = true;
						}
						catch(Exception error) {
							System.out.println(error);
						}
						if(success) {
							try {
								player.getClient().send("p2Connected");
								JPanel tmp = createGridLayout();
								replacePanel(tmp);
							}
							catch (Exception error) {
								System.out.println(error);
							}
						}
					}
				}
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
		this.panel.add(spacing);
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
			this.buttons[a] = new JButton("");
			this.buttons[a].setName(Integer.toString(a));
			this.buttons[a].addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) {
					JButton currentButton = (JButton) e.getSource();
					if(!gameOver) {
						if(!isServer) {
							if(isTurn) {
								if(currentButton.getText().equals("")) {
									currentButton.setText(Character.toString(player.getVal()));
									int index = Integer.parseInt(currentButton.getName());
									board.canGoDown(index / Board.SIZE, index % Board.SIZE);
									if(board.checkWin(player.getVal())) {
										JFrame winMessage = new JFrame();
										winMessage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
										winMessage.setSize(500, 500);
										JPanel p = new JPanel();
										JLabel l = new JLabel("You won!");
										p.add(l);
										winMessage.add(p);
										winMessage.setVisible(true);
										gameOver = true;
									}
									try {
										player.getClient().send(currentButton.getName());
									}
									catch (Exception error) {
										System.out.println(error);
									}
									try {
										incoming = player.getClient().receive();
									}
									catch (Exception error) {
										System.out.println(error);
									}
									isTurn = false;
								}
							}
						}
						else {

						}
					}
				}

				public void mousePressed(MouseEvent e) {}

				public void mouseReleased(MouseEvent e) {}

				public void mouseEntered(MouseEvent e) {}

				public void mouseExited(MouseEvent e) {}
			});
			tmp.add(this.buttons[a]);
		}
	}

	public JButton getButton(int row, int col) {
		if(row < Board.SIZE && row >= 0 && col < Board.SIZE && col >= 0) {
			return buttons[row * Board.SIZE + col];
		}
		return null;
	}

}