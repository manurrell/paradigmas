package nemo;

public class ComandoD extends Instruction {
	private int key = (int) 'd';
	public void execute(Nemo nemo) {
		nemo.descend();
	}
	public boolean applies(int c) {
		return key ==c;
	}
	
}
