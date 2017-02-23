package application.sounds;

import java.util.HashMap;


public class OtherResouce extends Resouce {


	public HashMap<String, OtherFormat> others = new HashMap<String, OtherFormat>();

	private static OtherResouce otherResouce = new OtherResouce();

	private OtherResouce() {
	}

	public static OtherResouce getInstance() {
		return otherResouce;
	}

	public void add(OtherFormat f) {
		others.put(f.title, f);
	}

	public void varid() {
		others.forEach((title, format) -> {
			if (format.createTime - System.currentTimeMillis() > 500)
				others.remove(title);
		});
	}

	@Override
	public PCMReader getResouce(String name) {
		others.get(name);
		return null;
	}

}
