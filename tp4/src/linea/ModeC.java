package linea;

import java.util.ArrayList;

public class ModeC extends Mode {
	public ModeC() {
		id='C';
	}


	public boolean checkIfBlueWon(CuatroEnLinea tablero) {
		return checkVerticallyAndHorizontally('B', tablero) || checkDiagonally('B', tablero);
	}

	public boolean checkIfRedWon(CuatroEnLinea tablero) {
		return checkVerticallyAndHorizontally('R', tablero) || checkDiagonally('R', tablero);
	}
}
