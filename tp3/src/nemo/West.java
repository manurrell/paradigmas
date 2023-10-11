package nemo;

public class West extends Cardinal {
	public void move(Coordinates cords){
		cords.moveWest();
	}
	public Cardinal turnRigth() {
		return new North();
	}
}
