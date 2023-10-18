package nemo;

public class IUp extends Instruction {

	public void execute(Nemo nemo) {
		nemo.up();
	}
	private int key = 117;
	public boolean applies(int c) {
		return key ==c;
	}
}
