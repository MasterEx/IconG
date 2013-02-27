package mmb.foss.aueb.icong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import mmb.foss.aueb.icong.boxes.Box;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawableAreaView extends View {

	private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
	private ArrayList<Box> boxes = new ArrayList<Box>();
	private Context mContext;
	private Box selectedBox = null;
	private int pressedX, pressedY;
	private int originalX, originalY;
	private int[] buttonCenter = new int[2];
	private int WIDTH, HEIGHT;
	private HashMap<BoxButtonPair,BoxButtonPair> lines = new HashMap<BoxButtonPair,BoxButtonPair>();
	private int selectedButton = -1;
	private Box selectedButtonBox = null;

	public DrawableAreaView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		mContext = context;
		paint.setColor(Color.BLACK);
	}

	protected void onDraw(Canvas c) {
		System.out.println("IN ON DRAW");
		if (WIDTH == 0) {
			WIDTH = this.getWidth();
			HEIGHT = this.getHeight();
		}
		for (Box box : boxes) {
			// TODO: Zooming to be removed
			box.setZoom(1.3);
			c.drawBitmap(box.getBitmap(), box.getX(), box.getY(), null);
			for (int i = 0; i < box.getNumOfButtons(); i++) {
				if (box.isPressed(i)) {
					buttonCenter = box.getButtonCenter(i);
					c.drawCircle(buttonCenter[0], buttonCenter[1],
							box.getButtonRadius(i), paint);
				}
			}
		}
		Iterator<Entry<BoxButtonPair, BoxButtonPair>> it = lines.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<BoxButtonPair,BoxButtonPair> entry = it.next();
			Box box0 = entry.getKey().getBox(), box1 = entry.getValue().getBox();
			int button0 = entry.getKey().getButton(), button1 = entry.getValue().getButton();
			int[] center0 = box0.getButtonCenter(button0), center1 = box1.getButtonCenter(button1);
			c.drawLine(center0[0], center0[1], center1[0], center1[1], paint);
		}
	}

	public void addBox(Box box) {
		int x, y;
		if (mContext.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
			y = getLower() + 15;
			x = (WIDTH / 2) - (box.getWidth() / 2);
		} else {
			y = (HEIGHT / 2) - (box.getHeight() / 2);
			x = getRighter() + 15;
		}
		box.setY(y);
		box.setX(x);
		boxes.add(box);
		invalidate();
	}

	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			Box box = getBoxTouched((int) event.getX(), (int) event.getY());
			if (box != null) {
				selectedBox = box;
				int buttonPressed = box.isButton((int) event.getX(),
						(int) event.getY());
				if (buttonPressed == -1) {
					pressedX = (int) event.getX();
					pressedY = (int) event.getY();
					originalX = box.getX();
					originalY = box.getY();
				} else {
					if (box.isPressed(buttonPressed)) {
						box.unsetButtonPressed(buttonPressed);
					} else {
						box.setButtonPressed(buttonPressed);
						if(selectedButton == -1) {
							selectedButtonBox = box;
							selectedButton = buttonPressed;
						} else {
							lines.put(new BoxButtonPair(selectedButtonBox, selectedButton), new BoxButtonPair(box, buttonPressed));
							selectedButton = -1;
							selectedButtonBox = null;
						}						
					}
					invalidate();
					selectedBox = null;
				}
			}
			break;
		case MotionEvent.ACTION_MOVE:
			if (selectedBox != null) {
				selectedBox.setX((int) event.getX() - (pressedX - originalX));
				selectedBox.setY((int) event.getY() - (pressedY - originalY));
				invalidate();
			}
			break;
		case MotionEvent.ACTION_UP:
			selectedBox = null;
			pressedX = pressedY = originalX = originalY = 0;
			return false;
		}
		return true;
	}

	// returns the lower pixel of the lower element
	private int getLower() {
		int y = 0;
		for (Box box : boxes) {
			if (y < box.getYY())
				y = box.getYY();
		}
		return y;
	}

	// returns the righter pixel of the righter element
	private int getRighter() {
		int x = 0;
		for (Box box : boxes) {
			if (x < box.getXX())
				x = box.getXX();
		}
		return x;
	}

	// returns the box that was touched
	private Box getBoxTouched(int x, int y) {
		for (Box b : boxes) {
			if (b.isOnBox(x, y)) {
				return b;
			}
		}
		return null;
	}

}
