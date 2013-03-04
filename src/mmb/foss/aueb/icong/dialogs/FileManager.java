package mmb.foss.aueb.icong.dialogs;

import java.io.File;

import android.net.Uri;
import android.os.Environment;

public class FileManager 
{
	
	private Uri[] Urls;
	static String[] files = null ;
	static String old_dir_initialized = null ;
	private final String appDir = "icong";
	private File rootDir;

	public FileManager() {
		rootDir = new File(Environment.getExternalStorageDirectory(),appDir);
		if(!rootDir.exists() && Environment.getExternalStorageState() != null)
			rootDir.mkdir();	
	}
	
	public String[] getFiles() {
		if(Environment.getExternalStorageState() != null) {
			if(rootDir.exists() && rootDir.canRead())
				files = rootDir.list();
		}
		return files;
	}

	public Uri[] getAllImagesFromDir() {
		// TODO Auto-generated method stub
		Urls = new Uri[files.length];
		for(int i=0;i<files.length;i++) {
			Urls[i] = Uri.parse(rootDir+File.separator+files[i]);
		}
		return Urls;
	}
}