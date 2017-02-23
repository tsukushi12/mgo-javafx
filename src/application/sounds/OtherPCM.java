/**
 *
 */
package application.sounds;

import java.net.DatagramPacket;

import application.socket.DGReceiver;

/**
 * @author yuki
 *
 */
public class OtherPCM extends PCMReader {

	public Format format;
	public static DGReceiver receiver;
	public byte[] buf;

	public OtherPCM(Format f) {
		format = f;
		buf = format.getFrame();
		try {
			if (receiver != null)
				receiver.close();
			receiver = DGReceiver.getFrameReceiver();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public byte[] read() throws Exception {
		DatagramPacket p = receiver.recv(buf);
		if (p.getData().length < 100)
			return null;
		return p.getData();
	}


	@Override
	public Format getFormat() {
		return format;
	}

}
