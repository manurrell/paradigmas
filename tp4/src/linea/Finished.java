package linea;

public class Finished extends State{
	String msg;
	public Finished ( String msg) {
		this.msg=msg;
	}
	
	public State canRedPlay(CuatroEnLinea juego, int prompt) {
		return this;
	}

	public State canBluePlay(CuatroEnLinea juego, int prompt) {
		return this;
	}

	public boolean isGameFinished() {
		return true;
	}

	public String getMsg() {
		return msg;
	}

}
