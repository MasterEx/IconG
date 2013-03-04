package mmb.foss.aueb.icong.boxes;

import mmb.foss.aueb.icong.R;
import android.content.Context;
import android.util.Log;

public class ScreenBox extends Box {

	public ScreenBox(Context context) {
		// TODO Auto-generated constructor stub
		super(context, R.drawable.screen);
		buttonX = new int[1][2];
		buttonY = new int[1][2];
		buttonPressed = new boolean[1];
		buttonX[0][0] = 5;
		buttonX[0][1] = 25;
		buttonY[0][0] = 10;
		buttonY[0][1] = 30;
		this.setNoOfInputs(1);
		this.setNoOfOutpus(0);

	}

	@Override
	public void function() {
		// TODO Auto-generated method stub
		Log.e("Screen", "" + this.getInput(0));
		
	}

	@Override
	public void showDialog(Context context) {
		// TODO Auto-generated method stub

	}

}
