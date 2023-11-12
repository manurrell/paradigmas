package linea;

public class ModeC extends Mode {
	public ModeC() {
		id='C';
	}


	public boolean checkIfBlueWon(CuatroEnLinea tablero) {
		return tablero.checkVerticallyAndHorizontally('B') || tablero.checkDiagonally('B');
	}

	public boolean checkIfRedWon(CuatroEnLinea tablero) {
		return tablero.checkVerticallyAndHorizontally('R') || tablero.checkDiagonally('R');
	}
}
