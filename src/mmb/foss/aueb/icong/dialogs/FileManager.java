package mmb.foss.aueb.icong.dialogs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;

public class FileManager {
	private Uri[] Urls;
	static String[] files = null;
	static String old_dir_initialized = null;
	private final String appDir = "icong";
	private File rootDir = null;

	public FileManager() {
		File mnt = new File("/" + File.separator + "mnt");
		rootDir = new File(new File(mnt, "sdcard"), appDir);

		if (rootDir.exists() && rootDir.isDirectory() && rootDir.canWrite()
				&& rootDir.canRead()) {
			rootDir = new File(Environment.getExternalStorageDirectory(),
					appDir);
			rootDir.mkdirs();
		} else {
			for (String dir : mnt.list()) {
				if (dir.contains("sdcard") && !dir.equals("sdcard")) {
					rootDir = new File(new File(mnt, dir), appDir);
					rootDir.mkdirs();
					break;
				}
			}
		}
	}

	public String[] getFiles() {
		ArrayList<String> files = new ArrayList<String>();
		if (rootDir != null) {
			for (String file : rootDir.list())
				if (file.endsWith(".png") || file.endsWith(".PNG")
						|| file.endsWith(".gif") || file.endsWith(".GIF")
						|| file.endsWith(".jpg") || file.endsWith(".JPG")
						|| file.endsWith("jpeg") || file.endsWith(".JPEG"))
					files.add(file);
		}
		this.files = files.toArray(new String[0]);
		return this.files;
	}

	public Uri[] getAllImagesFromDir() {
		// TODO Auto-generated method stub
		Urls = new Uri[files.length];
		for (int i = 0; i < files.length; i++) {
			Urls[i] = Uri.parse(rootDir + File.separator + files[i]);
		}
		return Urls;
	}

	public void saveBitmap(Bitmap bitmap, String filename,
			Bitmap.CompressFormat compressType) {
		if (rootDir.exists()) {
			File destinationFile = new File(rootDir, filename);
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