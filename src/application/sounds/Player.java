/**
 *
 */
package application.sounds;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import application.socket.DGSender;

/**
 * @author yuki
 *
 */
public class Player {

	/**
	 * @params forma
	 *
	 * @params thread
	 */
	public Format format;
	private PlayThread thread;

	private static Player player = new Player();
	private DGSender sender = DGSender.getInstance();

	/**
	 * main methd
	 * @param args
	 */
	public static void main(String[] args) {


	}

	private Player() {
	}

	public void setLine(PCMReader reader) {
		try {
		if (thread != null && thread.isAlive()) {
			thread.destroy();
			thread.join();
			thread = new PlayThread(reader);

		} else {
			thread = new PlayThread(reader);
		}
		format = reader.format;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void start() {
		if (thread != null)
			thread.start();
	}

	public void end() {
		if (thread != null)
			thread.destroy();
	}

	public void pause() {
		thread.pause();
	}

	public static Player getInstance() {
		return player;
	}
	public Format getFormat() {
		return format;
	}

	public boolean isPlayMine() {
		return thread != null && format.isMine && thread.isPlay();
	}


	private class PlayThread extends Thread {
		/**
		 * @params isPlay 再生の有無
		 * @params isAlive
		 */
		public boolean isPlay;
		public boolean isAlive;
		private SourceDataLine line;
		private PCMReader stream;
		@Override
		public void run() {
			try {
				while (isAlive) {
					while (isPlay) {
						byte[] b = stream.read();
						if (b == null){
							this.destroy();
							break;
						}

						line.write(b, 0, b.length);

						if (format.isMine) {
							sender.write(b, DGSender.getFrameDest());
						}

					}
					Thread.sleep(10);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public PlayThread(PCMReader reader) throws LineUnavailableException {
			isPlay = true;
			isAlive = true;
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, (AudioFormat)reader.getFormat());
			line = (SourceDataLine) AudioSystem.getLine(info);
			stream = reader;

			line.open();
			line.start();
		}

		public boolean isPlay() {
			return isPlay && isAlive();
		}

		/**
		 *
		 */
		public void pause(){
			isPlay = !isPlay;
		}
		public void destroy() {
			line.close();
			isPlay = false;
			isAlive = false;
		}
	}
}
