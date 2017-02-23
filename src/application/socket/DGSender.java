package application.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class DGSender {
    static final String broadCastIp6 = "ff02::1";
    static final String broadCastIp4 = "192.168.0.255";
    static final int metaPort = 10100;
    static final int framePort = 10101;


    private static DGSender dgSender = new DGSender();
    private DatagramSocket sock;

    private DGSender() {
    	try {
    		sock = new DatagramSocket();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    public static DGSender getInstance() {
    	return dgSender;
    }

    public static InetSocketAddress getMetaDest() throws UnknownHostException {
    	InetAddress ip = InetAddress.getByName(broadCastIp4);
    	return new InetSocketAddress(ip, metaPort);
    }

    public static InetSocketAddress getFrameDest() throws UnknownHostException {
    	InetAddress ip = InetAddress.getByName(broadCastIp4);
    	return new InetSocketAddress(ip, framePort);
    }


    public void write(byte[] frame, InetSocketAddress dest) throws IOException {
    	DatagramPacket p = new DatagramPacket(frame, 0, frame.length, dest);
    	sock.send(p);
    }
}

