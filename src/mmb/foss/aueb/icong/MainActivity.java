package mmb.foss.aueb.icong;
//fml 
import mmb.foss.aueb.icong.boxes.BlurBox;
import mmb.foss.aueb.icong.boxes.Box;
import mmb.foss.aueb.icong.boxes.BoxArray;
import mmb.foss.aueb.icong.boxes.BoxTypes;
import mmb.foss.aueb.icong.boxes.CameraBox;
import mmb.foss.aueb.icong.boxes.ChanMergeBox;
import mmb.foss.aueb.icong.boxes.ChanSplitBox;
import mmb.foss.aueb.icong.boxes.ClipBox;
import mmb.foss.aueb.icong.boxes.EdgesBox;
import mmb.foss.aueb.icong.boxes.ForkBox;
import mmb.foss.aueb.icong.boxes.HSV2RGBBox;
import mmb.foss.aueb.icong.boxes.InvertBox;
import mmb.foss.aueb.icong.boxes.MixBox;
import mmb.foss.aueb.icong.boxes.RGB2HSVBox;
import mmb.foss.aueb.icong.boxes.ScreenBox;
import mmb.foss.aueb.icong.boxes.SliderBox;
import mmb.foss.aueb.icong.boxes.ValueEntryBox;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	DrawableAreaView canvas;
	BoxTypes[] boxes = BoxTypes.values();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		canvas = (DrawableAreaView) findViewById(R.id.canvas);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void onAddButtonClick(View view) {
		Intent intent = new Intent(this, SelectionActivity.class);
		startActivityForResult(intent, 0);
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		int boxIndex = Integer.parseInt(data.getData().toString());
		canvas.addBox(getBox(boxIndex));
	}

	private Box getBox(int index) {
		Box box = null;
		Context ctx = getBaseContext();
		switch (boxes[index]) {
		case Camera:
			box = new CameraBox(ctx);
			break;
		case Screen:
			box = new ScreenBox(ctx);
			break;
		case ChanMerge:
			box = new ChanMergeBox(ctx);
			break;
		case ChanSplit:
			box = new ChanSplitBox(ctx);
			break;
		case Clip:
			box = new ClipBox(ctx);
			break;
		case Edges:
			box = new EdgesBox(ctx);
			break;
		case Fork:
			box = new ForkBox(ctx);
			break;
		case HSV2RGB:
			box = new HSV2RGBBox(ctx);
			break;
		case Invert:
			box = new InvertBox(ctx);
			break;
		case Mix:
			box = new MixBox(ctx);
			break;
		case RGB2HSV:
			box = new RGB2HSVBox(ctx);
			break;
		case Slider:
			box = new SliderBox(ctx);
			break;
		case ValueEntry:
			box = new ValueEntryBox(ctx);
			break;
		case Blur:
			box = new BlurBox(ctx);
			break;
		default:
			Log.v(">MainActivity", "Something wrong in getBox");
			break;
		}
		return box;
	}

}
