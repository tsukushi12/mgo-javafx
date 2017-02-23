package application.sounds;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * @author yuki
 *
 */
public class MinePCM extends PCMReader {

	/**
	 * @params stream
	 * @params format
	 * @params buf
	 */
	public AudioInputStream stream;
	public AudioFormat audioFormat;
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			File f = MusicFiles.getTestFile();
			MinePCM mpcm = new MinePCM(f);
			Player player = Player.getInstance();
			player.setLine(mpcm);
			player.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MinePCM(File file) throws UnsupportedAudioFileException, IOException {
		stream = AudioSystem.getAudioInputStream(file);
		format = Format.getFormat(stream.getFormat());
		format.setTitle(file.getName());
		format.setIsMine(true);
		frame = format.getFrame();
	}


	@Override
	public byte[] read() throws Exception {
		if (stream.read(frame, 0, frame.length) == -1)
			return null;
		return frame;
	}

	@Override
	public Format getFormat() {
		return format;
	}



}
