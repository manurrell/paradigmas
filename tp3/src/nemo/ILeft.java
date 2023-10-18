package nemo;

public class ILeft extends Instruction {
	public void execute(Nemo nemo) {
		nemo.turnLeft();
	}
	private int key = 108;
	public boolean applies(int c) {
		return key ==c;
	}
}
