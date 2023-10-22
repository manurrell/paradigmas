package nemo;

public class ComandoF extends Instruction {
	private int key = (int) 'f';
	public void execute(Nemo nemo) {
		nemo.moveFoward();
	}
	public boolean applies(int c) {
		return key ==c;
	}
}
