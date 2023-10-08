package nemo;
import java.util.ArrayList;
import java.util.Vector;

public class Nemo {
	private ArrayList<Integer> cords= new ArrayList<>();
	private ArrayList<Container> cap_list= new ArrayList<>();
	private ArrayList<Estados> state_list= new ArrayList<>();
	private Cardinal aim= new North();
	public int getX(){
		return cords.get(0);
	}
	public int getY(){
		return cords.get(1);
	}
	public int getZ(){
		return cords.get(2);
	}
}
