package mmb.foss.aueb.icong;

import mmb.foss.aueb.icong.boxes.Box;

public class BoxButtonPair implements Comparable<BoxButtonPair> {
	
	private int button;
	private Box box;

	public BoxButtonPair(Box box, int button) {
		// TODO Auto-generated constructor stub
		this.setBox(box);
		this.setButton(button);
		System.out.println("IN HERE");
	}

	@Override
	public int compareTo(BoxButtonPair another) {
		// TODO Auto-generated method stub
		System.out.println("IN HERE ** ");
		if(getBox() == another.getBox()) {
			return getButton()-another.getButton();
		}
		System.out.println("IN HERE ++ ");
		return 0;
	}

	public int getButton() {
		return button;
	}

	public void setButton(int button) {
		this.button = button;
	}

	public Box getBox() {
		return box;
	}

	public void setBox(Box box) {
		this.box = box;
	}

}
