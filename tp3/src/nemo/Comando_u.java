package nemo;

public class Comando_u extends Instruction {
	private int key = (int) 'u';
	public void execute(Nemo nemo) {
		nemo.up();
	}
	public boolean applies(int c) {
		return key ==c;
	}
}
