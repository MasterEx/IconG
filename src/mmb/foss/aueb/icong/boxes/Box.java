package mmb.foss.aueb.icong.boxes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

public class Box {

	protected BitmapDrawable image = null;
	protected int zoom = 100;
	protected int width, height;
	protected int x = 0, y = 0;
	protected int[][] buttonX;
	protected int[][] buttonY;
	protected boolean[] buttonPressed;

	public Box(Context context, int id) {
		// TODO Auto-generated constructor stub
		image = (BitmapDrawable) context.getResources().getDrawable(id);
		width = image.getBitmap().getWidth();
		height = image.getBitmap().getHeight();
	}

	public Bitmap getBitmap() {
		System.out.println("I AM NOOB");
		if (image != null)
			return image.getBitmap();
		return null;
	}

	public int isButton(int x, int y) {
		if (buttonX != null) {
			for (int i = 0; i < buttonX.length; i++) {
				System.out.println("IN BUTTON " + x + " " + y + " "
						+ (buttonX[i][0] + x) + " " + buttonX[i][1] + x + " ");
				if (x >= buttonX[i][0] + this.x && x <= buttonX[i][1] + this.x
						&& y >= buttonY[i][0] + this.y
						&& y <= buttonY[i][1] + this.y) {
					return i;
				}
			}
		}
		return -1;
	}

	public int[] getButtonCenter(int index) {
		int[] xy = new int[2];
		xy[0] = this.x + buttonX[index][0]
				+ ((buttonX[index][1] - buttonX[index][0]) / 2);
		xy[1] = this.y + buttonY[index][0]
				+ ((buttonY[index][1] - buttonY[index][0]) / 2);
		return xy;
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

}
