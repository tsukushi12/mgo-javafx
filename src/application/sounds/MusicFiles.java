/**
 *
 */
package application.sounds;

import java.io.File;

import application.MusicGO;

/**
 * @author yuki
 *
 */
public class MusicFiles {

	/**
	 * @params rootpath 音楽ファイルの場所
	 * @params MusicFiles singleton class of this class
	 * @params dir MusicFileDirectry
	 */
	final static String rootpath = MusicGO.class.getResource("music/").toString();
	private static MusicFiles musicFiles = new MusicFiles();
	public File dir;

	/**
	 * main method (test)
	 * @param args
	 * output All file name
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}
	private MusicFiles() {
		dir = new File(rootpath);
	}

	public static MusicFiles getInstance() {
		return musicFiles;
	}
	public File[] getFileNmaes() {
		return dir.listFiles();
	}

	public String[] getFileNames(){
		return dir.list();
	}

	public File getTestFile(){
		return dir.listFiles()[0];
	}
}
