package nemo;

import java.util.ArrayList;

public class Danger extends Estados {
	public static final String BROWNIE_MOMENT = "Brownie Moment";
	private int depth;
	public Danger(int d) {
		depth=d;
	}
	public void release() {
		throw new Error(BROWNIE_MOMENT);
	}
	public ArrayList<Estados> up(ArrayList<Estados> list) {
		list.remove(list.size()-1);
		return list;
	}
	public ArrayList<Estados> down(ArrayList<Estados> list) {
		list.add(new Danger(list.get(list.size()-1).getDepth()-1));
		return list;
	}
	public int getDepth() {
		return depth;
	}
}
