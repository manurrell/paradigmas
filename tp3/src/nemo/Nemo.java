package nemo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Nemo {
	private Coordinates cords;
	private ArrayList<Estados> state_list= new ArrayList<>(Arrays.asList(new SafeSurface()));
	private Cardinal aim;
	
	public Nemo(int x,int y,Cardinal aim){
		cords=new Coordinates(x,y);
		this.aim=aim;
	}
	public void moveFoward() {
		aim.move(cords);
	}
	public void turnRight() {
		aim= aim.turnRight();
	}
	public void executeInstruction(String commandos) {
		Instruction.ejecutarInstrucciones(commandos, this);
	}
	public Cardinal getAim() {
		return aim;
	}
	public int getX(){
		return cords.getX();
	}
	public int getY(){
		return cords.getY();
	}
	public int getZ(){
		return state_list.get(state_list.size()-1).getDepth();
	}
	public void turnLeft() {
		aim=aim.turnLeft();
	}
	public void descend() {
		state_list=state_list.get(state_list.size()-1).down(state_list);
	}
	public void up() {
		state_list=state_list.get(state_list.size()-1).up(state_list);
	}
	public void release() {
		state_list.get(state_list.size()-1).release();
	}
}