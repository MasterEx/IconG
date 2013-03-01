package mmb.foss.aueb.icong.boxes;

import mmb.foss.aueb.icong.R;
import android.content.Context;

public class RGB2HSVBox extends Box {

	public RGB2HSVBox(Context context) {
		// TODO Auto-generated constructor stub
		super(context, R.drawable.rgb2hsv);
		buttonX = new int[2][2];
		buttonY = new int[2][2];
		buttonPressed = new boolean[2];
		buttonX[0][0] = 6;
		buttonX[0][1] = 26;
		buttonX[1][0] = 95;
		buttonX[1][1] = 115;
		buttonY[0][0] = 5;
		buttonY[0][1] = 25;
		buttonY[1][0] = 5;
		buttonY[1][1] = 25;
		this.setNoOfInputs(1);
		this.setNoOfOutpus(1);
	}

	@Override
	public void function() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showDialog(Context context)
	{
		// TODO Auto-generated method stub
		
	}

}
