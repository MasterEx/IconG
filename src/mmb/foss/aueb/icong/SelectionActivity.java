package mmb.foss.aueb.icong;

import mmb.foss.aueb.icong.boxes.BoxTypes;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * This activity will introduce the boxes to the user.
 * 
 * @author periklis
 * 
 */
public class SelectionActivity extends Activity {

	private ImageView cameraBox, screenBox, chanSplitBox, mixBox, chanMergeBox,
			forkBox, valueEntryBox, sliderBox, blurBox, edgesBox, invertBox,
			clipBox, rgb2hsvBox, hsv2rgbBox;
	// fixed size of entries, no need for ArrayList or other dynamic data set
	private ImageView[] listImages = new ImageView[14];
	private String[] imageNames = { "Camera", "Screen", "Channel Split", "Mix",
			"Channel Merge", "Fork", "Value Entry", "Slider", "Blur", "Edges",
			"Invert", "Clip", "RGB to HSV", "HSV to RGB" };
	private String[] imageDescriptions = { "Gets input from the Camera",
			"Outputs the result to the screen", "Splits the color channel",
			"Mixes", "Merges the color channel", "Forks",
			"Inputs usr defined values", "Inputs user defined values", "Blurs",
			"Edges", "Inverts the image", "Clips", "", "" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selection_layout);

		cameraBox = new ImageView(getBaseContext());
		cameraBox.setImageResource(R.drawable.camera);
		listImages[0] = cameraBox;
		screenBox = new ImageView(getBaseContext());
		screenBox.setImageResource(R.drawable.screen);
		listImages[1] = screenBox;
		chanSplitBox = new ImageView(getBaseContext());
		chanSplitBox.setImageResource(R.drawable.chan_split);
		listImages[2] = chanSplitBox;
		mixBox = new ImageView(getBaseContext());
		mixBox.setImageResource(R.drawable.mix);
		listImages[3] = mixBox;
		chanMergeBox = new ImageView(getBaseContext());
		chanMergeBox.setImageResource(R.drawable.chan_merge);
		listImages[4] = chanMergeBox;
		forkBox = new ImageView(getBaseContext());
		forkBox.setImageResource(R.drawable.fork);
		listImages[5] = forkBox;
		valueEntryBox = new ImageView(getBaseContext());
		valueEntryBox.setImageResource(R.drawable.value_entry);
		listImages[6] = valueEntryBox;
		sliderBox = new ImageView(getBaseContext());
		sliderBox.setImageResource(R.drawable.slider);
		listImages[7] = sliderBox;
		blurBox = new ImageView(getBaseContext());
		blurBox.setImageResource(R.drawable.blur);
		listImages[8] = blurBox;
		edgesBox = new ImageView(getBaseContext());
		edgesBox.setImageResource(R.drawable.edges);
		listImages[9] = edgesBox;
		invertBox = new ImageView(getBaseContext());
		invertBox.setImageResource(R.drawable.invert);
		listImages[10] = invertBox;
		clipBox = new ImageView(getBaseContext());
		clipBox.setImageResource(R.drawable.clip);
		listImages[11] = clipBox;
		rgb2hsvBox = new ImageView(getBaseContext());
		rgb2hsvBox.setImageResource(R.drawable.rgb2hsv);
		listImages[12] = rgb2hsvBox;
		hsv2rgbBox = new ImageView(getBaseContext());
		hsv2rgbBox.setImageResource(R.drawable.hsv2rgb);
		listImages[13] = hsv2rgbBox;

		ListView listView = (ListView) findViewById(R.id.selectionlist);
		SelectionAdapter adapter = new SelectionAdapter(this, listImages,
				imageNames, imageDescriptions);
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				System.out.println(BoxTypes.Camera.ordinal());
				System.out.println("TOUCHED " + arg2);
				Intent selectedBox = new Intent();
				selectedBox.setData(Uri.parse("" + arg2));
				setResult(RESULT_OK, selectedBox);
				finish();
			}

		});
	}

}
