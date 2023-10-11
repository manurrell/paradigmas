package nemo;

public class Coordinates {
	private int x;
	private int y;
	private int z;
	public Coordinates(int x, int y, int z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	public void moveNorth() {
		x+=1;
	}
	public Coordinates moveSouth() {
		x-=1;
		return this;
	}
	public Coordinates moveEast() {
		y-=1;
		return this;
	}
	public Coordinates moveWest() {
		y+=1;
		return this;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getZ() {
		return z;
	}
}
