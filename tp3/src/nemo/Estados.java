package nemo;

import java.util.ArrayList;

public abstract class Estados {
	public abstract void release();
	public abstract ArrayList<Estados> up(ArrayList<Estados> list);
	public abstract ArrayList<Estados> down(ArrayList<Estados> list);
	public abstract Coordinates upIfAllowed(Coordinates cords);
	
}
