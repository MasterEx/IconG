package mmb.foss.aueb.icong;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectionAdapter extends BaseAdapter {

	private ImageView[] imageList;
	private String[] textList, descList;
	private static LayoutInflater inflater = null;
	private Activity activity;

	public SelectionAdapter(Activity activity, ImageView[] imageList,
			String[] textList, String[] descList) {
		// TODO Auto-generated constructor stub
		this.imageList = imageList;
		this.textList = textList;
		this.activity = activity;
		this.descList = descList;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imageList.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view = convertView;
		if (convertView == null)
			view = inflater.inflate(R.layout.selection_list_row, null);
		ImageView box = (ImageView) view.findViewById(R.id.box_image);
		TextView boxName = (TextView) view.findViewById(R.id.box_name);
		TextView boxDescription = (TextView) view
				.findViewById(R.id.box_description);
		box.setImageDrawable(imageList[position].getDrawable());
		boxName.setText(textList[position]);
		boxDescription.setText(descList[position]);

		return view;
	}

}
