package nemo;

public class IRelease extends Instruction {

	
	public void execute(Nemo nemo) {
		nemo.release();
	}
	private int key = 109;
	public boolean applies(int c) {
		return key ==c;
	}
}
