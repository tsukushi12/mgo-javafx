/**
 *
 */
package application.sounds;

import java.util.Map;

import javax.sound.sampled.AudioFormat;

/**
 * @author yuki
 *
 */
public class Format extends AudioFormat {

	/**
	 * @params sec １フレームの秒数
	 */
	public static final int milliSec = 40;
	public String title;
	public boolean isMine = false;

	/**
	 * @param sampleRate
	 * @param sampleSizeInBits
	 * @param channels
	 * @param signed
	 * @param bigEndian
	 */
	public Format(float sampleRate, int sampleSizeInBits, int channels, boolean signed, boolean bigEndian) {
		super(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/**
	 * @param encoding
	 * @param sampleRate
	 * @param sampleSizeInBits
	 * @param channels
	 * @param frameSize
	 * @param frameRate
	 * @param bigEndian
	 */
	public Format(Encoding encoding, float sampleRate, int sampleSizeInBits, int channels, int frameSize,
			float frameRate, boolean bigEndian) {
		super(encoding, sampleRate, sampleSizeInBits, channels, frameSize, frameRate, bigEndian);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/**
	 * @param encoding
	 * @param sampleRate
	 * @param sampleSizeInBits
	 * @param channels
	 * @param frameSize
	 * @param frameRate
	 * @param bigEndian
	 * @param properties
	 */
	public Format(Encoding encoding, float sampleRate, int sampleSizeInBits, int channels, int frameSize,
			float frameRate, boolean bigEndian, Map<String, Object> properties) {
		super(encoding, sampleRate, sampleSizeInBits, channels, frameSize, frameRate, bigEndian, properties);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public static Format getFormat(AudioFormat af) {
			return new Format(
				af.getEncoding(),
				af.getSampleRate(),
				af.getSampleSizeInBits(),
				af.getChannels(),
				af.getFrameSize(),
				af.getFrameRate(),
				af.isBigEndian()
				);
	}


    public void setTitle(String t){
    	title = t;
    }

    public void setIsMine(boolean b) {
    	isMine = b;
    }

    public boolean isMine() {
    	return isMine();
    }

    @Override
    public String toString(){
        return encoding.toString() + "," +
                 String.valueOf(sampleRate) + "," +
                 String.valueOf(sampleSizeInBits) + "," +
                 String.valueOf(channels) + "," +
                 String.valueOf(frameSize) + "," +
                 String.valueOf(frameRate) + "," +
                 String.valueOf(bigEndian) + "," +
                 title;
    }

	public int getPacketFrameSize() {
		return ((int)sampleRate * sampleSizeInBits * channels * Format.milliSec / 1000);
	}

	public byte[] getFrame() {
		return new byte[this.getPacketFrameSize()];
	}

	public byte[] toByte() {
		return this.toString().getBytes();
	}

    static AudioFormat.Encoding toEncoding(String encoding) {
        return AudioFormat.Encoding.PCM_SIGNED;
    }
    static float toFloat(String sr){
        return Float.parseFloat(sr);
    }
    static int toInt(String br){
        return Integer.parseInt(br);
    }

    static boolean toBoolean(String be){
        return Boolean.valueOf(be);
    }
}
