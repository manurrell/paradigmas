package nemo;

import java.util.ArrayList;

public class NotInDanger extends Estados {


	public void release() {
	}

	public ArrayList<Estados> up(ArrayList<Estados> list) {
		list.remove(list.size()-1);
		return list;
	}
	

	public ArrayList<Estados> down(ArrayList<Estados> list) {
		list.add(new Danger());
		return list;
	}

	
	public Coordinates upIfAllowed(Coordinates cords) {
		return cords.up();
	}

}
