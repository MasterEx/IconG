package mmb.foss.aueb.icong.boxes;

import mmb.foss.aueb.icong.R;
import android.content.Context;

public class ImageFileBox extends Box {

	public ImageFileBox(Context context) {
		super(context, R.drawable.image_file);
		buttonX = new int[2][2];
		buttonY = new int[2][2];
		buttonPressed = new boolean[2];
		buttonX[0][0] = 6;
		buttonX[0][1] = 26;
		buttonX[1][0] = 106;
		buttonX[1][1] = 126;
		buttonY[0][0] = 10;
		buttonY[0][1] = 30;
		buttonY[1][0] = 10;
		buttonY[1][1] = 30;
		this.setNoOfInputs(1);
		this.setNoOfOutpus(1);
	}

	@Override
	public void function() {
		// TODO Auto-generated method stub

	}

}
