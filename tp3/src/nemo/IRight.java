package nemo;

public class IRight extends Instruction {

	
	public void execute(Nemo nemo) {
		nemo.turnRight();
	}
	private int key = 114;
	public boolean applies(int c) {
		return key ==c;
	}
}
