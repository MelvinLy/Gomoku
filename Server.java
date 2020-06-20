import java.net.*;
import java.io.*;

public class Server {
	private ServerSocket serverSocket;
    private Socket connectionSocket;
    private int port;
    
    public Server(int port) throws IOException {
    	this.port = port;
    	serverSocket = new ServerSocket(port);
    }
    
	public String listen() throws IOException {
		this.connectionSocket = serverSocket.accept();
		String clientSentence;
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		clientSentence = inFromClient.readLine();
		return clientSentence;
	}
    
	public void send(String message) throws Exception {
		DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
		outToClient.writeBytes(message + "\n");
	}
	
	public void close() throws IOException {
		this.serverSocket.close();
		this.connectionSocket.close();
	}
	
	public static void main(String[] args) throws Exception {
		Server server = new Server(56789);
		while(true) {
			String r = server.listen();
			server.send(r);
			System.out.println(r);
		}
	}
	
}