import java.io.IOException;
import java.net.*;
import java.io.*;

public class Player {
	private Server server;
	private Client client;
	private char val;
	
	public Player(int port) throws IOException {
		this.server = new Server(port);
		this.val = 'X';
	}
	
	public Player(String name, int port) throws Exception {
		this.client = new Client(name, port);
		this.val = 'O';
	}
	
	
}