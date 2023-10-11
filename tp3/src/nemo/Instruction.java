package nemo;

public class Instruction {
	private char chr;
	private Runnable exe;
	
	public Instruction(char caracter, Runnable exe){
		this.chr=caracter;
		this.exe=exe;
	}
	public void execute() {
		exe.run();
	}
}
