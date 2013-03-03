package mmb.foss.aueb.icong.boxes;

import mmb.foss.aueb.icong.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;

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
		
		Bitmap src = null;
		int threshold = 170;
		
		if (this.getInput(0) == null) {
			return ;
		} else {
			src = (Bitmap) this.getInput(0);
			
			if(this.getInput(1) != null)
				threshold = (Integer) this.getInput(1);
		}
		
		int width = src.getWidth();
		int height = src.getHeight();
		
		Bitmap out = Bitmap.createBitmap(width, height, src.getConfig());
		
		boolean gray = isGrayscale(src);
		int pix, A, R, G, B;
		
		for(int x=0; x<width; x++) 
		{
			for(int y=0; y<height; y++)
			{
				pix = src.getPixel(x, y);
				
				A = Color.alpha(pix);
				R = Color.red(pix);
				G = Color.green(pix);
				B = Color.blue(pix);
				
				if(gray) 
				{
					if(R > threshold)
						R = 255;
					
					out.setPixel(x, y, R);
				} 
				else
				{
					if(R>threshold)
						R = 255;
					if(G>threshold)
						G = 255;
					if(B>threshold)
						B = 255;
					
					out.setPixel(x, y, Color.argb(A, R, G, B));
				}
			}
		}
		setOutput(out, 0);
	}

	@Override
	public void showDialog(Context context) {
		// TODO Auto-generated method stub

	}

}
