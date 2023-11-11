package linea;

public class TurnBlue extends State{
	public State canRedPlay(CuatroEnLinea juego, int prompt) {
		return this;
	}

	public State canBluePlay(CuatroEnLinea juego, int prompt) {
		juego.addFicha(prompt,'B');
		return new TurnRed();
	}

	public boolean isGameFinished() {
		return false;
	}

	public String getMsg() {
		return "Gano Rojo :)";
	}

}
