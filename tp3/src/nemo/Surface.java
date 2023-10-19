package nemo;

import java.util.ArrayList;

public class Surface extends Estados {

	
	public void release() {

	}

	
	public ArrayList<Estados> up(ArrayList<Estados> list) {
		
		return list;
	}

	@Override
	public ArrayList<Estados> down(ArrayList<Estados> list) {
		list.add(new NotInDanger());
		return list;
	}


	@Override
	public Coordinates upIfAllowed(Coordinates cords) {
		return cords;
	}


	


}
