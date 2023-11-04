package linea;

import java.util.ArrayList;

public class ModeA extends Mode {
	public ModeA() {
		id='A';
	}

	
	public boolean checkIfRedWon(CuatroEnLinea tablero) {
		return checkVerticallyAndHorizontally('R',tablero);					//julio
		
	}
	public boolean checkIfBlueWon(CuatroEnLinea tablero) {
		return checkVerticallyAndHorizontally('B',tablero);					//julio
		
	}
}
