package mmb.foss.aueb.icong.boxes;

import mmb.foss.aueb.icong.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;

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
		
		if(this.getOutput(0) != null)
			return;
		
		Bitmap src1, src2, src3;
		
		src1 = src2 = src3 =  null;

		if (this.getInput(0) == null || this.getInput(1) == null || this.getInput(2) == null) {
			return ;
		} else {
			
			src1 = (Bitmap) this.getInput(0);
			src2 = (Bitmap) this.getInput(1);
			src3 = (Bitmap) this.getInput(2);
		}
		
		int width = src1.getWidth();
		int height = src1.getHeight();
		
		Bitmap out = Bitmap.createBitmap(width, height, src1.getConfig());
		
		int pix1, pix2, pix3, A,R,G,B;
		
		for(int x=0; x<width; x++) 
		{
			for(int y=0; y<height; y++)
			{
				pix1 = src1.getPixel(x, y);
				pix2 = src2.getPixel(x, y);
				pix3 = src3.getPixel(x, y);
				
				A = Color.alpha(pix2);
				R = Color.red(pix1);
				G = Color.green(pix2);
				B = Color.blue(pix3);
				
				out.setPixel(x, y, Color.argb(A, R, G, B));
			}
		}
		
		this.setOutput(out, 0);
	}

	@Override
	public void showDialog(Context context) {
		// TODO Auto-generated method stub

	}

}
