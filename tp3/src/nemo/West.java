package nemo;

public class West extends Cardinal {
	public void move(Coordinates cords){
		cords.moveWest();
	}
	public Cardinal turnRight() {
		return new North();
	}
	
	public Cardinal turnLeft() {
		return new South();
	}
}
