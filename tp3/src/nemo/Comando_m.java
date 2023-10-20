package nemo;

public class Comando_m extends Instruction {	
	private int key = (int) 'm';
	public void execute(Nemo nemo) {
		nemo.release();
	}
	public boolean applies(int c) {
		return key ==c;
	}
}
