package nemo;
import java.util.ArrayList;
import java.util.Arrays;

public class Nemo {
	private Coordinates cords;
	private ArrayList<Estados> state_list= new ArrayList<>();
	private ArrayList<Instruction> instruction_list; 
	private Cardinal aim;
	private char[] a;
	
	
	public Nemo(int x,int y,int z,Cardinal aim){
		cords=new Coordinates(x,y,z);
		this.aim=aim;
		instruction_list=new ArrayList<>(Arrays.asList(new Instruction('f',()-> this.moveFoward()),new Instruction('r',()->this.turnRigth())));
	}
	public void moveFoward() {
		aim.move(cords);
	}
	public void turnRigth() {
		aim= aim.turnRigth();
	}
	public void executeInstruction(String commandos) {
		commandos.chars().forEach(instruction_list.stream().filter(Each==chr));
		
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
}
