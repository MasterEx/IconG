package mmb.foss.aueb.icong.boxes;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;

public abstract class Box {

	private Context context;
	protected BitmapDrawable image = null;
	private Bitmap originalBitmap;
	protected float zoom = 1;
	protected int originalWidth, originalHeight;
	protected float x = 0, y = 0;
	protected int[][] buttonX;
	protected int[][] buttonY;
	protected boolean[] buttonPressed;
	private int noOfInputs, noOfOutpus;
	private Object[] inputs, outputs;
	private boolean hasDialog = false;

	public Box(Context context, int id) {
		// TODO Auto-generated constructor stub
		this.context = context;
		// Nasty solution to keep original bitmap size. Any better idea?
		InputStream is = context.getResources().openRawResource(id);
		originalBitmap = BitmapFactory.decodeStream(is);
		image = new BitmapDrawable(context.getResources(),
						Bitmap.createScaledBitmap(originalBitmap,
						originalBitmap.getWidth(), originalBitmap.getHeight(),
						true));
		originalWidth = image.getBitmap().getWidth();
		originalHeight = image.getBitmap().getHeight();
	}

	public Bitmap getBitmap() {
		if (image != null)
			return image.getBitmap();
		return null;
	}

	public int isButton(int x, int y) {
		if (buttonX != null) {
			for (int i = 0; i < buttonX.length; i++) {
				float bx0 = (buttonX[i][0] * zoom);
				float bx1 = (buttonX[i][1] * zoom);
				float by0 = (buttonY[i][0] * zoom);
				float by1 = (buttonY[i][1] * zoom);
				if (x >= bx0 + this.x && x <= bx1 + this.x && y >= by0 + this.y
						&& y <= by1 + this.y) {
					return i;
				}
			}
		}
		return -1;
	}

	public float[] getButtonCenter(int index) {
		float[] xy = new float[2];
		float bx0 = (buttonX[index][0] * zoom);
		float bx1 = (buttonX[index][1] * zoom);
		float by0 = (buttonY[index][0] * zoom);
		float by1 = (buttonY[index][1] * zoom);
		xy[0] = this.x + bx0 + ((bx1 - bx0) / 2);
		xy[1] = this.y + by0 + ((by1 - by0) / 2);
		return xy;
	}

	public float getButtonRadius(int index) {
		float r;
		float bx0 = (buttonX[index][0] * zoom);
		float bx1 = (buttonX[index][1] * zoom);
		r = (bx1 - bx0) / 2;
		return r;
	}

	// returns if the (posx,posy) is on box
	public boolean isOnBox(int posx, int posy) {
		boolean isOnBox = false;
		if (posx >= x && posx <= (x + getWidth()) && posy >= y
				&& posy <= (y + getHeight())) {
			isOnBox = true;
		}
		return isOnBox;
	}

	public void setButtonPressed(int index) {
		this.buttonPressed[index] = true;
	}

	public void unsetButtonPressed(int index) {
		this.buttonPressed[index] = false;
	}

	public int getNumOfButtons() {
		if (buttonX == null)
			return 0;
		return buttonX.length;
	}

	public boolean isPressed(int index) {
		if (this.buttonPressed == null)
			return false;
		return this.buttonPressed[index];
	}

	public void setZoom(float zoom) {
		if (this.x == this.zoom)
			this.x = 0;
		else
			this.x = this.x / this.zoom;
		if (this.y == this.zoom)
			this.y = 0;
		else
			this.y = this.y / this.zoom;
		this.zoom = zoom;
		image = new BitmapDrawable(context.getResources(),
				Bitmap.createScaledBitmap(originalBitmap,
						(int) (originalBitmap.getWidth() * zoom),
						(int) (originalBitmap.getHeight() * zoom), true));
		if (this.x == 0)
			this.x = this.x + zoom;
		else
			this.x = this.x * zoom;
		if (this.y == 0)
			this.y = this.y + zoom;
		else
			this.y = this.y * zoom;
	}

	public void setX(float f) {
		this.x = f;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getXX() {
		return x + getWidth();
	}

	public float getYY() {
		return y + getHeight();
	}

	public float getWidth() {
		return originalWidth * zoom;
	}

	public float getHeight() {
		return originalHeight * zoom;
	}

	public int getNoOfInputs() {
		return noOfInputs;
	}

	public void setNoOfInputs(int noOfInputs) {
		this.noOfInputs = noOfInputs;
		this.inputs = new Object[noOfInputs];
	}

	public int getNoOfOutpus() {
		return noOfOutpus;
	}

	public void setNoOfOutpus(int noOfOutpus) {
		this.noOfOutpus = noOfOutpus;
		this.outputs = new Object[noOfOutpus];
	}

	public Object getOutput(int index) {
		return this.outputs[index];
	}

	public void setOutput(Object output, int index) {
		Log.e("yaw", "index is" + index + "for object " + output.toString());
		outputs[index] = output;
	}

	public Object getInput(int index) {
		return this.inputs[index];
	}

	public void setInput(Object input, int index) {
		this.inputs[index] = new Object();
		this.inputs[index] = input;
	}

	public boolean HasDialog() {
		return hasDialog;
	}

	public void setHasDialog(boolean hasDialog) {
		this.hasDialog = hasDialog;
	}

	public abstract void function();

	public abstract void showDialog(Context context);
	
	public boolean isGrayscale(Bitmap b) {
		
		boolean ig = true;
		
		for(int x=0; x< b.getWidth(); x++) 
		{
			for(int y=0; y<b.getHeight(); y++) 
			{
				
				int pix = b.getPixel(x, y);
				
				if(!isGrayscalePix(pix)) 
				{	
					ig = false;
					break;
				}
			}
			if(!ig) {
				break;
			}
		}
		
		return ig;
	}
	
	private boolean isGrayscalePix(int pix) {
		
		int alpha = (pix & 0xFF000000) >> 24;
	    int red   = (pix & 0x00FF0000) >> 16;
	    int green = (pix & 0x0000FF00) >> 8;
	    int blue  = (pix & 0x000000FF);

	    if( alpha == 0 && red == green && green == blue ) 
	    	return true;
	    else 
	    	return false;
	}

}
