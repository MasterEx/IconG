package mmb.foss.aueb.icong.boxes;

import mmb.foss.aueb.icong.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;

public class HSV2RGBBox extends Box {

	public HSV2RGBBox(Context context) {
		// TODO Auto-generated constructor stub
		super(context, R.drawable.hsv2rgb);
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
		
		Bitmap src = null;
		
		if (this.getInput(0) == null) {
			return ;
		} else {
			src = (Bitmap) this.getInput(0);
		}
		

	}

	@Override
	public void showDialog(Context context)
	{
		// TODO Auto-generated method stub
		
	}

}
