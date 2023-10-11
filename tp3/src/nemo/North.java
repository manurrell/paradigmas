package nemo;

public class North extends Cardinal {
	public void move(Coordinates cords){
		cords.moveNorth();
	}
	public Cardinal turnRigth() {
		return new East();
	}
}
