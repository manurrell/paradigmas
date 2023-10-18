package nemo;
import java.util.ArrayList;
import java.util.Arrays;

public class Nemo {
	private Coordinates cords;
	private ArrayList<Estados> state_list= new ArrayList<>();
	private ArrayList<Instruction> instruction_list; 
	private Cardinal aim;
	private char[] a;
	
	
	public Nemo(int x,int y,Cardinal aim){
		cords=new Coordinates(x,y,0);
		this.aim=aim;
		instruction_list=new ArrayList<>(Arrays.asList(new IUp(),new IRight(), new ILeft(), new IForward(), new IDescend(), new IRelease()));
	}
	public void moveFoward() {
		aim.move(cords);
	}
	public void turnRigth() {
		aim= aim.turnRigth();
	}
	public void executeInstruction(String commandos) {
		commandos.chars().forEach(comando -> instruction_list.stream().filter(instructions -> instructions.applies(comando)).toList().get(0).execute(this));
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
		return cords.getZ();
	}
	public void turnLeft() {
		aim=aim.turnLeft();
		
	}
	public void descend() {
		cords= cords.down();
		state_list=state_list.get(state_list.size()-1).down(state_list);
	}
	public void up() {
		
		
	}
}
