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
	Bitmap originalBitmap;
	protected static double zoom = 1;
	protected int width, height;
	protected int x = 0, y = 0;
	protected int[][] buttonX;
	protected int[][] buttonY;
	protected boolean[] buttonPressed;
	private int noOfInputs, noOfOutpus;
	private Object[] inputs, outputs;
	private boolean hasDialog = false ;
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
		width = image.getBitmap().getWidth();
		height = image.getBitmap().getHeight();
	}

	public Bitmap getBitmap() {
		if (image != null)
			return image.getBitmap();
		return null;
	}

	public int isButton(int x, int y) {
		if (buttonX != null) {
			for (int i = 0; i < buttonX.length; i++) {
				int bx0 = (int) (buttonX[i][0] * zoom);
				int bx1 = (int) (buttonX[i][1] * zoom);
				int by0 = (int) (buttonY[i][0] * zoom);
				int by1 = (int) (buttonY[i][1] * zoom);
				System.out.println("IN BUTTON " + x + " " + y + " " + (bx0 + x)
						+ " " + bx1 + x + " ");
				if (x >= bx0 + this.x && x <= bx1 + this.x && y >= by0 + this.y
						&& y <= by1 + this.y) {
					return i;
				}
			}
		}
		return -1;
	}

	public int[] getButtonCenter(int index) {
		int[] xy = new int[2];
		int bx0 = (int) (buttonX[index][0] * zoom);
		int bx1 = (int) (buttonX[index][1] * zoom);
		int by0 = (int) (buttonY[index][0] * zoom);
		int by1 = (int) (buttonY[index][1] * zoom);
		xy[0] = this.x + bx0 + ((bx1 - bx0) / 2);
		xy[1] = this.y + by0 + ((by1 - by0) / 2);
		return xy;
	}

	public int getButtonRadius(int index) {
		int r;
		int bx0 = (int) (buttonX[index][0] * zoom);
		int bx1 = (int) (buttonX[index][1] * zoom);
		r = (bx1 - bx0) / 2;
		return r;
	}

	// returns if the (posx,posy) is on box
	public boolean isOnBox(int posx, int posy) {
		boolean isOnBox = false;
		if (posx >= x && posx <= (x + width) && posy >= y
				&& posy <= (y + height)) {
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

	public void setZoom(double zoom) {
		this.zoom = zoom;
		image = new BitmapDrawable(context.getResources(),
				Bitmap.createScaledBitmap(originalBitmap,
						(int) (originalBitmap.getWidth() * zoom),
						(int) (originalBitmap.getHeight() * zoom), true));
		width = image.getBitmap().getWidth();
		height = image.getBitmap().getHeight();
	}
	public static double getZoom()
	{
		return zoom ;
	}
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getXX() {
		return x + width;
	}

	public int getYY() {
		return y + height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
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
		Log.e("yaw","index is"+index+"for object "+output.toString());
		outputs[index] = output ;
	}

	public Object getInput(int index) {
		return this.inputs[index];
	}

	public void setInput(Object input, int index) {
		this.inputs[index] = new Object() ;
		this.inputs[index] = input;
	}
	public boolean HasDialog()
	{
		return hasDialog;
	}

	public void setHasDialog(boolean hasDialog)
	{
		this.hasDialog = hasDialog;
	}
	public abstract void function();
	public abstract void showDialog(Context context);

}
