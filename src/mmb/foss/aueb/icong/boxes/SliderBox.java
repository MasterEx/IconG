package mmb.foss.aueb.icong.boxes;

import mmb.foss.aueb.icong.R;
import android.content.Context;

public class SliderBox extends Box {

	public SliderBox(Context context) {
		// TODO Auto-generated constructor stub
		super(context, R.drawable.slider);
		buttonX = new int[1][2];
		buttonY = new int[1][2];
		buttonPressed = new boolean[1];
		buttonX[0][0] = 107;
		buttonX[0][1] = 127;
		buttonY[0][0] = 10;
		buttonY[0][1] = 30;
	}

}
