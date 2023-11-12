package linea;


public class ModeA extends Mode {
	public ModeA() {
		id='A';
	}

	public boolean checkIfRedWon(CuatroEnLinea tablero) {
		return tablero.checkVerticallyAndHorizontally('R');	
		
	}
	public boolean checkIfBlueWon(CuatroEnLinea tablero) {
		return tablero.checkVerticallyAndHorizontally('B');
		
	}
}
