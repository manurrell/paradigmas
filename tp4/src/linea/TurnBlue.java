package linea;

public class TurnBlue extends State{
	public void canRedPlay(CuatroEnLinea juego, int prompt) {
	}

	public void canBluePlay(CuatroEnLinea juego, int prompt) {
		juego.addFicha(prompt,'B');
	}

	public boolean isGameFinished() {
		return false;
	}

	public String getMsg() {
		return "Gano Rojo :)";
	}

}
