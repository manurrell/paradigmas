package linea;

public class ModeB extends Mode{
	public ModeB() {
		id='B';
	}

	
	public boolean checkIfBlueWon(CuatroEnLinea juego) {
		return juego.checkDiagonally('B');
		
	}


	public boolean checkIfRedWon(CuatroEnLinea juego) {
		return juego.checkDiagonally('R');
	}
}
