package linea;

public abstract class State {

	public abstract State canRedPlay(CuatroEnLinea juego, int prompt);
	public abstract State canBluePlay(CuatroEnLinea juego, int prompt);
	public abstract boolean isGameFinished();
	public abstract String getMsg();
}
