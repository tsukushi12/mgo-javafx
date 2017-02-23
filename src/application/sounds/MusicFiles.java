/**
 *
 */
package application.sounds;

import java.io.File;

/**
 * @author yuki
 *
 */
public class MusicFiles extends Resouce{

	/**
	 * @params rootpath 音楽ファイルの場所
	 * @params MusicFiles singleton class of this class
	 * @params dir MusicFileDirectry
	 */
	public final static String rootpath = "bin/application/music/";
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

	@Override
	public PCMReader getResouce(String name) throws Exception {
		MinePCM mpcm = new MinePCM(new File(rootpath + name));
		return mpcm;
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
	public File[] getFiles() {
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
	public static File getTestFile(){
		return new MusicFiles().getFiles()[1];
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
