import java.io.IOException;
import java.net.*;


public class Player {
	private DatagramSocket udp;
	private InetAddress address;
	private int port;
	private byte[] buf;
	
	public Player(int port, byte[] outAddress) throws SocketException, UnknownHostException {
		udp = new DatagramSocket();
		this.port = port;
		address = InetAddress.getByAddress(outAddress);
	}
	
	public void send(String message) throws IOException {
		byte[] out = message.getBytes();
		DatagramPacket packet = new DatagramPacket(out, out.length, address, port);
		udp.send(packet);
	}
	
	public String receive() throws IOException {
		byte[] receive = new byte[576];
		DatagramPacket in = new DatagramPacket(receive, receive.length);
		udp.receive(in);
		byte[] received = in.getData();
		String out = new String(received, 0, received.length);
		return out;
	}
}