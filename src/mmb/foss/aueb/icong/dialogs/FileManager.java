package mmb.foss.aueb.icong.dialogs;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

public class FileManager 
{
	
	private static String Saving_Directory ;
	private static Uri[] Urls;
	static String[] Files = null ;
	static String old_dir_initialized = null ;
	private static void initialize(String dir)
	{
		if(old_dir_initialized!=null){
			if(!dir.equals(old_dir_initialized))
			{
				old_dir_initialized = dir ;
				File images = new File (Environment.getExternalStorageDirectory().getAbsolutePath() + dir);
			    String[] imagelist = images.list();
			    Files = new String[imagelist.length];  
			    Log.e("length",""+imagelist.length);
			    for(int i= 0 ; i< imagelist.length; i++)  
			    {  
			    	Log.e("first for ",""+i+" imagelist []= "+imagelist[i]);
			    	Files[i] = imagelist[i].toString();  
			    }  
			    Urls = new Uri[Files.length];  
			  
			    for(int i=0; i < Files.length; i++)  
			    {  
			    	Urls[i] = Uri.parse(Files[i]);     
			    }
			}
		}
		else
		{

			old_dir_initialized = dir ;
			Log.e("state",""+Environment.getExternalStorageState());
			File images = new File (Environment.getRootDirectory().getAbsolutePath()+"/media");
		    String[] imagelist = images.list();
		    Files = new String[imagelist.length];  
		    Log.e("length",""+imagelist.length);
		    
			if(images.isDirectory())
			{
				Log.e("it is a dir ffs","");
			}
			if(images.listFiles()==null)
			{
				Log.e("fu","android");
			}
			
			
			
		    //File[] imagelist = images.listFiles();
		    		/*(new FilenameFilter()
		    {  
		        @Override  
		        public boolean accept(File dir, String name)  
		        {  
		            return ((name.endsWith(".jpg"))||(name.endsWith(".png"))
		           		 ||(name.endsWith(".jpeg")));
		        }  
		    });*/
		    
		    Files = new String[imagelist.length];  
		    
		    for(int i= 0 ; i< imagelist.length; i++)  
		    {  
		    	Log.e("first for ",""+i+" imagelist []= "+imagelist[i]);

		    	Files[i] = imagelist[i];  
		    }  
		    Urls = new Uri[Files.length];  
		  
		    for(int i=0; i < Files.length; i++)  
		    {  
		    	Urls[i] = Uri.parse(Files[i]);     
		    }
		    
			/*
			ArrayList<String> item = new ArrayList<String>();

		    ArrayList<String> path = new ArrayList<String>();

		     

		     File f = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
		     if(f.isDirectory())
		     {
		    	 Log.e("directory","true");
		     }
		     
		     File[] files = f.listFiles();

		     

		     for(int i=0; i < files.length; i++)

		     {

		       File file = files[i];
		       Log.e("filePath",""+file.getPath().toString());

		       path.add(file.getPath());

		       if(file.isDirectory())

		       item.add(file.getName() + "/");

		       else

		       item.add(file.getName());
		     }*/
		}
	}
	private static List<File> getListFiles(File parentDir)
	{
		
	    ArrayList<File> inFiles = new ArrayList<File>();
	    File[] files = parentDir.listFiles();
	    for (File file : files) {
	        if (file.isDirectory()) {
	            inFiles.addAll(getListFiles(file));
	        } else {
	            if(file.getName().endsWith(".csv")){
	                inFiles.add(file);
	            }
	        }
	    }
	    return inFiles;
	
	}
	public static Uri[] getAllImagesFromDir(String dir)
	{
		initialize(dir);
		return Urls ;
	}
	public static String[] getAllImagesFileNamesFromDir(String dir)
	{
		initialize(dir);
		return Files;
	}
	public static void setSavingDir(String dir)
	{
		Saving_Directory = dir ;
	}
	
	
}
/*
public class Images extends Activity  
{  
    private Uri[] mUrls;  
    String[] mFiles=null;  
  
    public void onCreate(Bundle icicle)  
    {  
  
        super.onCreate(icicle);  
        setContentView(R.layout.images);  
  
        File images = Environment.getDataDirectory();  
        File[] imagelist = images.listFiles(new FilenameFilter(){  
        @override  
        public boolean accept(File dir, String name)  
        {  
            return ((name.endsWith(".jpg"))||(name.endsWith(".png"))  
        }  
    });  
        mFiles = new String[imagelist.length];  
  
        for(int i= 0 ; i< imagelist.length; i++)  
        {  
            mFiles[i] = imagelist[i].getAbsolutePath();  
        }  
        mUrls = new Uri[mFiles.length];  
  
        for(int i=0; i < mFiles.length; i++)  
        {  
            mUrls[i] = Uri.parse(mFiles[i]);     
        }     
  
        Gallery g = (Gallery) findViewById(R.id.gallery);  
        g.setAdapter(new ImageAdapter(this));  
        g.setFadingEdgeLength(40);  
    }  
    public class ImageAdapter extends BaseAdapter{  
          
        int mGalleryItemBackground;  
        public ImageAdapter(Context c)  {     
            mContext = c;     
        }  
        public int getCount(){  
            return mUrls.length;  
        }  
        public Object getItem(int position){  
            return position;  
        }  
        public long getItemId(int position) {  
            return position;  
        }  
        public View getView(int position, View convertView, ViewGroup parent){  
            ImageView i = new ImageView(mContext);  
  
            i.setImageURI(mUrls[position]);  
            i.setScaleType(ImageView.ScaleType.FIT_XY);  
            i.setLayoutParams(new Gallery.LayoutParams(260, 210));  
            return i;  
        }     
        private Context mContext;  
        }     
    }  
*/