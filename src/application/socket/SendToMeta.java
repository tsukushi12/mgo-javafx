package application.socket;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import application.sounds.Format;
import application.sounds.Player;

/**
 * @author yuki
 *
 */
public class SendToMeta extends Thread{

	public Player player = Player.getInstance();
	public DGSender sender = DGSender.getInstance();
	public InetSocketAddress dest;

	public SendToMeta() {
		try {
			dest = DGSender.getMetaDest();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				if (player.isPlayMine()) {
					Format f = player.getFormat();
					sender.write(f.toByte(), dest);
				}
				Thread.sleep(300);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
