package nemo;

public class South extends Cardinal {
	public void move(Coordinates cords){
		cords.moveSouth();
	}
	public Cardinal turnRight() {
		return new West();
	}
	public Cardinal turnLeft() {
		return new East();
	}
}
