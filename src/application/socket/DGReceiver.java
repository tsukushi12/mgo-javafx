/**
 *
 */
package application.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * @author yuki
 *
 */
public class DGReceiver {
	static final String bindIp6 = "::";
	static final String bindIp4 = "0.0.0.0";
    static final int metaPort = 10100;
    static final int framePort = 10101;

    public InetAddress senderIp;
    public int senderPort;
    public DatagramSocket sock;

    private DGReceiver(InetAddress ip, int port) throws SocketException {
			sock = new DatagramSocket(port, ip);
    }

    public static DGReceiver getMetaReceiver() throws UnknownHostException, SocketException {
    	InetAddress i = InetAddress.getByName(bindIp4);
    	return new DGReceiver(i, metaPort);
    }

    public static DGReceiver getFrameReceiver() throws UnknownHostException, SocketException {
    	InetAddress i = InetAddress.getByName(bindIp4);
    	return new DGReceiver(i, framePort);
    }

    public DatagramPacket recv(byte[] buf) throws IOException {
    	DatagramPacket packet = new DatagramPacket(buf, 0, buf.length);
    	sock.receive(packet);
    	return packet;
    }

    public void close() {
    	sock.close();
    }
}
