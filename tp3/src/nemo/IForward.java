package nemo;

public class IForward extends Instruction {
	public void execute(Nemo nemo) {
		nemo.moveFoward();
	}
	private int key = 102;
	public boolean applies(int c) {
		return key ==c;
	}
}
