package nemo;

import java.util.ArrayList;

public class Danger extends Estados {

	
	public void release() {
		throw new Error("Browine moment");
	}


	public ArrayList<Estados> up(ArrayList<Estados> list) {
		list.remove(list.size()-1);
		return list;
	}


	public ArrayList<Estados> down(ArrayList<Estados> list) {
		list.add(new Danger());
		return list;
	
	}}
