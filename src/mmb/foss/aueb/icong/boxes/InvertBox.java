package mmb.foss.aueb.icong.boxes;

import mmb.foss.aueb.icong.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;

public class InvertBox extends Box {

	public InvertBox(Context context) {
		// TODO Auto-generated constructor stub
		super(context, R.drawable.invert);
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
		if (getOutput(0) == null) {
			Log.e("so output = ", "" + getOutput(0));

			Bitmap src = null;

			if (this.getInput(0) == null) {
				return;
			} else {
				src = (Bitmap) this.getInput(0);
				this.setOutput(src, 0);
			}

			int width = src.getWidth();
			int height = src.getHeight();

			Bitmap out = Bitmap.createBitmap(width, height, src.getConfig());

			int A, R, G, B;
			int pixel_color;

			for (int x = 0; x < src.getWidth(); x++) {
				for (int y = 0; y < src.getHeight(); y++) {
					pixel_color = src.getPixel(x, y);
					A = Color.alpha(pixel_color);

					R = 255 - Color.red(pixel_color);
					G = 255 - Color.green(pixel_color);
					B = 255 - Color.blue(pixel_color);
					out.setPixel(x, y, Color.argb(A, R, G, B));
				}
			}
			Log.e("Finished", "sdasdsadasdadsada");
			setOutput(out, 0);
		}
	}

	@Override
	public void showDialog(Context context) {
		// TODO Auto-generated method stub

	}

}
