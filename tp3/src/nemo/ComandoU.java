package nemo;

public class ComandoU extends Instruction {
	private int key = (int) 'u';
	public void execute(Nemo nemo) {
		nemo.up();
	}
	public boolean applies(int c) {
		return key ==c;
	}
}
