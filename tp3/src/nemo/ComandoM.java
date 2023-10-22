package nemo;

public class ComandoM extends Instruction {	
	private int key = (int) 'm';
	public void execute(Nemo nemo) {
		nemo.release();
	}
	public boolean applies(int c) {
		return key ==c;
	}
}
