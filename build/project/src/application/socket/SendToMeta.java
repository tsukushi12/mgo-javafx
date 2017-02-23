package application.socket;

import java.io.File;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import application.sounds.Format;
import application.sounds.MinePCM;
import application.sounds.MusicFiles;
import application.sounds.Player;

/**
 * @author yuki
 *
 */
public class SendToMeta extends Thread{

	public Player player = Player.getInstance();
	public DGSender sender = DGSender.getInstance();
	public InetSocketAddress dest;
	public boolean isEnd = true;

	public static void main(String args[]) {
	try {
		File f = MusicFiles.getTestFile();
		MinePCM mpcm = new MinePCM(f);
		Player player = Player.getInstance();
		player.setLine(mpcm);
	//	player.start();

		SendToMeta sender = new SendToMeta();
		sender.start();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

	public SendToMeta() {
		try {
			dest = DGSender.getMetaDest();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void end() {
		isEnd = false;
	}

	@Override
	public void run() {
		try {
			while (isEnd) {
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
