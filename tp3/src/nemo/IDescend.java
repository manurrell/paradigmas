package nemo;

public class IDescend extends Instruction {


	public void execute(Nemo nemo) {
		nemo.descend();
	}
	private int key = 100;
	public boolean applies(int c) {
		return key ==c;
	}
	
}
