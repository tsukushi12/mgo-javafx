package application.sounds;

import javax.sound.sampled.AudioFormat;

abstract class PCMReader {

	abstract public byte[] read();

	abstract public AudioFormat getAudioFormat();
}
