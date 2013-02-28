package mmb.foss.aueb.icong;

import mmb.foss.aueb.icong.boxes.Box;

public class BoxButtonPair implements Comparable<BoxButtonPair> {

	private int button;
	private Box box;

	public BoxButtonPair(Box box, int button) {
		// TODO Auto-generated constructor stub
		this.setBox(box);
		this.setButton(button);
	}

	@Override
	public int compareTo(BoxButtonPair another) {
		// TODO Auto-generated method stub
		if (getBox().equals(another.getBox())) {
			return getButton() - another.getButton();
		}
		return 0;
	}

	public boolean equals(Object o) {
		BoxButtonPair other = (BoxButtonPair) o;
		if (box.equals(other.getBox()) && button == other.getButton())
			return true;
		else
			return false;
		// return (box.equals(((BoxButtonPair) o).getBox()) && button ==
		// ((BoxButtonPair) o).getButton());
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
