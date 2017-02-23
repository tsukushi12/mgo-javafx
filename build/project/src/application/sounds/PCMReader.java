package application.sounds;

public abstract class PCMReader {

	public byte[] frame;
	public Format format;

	abstract public byte[] read() throws Exception;

	abstract public Format getFormat();
}
