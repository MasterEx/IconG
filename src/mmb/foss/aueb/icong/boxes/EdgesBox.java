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
		int compR, compG, compB;
		int A, R, G, B;
		int temp, gray;
		
		Bitmap tempB = Bitmap.createBitmap(width, height, src.getConfig());
		
		//if(!isGrayscale(src)) {
			
			for(int y=0; y<height; y++)
			{
				for(int x=0; x<width; x++)
				{
					temp = src.getPixel(x, y);
					A = Color.alpha(temp);
					R = Color.red(temp);
					G = Color.green(temp);
					B = Color.blue(temp);
					
					gray = (R + G + B) / 3;
					
					tempB.setPixel(x, y, Color.argb(A, R, G, B));
				}
			}
		//}
		
		for(int y=0; y<height; y++)
		{
			for(int x=0; x<width; x++)
			{
				if(x>0 && y>0)
					tl = tempB.getPixel(x-1, y-1);
				else
					tl = 0;
				
				if(y>0)
					tm = tempB.getPixel(x, y-1);
				else
					tm = 0;
				
				if(x<width-1 && y>0)
					tr = tempB.getPixel(x+1, y-1);
				else 
					tr = 0;
				
				if(x>0 && y<height-1)
					bl = tempB.getPixel(x-1, y+1);
				else 
					bl = 0;
				
				if(y<height-1)
					bm = tempB.getPixel(x, y+1);
				else
					bm = 0;
				
				if(x<width-1 && y<height-1)
					br = tempB.getPixel(x+1, y+1);
				else
					br = 0;
				
				compR = Color.red(tl) + (2*Color.red(tm)) + Color.red(tr) - Color.red(bl) - (2*Color.red(bm)) - Color.red(br);
				compB = Color.blue(tl) + (2*Color.blue(tm)) + Color.blue(tr) - Color.blue(bl) - (2*Color.blue(bm)) - Color.blue(br);
				compG = Color.green(tl) + (2*Color.green(tm)) + Color.green(tr) - Color.green(bl) - (2*Color.green(bm)) - Color.green(br);
				
				pix = tempB.getPixel(x, y);
				A = Color.alpha(pix);
				
				out.setPixel(x, y, Color.argb(A, compR, compG, compB));
			}
		}
		
		this.setOutput(out, 0);
		
	}

	@Override
	public void showDialog(Context context) {
		// TODO Auto-generated method stub

	}

}
