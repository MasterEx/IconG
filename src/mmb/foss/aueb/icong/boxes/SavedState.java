package mmb.foss.aueb.icong.boxes;

import java.util.ArrayList;

import mmb.foss.aueb.icong.BoxButtonPair;

public class SavedState 
{
	static ArrayList<Box> boxes = new ArrayList<Box>();
	static ArrayList<BoxButtonPair[]> lines = new ArrayList<BoxButtonPair[]>();

	public static void addBox(Box box)
	{
		boxes.add(box);
	}
	public static ArrayList<Box> getBoxes()
	{
		return boxes ;
	}
	public static void clear()
	{
		boxes.clear();
	}
	public static ArrayList<BoxButtonPair[]> getLines()
	{
		return lines ;
	}
	public static void addLine(BoxButtonPair[] line)
	{
		lines.add(line);
	}
	public static void removeLine(BoxButtonPair[] line)
	{
		lines.remove(line);
	}
	public static BoxButtonPair[] getLine(int index)
	{
		return lines.get(index);
	}
	
}
