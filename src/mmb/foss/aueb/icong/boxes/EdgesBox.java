package mmb.foss.aueb.icong.boxes;

import mmb.foss.aueb.icong.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;

public class EdgesBox extends Box {

	public EdgesBox(Context context) {
		// TODO Auto-generated constructor stub
		super(context, R.drawable.edges);
		buttonX = new int[2][2];
		buttonY = new int[2][2];
		buttonPressed = new boolean[2];
		buttonX[0][0] = 6;
		buttonX[0][1] = 26;
		buttonX[1][0] = 97;
		buttonX[1][1] = 117;
		buttonY[0][0] = 23;
		buttonY[0][1] = 43;
		buttonY[1][0] = 23;
		buttonY[1][1] = 43;
		this.setNoOfInputs(1);
		this.setNoOfOutpus(1);
	}

	@Override
	public void function() {
		
		if(this.getOutput(0) != null)
			return;
	
		Bitmap src = null;
		
		if (this.getInput(0) == null) {
			return;
		} else {
			src = (Bitmap) this.getInput(0);
		}
		
		int width = src.getWidth();
		int height = src.getHeight();
		
		Bitmap out = Bitmap.createBitmap(width, height, src.getConfig());
		int tl, tm, tr, bl, bm , br, pix;
		int composite;
		int A, R, G, B;
		
		/*float[] matrix = {
				1, 2, 1,
				0, 0, 0,
				-1, -2, -1,
			};*/
		
		for(int y=0; y<height; y++)
		{
			for(int x=0; x<width; x++)
			{
				if(x>0 && y>0)
					tl = src.getPixel(x-1, y-1);
				else
					tl = 0;
				
				if(y>0)
					tm = src.getPixel(x, y-1);
				else
					tm = 0;
				
				if(x<width-1 && y>0)
					tr = src.getPixel(x+1, y-1);
				else 
					tr = 0;
				
				if(x>0 && y<height-1)
					bl = src.getPixel(x-1, y+1);
				else 
					bl = 0;
				
				if(y<height-1)
					bm = src.getPixel(x, y+1);
				else
					bm = 0;
				
				if(x<width-1 && y<height-1)
					br = src.getPixel(x+1, y+1);
				else
					br = 0;
				
				composite = tl + (2*tm) + tr - bl - (2*bm) -br;
				pix = src.getPixel(x, y);
				
				A = Color.alpha(pix);
				R = Color.red(composite);
				G = Color.green(composite);
				B = Color.blue(composite);
				
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
