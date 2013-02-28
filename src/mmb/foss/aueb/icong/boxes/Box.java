package mmb.foss.aueb.icong.boxes;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;

public abstract class Box {

	private Context context;
	protected BitmapDrawable image = null;
	Bitmap originalBitmap;
	protected double zoom = 1;
	protected int width, height;
	protected int x = 0, y = 0;
	protected int[][] buttonX;
	protected int[][] buttonY;
	protected boolean[] buttonPressed;
	private int noOfInputs, noOfOutpus;
	private Object output1, output2, output3, input1, input2, input3;

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
	}

	public int getNoOfOutpus() {
		return noOfOutpus;
	}

	public void setNoOfOutpus(int noOfOutpus) {
		this.noOfOutpus = noOfOutpus;
	}

	public Object getOutput1() {
		return output1;
	}

	public void setOutput1(Object output1) {
		this.output1 = output1;
	}

	public Object getOutput2() {
		return output2;
	}

	public void setOutput2(Object output2) {
		this.output2 = output2;
	}

	public Object getOutput3() {
		return output3;
	}

	public void setOutput3(Object output3) {
		this.output3 = output3;
	}

	public Object getInput1() {
		return input1;
	}

	public void setInput1(Object input1) {
		this.input1 = input1;
	}

	public Object getInput2() {
		return input2;
	}

	public void setInput2(Object input2) {
		this.input2 = input2;
	}

	public Object getInput3() {
		return input3;
	}

	public void setInput3(Object input3) {
		this.input3 = input3;
	}

	public abstract void function();

}
