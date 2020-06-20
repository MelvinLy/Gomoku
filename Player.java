import java.io.IOException;

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
	
	public char getVal() {
		return this.val;
	}
	
	public boolean isHost() {
		if(val == 'X') {
			return true;
		}
		return false;
	}
	
	public Server getServer() {
		return this.server;
	}
	
	public Client getClient() {
		return this.client;
	}
}