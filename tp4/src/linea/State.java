package linea;

public abstract class State {

	public abstract void canRedPlay(CuatroEnLinea juego, int prompt);
	public abstract void canBluePlay(CuatroEnLinea juego, int prompt);
	public abstract boolean isGameFinished();
	public abstract String getMsg();
}
