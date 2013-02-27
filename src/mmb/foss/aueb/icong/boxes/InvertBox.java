package mmb.foss.aueb.icong.boxes;

import mmb.foss.aueb.icong.R;
import android.content.Context;

public class InvertBox extends Box {

	public InvertBox(Context context) {
		// TODO Auto-generated constructor stub
		super(context, R.drawable.invert);
		buttonX = new int[2][2];
		buttonY = new int[2][2];
		buttonPressed = new boolean[2];
		buttonX[0][0] = 6;
		buttonX[0][1] = 26;
		buttonX[1][0] = 97;
		buttonX[1][1] = 117;
		buttonY[0][0] = 23;
		buttonY[0][1] = 43;
		buttonY[1][0] = 23;
		buttonY[1][1] = 43;
	}

}
