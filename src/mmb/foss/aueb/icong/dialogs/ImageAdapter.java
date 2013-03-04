package mmb.foss.aueb.icong.dialogs;
import android.content.Context;
import android.database.DataSetObserver;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter
{
	Context mContext ;
	Uri[] mUrls;
	FileManager fileMngr;
	public ImageAdapter(Context context)
	{
		mContext = context ;
		fileMngr = new FileManager();
		mUrls = fileMngr.getAllImagesFromDir();
	}

	@Override
	public int getCount()
	{
		return mUrls.length ;
	}

	@Override
	public Object getItem(int position)
	{
		return position;
	}

	@Override
	public long getItemId(int position)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getItemViewType(int position)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ImageView i = new ImageView(mContext);  
		  
       // i.setImageURI(mUrls[position]);  
        i.setScaleType(ImageView.ScaleType.FIT_XY);  
        i.setLayoutParams(new Gallery.LayoutParams(260, 210));  
        return i; 
	}

	@Override
	public int getViewTypeCount()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasStableIds()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void registerDataSetObserver(DataSetObserver observer)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void unregisterDataSetObserver(DataSetObserver observer)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public View getDropDownView(int arg0, View arg1, ViewGroup arg2)
	{
		// TODO Auto-generated method stub
		return null;
	}

}

