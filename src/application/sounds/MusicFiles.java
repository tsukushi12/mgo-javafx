/**
 *
 */
package application.sounds;

import java.io.File;

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
	final static String rootpath = "bin/application/music";
	private static MusicFiles musicFiles = new MusicFiles();
	public File dir;

	/**
	 * main method (test)
	 * @param args
	 * output All file name
	 */
	public static void main(String[] args) {
		MusicFiles mf = MusicFiles.getInstance();
		mf.output();
	}

	/**
	 * singleton instance
	 */
	private MusicFiles() {
		dir = new File(rootpath);
	}

	/**
	 * @return ThisInstance
	 */

	public static MusicFiles getInstance() {
		return musicFiles;
	}

	/**
	 * instanceの再定義　ディレクトリの再読み込み
	 * @params ThisInstance
	 */
	public static MusicFiles reGetInstance() {
		musicFiles = new MusicFiles();
		return musicFiles;
	}

	/**
	 * @return ファイル一覧の取得（ファイル型）
	 */
	public File[] getFileNmaes() {
		return dir.listFiles();
	}

	/**
	 * @return ファイル一覧　文字列
	 */
	public String[] getFileNames(){
		return dir.list();
	}

	/**
	 * @return テスト用音楽ファイルの取得
	 */
	public File getTestFile(){
		return dir.listFiles()[0];
	}

	/**
	 * test output
	 */
    public void output(){
        String files[] = dir.list();
        for (String file: files){
            System.out.println(file);
        }
    }
}
