package application.sounds;

/**
 * @author yuki
 *
 */
public abstract class Resouce {

	abstract public PCMReader getResouce(String name) throws Exception;
}
