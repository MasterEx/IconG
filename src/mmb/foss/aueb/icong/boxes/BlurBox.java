package mmb.foss.aueb.icong.boxes;

import mmb.foss.aueb.icong.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;

public class BlurBox extends Box {

	public BlurBox(Context context) {
		// TODO Auto-generated constructor stub
		super(context, R.drawable.blur);
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
		int tl, tm, tr, ml, mm, mr, bl, bm , br;
		int compR, compG, compB, A;
		
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
				
				if(x>0)
					ml = src.getPixel(x-1, y);
				else 
					ml = 0;
				
				mm = src.getPixel(x, y);
				
				if(x<width-1)
					mr = src.getPixel(x+1, y);
				else 
					mr = 0;
				
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
				
				compR = Color.red(tl) + (2*Color.red(tm)) + Color.red(tr) + (2*Color.red(ml)) + 
						(4*Color.red(mm)) + (2*Color.red(mr)) + Color.red(bl) + (2*Color.red(bm)) + Color.red(br);
				compR = compR/16;
				
				compG = Color.green(tl) + (2*Color.green(tm)) + Color.green(tr) + (2*Color.green(ml)) + 
						(4*Color.green(mm)) + (2*Color.green(mr)) + Color.green(bl) + (2*Color.green(bm)) + Color.green(br);
				compG = compG/16;
				
				compB = Color.blue(tl) + (2*Color.blue(tm)) + Color.blue(tr) + (2*Color.blue(ml)) + 
						(4*Color.blue(mm)) + (2*Color.blue(mr)) + Color.blue(bl) + (2*Color.blue(bm)) + Color.blue(br);
				compB = compB/16;
				
				A = Color.alpha(mm);
				
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
