package linea;

public class TurnRed extends State {



	public State canBluePlay(CuatroEnLinea juego, int prompt) {
		return this;
	}

	public boolean isGameFinished() {
		return false;
	}

	public State canRedPlay(CuatroEnLinea juego, int prompt) {
		juego.addFicha(prompt, 'R');
		return new TurnBlue();
	}

	public String getMsg() {
		return "Gano Azul :)";
	}

}
