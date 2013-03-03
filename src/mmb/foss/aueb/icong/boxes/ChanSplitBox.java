package mmb.foss.aueb.icong.boxes;

import mmb.foss.aueb.icong.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;

public class ChanSplitBox extends Box {

	public ChanSplitBox(Context context) {
		// TODO Auto-generated constructor stub
		super(context, R.drawable.chan_split);
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
			return;
		} else {
			
			src = (Bitmap) this.getInput(0);
		
		}
		
		int width = src.getWidth();
		int height = src.getHeight();
		
		Bitmap out1 = Bitmap.createBitmap(width, height, src.getConfig());
		Bitmap out2 = Bitmap.createBitmap(width, height, src.getConfig());
		Bitmap out3 = Bitmap.createBitmap(width, height, src.getConfig());
		
		int pix, R, G, B;
		
		for(int x=0; x<width; x++)
		{
			for(int y=0; y<height; y++)
			{
				pix = src.getPixel(x, y);
				
				R = Color.red(pix);
				G = Color.green(pix);
				B = Color.blue(pix);
				
				out1.setPixel(x, y, R);
				out2.setPixel(x, y, G);
				out3.setPixel(x, y, B);
			}
		}

		this.setOutput(out1, 0);
		this.setOutput(out2, 1);
		this.setOutput(out3, 2);
	}

	@Override
	public void showDialog(Context context) {
		// TODO Auto-generated method stub

	}

}
