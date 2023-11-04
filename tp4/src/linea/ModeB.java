package linea;

import java.util.ArrayList;

public class ModeB extends Mode{
	public ModeB() {
		id='B';
	}

	
	public boolean checkIfBlueWon(CuatroEnLinea juego) {
		return checkDiagonally('B',juego);
		
	}


	public boolean checkIfRedWon(CuatroEnLinea juego) {
		return checkDiagonally('R',juego);
	}
}
