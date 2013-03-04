package mmb.foss.aueb.icong.dialogs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.graphics.Bitmap;
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
	
	public void saveBitmap(Bitmap bitmap, String filename, Bitmap.CompressFormat compressType) {
		if(rootDir.exists() && Environment.getExternalStorageState() != null) {
			File destinationFile = new File(rootDir,filename); 
			try {
				FileOutputStream fos = new FileOutputStream(destinationFile);
				bitmap.compress(compressType, 100, fos);
				fos.flush();
				fos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}