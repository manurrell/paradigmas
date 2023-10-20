package nemo;

public class Comando_r extends Instruction {
	private int key = (int) 'r';
	public void execute(Nemo nemo) {
		nemo.turnRight();
	}
	public boolean applies(int c) {
		return key ==c;
	}
}
