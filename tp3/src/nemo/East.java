package nemo;

public class East extends Cardinal {
	public void move(Coordinates cords){
		cords.moveEast();
	}
	public Cardinal turnRight() {
		return new South();
	}
	public Cardinal turnLeft() {
		return new North();
	}
}
