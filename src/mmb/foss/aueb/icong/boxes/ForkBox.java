package mmb.foss.aueb.icong.boxes;

import mmb.foss.aueb.icong.R;
import android.content.Context;
import android.graphics.Bitmap;

public class ForkBox extends Box {

	public ForkBox(Context context) {
		// TODO Auto-generated constructor stub
		super(context, R.drawable.fork);
		buttonX = new int[4][2];
		buttonY = new int[4][2];
		buttonPressed = new boolean[4];
		buttonX[0][0] = 5;
		buttonX[0][1] = 26;
		buttonX[1][0] = 96;
		buttonX[1][1] = 116;
		buttonX[2][0] = 96;
		buttonX[2][1] = 116;
		buttonX[3][0] = 96;
		buttonX[3][1] = 116;
		buttonY[0][0] = 32;
		buttonY[0][1] = 53;
		buttonY[1][0] = 6;
		buttonY[1][1] = 26;
		buttonY[2][0] = 32;
		buttonY[2][1] = 52;
		buttonY[3][0] = 59;
		buttonY[3][1] = 79;
		this.setNoOfInputs(1);
		this.setNoOfOutpus(3);
	}

	@Override
	public void function() {
		
		if(this.getOutput(0) != null && this.getOutput(1) != null && this.getOutput(2) != null)
			return;
		
		Bitmap src = null;
		
		if (this.getInput(0) == null) {
			return ;
		} else {
			src = (Bitmap) this.getInput(0);
		}
		
		this.setOutput(src, 0);
		this.setOutput(src, 1);
		this.setOutput(src, 2);

	}

	@Override
	public void showDialog(Context context) {
		// TODO Auto-generated method stub

	}

}
