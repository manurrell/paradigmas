package nemo;

import java.util.ArrayList;

public class NotInDanger extends Estados {
	private int depth=-1;
	public void release() {
	}

	public ArrayList<Estados> up(ArrayList<Estados> list) {
		list.remove(list.size()-1);
		return list;
	}
	

	public ArrayList<Estados> down(ArrayList<Estados> list) {
		list.add(new Danger(-2));
		return list;
	}

	public int getDepth() {
		return depth;
	}
}
