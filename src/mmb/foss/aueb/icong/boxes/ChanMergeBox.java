package mmb.foss.aueb.icong.boxes;

import mmb.foss.aueb.icong.R;
import android.content.Context;

public class ChanMergeBox extends Box {

	public ChanMergeBox(Context context) {
		// TODO Auto-generated constructor stub
		super(context, R.drawable.chan_merge);
		buttonX = new int[4][2];
		buttonY = new int[4][2];
		buttonPressed = new boolean[4];
		buttonX[0][0] = 5;
		buttonX[0][1] = 26;
		buttonX[1][0] = 5;
		buttonX[1][1] = 26;
		buttonX[2][0] = 5;
		buttonX[2][1] = 26;
		buttonX[3][0] = 95;
		buttonX[3][1] = 116;
		buttonY[0][0] = 5;
		buttonY[0][1] = 27;
		buttonY[1][0] = 31;
		buttonY[1][1] = 52;
		buttonY[2][0] = 58;
		buttonY[2][1] = 79;
		buttonY[3][0] = 31;
		buttonY[3][1] = 52;
		this.setNoOfInputs(3);
		this.setNoOfOutpus(1);
	}

	@Override
	public void function() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showDialog(Context context) {
		// TODO Auto-generated method stub

	}

}
