package linea;

public class TurnRed extends State {



	public void canBluePlay(CuatroEnLinea juego, int prompt) {
	}

	public boolean isGameFinished() {
		return false;
	}

	public void canRedPlay(CuatroEnLinea juego, int prompt) {
		juego.addFicha(prompt, 'R');
	}

}
