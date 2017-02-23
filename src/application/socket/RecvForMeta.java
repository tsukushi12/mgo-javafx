package application.socket;

import java.net.DatagramPacket;

import application.sounds.OtherFormat;
import application.sounds.OtherResouce;

public class RecvForMeta extends Thread {

	private DGReceiver receiver;
	public OtherResouce others;
	public byte[] buf = new byte[1200];
	public boolean isEnd = true;


	public static void main(String args[]) {
		RecvForMeta receiver = new RecvForMeta();
		receiver.start();
	}

	public RecvForMeta() {
		try {
			receiver = DGReceiver.getMetaReceiver();
			others = OtherResouce.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public OtherResouce getOthers() {
		return others;
	}

	public void end() {
		isEnd = false;
	}
	@Override
	public void run() {
		try {
			while (isEnd) {
				DatagramPacket p = receiver.recv(buf);
				if (java.net.InetAddress.getLocalHost() != p.getAddress()){
					others.add(OtherFormat.getOtherFormat(p));
					others.varid();
				}
			}
			receiver.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
