package application.socket;

import java.util.ArrayList;

import application.sounds.Format;

public class RecvForMeta extends Thread {

	private DGReceiver receiver;
	public ArrayList<Format> others;
	public RecvForMeta() {
		try {
			receiver = DGReceiver.getMetaReceiver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

	}

}
