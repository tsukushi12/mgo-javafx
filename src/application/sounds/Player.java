/**
 *
 */
package application.sounds;

import javax.sound.sampled.AudioFormat;

/**
 * @author yuki
 *
 */
public class Player {

	/**
	 * @params line
	 * @params forma
	 *
	 * @params thread
	 */
	private PCMReader line;
	private AudioFormat format;
	private PlayThread thread;

	private static Player player = new Player();

	/**
	 * main methd
	 * @param args
	 */
	public static void main(String[] args) {


	}

	private Player() {
	}

	public void setLine(PCMReader l, AudioFormat f) throws InterruptedException {
		if (thread.isAlive()) {
			thread.destroy();
			thread.join();
			line = l;
			format = f;
			thread = new PlayThread();

		} else {
			thread = new PlayThread();
		}
	}

	public void pause() {
		thread.pause();
	}

	public static Player getInstance() {
		return player;
	}


	private class PlayThread extends Thread {
		/**
		 * @params isPlay 再生の有無
		 * @params isAlive
		 */
		public boolean isPlay;
		public boolean isAlive;

		@Override
		public void run() {
			while (isAlive) {
				while (isAlive) {


				}
			}
		}
		public PlayThread() {
			isPlay = true;
			isAlive = true;
		}

		/**
		 *
		 */
		public void pause(){
			isPlay = !isPlay;
		}
		public void destroy() {
			isAlive = false;
		}
	}
}
