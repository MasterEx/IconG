package mmb.foss.aueb.icong.boxes;

import mmb.foss.aueb.icong.R;
import android.content.Context;

public class ClipBox extends Box {

	public ClipBox(Context context) {
		// TODO Auto-generated constructor stub
		super(context, R.drawable.clip);
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
		// TODO Auto-generated method stub

	}

}
