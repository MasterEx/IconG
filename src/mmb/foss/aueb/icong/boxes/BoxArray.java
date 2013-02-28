package mmb.foss.aueb.icong.boxes;

import java.util.ArrayList;

public class BoxArray {
	static ArrayList<Box> boxes = new ArrayList<Box>();

	public static void add(Box box) {
		boxes.add(box);
	}

	public static ArrayList<Box> getBoxes() {
		return boxes;
	}
}
