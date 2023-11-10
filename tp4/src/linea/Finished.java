package linea;

public class Finished extends State{
	String msg;
	public Finished ( String msg) {
		this.msg=msg;
	}
	
	public void canRedPlay(CuatroEnLinea juego, int prompt) {
	}

	public void canBluePlay(CuatroEnLinea juego, int prompt) {
	}

	public boolean isGameFinished() {
		return true;
	}

	public String getMsg() {
		return msg;
	}

}
