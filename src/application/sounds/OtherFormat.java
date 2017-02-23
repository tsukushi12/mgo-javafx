/**
 *
 */
package application.sounds;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Map;

/**
 * @author yuki
 *
 */
public class OtherFormat extends Format {

	public InetAddress senderIp;
	public long createTime;
	public boolean isMine = false;
	/**
	 * @param sampleRate
	 * @param sampleSizeInBits
	 * @param channels
	 * @param signed
	 * @param bigEndian
	 */
	public OtherFormat(float sampleRate, int sampleSizeInBits, int channels, boolean signed, boolean bigEndian) {
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
	public OtherFormat(Encoding encoding, float sampleRate, int sampleSizeInBits, int channels, int frameSize,
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
	public OtherFormat(Encoding encoding, float sampleRate, int sampleSizeInBits, int channels, int frameSize,
			float frameRate, boolean bigEndian, Map<String, Object> properties) {
		super(encoding, sampleRate, sampleSizeInBits, channels, frameSize, frameRate, bigEndian, properties);
		// TODO 自動生成されたコンストラクター・スタブ
	}

    public static OtherFormat getOtherFormat(DatagramPacket p) {
        String values[] = new String(p.getData(), 0, p.getData().length).split(",");
        InetAddress i = p.getAddress();
        OtherFormat of = new OtherFormat(
        		toEncoding(values[0]),
        		toFloat(values[1]),
        		toInt(values[2]),
        		toInt(values[3]),
        		toInt(values[4]),
        		toFloat(values[5]),
        		toBoolean(values[6])
        		);
        of.setTitle(values[7]);
        of.setIp(i);
        of.setTime();
        return of;
    }

    public void setIp(InetAddress i) {
    	senderIp = i;
    }
    public void setTime() {
    	createTime = System.currentTimeMillis();
    }
    public long getTime() {
    	return createTime;
    }

}
