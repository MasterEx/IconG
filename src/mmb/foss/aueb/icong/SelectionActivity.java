package mmb.foss.aueb.icong;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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

	private ImageView imagefileBox, cameraBox, screenBox, chanSplitBox, mixBox,
			chanMergeBox, forkBox, valueEntryBox, sliderBox, blurBox, edgesBox,
			invertBox, clipBox, rgb2hsvBox, hsv2rgbBox;
	// fixed size of entries, no need for ArrayList or other dynamic data set
	private ArrayList<ImageView> listImages = new ArrayList<ImageView>();
	private ArrayList<String> imageNames = new ArrayList<String>();
	private ArrayList<String> imageDescriptions = new ArrayList<String>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selection_layout);
		imagefileBox = new ImageView(getBaseContext());
		imagefileBox.setImageResource(R.drawable.image_file);
		listImages.add(imagefileBox);
		imageNames.add("ImageFile");
		imageDescriptions.add("Gets/sets input/output to file");
		try {
			Camera camera = Camera.open();
			camera.release();
			cameraBox = new ImageView(getBaseContext());
			cameraBox.setImageResource(R.drawable.camera);
			listImages.add(cameraBox);
			imageNames.add("Camera");
			imageDescriptions.add("Gets/sets input/output to file");
		} catch (Exception e) {
			// no camera available
		}
		screenBox = new ImageView(getBaseContext());
		screenBox.setImageResource(R.drawable.screen);
		listImages.add(screenBox);
		imageNames.add("Screen");
		imageDescriptions.add("Outputs the result to the screen");
		chanSplitBox = new ImageView(getBaseContext());
		chanSplitBox.setImageResource(R.drawable.chan_split);
		listImages.add(chanSplitBox);
		imageNames.add("Channel Split");
		imageDescriptions.add("Splits the color channel");
		mixBox = new ImageView(getBaseContext());
		mixBox.setImageResource(R.drawable.mix);
		listImages.add(mixBox);
		imageNames.add("Mix");
		imageDescriptions.add("Mixes");
		chanMergeBox = new ImageView(getBaseContext());
		chanMergeBox.setImageResource(R.drawable.chan_merge);
		listImages.add(chanMergeBox);
		imageNames.add("Channel Merge");
		imageDescriptions.add("Merges the color channel");
		forkBox = new ImageView(getBaseContext());
		forkBox.setImageResource(R.drawable.fork);
		listImages.add(forkBox);
		imageNames.add("Fork");
		imageDescriptions.add("Forks");
		valueEntryBox = new ImageView(getBaseContext());
		valueEntryBox.setImageResource(R.drawable.value_entry_preview);
		listImages.add(valueEntryBox);
		imageNames.add("Value Entry");
		imageDescriptions.add("Inputs usr defined values");
		sliderBox = new ImageView(getBaseContext());
		sliderBox.setImageResource(R.drawable.slider_preview);
		listImages.add(sliderBox);
		imageNames.add("Slider");
		imageDescriptions.add("Inputs user defined values");
		blurBox = new ImageView(getBaseContext());
		blurBox.setImageResource(R.drawable.blur);
		listImages.add(blurBox);
		imageNames.add("Blur");
		imageDescriptions.add("Blurs");
		edgesBox = new ImageView(getBaseContext());
		edgesBox.setImageResource(R.drawable.edges);
		listImages.add(edgesBox);
		imageNames.add("Edges");
		imageDescriptions.add("Edges");
		invertBox = new ImageView(getBaseContext());
		invertBox.setImageResource(R.drawable.invert);
		listImages.add(invertBox);
		imageNames.add("Invert");
		imageDescriptions.add("Inverts the image");
		clipBox = new ImageView(getBaseContext());
		clipBox.setImageResource(R.drawable.clip);
		listImages.add(clipBox);
		imageNames.add("Clip");
		imageDescriptions.add("Clips");
		rgb2hsvBox = new ImageView(getBaseContext());
		rgb2hsvBox.setImageResource(R.drawable.rgb2hsv);
		listImages.add(rgb2hsvBox);
		imageNames.add("RGB to HSV");
		imageDescriptions.add("");
		hsv2rgbBox = new ImageView(getBaseContext());
		hsv2rgbBox.setImageResource(R.drawable.hsv2rgb);
		listImages.add(hsv2rgbBox);
		imageNames.add("HSV to RGB");
		imageDescriptions.add("");

		ListView listView = (ListView) findViewById(R.id.selectionlist);
		SelectionAdapter adapter = new SelectionAdapter(this, listImages,
				imageNames, imageDescriptions);
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent selectedBox = new Intent();
				selectedBox.setData(Uri.parse("" + arg2));
				setResult(RESULT_OK, selectedBox);
				finish();
			}

		});
	}

}
