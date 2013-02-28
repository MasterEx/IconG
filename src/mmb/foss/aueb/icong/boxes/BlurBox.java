package mmb.foss.aueb.icong.boxes;

import mmb.foss.aueb.icong.R;
import android.content.Context;
import android.util.Log;

public class BlurBox extends Box {

	public BlurBox(Context context) {
		// TODO Auto-generated constructor stub
		super(context, R.drawable.blur);
		buttonX = new int[3][2];
		buttonY = new int[3][2];
		buttonPressed = new boolean[3];
		buttonX[0][0] = 5;
		buttonX[0][1] = 27;
		buttonX[1][0] = 5;
		buttonX[1][1] = 27;
		buttonX[2][0] = 95;
		buttonX[2][1] = 117;
		buttonY[0][0] = 5;
		buttonY[0][1] = 27;
		buttonY[1][0] = 39;
		buttonY[1][1] = 61;
		buttonY[2][0] = 23;
		buttonY[2][1] = 43;
		this.setNoOfInputs(2);
		this.setNoOfOutpus(1);

	}

	@Override
	public void function() {
		Log.e("input 1", "" + this.getInput(0));
		Log.e("input 2", "" + this.getInput(1));
		if (this.getInput(1) == null || this.getInput(1) == null) {
			// do nothing
		} else {
			int yaw = (Integer) this.getInput(0);
			yaw += (Integer) this.getInput(1);
			Log.e("yoooooolo", "" + yaw);
			this.setOutput(yaw,0);
		}

	}

}
