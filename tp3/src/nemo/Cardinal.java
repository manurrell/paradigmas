package nemo;

public class Cardinal {
	public  North north() {
		return new North();
	}
	public  South south() {
		return new South();
	}
	public West west() {
		return new West();
	}
	public East east() {
		return new East();
	}
}
