package nemo;

public abstract class Instruction {
	public abstract void execute(Nemo nemo); 
	public abstract boolean applies(int c);
}
