package nemo;

public class ComandoL extends Instruction {
	private int key = (int) 'l';
	public void execute(Nemo nemo) {
		nemo.turnLeft();
	}
	public boolean applies(int c) {
		return key ==c;
	}
}
