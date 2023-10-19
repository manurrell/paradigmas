package nemo;

public class North extends Cardinal {
	public void move(Coordinates cords){
		cords.moveNorth();
	}
	public Cardinal turnRight() {
		return new East();
	}
	public Cardinal turnLeft() {
		return new West();
	}
}
