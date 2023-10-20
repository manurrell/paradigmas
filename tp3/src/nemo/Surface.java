package nemo;

import java.util.ArrayList;

public class Surface extends Estados {
	private int depth=0;
	public void release() {
	}
	public ArrayList<Estados> up(ArrayList<Estados> list) {	
		return list;
	}
	public ArrayList<Estados> down(ArrayList<Estados> list) {
		list.add(new NotInDanger());
		return list;
	}
	public int getDepth() {
		return depth;
	}

}
		